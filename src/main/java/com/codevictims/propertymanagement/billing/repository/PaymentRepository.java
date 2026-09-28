package com.codevictims.propertymanagement.billing.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentRepository extends JpaRepository<com.codevictims.propertymanagement.billing.entity.Payment, UUID> {}
