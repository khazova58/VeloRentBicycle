-- liquibase formatted sql

-- changeset yakhazova:update-table-bicycle-13-09-23.sql
alter table bicycles.rental.bicycle add if not exists name varchar (200);