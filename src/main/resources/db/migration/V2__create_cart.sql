create table carts
(
    id              BINARY(16)  DEFAULT (uuid_to_bin(uuid())) NOT NULL primary key ,
    date_created    DATE        DEFAULT (curdate()) NOT NULL
);