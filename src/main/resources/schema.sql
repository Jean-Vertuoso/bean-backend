-- DROP TABLES se já existirem, para reiniciar o schema (opcional)
DROP TABLE IF EXISTS tb_product_category;
DROP TABLE IF EXISTS tb_product;
DROP TABLE IF EXISTS tb_category;
DROP TABLE IF EXISTS tb_inventory;
DROP TABLE IF EXISTS tb_user_role;
DROP TABLE IF EXISTS tb_user;
DROP TABLE IF EXISTS tb_role;
DROP TABLE IF EXISTS tb_client_phones;
DROP TABLE IF EXISTS tb_client_addresses;
DROP TABLE IF EXISTS tb_client;
DROP TABLE IF EXISTS tb_cash_session;
DROP TABLE IF EXISTS tb_sale_item;
DROP TABLE IF EXISTS tb_sale;

CREATE TABLE tb_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tb_product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DECIMAL(15, 2) NOT NULL,
    bar_code VARCHAR(50) NOT NULL,
    img_url VARCHAR(255),
    packaging_type VARCHAR(50) NOT NULL,
    unit_of_measure VARCHAR(50) NOT NULL
);

CREATE TABLE tb_product_category (
    product_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT pk_product_category PRIMARY KEY (product_id, category_id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES tb_product(id) ON DELETE CASCADE,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES tb_category(id)
);

CREATE TABLE tb_inventory (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL,
    minimum_quantity INT NOT NULL,
    total_value DECIMAL(15, 2) NOT NULL,
    last_updated TIMESTAMP NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT fk_inventory_product FOREIGN KEY (product_id) REFERENCES tb_product(id)
);

CREATE TABLE tb_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE tb_role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    authority VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE tb_user_role (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_role_user FOREIGN KEY (user_id) REFERENCES tb_user(id),
    CONSTRAINT fk_user_role_role FOREIGN KEY (role_id) REFERENCES tb_role(id)
);

CREATE TABLE tb_client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    document_type VARCHAR(50) NOT NULL,
    document_number VARCHAR(50) NOT NULL,
    email VARCHAR(255)
);

CREATE TABLE tb_client_phones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    area_code VARCHAR(10) NOT NULL,
    number VARCHAR(20) NOT NULL,
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_client_phone_client FOREIGN KEY (client_id) REFERENCES tb_client(id)
);

CREATE TABLE tb_client_addresses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(50),
    neighborhood VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(2),
    postal_code VARCHAR(20),
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_client_address_client FOREIGN KEY (client_id) REFERENCES tb_client(id)
);

CREATE TABLE tb_cash_session (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    opening_timestamp TIMESTAMP WITH TIME ZONE NOT NULL,
    closing_timestamp TIMESTAMP WITH TIME ZONE,
    opening_amount DECIMAL(15, 2) NOT NULL,
    closing_amount DECIMAL(15, 2),
    expected_amount DECIMAL(15, 2),
    notes VARCHAR(255),
    closed BOOLEAN NOT NULL,
    operator_id BIGINT NOT NULL,
    CONSTRAINT fk_cash_session_operator FOREIGN KEY (operator_id) REFERENCES tb_user(id)
);

CREATE TABLE tb_sale (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sale_timestamp TIMESTAMP WITH TIME ZONE NOT NULL,
    total_value DECIMAL(15, 2) NOT NULL,
    total_discount DECIMAL(15, 2),
    payment_method INT NOT NULL,
    client_id BIGINT NOT NULL,
    operator_id BIGINT NOT NULL,
    cash_session_id BIGINT NOT NULL,
    CONSTRAINT fk_sale_client FOREIGN KEY (client_id) REFERENCES tb_client(id),
    CONSTRAINT fk_sale_operator FOREIGN KEY (operator_id) REFERENCES tb_user(id),
    CONSTRAINT fk_sale_cash_session FOREIGN KEY (cash_session_id) REFERENCES tb_cash_session(id)
);

CREATE TABLE tb_sale_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sale_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(15, 2) NOT NULL,
    discount DECIMAL(15, 2),
    CONSTRAINT fk_sale_item_sale FOREIGN KEY (sale_id) REFERENCES tb_sale(id),
    CONSTRAINT fk_sale_item_product FOREIGN KEY (product_id) REFERENCES tb_product(id)
);
