-- liquibase formatted sql

-- changeset: ekukarskiy: 10
CREATE TABLE IF NOT EXISTS Customers(
	id bigserial PRIMARY KEY,
	name TEXT NOT NULL,
	surname TEXT NOT NULL,
	age int NOT NULL,
	phone_number TEXT
);
