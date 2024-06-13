create table if not exists notes
(
    id          INT AUTO_INCREMENT primary key,
    title       varchar(255) not null,
    description varchar(255) not null,
    create_date timestamp    not null
);