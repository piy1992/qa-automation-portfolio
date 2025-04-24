package projectname.api.config;

import java.util.HashMap;
import java.util.Map;

public class APIConfig {
    private String baseURL;
    private String connectionTimeout;
    private Boolean followRedirects; 
    private Boolean urlEncodingEnabled;
    private int maxRetries;
    private int retryDelay;
    private String contentType;
    private Map<String,String> defaultHeaders;

    ConfigManager cm = new ConfigManager();
    private void initializeFromConfig() {
        this.baseURL = cm.getEnvConfigProperty("BASE_URL");
        this.connectionTimeout = cm.getConfigProperty("api.timeout");
        this.followRedirects = cm.getConfigBoolProperBoolean("api.follow.redirects");
        this.urlEncodingEnabled = cm.getConfigBoolProperBoolean("api.url.encoding.enabled");
        this.maxRetries = cm.getConfigintProperties("api.retry.count");
        this.retryDelay = cm.getConfigintProperties("api.retry.delay");
        this.contentType = cm.getConfigProperty("api.contentType");
    }

    private void initializeDefaultHeaders(){
        this.defaultHeaders = new HashMap<>();
        this.defaultHeaders.put("Accept", "application/"+contentType);
        this.defaultHeaders.put("User-Agent", "RestAssured");
    }
}
