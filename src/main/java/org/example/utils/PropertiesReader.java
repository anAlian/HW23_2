package org.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance;
    private Properties properties;

    PropertiesReader() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("src/main/resources/app.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getProperties(String name) {
        return properties.getProperty(name);
    }
}
