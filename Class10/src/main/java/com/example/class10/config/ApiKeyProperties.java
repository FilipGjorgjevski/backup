package com.example.class10.config;

import org.springframework.context.annotation.Configuration;

/**
 * Configuration class that holds the API key value for authentication.
 */
@Configuration
public class ApiKeyProperties {
    // Hardcoded API key (in a real application, this would be externalized)
    private static final String API_KEY = "e1c11dc9-9f1b-4d13-b3a1-a7f00ea39aca";
    
    /**
     * Returns the API key value.
     * 
     * @return the API key
     */
    public String getApiKey() {
        return API_KEY;
    }
}
