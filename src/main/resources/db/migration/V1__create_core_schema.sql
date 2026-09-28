CREATE TABLE app_user (
 id BINARY(16) PRIMARY KEY,
 email VARCHAR(190) NOT NULL UNIQUE,
 password_hash VARCHAR(255) NOT NULL,
 role VARCHAR(30) NOT NULL,
 owner_id BINARY(16) NULL,
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE building (
 id BINARY(16) PRIMARY KEY,
 owner_id BINARY(16) NOT NULL,
 name VARCHAR(150) NOT NULL,
 address VARCHAR(255) NOT NULL,
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 CONSTRAINT fk_building_owner FOREIGN KEY (owner_id) REFERENCES app_user(id)
);
CREATE TABLE unit (
 id BINARY(16) PRIMARY KEY,
 building_id BINARY(16) NOT NULL,
 code VARCHAR(50) NOT NULL,
 unit_type VARCHAR(30) NOT NULL,
 availability VARCHAR(30) NOT NULL,
 area DECIMAL(12,3) NOT NULL,
 UNIQUE KEY uq_unit_building_code(building_id, code),
 CONSTRAINT fk_unit_building FOREIGN KEY (building_id) REFERENCES building(id)
);
CREATE TABLE tenant (
 id BINARY(16) PRIMARY KEY,
 owner_id BINARY(16) NOT NULL,
 full_name VARCHAR(180) NOT NULL,
 email VARCHAR(190),
 phone VARCHAR(40),
 tenant_type VARCHAR(30) NOT NULL,
 CONSTRAINT fk_tenant_owner FOREIGN KEY (owner_id) REFERENCES app_user(id)
);
CREATE TABLE lease (
 id BINARY(16) PRIMARY KEY,
 owner_id BINARY(16) NOT NULL,
 unit_id BINARY(16) NOT NULL,
 tenant_id BINARY(16) NOT NULL,
 start_date DATE NOT NULL,
 end_date DATE NOT NULL,
 monthly_rent DECIMAL(12,3) NOT NULL,
 deposit_amount DECIMAL(12,3) NOT NULL,
 status VARCHAR(30) NOT NULL,
 CONSTRAINT ck_lease_dates CHECK (end_date > start_date),
 CONSTRAINT fk_lease_owner FOREIGN KEY (owner_id) REFERENCES app_user(id),
 CONSTRAINT fk_lease_unit FOREIGN KEY (unit_id) REFERENCES unit(id),
 CONSTRAINT fk_lease_tenant FOREIGN KEY (tenant_id) REFERENCES tenant(id)
);
CREATE INDEX ix_lease_unit_dates ON lease(unit_id, start_date, end_date);
CREATE TABLE maintenance_request (
 id BINARY(16) PRIMARY KEY,
 owner_id BINARY(16) NOT NULL,
 tenant_id BINARY(16) NULL,
 title VARCHAR(180) NOT NULL,
 description_en TEXT NOT NULL,
 description_ar TEXT,
 category VARCHAR(30) NOT NULL,
 status VARCHAR(30) NOT NULL,
 urgent BOOLEAN NOT NULL DEFAULT FALSE,
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 CONSTRAINT fk_maintenance_owner FOREIGN KEY (owner_id) REFERENCES app_user(id),
 CONSTRAINT fk_maintenance_tenant FOREIGN KEY (tenant_id) REFERENCES tenant(id)
);