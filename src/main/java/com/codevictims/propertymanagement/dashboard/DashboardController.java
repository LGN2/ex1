package com.codevictims.propertymanagement.dashboard;
import java.util.Map; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/dashboard")
public class DashboardController {
 @GetMapping("/summary") public Map<String,Object> summary(){return Map.of("buildings",0,"occupiedUnits",0,"vacantUnits",0,"outstandingRent","0.000","maintenanceOpen",0);}
}