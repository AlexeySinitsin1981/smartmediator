-- Orders_products table.

CREATE TABLE orders_products
(
    id         UUID           NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    order_id   UUID           NULL,
    product_id UUID           NULL,
    amount     decimal(15, 3) NULL CHECK (amount > 0),
    note       TEXT           NULL                 DEFAULT '',
    CONSTRAINT pk_orders_products UNIQUE (id),
    CONSTRAINT fk_orders_products_orders FOREIGN KEY (order_id) REFERENCES orders (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_products_products FOREIGN KEY (product_id) REFERENCES products (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_orders_products_amount ON orders_products (amount);