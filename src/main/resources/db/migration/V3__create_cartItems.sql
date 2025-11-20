create table cart_items
(
    id  BIGINT AUTO_INCREMENT primary key ,
    cart_id BINARY(16) NOT NULL,
    product_id  BIGINT  NOT NULL,
    quantity INT DEFAULT 1 NOT NULL
);

alter table cart_items
    add constraint cart_items_carts_id_fk foreign key (cart_id) references carts (id)
            on delete cascade;


alter table cart_items
    add constraint cart_items_products_id_fk foreign key (product_id) references products (id)
            on delete cascade;

ALTER TABLE cart_items
    ADD CONSTRAINT cart_items_cart_product_unique unique (cart_id, product_id);




