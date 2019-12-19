-- Units table.

CREATE TABLE units
(
    id      UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    code    varchar(50) NULL CHECK (length(code) > 0),
    name    varchar(50) NULL CHECK (length(name) > 0),
    deleted boolean,
    CONSTRAINT pk_units UNIQUE (id),
    CONSTRAINT uq_units_code UNIQUE (code),
    CONSTRAINT uq_units_name UNIQUE (name)
);
