package com.codevictims.propertymanagement.property.entity;
import jakarta.persistence.*; import java.util.UUID;
@Entity public class Unit { @Id @GeneratedValue private UUID id; public UUID getId(){return id;} }
