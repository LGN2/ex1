package com.codevictims.propertymanagement.common.audit.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
import com.codevictims.propertymanagement.common.audit.entity.AuditEvent;
public interface AuditEventRepository extends JpaRepository<AuditEvent, UUID> {}