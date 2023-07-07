package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ConfigFileReader {
    public static String getPropertyV(String PropertyKey){


        // Navigating to the file
        FileInputStream fileInputStream= null;
        Properties properties = null;
        try {
            fileInputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
            // a class that understand how to read/write data to .properties file
            properties=new Properties();
            //Loads all the raw data from fileInputStream
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                Objects.requireNonNull(fileInputStream).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return properties.getProperty(PropertyKey);
    }
}
