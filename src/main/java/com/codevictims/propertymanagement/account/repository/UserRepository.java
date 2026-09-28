package com.codevictims.propertymanagement.account.repository;
import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<com.codevictims.propertymanagement.account.entity.User, UUID> {}
