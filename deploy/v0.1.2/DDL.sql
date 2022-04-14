-- auto-generated definition
create table test_drive
(
    id          int auto_increment
        primary key,
    car_id      int           not null,
    address     varchar(255)  not null,
    phone       varchar(255)  not null,
    user_id     int           not null,
    create_time datetime      not null,
    update_time datetime      not null,
    status      int default 1 not null
);