package ui.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eunderhi on 10/08/15.
 */
public class Credentials {

    private static final String PATH_KEY = "CREDENTIALS";
    private static final String DEFAULT_PATH = "credentials.conf";

    String username;
    String password;
    String loginUrl;
    BufferedReader reader;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public Credentials() {
        String filePath = getFilePath();
        reader = new BufferedReader(getFileReader(filePath));
        username = readValue();
        password = readValue();
        loginUrl = readValue();
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

    private String readValue() {
         try {
            return reader.readLine();
        }
        catch(IOException e) {
            throw new IllegalArgumentException("Unable to read credentials file.");
        }
    }
}
