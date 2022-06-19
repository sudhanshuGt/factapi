package com.factapi.factapi.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;

public class MyHandlerInterceptor implements HandlerInterceptor {
    private static final String YOUR_KEY = "key12345";
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String key = request.getHeader("X-Key");
        boolean isValid = YOUR_KEY.equals(key);
        if (!isValid) {
            //invalid key
            response.setStatus(401);
            PrintWriter writer = response.getWriter();
            writer.write("invalid key");
        }
        return isValid;
    }

}
