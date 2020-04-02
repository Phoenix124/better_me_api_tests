package better.me.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.fail;

public class ConfigProperties {

    public static Properties properties;

    static {
        File globalConfigFile = new File("src/main/resources/config.properties");
        Properties globalProperties = new Properties();

        try {
            globalProperties.load(new FileInputStream(globalConfigFile));

            properties = new Properties();
            properties.putAll(globalProperties);

        } catch (IOException e) {
            fail("Error open config file.\n" + e.getMessage());
        }

    }
}