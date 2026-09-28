package com.codevictims.propertymanagement.property;
import jakarta.validation.Valid; import jakarta.validation.constraints.NotBlank; import java.util.*; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/buildings")
public class BuildingController {
 private final BuildingRepository repo; public BuildingController(BuildingRepository repo){this.repo=repo;}
 record BuildingRequest(@NotBlank String name,@NotBlank String address){}
 @GetMapping public List<Building> all(){return repo.findAll();}
 @PostMapping public ResponseEntity<Building> create(@Valid @RequestBody BuildingRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(new Building(UUID.randomUUID(),r.name(),r.address())));}
 @GetMapping("/{id}") public Building one(@PathVariable UUID id){return repo.findById(id).orElseThrow();}
 @PutMapping("/{id}") public Building update(@PathVariable UUID id,@Valid @RequestBody BuildingRequest r){Building b=one(id);b.setName(r.name());b.setAddress(r.address());return repo.save(b);}
}