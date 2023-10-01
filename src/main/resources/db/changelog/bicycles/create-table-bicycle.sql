-- liquibase formatted sql

-- changeset yakhazova:create-table-bicycle
create table if not exists rental.bicycle
(
    id          varchar(40) not null primary key,
    clazz       varchar(20),
    manufacturer varchar(20),
    diameter    int,
    frame       varchar(20),
    brake       varchar(20)
)