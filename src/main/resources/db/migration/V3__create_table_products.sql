CREATE TABLE products
(
    id           serial       not null primary key,
    name         varchar(100)  not null,
    price        decimal      not null,
    description  varchar(200) not null,
    availability boolean      not null,
    quantity     integer      not null,
    category     varchar(30)  not null
);