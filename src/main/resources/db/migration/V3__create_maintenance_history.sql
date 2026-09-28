CREATE TABLE maintenance_status_history (
 id BINARY(16) PRIMARY KEY, request_id BINARY(16) NOT NULL, old_status VARCHAR(30),
 new_status VARCHAR(30) NOT NULL, comment VARCHAR(500), created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 CONSTRAINT fk_history_request FOREIGN KEY (request_id) REFERENCES maintenance_request(id)
);