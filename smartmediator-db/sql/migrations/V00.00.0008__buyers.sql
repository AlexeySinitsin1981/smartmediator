-- Buyers table;

CREATE TABLE buyers
(
    id                  UUID   NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    org_id              UUID NULL,
    price_pattern_id    UUID NULL,
    CONSTRAINT pk_buyers UNIQUE (id),
    CONSTRAINT uk_buyers_org_id UNIQUE (org_id),
    CONSTRAINT fk_buyers_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_buyers_price_pattern_id FOREIGN KEY (price_pattern_id) REFERENCES price_patterns (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

