package projectname.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private Properties configProperties;
    private Properties envProperties;

    public void loadPropertiesFile() throws IOException {
        configProperties = new Properties();
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");
            configProperties.load(is);
            envProperties = new Properties();
            String env = System.getProperty("env", "dev");
            envProperties.load(getClass().getClassLoader().getResourceAsStream("config/" + env + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getConfigProperty(String key){
        return configProperties.getProperty(key);
    }

    public String getEnvConfigProperty(String key){
        return envProperties.getProperty(key);
    }

    public Boolean getConfigBoolProperBoolean(String key){
        return Boolean.parseBoolean(getConfigProperty(key));
    }
}
