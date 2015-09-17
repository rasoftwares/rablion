--drop table expense;

CREATE TABLE expense (
    id     SERIAL PRIMARY KEY,
    username varchar(60)
);

insert into expense (username) values ('robin')

select * from expense

CREATE TABLE appuser (
    id     integer,
    username varchar(60)
);

