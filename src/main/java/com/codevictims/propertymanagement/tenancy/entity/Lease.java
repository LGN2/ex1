package com.codevictims.propertymanagement.tenancy.entity;
import jakarta.persistence.*; import java.util.UUID;
@Entity public class Lease { @Id @GeneratedValue private UUID id; public UUID getId(){return id;} }
