CREATE TABLE orders
(
    id          serial  not null primary key,
    date        date    not null,
    total_price decimal not null,
    quantity    integer not null
);