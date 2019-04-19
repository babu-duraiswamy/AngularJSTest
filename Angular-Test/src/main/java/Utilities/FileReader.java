package Utilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileReader{
    public static void main(String[] args) throws IOException {
        Properties configValues = new Properties();
        Properties demoInputControlsAndValues = new Properties();
        InputStream config = FileReader.class.getClassLoader().
        		getResourceAsStream("Config.properties");
        InputStream demoInputControlsAndValuesStream = FileReader.class.getClassLoader().
        		getResourceAsStream("DemoInputControlsAndValues.properties");
        configValues.load(config);
        demoInputControlsAndValues.load(demoInputControlsAndValuesStream);
    }
}