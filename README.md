REST сервис организаций, сотрудников, офисов
-

Учебное задание на Java для Bell Integrator
Сервис позволяет выполнить CRUD операции для:
* организаций
* офисов
* сотрудников
* документов

Данный сервис может быть использован как начальная структура для какого-нибудь компании арендаторов...


Запуск проекта:
--
1.Собрать проект с помощью Maven:
зайти в папку с проектом
вызвать в консоли mvn clean package
запустить java -jar target/practice-0.0.1.jar
2.С помощью IDEA:
Открыть проект
Запустить main в классе ProjectApplication

По умолчанию используется БД H2 in memory и поэтому не нужно ничего конфигурировать для подключения к БД
Если вы хотите запустить собственную БД, то необходимо выполнить данные пункты:
-Указать в config логин и пароль к БД H2
-Для того чтобы создать структуру для нашего проекта нужна накатить sql скрипт и заполнить его. Скрипты находятся в корне проекта: https://github.com/Salavato/bell_project/blob/main/src/main/resources/data.sql
https://github.com/Salavato/bell_project/blob/main/src/main/resources/schema.sql

Технологии:
-
* Spring, Hibernate
* Maven
* H2
* Swagger

Используется многослойная архитектура со следующими слоями:
Conroller - слой представления, ответственный за реализацию API
DAO - слой доступа к данным (хранения данных)
Service - слой бизнес-логики




