-- Products table.

CREATE TABLE products
(
    id               UUID   NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    code             varchar(50)    NOT NULL CHECK (length(code) > 0),
    name             varchar(50)    NOT NULL CHECK (length(name) > 0),
    unit_id          UUID         NOT NULL,
    products_type_id UUID         NOT NULL,
    seller_id        UUID         NOT NULL,
    quantity        decimal(20, 3) NOT NULL CHECK (quantity >= 0),
    note             TEXT           NOT NULL DEFAULT '',
    deleted          boolean,
    CONSTRAINT pk_products UNIQUE (id),
    CONSTRAINT fk_products_units FOREIGN KEY (unit_id) REFERENCES units (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_products_products_types FOREIGN KEY (products_type_id) REFERENCES products_types (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_products_sellers FOREIGN KEY (seller_id) REFERENCES sellers (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_products_code ON products (code);
CREATE INDEX idx_products_name ON products (name);
CREATE INDEX idx_products_quantity ON products (quantity);
