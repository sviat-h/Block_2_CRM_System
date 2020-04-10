CREATE TABLE accounts
(
    id serial not null primary key,
    username   varchar(60) not null unique,
    email   varchar(60) not null unique,
    password varchar (60) not null,
    confirm_password varchar (60) not null,
    role varchar (10) not null
);