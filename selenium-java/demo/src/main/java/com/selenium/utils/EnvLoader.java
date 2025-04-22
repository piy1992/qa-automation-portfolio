package com.selenium.utils;

import io.github.cdimascio.dotenv.Dotenv;
import java.nio.file.Paths;

public class EnvLoader {
    public Dotenv loadEnv(String environment) {
        String projectRoot = System.getProperty("user.dir");
        String envPath = Paths.get(projectRoot).getParent().resolve("env").toString();
        
        return Dotenv.configure()
                .directory(envPath)
                .filename(".env." + environment)
                .load();
    }
}
