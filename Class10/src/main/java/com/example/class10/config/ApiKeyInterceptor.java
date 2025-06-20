package com.example.class10.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor that validates the API key in request headers.
 * This applies to all HTTP methods (GET, POST, PUT, DELETE, etc.)
 * for protected endpoints.
 */
@Component
public class ApiKeyInterceptor implements HandlerInterceptor {
    
    private static final Logger logger = LoggerFactory.getLogger(ApiKeyInterceptor.class);
    private static final String API_KEY_HEADER = "X-API-KEY";
    
    private final ApiKeyProperties apiKeyProperties;
    
    public ApiKeyInterceptor(ApiKeyProperties apiKeyProperties) {
        this.apiKeyProperties = apiKeyProperties;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String path = request.getRequestURI();
        
        // Get the API key from the request header
        String apiKey = request.getHeader(API_KEY_HEADER);
        
        // Check if the API key is valid
        if (apiKey == null || !apiKey.equals(apiKeyProperties.getApiKey())) {
            // If invalid, return 401 Unauthorized
            logger.warn("Unauthorized access attempt: {} {} - Invalid or missing API key", method, path);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Invalid or missing API key");
            return false;
        }
        
        // If valid, continue with the request
        logger.debug("API key authentication successful for: {} {}", method, path);
        return true;
    }
}
