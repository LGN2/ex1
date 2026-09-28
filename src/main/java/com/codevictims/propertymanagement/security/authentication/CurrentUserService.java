package com.codevictims.propertymanagement.security.authentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
@Service public class CurrentUserService {
 public String email(Authentication authentication){return authentication==null?null:authentication.getName();}
}