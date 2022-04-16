package properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        try {
            var settings = new Properties();
            settings.setProperty("width", "600.0");
            settings.setProperty("filename", "value")
            var out = new FileOutputStream("program.properties");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
