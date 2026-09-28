package com.codevictims.propertymanagement.billing.entity;
import jakarta.persistence.*; import java.util.UUID;
@Entity public class Cheque { @Id @GeneratedValue private UUID id; public UUID getId(){return id;} }
