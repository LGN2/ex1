package com.codevictims.propertymanagement.billing.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface RentDueRepository extends JpaRepository<com.codevictims.propertymanagement.billing.entity.RentDue, UUID> {}
