package com.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public Properties readPropertyFile(String filepath) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream io = new FileInputStream(filepath)) {
            properties.load(io);
        } catch (IOException e) {
            throw new IOException("Failed to read properties file: " + filepath, e);
        }
        return properties;
    }
}