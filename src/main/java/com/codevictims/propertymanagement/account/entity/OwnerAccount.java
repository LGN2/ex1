package com.codevictims.propertymanagement.account.entity;
import jakarta.persistence.*; import java.util.UUID;
@Entity public class OwnerAccount { @Id @GeneratedValue private UUID id; public UUID getId(){return id;} }
