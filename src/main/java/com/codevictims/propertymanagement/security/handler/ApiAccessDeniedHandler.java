package com.codevictims.propertymanagement.security.handler;
import org.springframework.security.web.access.AccessDeniedHandler;
public class ApiAccessDeniedHandler implements AccessDeniedHandler {
 public void handle(jakarta.servlet.http.HttpServletRequest r,jakarta.servlet.http.HttpServletResponse s,org.springframework.security.access.AccessDeniedException e){s.setStatus(403);}
}