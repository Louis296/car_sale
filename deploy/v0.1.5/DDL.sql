-- auto-generated definition
create table comment
(
    id          int auto_increment
        primary key,
    context     tinytext      not null,
    user_id     int           not null,
    moment_id   int           not null,
    create_time datetime      not null,
    update_time datetime      not null,
    status      int default 1 not null
);

-- auto-generated definition
create table moment
(
    id          int auto_increment
        primary key,
    context     text          not null,
    `like`      int default 0 not null,
    img_url     varchar(255)  null,
    user_id     int           not null,
    create_time datetime      not null,
    update_time datetime      not null,
    status      int default 1 not null
);

-- auto-generated definition
create table thumb_up
(
    id          int auto_increment
        primary key,
    moment_id   int           not null,
    user_id     int           not null,
    create_time datetime      not null,
    update_time datetime      not null,
    status      int default 1 not null
);

