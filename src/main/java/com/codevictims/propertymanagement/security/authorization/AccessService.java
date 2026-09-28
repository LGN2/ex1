package com.codevictims.propertymanagement.security.authorization;
import org.springframework.stereotype.Service;
@Service public class AccessService {
 public boolean canAccess(String ownerId,String resourceOwnerId){return ownerId!=null&&ownerId.equals(resourceOwnerId);}
}