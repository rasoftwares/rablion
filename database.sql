--drop table expense;

CREATE TABLE expense (
    id     SERIAL PRIMARY KEY,
    username varchar(60),
    date date,
    amount numeric(10,2),
    type varchar(60)
    
);

insert into expense (username,date,amount,type) values ('Raja', CURRENT_TIMESTAMP , 500.00, 'Travel')

select * from expense

select now() from dual

CREATE TABLE appuser (
    id     integer,
    username varchar(60)
);

