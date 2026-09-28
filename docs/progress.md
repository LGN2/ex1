# Progress

## Completed
- Spring Boot 3.5 / Java 21 Maven foundation.
- MySQL 8.4, Flyway and Docker Compose configuration.
- Core schema for users, buildings, units, tenants, leases and maintenance requests.
- Basic security filter and password encoder.
- Health, dashboard summary, building listing/creation/update endpoints.
- Arabic landing page, login page, dashboard page and property page.
- Initial Postman collection and GitHub Actions CI.
- Docker build corrected to use a Maven builder image.

## Remaining
- Replace development placeholder authentication with database-backed sessions and CSRF.
- Add floors, units, tenants and leases DTO/service layers.
- Add rent dues, payments, allocations, cheques, deposits and arrears.
- Add maintenance assignment/status history and Spring AI fallback.
- Add complete bilingual frontend pages and owner/tenant authorization isolation.
- Add full integration test suite and execute it against MySQL.

## Test results
GitHub Actions is configured, but a complete test run has not been executed in this environment.

## Next action
Continue with database-backed account seeding and billing vertical slice.