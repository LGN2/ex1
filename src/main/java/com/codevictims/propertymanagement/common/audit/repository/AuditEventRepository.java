package com.codevictims.propertymanagement.common.audit.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface AuditEventRepository extends JpaRepository<com.codevictims.propertymanagement.common.entity.AuditEvent, UUID> {}
