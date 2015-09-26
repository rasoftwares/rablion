--Expense 
--drop table expense;

CREATE TABLE expense (
    id     SERIAL PRIMARY KEY,
    username varchar(60),
    date date,
    amount numeric(10,2),
    type varchar(60)
    
);

insert into expense (username,date,amount,type) values ('User1', CURRENT_TIMESTAMP , 500.00, 'Travel');
insert into expense (username,date,amount,type) values ('User2', CURRENT_TIMESTAMP , 500.00, 'Food');
insert into expense (username,date,amount,type) values ('User1', CURRENT_TIMESTAMP , 500.00, 'Mobile');

select * from expense

--Appuser
--drop table appuser
CREATE TABLE appuser (
    id     integer,
    username varchar(60)
);

--TODO's
--drop table todo
create table todo( 
	id SERIAL PRIMARY KEY,
	task varchar(255),
	status varchar (25),
	startdate date,
	enddate date,
	assignedto varchar(60)
	createdby varchar(60),
	createdtimestamp date,
	modifiedby varchar(60),
	modifiedtimestamp date
);