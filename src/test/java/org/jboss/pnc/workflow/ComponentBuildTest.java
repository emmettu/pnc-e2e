package org.jboss.pnc.workflow;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@Ignore
public class ComponentBuildTest {
    private static final Logger LOGGER = Logger.getLogger(ComponentBuildTest.class.toString());

    private String applicationContext;
    private String deploymentId;
    private String pncRestBaseUrl;
    private String repourRestBaseUrl;
    private String daRestBaseUrl;

    private boolean isWait;

    private final String processDefId = "ComponentBuild.componentbuild";

    @Before
    public void setUp() throws Exception {
        applicationContext = System.getProperty("maitai.restBaseUrl");
        deploymentId = System.getProperty("maitai.deploymentId");
        if (deploymentId == null) {
            deploymentId = getLatestDeploymentId();
        }
        pncRestBaseUrl = System.getProperty("pnc.restBaseUrl");
        repourRestBaseUrl = System.getProperty("repour.restBaseUrl");
        daRestBaseUrl = System.getProperty("da.restBaseUrl");

        isWait = "true".equals(System.getProperty("maitai.waitPncCallback"));
    }

    // [GET] /deployment
    private static final String REST_GET_DEPLOYMENT = "/deployment";

    private String getLatestDeploymentId() throws Exception {
        HttpClient httpclient = getHttpClient();
        String urlStr = applicationContext + REST_GET_DEPLOYMENT;
        Map<String, Object> ret = execute(httpclient, urlStr, "GET");
        if (!responseCodeOk((Integer) ret.get("responseCode"))) {
            fail("Endpoint could not be reached, " + urlStr);
        }
        String deploymentId = getDeploymentId((String) ret.get("responseBody"));
        return deploymentId;
    }

