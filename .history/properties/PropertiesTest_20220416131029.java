package properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        try {
            var settings = new Properties();
            settings.setProperty("width", "600.0");
            settings.setProperty("filename", "/properties/program.properties");
            var out = new FileOutputStream("\\properties\\program.properties");
            settings.store(out, "Program Properties");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
