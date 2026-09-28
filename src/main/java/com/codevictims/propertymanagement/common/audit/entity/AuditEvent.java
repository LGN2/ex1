package com.codevictims.propertymanagement.common.audit.entity;
import jakarta.persistence.*; import java.util.UUID;
@Entity public class AuditEvent { @Id @GeneratedValue private UUID id; public UUID getId(){return id;} }
