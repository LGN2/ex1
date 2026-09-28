package com.codevictims.propertymanagement.maintenance.entity;
import jakarta.persistence.*; import java.util.UUID;
@Entity public class MaintenanceStatusHistory { @Id @GeneratedValue private UUID id; public UUID getId(){return id;} }
