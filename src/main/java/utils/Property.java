package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    public static String getPropertyValue(String key) throws IOException {
        String output = "";
        InputStream inputStream = null;

        try {
            Properties props = new Properties();
            String propertiesFileName = "token.properties";
            inputStream = Property.class.getClassLoader().getResourceAsStream(propertiesFileName);
            props.load(inputStream);
            output = props.getProperty(key);
        }
        catch (Exception e ) {
            Log.error(e);
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return output;
    }
}
