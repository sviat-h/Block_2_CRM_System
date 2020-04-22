CREATE TABLE orders
(
    id         serial  not null primary key,
    date       date    not null,
    totalPrice decimal not null
);