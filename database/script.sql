CREATE DATABASE canalsdb;

USE canalsdb;

CREATE TABLE warehouse(
	id_warehouse BIGINT AUTO_INCREMENT,

    name_warehouse VARCHAR(255) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,

    PRIMARY KEY(id_warehouse)
);

CREATE TABLE orders(
	id_order BIGINT AUTO_INCREMENT,
    id_warehouse BIGINT,

    customer VARCHAR(255) NOT NULL,
    payment_status VARCHAR(50),

    PRIMARY KEY(id_order),
    FOREIGN KEY(id_warehouse) REFERENCES warehouse(id_warehouse)
);

CREATE TABLE address(
	id_address BIGINT AUTO_INCREMENT,
    id_order BIGINT UNIQUE,

    country VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    residence_num INT NOT NULL,
    apartment INT DEFAULT NULL,

    PRIMARY KEY(id_address),
    FOREIGN KEY (id_order) REFERENCES orders(id_order)
);

CREATE TABLE product(
	id_product BIGINT AUTO_INCREMENT,

    name_product VARCHAR(255) NOT NULL,
    value_product DECIMAL(15,2) NOT NULL,

    PRIMARY KEY(id_product),
    CHECK(value_product >= 0.0)
);

CREATE TABLE order_prod(
	id_order_prod BIGINT AUTO_INCREMENT,
	id_product BIGINT,
    id_order BIGINT,

    quantity INT NOT NULL,

    PRIMARY KEY(id_order_prod),
    FOREIGN KEY(id_product) REFERENCES product(id_product),
    FOREIGN KEY(id_order) REFERENCES orders(id_order),

    UNIQUE(id_product, id_order)
);

CREATE TABLE warehouse_prod(
	id_warehouse_prod BIGINT AUTO_INCREMENT,
	id_product BIGINT,
    id_warehouse BIGINT,

    quantity INT NOT NULL,

    PRIMARY KEY(id_warehouse_prod),
    FOREIGN KEY(id_product) REFERENCES product(id_product),
    FOREIGN KEY(id_warehouse) REFERENCES warehouse(id_warehouse),

    UNIQUE(id_product, id_warehouse)
);