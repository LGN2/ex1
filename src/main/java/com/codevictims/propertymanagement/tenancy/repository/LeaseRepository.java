package com.codevictims.propertymanagement.tenancy.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface LeaseRepository extends JpaRepository<com.codevictims.propertymanagement.tenancy.entity.Lease, UUID> {}
