--Expense 
--drop table expense;

CREATE TABLE expense (
    id     SERIAL PRIMARY KEY,
    username varchar(60),
    date date,
    currency varchar(60),
    amount numeric(10,2),
    type varchar(60)
);

insert into expense (username, date, currency, amount, type) values ('Fowmi', CURRENT_TIMESTAMP , 'USD', 500.00, 'Travel');
insert into expense (username, date, currency, amount,type) values ('Fowmi', CURRENT_TIMESTAMP , 'INR', 10.00, 'Food');
insert into expense (username, date, currency, amount,type) values ('Fowmi', CURRENT_TIMESTAMP , 'INR', 50.00, 'Mobile');

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
select * from appuser;

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
	assignedto varchar(60),
	createdby varchar(60),
	createdtimestamp date,
	modifiedby varchar(60)
	
);
insert into todo(task,status,startdate,enddate,assignedto,createdby,createdtimestamp,modifiedby) values ('todo','pending','20/10/2015','25/10/2015','who','me',CURRENT_TIMESTAMP,'jack');
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

--drop table inventory;

CREATE TABLE inventory( 
id SERIAL PRIMARY KEY,
itemname varchar(255),
itemtype varchar(255),
quantity numeric(10),
alertlimit numeric(100),
purchaseprice numeric(10,2),
discountpercentage numeric(10),
purchasedate date,
saledate date,
image varchar(255)
);
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image) values ('processor','intel I7',5,10,10000.00,10,'Feb-06-2014','Feb-12-2014','catalog\images\pros.jpg');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image) values ('ram','intel I7',5,10,10000.00,5,'Jan-02-2016','Jan-10-2016','catalog\images\ram.jpg');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image) values ('data cable','intel I7',5,10,10000.00,4,'Jun-24-2014','Jun-28-2014','catalog\images\dc.jpg');

select * from inventory

---drop table catalog;
CREATE TABLE catalog (
    id     SERIAL PRIMARY KEY,
    model varchar(60),
    price numeric(10,2),
    discount numeric(10,2),
    image varchar(60)
    
);

insert into catalog(model,price,discount,image) values ('halfsaree',1000.00,250.00,'image\1.jpg')


---MySql Script For Bse Application--

--1.Extract and Retrive
---csvlist table---
CREATE TABLE  `csvdb`.`csvlist` (
  `sno` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `csvfiles` longblob,
  `date` varchar(50) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=659 DEFAULT CHARSET=latin1;

---2.Bulkeals---
--bulkdeals table---
CREATE TABLE  `csvdb`.`bulkdeals` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `csvfiles` longblob,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;

--drop table article;
CREATE TABLE article(
    id     SERIAL PRIMARY KEY,
    title varchar(255),
    publishdate date,
    content varchar(255),
    category varchar(25),
    type varchar(255),
    item varchar(255),
    summary varchar(255)
);

select * from article;




