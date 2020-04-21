CREATE TABLE cars
(
    id           serial       not null primary key,
    name         varchar(60)  not null,
    price        money        not null,
    description  varchar(100) not null,
    availability boolean      not null,
    type         varchar(10)  not null,
    brand        varchar(10)  not null
);