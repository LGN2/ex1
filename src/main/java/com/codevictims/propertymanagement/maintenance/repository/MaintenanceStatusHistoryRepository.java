package com.codevictims.propertymanagement.maintenance.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface MaintenanceStatusHistoryRepository extends JpaRepository<com.codevictims.propertymanagement.maintenance.entity.MaintenanceStatusHistory, UUID> {}
