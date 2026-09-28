# Security package structure

Security is divided into focused packages:

- security/config: Spring Security configuration and beans.
- security/authentication: login identity, current-user lookup, and UserDetails integration.
- security/authorization: owner, manager, and tenant access rules.
- security/handler: authentication success/failure, unauthenticated, and forbidden API responses.

This separation lets different team members implement authentication, authorization, configuration, and HTTP handlers independently.