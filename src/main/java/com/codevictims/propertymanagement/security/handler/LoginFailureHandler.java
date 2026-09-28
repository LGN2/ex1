package com.codevictims.propertymanagement.security.handler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
public class LoginFailureHandler implements AuthenticationFailureHandler {
 public void onAuthenticationFailure(jakarta.servlet.http.HttpServletRequest r,jakarta.servlet.http.HttpServletResponse s,org.springframework.security.core.AuthenticationException e){s.setStatus(401);}
}