package com.codevictims.propertymanagement.property;
import java.util.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface BuildingRepository extends JpaRepository<Building,UUID>{List<Building> findByOwnerId(UUID ownerId);}