create table orders
(
    id          bigint auto_increment primary key,
    customer_id bigint,
    status      varchar(20),
    created_at  datetime  default (current_timestamp),
    total_price decimal(10, 2)
);

ALTER TABLE orders
    ADD CONSTRAINT orders_users_id_fk
        foreign key (customer_id) references users (id);



