package com.example.class10.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class that registers the API key interceptor for all API requests.
 * This ensures the API key is checked for all HTTP methods (GET, POST, PUT, DELETE, etc.)
 * on the specified endpoints.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
    private final ApiKeyInterceptor apiKeyInterceptor;
    
    public WebMvcConfig(ApiKeyInterceptor apiKeyInterceptor) {
        this.apiKeyInterceptor = apiKeyInterceptor;
        logger.info("API Key interceptor configured for all controller endpoints");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register the API key interceptor for all API endpoints and all HTTP methods
        registry.addInterceptor(apiKeyInterceptor)
                // Apply to all actual controller paths in the application
                .addPathPatterns("/students/**")
                .addPathPatterns("/courses/**")
                .addPathPatterns("/courses-admin/**")
                .addPathPatterns("/grades/**")
                // You can add more endpoints as needed
                
                // Optionally exclude paths that don't need authentication
                .excludePathPatterns("/h2-console/**")
                .excludePathPatterns("/error");
        
        logger.info("API Key interception paths configured");
    }
}
