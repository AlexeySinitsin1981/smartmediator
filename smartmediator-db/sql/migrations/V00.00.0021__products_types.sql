-- Products_types table.

CREATE TABLE products_types
(
    id      UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    code    varchar(50) NULL CHECK (length(code) > 0),
    name    varchar(50) NULL CHECK (length(name) > 0),
    deleted boolean,
    CONSTRAINT pk_products_types UNIQUE (id),
    CONSTRAINT uq_products_types_code UNIQUE (code),
    CONSTRAINT uq_products_types_name UNIQUE (name)
);
