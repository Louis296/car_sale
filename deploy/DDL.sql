create table if not exists car
(
    id          int auto_increment
        primary key,
    name        varchar(255)  not null,
    version     varchar(255)  not null,
    description varchar(255)  not null,
    create_time datetime      not null,
    update_time datetime      not null,
    status      int default 1 not null
);

create table if not exists sale_order
(
    id                int auto_increment
        primary key,
    price             float         not null,
    car_id            int           not null,
    user_id           int           not null,
    sale_order_status int default 0 not null,
    create_time       datetime      not null,
    update_time       datetime      not null,
    status            int default 1 not null
);

create table if not exists user
(
    id          int auto_increment
        primary key,
    user_id     varchar(255)  not null,
    password    varchar(255)  not null,
    phone       varchar(255)  null,
    type        int default 1 not null,
    create_time datetime      not null,
    update_time datetime      not null,
    status      int default 1 not null,
    constraint user_userId_uindex
        unique (user_id)
);

