SHOW DATABASES ;
USE jpaEmDemo;

CREATE TABLE cd (
    id INTEGER(255),
    title VARCHAR(255),
    des VARCHAR(255),
    year INTEGER(255),
    artist VARCHAR(255),
    price INTEGER(255)
);

CREATE TABLE artist(
    id INTEGER(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    instrument VARCHAR(255)
);

SHOW TABLES ;


