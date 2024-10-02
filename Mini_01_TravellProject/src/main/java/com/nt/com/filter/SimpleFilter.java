package com.nt.com.filter;


import java.io.IOException;

import org.springframework.context.annotation.Profile;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SimpleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Pre-processing logic
        log.error("Request received IN this filter");
     
        //request.setAttribute("Org", "31311");
        // Continue with the next filter or the target resource
        chain.doFilter(request, response);

        // Post-processing logic
        log.error("Response sent from this filter");
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}
