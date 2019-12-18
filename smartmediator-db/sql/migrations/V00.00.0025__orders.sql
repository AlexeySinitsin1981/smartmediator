-- Orders table.

CREATE TABLE orders
(
    id               UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    status           UUID NULL,
    buyer_id         UUID NULL,
    seller_id        UUID NULL,
    delivery         UUID NULL,
    price_pattern_id UUID NULL,
    get_from         UUID NULL,
    set_to           UUID NULL,
    note             TEXT NULL             DEFAULT '',
    CONSTRAINT pk_orders UNIQUE (id),
    CONSTRAINT fk_orders_status FOREIGN KEY (status) REFERENCES order_statuses (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_buyers FOREIGN KEY (buyer_id) REFERENCES buyers (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_sellers FOREIGN KEY (seller_id) REFERENCES sellers (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_delivery FOREIGN KEY (delivery) REFERENCES delivery_types (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_price_pattern FOREIGN KEY (price_pattern_id) REFERENCES price_patterns (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_get_from FOREIGN KEY (get_from) REFERENCES logistics_points (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_set_to FOREIGN KEY (set_to) REFERENCES logistics_points (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);
