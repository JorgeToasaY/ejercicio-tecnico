-- ========================
-- SCHEMA: microservicios_db
-- ========================

-- Tabla Person
CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    age INT,
    identification VARCHAR(20) UNIQUE NOT NULL,
    address VARCHAR(200),
    phone VARCHAR(20)
);

-- Tabla Customer (hereda de Person por composición)
CREATE TABLE customer (
    id INT PRIMARY KEY,
	customerId VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    state BOOLEAN NOT NULL,
    FOREIGN KEY (id) REFERENCES person(id)
);

-- Tabla Account
CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    accountNumber VARCHAR(20) UNIQUE NOT NULL,
    accountType VARCHAR(50) NOT NULL,
    initialBalance DECIMAL(12,2) NOT NULL,
    state BOOLEAN NOT NULL,
    customerId VARCHAR(100) NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

-- Tabla Movement
CREATE TABLE movement (
    id SERIAL PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    movementType VARCHAR(50) NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    balance DECIMAL(12,2) NOT NULL,
    accountId INT NOT NULL,
    FOREIGN KEY (accountId) REFERENCES account(id)
);
