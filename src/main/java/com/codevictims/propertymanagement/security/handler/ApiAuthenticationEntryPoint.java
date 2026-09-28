package com.codevictims.propertymanagement.security.handler;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
public class ApiAuthenticationEntryPoint implements AuthenticationEntryPoint {
 public void commence(jakarta.servlet.http.HttpServletRequest r,jakarta.servlet.http.HttpServletResponse s,AuthenticationException e){s.setStatus(401);}
}