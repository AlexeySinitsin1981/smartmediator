-- Users table.

CREATE TABLE users
(
    id       UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    email    varchar(255) NULL CHECK (length(email) > 0),
    password varchar(255) NULL CHECK (length(password) > 0),
    username varchar(255) NULL CHECK (length(username) > 0),
    status   UUID         NULL,
    active   boolean      NULL,
    CONSTRAINT pk_users UNIQUE (id),
    CONSTRAINT uq_users_email UNIQUE (email),
    CONSTRAINT uq_users_username UNIQUE (username),
    CONSTRAINT fk_users_status FOREIGN KEY (status) REFERENCES user_statuses (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_users_username ON users (username);