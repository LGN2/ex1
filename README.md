# Property Management

Oman-focused building and property management application.

## Current foundation
- Spring Boot 3.5 / Java 21 / Maven
- MySQL 8.4 with Flyway migrations
- Docker Compose
- Core schema for users, buildings, units, tenants, leases and maintenance
- Arabic RTL landing page and health endpoint

## Run
1. Copy .env.example to .env and adjust credentials.
2. Start MySQL: `docker compose up mysql -d`
3. Run: `./mvnw spring-boot:run`
4. Open http://localhost:8080

Java 21 is required. The Maven compiler is configured through Spring Boot's `java.version`; this avoids the unsupported JVM target 5 issue.

## API
- GET /api/health

The remaining vertical slices are tracked in docs/progress.md.