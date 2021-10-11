CREATE TABLE address (
    id     INTEGER NOT NULL,
    street VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer (
    id   INTEGER NOT NULL,
    name VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer_addresses (
    customer_id  INTEGER NOT NULL,
    addresses_id INTEGER NOT NULL
);
