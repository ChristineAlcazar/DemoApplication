CREATE DATABASE DB;
CREATE TABLE DB.users(
id int NOT NULL AUTO_INCREMENT primary key,
full_name varchar(255) NOT NULL,
email_address varchar(255) NOT NULL,
mobile_number varchar(100) NOT NULL,
date_of_birth varchar(100) NOT NULL,
age int NOT NULL,
gender varchar(100) NOT NULL);
