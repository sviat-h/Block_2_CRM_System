CREATE TABLE products
(
    id           serial       not null primary key,
    name         varchar(60)  not null,
    price        decimal      not null,
    description  varchar(100) not null,
    availability boolean      not null,
    quantity     integer      not null,
    category     varchar(20)  not null
);