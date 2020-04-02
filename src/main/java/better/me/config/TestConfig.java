package better.me.config;

import java.util.Properties;

public class TestConfig {

    public static final Properties properties = ConfigProperties.properties;

    public static String baseUrl;

    static {
        baseUrl = properties.getProperty("BASE_URL_PARAM");
    }
}
