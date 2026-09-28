CREATE TABLE rent_due (
 id BINARY(16) PRIMARY KEY, lease_id BINARY(16) NOT NULL, due_month DATE NOT NULL,
 amount DECIMAL(12,3) NOT NULL, settled_amount DECIMAL(12,3) NOT NULL DEFAULT 0,
 status VARCHAR(20) NOT NULL, UNIQUE KEY uq_due_month(lease_id,due_month),
 CONSTRAINT fk_due_lease FOREIGN KEY (lease_id) REFERENCES lease(id)
);
CREATE TABLE payment (
 id BINARY(16) PRIMARY KEY, lease_id BINARY(16) NOT NULL, amount DECIMAL(12,3) NOT NULL,
 method VARCHAR(30) NOT NULL, status VARCHAR(20) NOT NULL, received_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 CONSTRAINT fk_payment_lease FOREIGN KEY (lease_id) REFERENCES lease(id)
);
CREATE TABLE payment_allocation (
 id BINARY(16) PRIMARY KEY, payment_id BINARY(16) NOT NULL, due_id BINARY(16) NOT NULL,
 amount DECIMAL(12,3) NOT NULL, UNIQUE KEY uq_payment_due(payment_id,due_id),
 CONSTRAINT fk_allocation_payment FOREIGN KEY (payment_id) REFERENCES payment(id),
 CONSTRAINT fk_allocation_due FOREIGN KEY (due_id) REFERENCES rent_due(id)
);
CREATE TABLE cheque (
 id BINARY(16) PRIMARY KEY, lease_id BINARY(16) NOT NULL, cheque_number VARCHAR(80) NOT NULL,
 amount DECIMAL(12,3) NOT NULL, deposit_date DATE NOT NULL, status VARCHAR(20) NOT NULL,
 cleared_payment_id BINARY(16) NULL UNIQUE, CONSTRAINT fk_cheque_lease FOREIGN KEY (lease_id) REFERENCES lease(id),
 CONSTRAINT fk_cheque_payment FOREIGN KEY (cleared_payment_id) REFERENCES payment(id)
);