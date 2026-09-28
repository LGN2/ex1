package com.codevictims.propertymanagement.security.authentication;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
@Service public class ApplicationUserDetailsService implements UserDetailsService {
 public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {throw new UsernameNotFoundException(username);}
}