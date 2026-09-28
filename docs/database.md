# Database

MySQL 8.4 is the system of record. Flyway owns schema changes. Monetary values use DECIMAL(12,3) for OMR. Owner-scoped foreign keys and indexes are included in the initial migration. Applied migrations must not be edited; add a new V__ migration instead.