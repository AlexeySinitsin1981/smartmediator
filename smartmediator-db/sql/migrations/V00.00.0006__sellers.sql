-- Sellers table;

CREATE TABLE sellers
(
    id               UUID   NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    org_id           UUID   NULL,
    CONSTRAINT uk_sellers UNIQUE (id),
    CONSTRAINT uk_sellers_org_id UNIQUE (org_id),
    CONSTRAINT fk_sellers_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

