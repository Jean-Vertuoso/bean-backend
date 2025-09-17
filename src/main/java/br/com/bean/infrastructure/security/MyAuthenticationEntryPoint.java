package br.com.bean.infrastructure.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import java.io.IOException;

public class MyAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

    private final HttpRequestEndpointChecker endpointChecker;

    public MyAuthenticationEntryPoint(HttpRequestEndpointChecker endpointChecker) {
        this.endpointChecker = endpointChecker;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        if(!endpointChecker.isEndpointExist(request)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
        } else {
            super.commence(request, response, authException);
        }
    }
}
