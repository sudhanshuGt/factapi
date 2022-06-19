package com.factapi.factapi.factapiservices;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public interface ipservice {
    String getIpAddress(HttpServletRequest request);
}
