package com.codevictims.propertymanagement.account;
import java.util.Map; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth")
public class AuthController {
 @GetMapping("/me") public Map<String,String> me(){return Map.of("status","authenticated");}
 @PostMapping("/logout") public Map<String,String> logout(){return Map.of("status","logged out");}
}