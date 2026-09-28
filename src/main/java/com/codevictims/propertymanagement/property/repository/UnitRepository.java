package com.codevictims.propertymanagement.property.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface UnitRepository extends JpaRepository<com.codevictims.propertymanagement.property.entity.Unit, UUID> {}
