CREATE TABLE IF NOT EXISTS organization (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    full_name  VARCHAR(100) NOT NULL COMMENT 'Полное имя',
    name       VARCHAR(50) NOT NULL COMMENT 'имя',
    inn        VARCHAR(10) NOT NULL COMMENT 'инн' UNIQUE,
    kpp        VARCHAR(10) NOT NULL COMMENT 'kpp' UNIQUE,
    address    VARCHAR(100) NOT NULL COMMENT 'адрес',
    phone      VARCHAR(20)          COMMENT 'телефон',
    is_active   BOOLEAN
);

CREATE INDEX IX_organization_full_name ON organization (full_name);
CREATE INDEX IX_organization_inn ON organization (inn);
CREATE INDEX IX_organization_is_active ON organization (is_active);

CREATE TABLE IF NOT EXISTS office (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    organization_id      INTEGER NOT NULL     COMMENT 'id Организации',
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    name       VARCHAR(50) NOT NULL COMMENT 'название',
    address    VARCHAR(100) NOT NULL COMMENT 'адрес',
    phone      VARCHAR(20)          COMMENT 'телефон',
    is_active   BOOLEAN NOT NULL,
    FOREIGN KEY (organization_id) REFERENCES organization (id)
);

CREATE INDEX IX_office_name ON office (name);
CREATE INDEX IX_office_phone ON office (phone);
CREATE INDEX IX_office_is_active ON office (is_active);


CREATE TABLE IF NOT EXISTS doc_dictionary (
  code  INTEGER  NOT NULL COMMENT 'код документа' PRIMARY KEY,
  name  VARCHAR(50) NOT NULL COMMENT 'наименование документа'
);

CREATE TABLE IF NOT EXISTS country_dictionary (
  code  INTEGER  NOT NULL COMMENT 'код страны' PRIMARY KEY,
  name  VARCHAR(50) NOT NULL COMMENT 'название страны'
);

CREATE TABLE IF NOT EXISTS user_table (
    id          INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    office_id   INTEGER NOT NULL     COMMENT 'id офиса',
    version     INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    first_name  VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name VARCHAR(50)          COMMENT 'Фамилия',
    middle_name VARCHAR(50)          COMMENT 'Отчество',
    post        VARCHAR(50) NOT NULL COMMENT 'Позиция',
    phone       VARCHAR(20)          COMMENT 'телефон',
    citizenship_code VARCHAR(3),
    is_identified BOOLEAN,
    FOREIGN KEY (citizenship_code)   REFERENCES country_dictionary (code),
    FOREIGN KEY (office_id)          REFERENCES office (id)
);

CREATE INDEX IX_user_first_name ON user_table (first_name);
CREATE INDEX IX_user_second_name   ON user_table (second_name);
CREATE INDEX IX_user_middle_name   ON user_table (middle_name);
CREATE INDEX IX_user_post   ON user_table (post);


CREATE TABLE IF NOT EXISTS user_document (
      id          INTEGER PRIMARY KEY AUTO_INCREMENT,
      version     INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
      doc_number  VARCHAR(50),
      doc_code    INTEGER,
      doc_date    DATE,
      FOREIGN KEY (doc_code) REFERENCES doc_dictionary (code),
      FOREIGN KEY (id)  REFERENCES user_table (id)
);

CREATE INDEX UX_user_document_user_id ON user_document (id);








