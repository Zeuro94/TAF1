package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 public class ConfigUtils {

     private static FileInputStream fileReader;
     private ConfigUtils(){
         throw new IllegalStateException("ConfigUtils class");
     }
    public static Properties readProperties(String filename) throws IOException {
        filename = filename.trim();
        readTheFile(filename);
        Properties properties = new Properties();
        properties.load(fileReader);
        return properties;
    }

    private static void readTheFile(String filename){
         try {
            fileReader = new FileInputStream(filename);
         } catch (FileNotFoundException e) {
             e.getStackTrace();
         }
    }
}
