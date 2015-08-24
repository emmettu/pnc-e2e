package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eunderhi on 10/08/15.
 */
public class Credentials {

    private static final String PATH_KEY = "CREDENTIALS";
    private static final String LOGIN_URL_KEY = "login url";
    private static final String BASE_URL_KEY = "base url";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String DEFAULT_PATH = "credentials.conf";

    BufferedReader reader;
    Map<String, String> valueMap = new HashMap<String, String>();

    public String getUsername() {
        return valueMap.get(USERNAME_KEY);
    }

    public String getPassword() {
        return valueMap.get(PASSWORD_KEY);
    }

    public String getLoginURL() {
        return valueMap.get(LOGIN_URL_KEY);
    }

    public String getBaseURL() {
        return valueMap.get(BASE_URL_KEY);
    }

    public boolean hasLoginURL() {
        return valueMap.containsKey(LOGIN_URL_KEY);
    }

    public Credentials() {
        String filePath = getFilePath();
        reader = new BufferedReader(getFileReader(filePath));
        readAllLines();
    }

    private String getFilePath() {
        String path = System.getProperty(PATH_KEY);
        if(path == null) {
            return DEFAULT_PATH;
        }
        return path;
    }

    private FileReader getFileReader(String path) {
        FileReader fr;
        try {
            fr = new FileReader(path);
        }
        catch(IOException e) {
            throw new IllegalArgumentException("Unable to load file: " + path);
        }
        return fr;
    }

    private void readAllLines() {
        for (String line = readValue(); line != null; line = readValue()) {
            if(!line.startsWith("#")) {
                addToValueMap(line);
            }
        }
    }

    private String readValue() {
         try {
             return reader.readLine();
        }
        catch(IOException e) {
            throw new IllegalArgumentException("Unable to read credentials file.");
        }
    }

    private void addToValueMap(String line) {
        String[] keyAndValue = line.split("=");
        String key = keyAndValue[0];
        String value = keyAndValue[1];

        if(key == null || value == null) {
            throw new IllegalArgumentException("Credentials file must be in the format key=value for each line");
        }

        valueMap.put(key, value);
    }
}
