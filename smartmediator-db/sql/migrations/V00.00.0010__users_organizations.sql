-- Users_organizations table.

CREATE TABLE users_organizations
(
    id      UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    user_id UUID NULL,
    org_id  UUID NULL,
    CONSTRAINT pk_users_organizations UNIQUE (id),
    CONSTRAINT fk_users_organizations_users FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_users_organizations_organizations FOREIGN KEY (org_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);