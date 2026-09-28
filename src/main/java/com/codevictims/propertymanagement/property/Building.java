package com.codevictims.propertymanagement.property;
import jakarta.persistence.*; import java.util.UUID;
@Entity @Table(name="building")
public class Building {
 @Id @Column(columnDefinition="BINARY(16)") private UUID id=UUID.randomUUID();
 @Column(name="owner_id",columnDefinition="BINARY(16)",nullable=false) private UUID ownerId;
 @Column(nullable=false) private String name;
 @Column(nullable=false) private String address;
 public Building(){} public Building(UUID ownerId,String name,String address){this.ownerId=ownerId;this.name=name;this.address=address;}
 public UUID getId(){return id;} public UUID getOwnerId(){return ownerId;} public String getName(){return name;} public String getAddress(){return address;}
 public void setName(String n){name=n;} public void setAddress(String a){address=a;}
}