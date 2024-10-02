package com.nt.com.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class RequestModificationFilter implements Filter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Check if the request is a POST request and has a JSON content type
        if ("POST".equalsIgnoreCase(httpRequest.getMethod()) &&
                "application/json".equalsIgnoreCase(httpRequest.getContentType())) {

            // Read the original request body
            String originalBody = new String(httpRequest.getInputStream().readAllBytes());

            // Parse the JSON and add dummy values
            JsonNode originalJson = objectMapper.readTree(originalBody);
            ObjectNode modifiedJson = (ObjectNode) originalJson;
            modifiedJson.put("orgId", "31311");

            // Wrap the request with the modified body
            CustomHttpServletRequestWrapper wrappedRequest = new CustomHttpServletRequestWrapper(
                    httpRequest, modifiedJson.toString());

            // Proceed with the wrapped request
            chain.doFilter(wrappedRequest, response);
        } else {
            // For non-POST requests or other content types, just proceed as normal
            chain.doFilter(request, response);
        }
    }
}