    /**
     * Parse xml response and find the latest version.
     *
     * <pre>
     * <deployment-unit-list>
     *   ...
     *   <deployment-unit>
     *     <groupId>com.redhat.maitai.ncl</groupId>
     *     <artifactId>ComponentBuild</artifactId>
     *     <version>1.0.3</version>
     *     <kbaseName/>
     *     <ksessionName/>
     *     <strategy>SINGLETON</strategy>
     *     <status>DEPLOYED</status>
     *   </deployment-unit>
     * <deployment-unit-list>
     * </pre>
     */
    private String getDeploymentId(String xmlString) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new ByteArrayInputStream(xmlString.getBytes("utf-8")));
        NodeList nList = doc.getElementsByTagName("deployment-unit");
        List<String> l = new ArrayList<String>();
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String groupId = eElement.getElementsByTagName("groupId").item(0).getTextContent();
                String artifactId = eElement.getElementsByTagName("artifactId").item(0).getTextContent();
                String version = eElement.getElementsByTagName("version").item(0).getTextContent();
                if ("com.redhat.maitai.ncl:ComponentBuild".equals(groupId + ":" + artifactId)) {
                    l.add(groupId + ":" + artifactId + ":" + version);
                }
            }
        }
        if (l.isEmpty()) {
            return null;
        }
        Collections.sort(l);
        return l.get(l.size() - 1); // last one
    }

    @After
    public void tearDown() throws Exception {
    }

    // [POST] /runtime/{deploymentId}/process/{processDefId}/start
    private static final String REST_START = "/runtime/{0}/process/{1}/start";

    // [GET] /runtime/{deploymentId}/process/instance/{procInstId}
    private static final String REST_GET_INST = "/runtime/{0}/process/instance/{1}";

    // [GET] /runtime/{deploymentId}/history/instance/{procInstId}/variable/{varId}
    private static final String REST_GET_VAR = "/runtime/{0}/history/instance/{1}/variable/{2}";

    private static HttpClient getHttpClient() {
        HttpClient client = new DefaultHttpClient();
        return client;
    }

    private static final int SLEEP_MILL_SECONDS = 30000;
    private static final int RETRY_TIMES = 10;

    @Test
    public void testTriggerProcess() {
        HttpClient httpclient = getHttpClient();
        try {
            // start process
            String urlStr = getStartProcUrl();
            Map<String, Object> ret = execute(httpclient, urlStr, "POST");
            if (!responseCodeOk((Integer) ret.get("responseCode"))) {
                fail("Endpoint could not be reached, " + urlStr);
            }

            if (!isWait) { // not wait for pncCallback
                return;
            }

            String processId = getProcessId((String) ret.get("responseBody"));

            // wait for callback and check result
            int retry = 0;
            Thread.sleep(SLEEP_MILL_SECONDS);

            while (!isComplete(httpclient, processId)) {
                Thread.sleep(SLEEP_MILL_SECONDS); // sleep
                retry++;
                if (retry >= RETRY_TIMES) {
                    fail("Process does not complete after retry " + retry + " times");
                }
            }

            // fetch callback data
            urlStr = applicationContext + MessageFormat.format(REST_GET_VAR, deploymentId, processId, "callbackData");
            ret = execute(httpclient, urlStr, "GET");
            if (!responseCodeOk((Integer) ret.get("responseCode"))) {
                fail("Endpoint could not be reached, " + urlStr);
            }

            String callbackData = getCallbackData((String) ret.get("responseBody"));
            LOGGER.info("callbackData=" + callbackData);
            assertTrue(callbackData != null);
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    private String getStartProcUrl() throws Exception {
        StringBuffer sb = new StringBuffer(applicationContext + MessageFormat.format(REST_START, deploymentId, processDefId));
        sb.append("?map_paramsJSON=");
        sb.append(getParamsJSONEncoded("compbuild.json"));
        sb.append("&map_restBaseUrl=");
        sb.append(URLEncoder.encode(pncRestBaseUrl, "UTF-8"));
        sb.append("&map_repourBaseUrl=");
        sb.append(URLEncoder.encode(repourRestBaseUrl, "UTF-8"));
        sb.append("&map_daBaseUrl=");
        sb.append(URLEncoder.encode(daRestBaseUrl, "UTF-8"));
        return sb.toString();
    }

    static String loadJSONFile(String filename) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedReader bis = null;
        try {
            InputStream inputStream = ComponentBuildTest.class.getResourceAsStream(filename);
            bis = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bis.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0) {
                    sb.append(line);
                }
            }
        } finally {
            IOUtils.closeQuietly(bis);
        }
        return sb.toString();
    }

    private static Object getParamsJSONEncoded(String filename) throws Exception {
        return URLEncoder.encode(loadJSONFile(filename), "UTF-8");
    }

    /**
     * As said in the api doc, REST_GET_INST operation will fail if the process instance has been completed.
     */
    private boolean isComplete(HttpClient httpclient, String processId) throws Exception {
        String urlStr = applicationContext + MessageFormat.format(REST_GET_INST, deploymentId, processId);
        Map<String, Object> ret = execute(httpclient, urlStr, "GET");
        int code = (Integer) ret.get("responseCode");
        if (code == 404) {
            return true; // 404 Not Found
        }
        return false;
    }

    private Map<String, Object> execute(HttpClient httpclient, String urlStr, String method) throws Exception {
        HttpRequestBase theMethod = null;
        if (method.equals("POST")) {
            theMethod = new HttpPost(urlStr);
        } else if (method.equals("GET")) {
            theMethod = new HttpGet(urlStr);
        } else {
            throw new IllegalArgumentException("Invalid method, " + method);
        }
        theMethod.addHeader("Authorization", getAuthHeader());
        HttpResponse response = httpclient.execute(theMethod);
        StatusLine statusLine = response.getStatusLine();
        int responseCode = response.getStatusLine().getStatusCode();
        String responseBody = getResponseBodyAsString(response);
        theMethod.releaseConnection();
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("responseCode", responseCode);
        ret.put("statusLine", statusLine);
        ret.put("responseBody", responseBody);
        LOGGER.info("Endpoint " + urlStr + ", statusLine=" + statusLine + ", responseBody=" + responseBody);
        return ret;
    }

    private String getAuthHeader() {
        String authString = System.getProperty("maitai.user.name") + ":" + System.getProperty("maitai.user.pass");
        byte[] encodedBytes = Base64.encodeBase64(authString.getBytes());
        return "Basic " + new String(encodedBytes);
    }

    private boolean responseCodeOk(int responseCode) {
        return responseCode >= 200 && responseCode < 300;
    }

    private String getResponseBodyAsString(HttpResponse response) throws Exception {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } finally {
            if (rd != null) {
                rd.close();
            }
        }
    }

    /**
     * Parse below xml response data to retrieve the process Id. I do not use xml parser but simple string slicing.
     *
     * <pre>
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * <process-instance>
     *   <status>SUCCESS</status>
     *   <url>http://localhost:8080</url>
     *   <process-id>ComponentBuild.componentbuild</process-id>
     *   <id>14</id>
     *   <state>1</state>
     *   <event-types>pncCallback</event-types>
     * </process-instance>
     * </pre>
     */
    private String getProcessId(String responseBody) {
        int beginIndex = responseBody.indexOf("<id>");
        if (beginIndex < 0) { // not found
            throw new RuntimeException("Can not find process Id");
        }
        beginIndex += 4; // 4, len of "<id>"
        int endIndex = responseBody.indexOf("</id>");
        return responseBody.substring(beginIndex, endIndex);
    }

    /**
     * Parse below xml response data to retrieve the value for callbackData. I do not use xml parser but simple string slicing.
     *
     * <pre>
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * <log-instance-list>
     *   <variable-instance-log id="403">
     *     <process-instance-id>15</process-instance-id>
     *     <process-id>ComponentBuild.componentbuild</process-id>
     *     <date>2015-08-07T17:17:42+08:00</date>
     *     <variable-instance-id>callbackData</variable-instance-id>
     *     <variable-id>callbackData</variable-id>
     *     <value>DONE</value>
     *     <oldValue></oldValue>
     *     <external-id>com.redhat.maitai.ncl:ComponentBuild:1.0.3</external-id>
     *   </variable-instance-log>
     * </log-instance-list>
     * </pre>
     */
    private String getCallbackData(String responseBody) throws Exception {
        int beginIndex = responseBody.indexOf("<value>");
        if (beginIndex < 0) { // not found
            throw new RuntimeException("Can not find variable value");
        }
        beginIndex += 7; // 7, len of "<value>"
        int endIndex = responseBody.indexOf("</value>");
        return responseBody.substring(beginIndex, endIndex);
    }

}
