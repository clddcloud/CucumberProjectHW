package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String read(String path,String key) throws IOException {
        Properties properties=new Properties();
        FileInputStream fis=new FileInputStream(path);
        properties.load(fis);
        return properties.getProperty(key);
    }

    public static String read (String key) throws IOException {
        return read (Constants.CONFIG_FILE_PATH, key);
    }
}

