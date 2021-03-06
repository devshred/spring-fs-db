CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE address (
    id     INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    street VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer (
    id   INTEGER      NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer_addresses (
    customer_id  INTEGER NOT NULL UNIQUE,
    addresses_id INTEGER NOT NULL
);

ALTER TABLE customer_addresses ADD CONSTRAINT fk_customer_addresses_address FOREIGN KEY (addresses_id) REFERENCES address;
ALTER TABLE customer_addresses ADD CONSTRAINT fk_customer_addresses_customer FOREIGN KEY (customer_id) REFERENCES customer;
