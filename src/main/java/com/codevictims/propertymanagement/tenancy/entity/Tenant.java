package com.codevictims.propertymanagement.tenancy.entity;
import jakarta.persistence.*; import java.util.UUID;
@Entity public class Tenant { @Id @GeneratedValue private UUID id; public UUID getId(){return id;} }
