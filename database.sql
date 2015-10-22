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
CREATE TABLE appuser( 
id SERIAL PRIMARY KEY,
username varchar(255),
usertype varchar (25),
loginid varchar(60),
password varchar(60),
email varchar(60)
);

insert into appuser(username,usertype,loginid,password,email) values ('jhari','guest','0001','rablion-1','hari@rasoftwares.com');
select * from appuser
);

--drop table currency
CREATE TABLE currency(
  id  SERIAL PRIMARY KEY,
   currency varchar(60),
 sourcevalue numeric(10,2),
 inrvalue numeric(10,2)
 );
 insert into currency (currency,sourcevalue,inrvalue) values ('US$', 5000.00 , 500000.00);
 select * from currency
 
 
 
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
	
);
insert into todo(task,status,startdate,enddate,assignedto,createdby,createdtime,modifiedby) values ('todo','pending','20/10/2015','25/10/2015','who','me',CURRENT_TIMESTAMP,'jack');
select * from todo

--drop table loan;
select * from loan;

CREATE TABLE loan(
    id     SERIAL PRIMARY KEY,
    loanno varchar(60),
    customername varchar(60),
    amount numeric(10,2),
     totalweight varchar(60),
    item varchar(60)
    );
insert into loan(loanno,customername,amount,totalweight,item) values ('7891','mahi',5666.666,58.22,'bangles');

