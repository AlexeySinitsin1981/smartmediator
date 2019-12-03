-- External_links table.

CREATE TABLE external_links
(
    id         BIGSERIAL,
    org_id     BIGINT      NOT NULL,
    product_id BIGINT      NOT NULL,
    code       varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT pk_external_links PRIMARY KEY (id),
    CONSTRAINT fk_external_links_org FOREIGN KEY (org_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_external_links_product FOREIGN KEY (product_id) REFERENCES products (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_external_links_code ON external_links (code);
