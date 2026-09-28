package com.codevictims.propertymanagement.security.handler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
 public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest r,jakarta.servlet.http.HttpServletResponse s,org.springframework.security.core.Authentication a){s.setStatus(200);}
}