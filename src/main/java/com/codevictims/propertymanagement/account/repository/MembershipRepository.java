package com.codevictims.propertymanagement.account.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface MembershipRepository extends JpaRepository<com.codevictims.propertymanagement.account.entity.Membership, UUID> {}
