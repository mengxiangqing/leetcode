package properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        try {
            var settings = new Properties();
            settings.setProperty("width", "600.0");
            settings.setProperty("filename", "/properties/program.properties");
            var out = new FileOutputStream("properties\\program.properties"); //指定输出文件路径
            settings.store(out, "Program Properties");
            var in = new FileInputStream("properties/program.properties");
            var settings2 = new Properties();
            settings2.load(in);
            String userDir = System.getProperty("user.home");


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
