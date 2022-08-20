package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    public static Properties readProperties(String filename) throws IOException {
        filename = filename.trim();
        InputStream fileReader = new FileInputStream(filename) ;
        Properties properties = new Properties();
        properties.load(fileReader);
        return properties;
    }
}
