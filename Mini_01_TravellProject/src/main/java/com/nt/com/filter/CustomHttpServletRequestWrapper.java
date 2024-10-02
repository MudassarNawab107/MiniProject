package com.nt.com.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private final byte[] modifiedBody;

    public CustomHttpServletRequestWrapper(HttpServletRequest request, String newBody) throws IOException {
        super(request);
        this.modifiedBody = newBody.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStream() {
            private int idx = 0;

            @Override
            public boolean isFinished() {
                return idx >= modifiedBody.length;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                // No implementation needed for this example
            }

            @Override
            public int read() throws IOException {
                return (idx < modifiedBody.length) ? modifiedBody[idx++] : -1;
            }
        };
    }
}
