package com.github.ashwinikb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {


    private static final String CONFIGURATION_FILE = "/configuration.properties";

    private static final Properties properties;

    // Static initializer to read the configuration file when the class is loaded
    static {
        properties = new Properties();
        try (InputStream inputStream = Configuration.class.getResourceAsStream(CONFIGURATION_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + CONFIGURATION_FILE, e);
        }
    }

    public static String getConfigurationValue(String key) {
        return properties.getProperty(key);
    }

    // private constructor to prevent initialization
    private Configuration() {
    }


}
