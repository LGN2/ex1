package com.codevictims.propertymanagement.maintenance;
import java.time.Instant; import java.util.*; import java.util.concurrent.ConcurrentHashMap; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/maintenance-requests")
public class MaintenanceController {
 record Request(UUID id,UUID ownerId,String title,String description,String category,String status,boolean urgent,Instant createdAt){}
 private final Map<UUID,Request> data=new ConcurrentHashMap<>();
 @GetMapping public Collection<Request> all(){return data.values();}
 @PostMapping public ResponseEntity<Request> create(@RequestBody Map<String,Object> body){Request r=new Request(UUID.randomUUID(),UUID.randomUUID(),(String)body.get("title"),(String)body.get("description"),String.valueOf(body.getOrDefault("category","OTHER")),"OPEN",Boolean.TRUE.equals(body.get("urgent")),Instant.now());data.put(r.id(),r);return ResponseEntity.status(HttpStatus.CREATED).body(r);}
 @GetMapping("/{id}") public Request one(@PathVariable UUID id){return Optional.ofNullable(data.get(id)).orElseThrow();}
 @PostMapping("/{id}/transitions") public Request transition(@PathVariable UUID id,@RequestBody Map<String,String> body){Request o=one(id);Request n=new Request(o.id(),o.ownerId(),o.title(),o.description(),o.category(),body.get("status"),o.urgent(),o.createdAt());data.put(id,n);return n;}
}