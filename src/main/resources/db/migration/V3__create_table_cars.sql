CREATE TABLE food_product
(
    id           serial       not null primary key,
    name         varchar(60)  not null,
    price        money        not null,
    description  varchar(100) not null,
    availability boolean      not null,
    category     varchar(20)  not null
);