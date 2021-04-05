CREATE TABLE IF NOT EXISTS organization (
    id         INTEGER      PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER      NOT NULL,
    full_name  VARCHAR(300) NOT NULL,
    name       VARCHAR(200)  NOT NULL,
    inn        VARCHAR(100)  NOT NULL,
    kpp        VARCHAR(100)  NOT NULL,
    address    VARCHAR(300) NOT NULL,
    phone      VARCHAR(100),
    is_active  BOOLEAN
);

CREATE INDEX IX_organization_full_name ON organization (full_name);
CREATE INDEX IX_organization_inn ON organization (inn);
CREATE INDEX IX_organization_is_active ON organization (is_active);

CREATE TABLE IF NOT EXISTS office (
    id         INTEGER              PRIMARY KEY AUTO_INCREMENT,
    organization_id INTEGER         NOT NULL,
    version    INTEGER              NOT NULL,
    name       VARCHAR(200)         NOT NULL,
    address    VARCHAR(200)         NOT NULL,
    phone      VARCHAR(100),
    is_active  BOOLEAN,
    FOREIGN KEY (organization_id) REFERENCES organization (id)
);

CREATE INDEX IX_office_name ON office (name);
CREATE INDEX IX_office_phone ON office (phone);
CREATE INDEX IX_office_is_active ON office (is_active);


CREATE TABLE IF NOT EXISTS doc_dictionary (
  code  INTEGER PRIMARY KEY,
  name  VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS country_dictionary (
  code  INTEGER PRIMARY KEY,
  name  VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS user_table (
    id          INTEGER              PRIMARY KEY AUTO_INCREMENT,
    office_id   INTEGER              NOT NULL,
    version     INTEGER              NOT NULL,
    first_name  VARCHAR(200)         NOT NULL,
    second_name VARCHAR(200),
    middle_name VARCHAR(200),
    position    VARCHAR(100)          NOT NULL,
    phone       VARCHAR(100),
    citizenship_code INTEGER,
    is_identified BOOLEAN,
    FOREIGN KEY (citizenship_code)   REFERENCES country_dictionary (code),
    FOREIGN KEY (office_id)          REFERENCES office (id)
);

CREATE INDEX IX_user_first_name ON user_table (first_name);
CREATE INDEX IX_user_second_name   ON user_table (second_name);
CREATE INDEX IX_user_middle_name   ON user_table (middle_name);
CREATE INDEX IX_user_post   ON user_table (position);


CREATE TABLE IF NOT EXISTS user_document (
      id          INTEGER PRIMARY KEY AUTO_INCREMENT,
      version     INTEGER NOT NULL,
      doc_number  VARCHAR(100),
      doc_code    INTEGER,
      doc_date    DATE,
      FOREIGN KEY (doc_code) REFERENCES doc_dictionary (code),
      FOREIGN KEY (id)  REFERENCES user_table (id)
);

CREATE INDEX UX_user_document_user_id ON user_document (id);

create sequence HIBERNATE_SEQUENCE;






