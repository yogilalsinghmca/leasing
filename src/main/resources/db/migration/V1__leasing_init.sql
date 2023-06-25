--
-- customer table
--
CREATE TABLE customers (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  birthDate DATE,
  CONSTRAINT uk_customers_name UNIQUE (first_name, last_name)
);

--
-- vehicle table
--

CREATE TABLE vehicles (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  Brand VARCHAR(255),
  model VARCHAR(255),
  model_year INTEGER,
  vehicle_identification_number VARCHAR(255),
  price DECIMAL(19, 2)
);
--
-- leasing contract table
--
CREATE TABLE contracts (
  contract_number BIGINT PRIMARY KEY AUTO_INCREMENT,
  monthly_rate DECIMAL(19,2),
  customer_id BIGINT,
  vehicle_id BIGINT,
  FOREIGN KEY (customer_id) REFERENCES customers (id),
  FOREIGN KEY (vehicle_id) REFERENCES vehicles (id)
);