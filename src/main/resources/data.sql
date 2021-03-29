INSERT INTO organization (version, full_name, name, inn, kpp, address, phone, is_active)
              VALUES (1,'ООО Ромашка', 'Ромашка', 7718057567, 771801001,
              'г. Москва, шоссе Щёлковское, д. 69', 155-24-78, true);

INSERT INTO organization (version, full_name, name, inn, kpp, address, phone, is_active)
              VALUES (2,'ООО Василек', 'Василек', 7705902106, 770501001,
              'г. Москва, набережная Овчинниковская, д. 20', 215-48-55, true);

INSERT INTO office (organization_id, version, name, address, phone, is_active)
              VALUES (1, 1, 'Офис_1', 'Москва, ул. Тверская, 5', 154-45-77, true);
INSERT INTO office (organization_id, version, name, address, phone, is_active)
              VALUES (2, 2, 'Офис_2', 'Москва, ул. Ленина, 10', 154-11-77, true);

INSERT INTO doc_dictionary (code, name) VALUES (03, 'Свидетельство о рождении');
INSERT INTO doc_dictionary (code, name) VALUES (07, 'Военный билет');

INSERT INTO country_dictionary (code, name) VALUES (643, 'Российская Федерация');

INSERT INTO user_table (office_id, version, first_name, second_name, middle_name, post, phone, is_identified)
VALUES (1,1, 'Иван', 'Иванов', 'Петрович', 'менеджер', 150-76, true);

INSERT INTO user_table (office_id, version, first_name, second_name, middle_name, post, phone, is_identified)
VALUES (2,3, 'Андрей', 'Васильев', 'Олегович', 'Директор', 150-95, true);

-- INSERT INTO USER_DOCUMENT (version, doc_number, doc_code, doc_date)
--             VALUES (10,'101',1,'20-01-2001');


