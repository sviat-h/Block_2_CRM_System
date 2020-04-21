CREATE TABLE users
(
    id         serial      not null primary key,
    first_name varchar(60) not null,
    last_name  varchar(60) not null,
    age        integer     not null,
    phone      varchar(15) not null,
    account_id integer     not null unique
);