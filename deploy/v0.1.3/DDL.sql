-- auto-generated definition
create table after_sale_order
(
    id            int auto_increment
        primary key,
    price         float default 0 not null,
    order_status  int   default 0 not null,
    address       varchar(255)    not null,
    type          int             not null,
    car_id        int             not null,
    sale_order_id int             not null,
    user_id       int             not null,
    create_time   datetime        not null,
    update_time   datetime        not null,
    status        int   default 1 not null
);
