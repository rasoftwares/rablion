--Expense 

--drop table expense;

CREATE TABLE expense (
    id     SERIAL PRIMARY KEY,
    username varchar(60),
    date date,
    currency varchar(60),
    amount numeric(10,2),
    type varchar(60),
    createdby varchar(60),
	createdtimestamp date,
	modifiedby varchar(60)
);

insert into expense (username, date, currency, amount, type) values ('Fowmi', CURRENT_TIMESTAMP , 'USD', 500.00, 'Travel');
insert into expense (username, date, currency, amount,type) values ('Fowmi', CURRENT_TIMESTAMP , 'INR', 10.00, 'Food');
insert into expense (username, date, currency, amount,type) values ('Fowmi', CURRENT_TIMESTAMP , 'INR', 50.00, 'Mobile');

select * from expense


--drop table appuser

CREATE TABLE appuser( 
id SERIAL PRIMARY KEY,
username varchar(255),
usertype varchar (25),
loginid varchar(60),
password varchar(60),
email varchar(60),
createdby varchar(60),
createdtimestamp date,
modifiedby varchar(60),
modifiedtimestamp date
);

insert into appuser(username,usertype,loginid,password,email) values ('jhari','guest','0001','rablion-1','hari@rasoftwares.com');
select * from appuser;

--drop table currency
CREATE TABLE currency(
 id  SERIAL PRIMARY KEY,
 currency varchar(60),
 sourcevalue numeric(10,2),
 inrvalue numeric(10,2),
 createdby varchar(60),
 createdtimestamp date,
 modifiedby varchar(60),
 modifiedtimestamp date
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
	modifiedby varchar(60),
	modifiedtimestamp date
	
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
    item varchar(60),
    createdby varchar(60),
   createdtimestamp date,
   modifiedby varchar(60),
   modifiedtimestamp date
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
image varchar(255),
createdby varchar(60),
createdtimestamp date,
modifiedby varchar(60),
modifiedtimestamp date
);

insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,createdby,createdtimestamp,modifiedby,modifiedtimestamp) values ('data cable','intel I7',5,10,10000.00,4,'Jun-24-2014','Jun-28-2014','dc','mari','Jun-28-2014','mari','Jun-28-2014');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,createdby,createdtimestamp,modifiedby,modifiedtimestamp) values ('data cable','intel I7',5,10,10000.00,4,'Jun-24-2014','Jun-28-2014','dc','mari','Jun-28-2014','mari','Jun-28-2014');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,createdby,createdtimestamp,modifiedby,modifiedtimestamp) values ('data cable','intel I7',5,10,10000.00,4,'Jun-24-2014','Jun-28-2014','dc','mari','Jun-28-2014','mari','Jun-28-2014');

select * from inventory



--drop table discount;

create table discount( 
	id SERIAL PRIMARY KEY,
	startdate date,
	enddate date,
	percentage numeric(10),
	isactive varchar(60),
	createdby varchar(60),
	createdtimestamp date,
	modifiedby varchar(60),
	modifiedtimestamp date
);

--drop table payment;

create table payment( 
	id SERIAL PRIMARY KEY,
	txnid varchar(255),
	userid varchar(255),
	orderid varchar(255),
	status varchar(255),
	date date,
	amount numeric(10,2),
	createdby varchar(255),
	createdtimestamp date,
	modifiedby varchar(255),
	modifiedtimestamp date
);

select * from payment

insert into payment(txnid,userid,orderid,status,date,amount,createdby,createdtimestamp,modifiedby,modifiedtimestamp) values ('ID0021','USR0001','OD0001','orderplaced','Feb-06-2014',10000.00,'mari','Feb-12-2014','mari','Feb-12-2014');



---MySql Script For inventory table--mobileapp--

CREATE TABLE  `rabliondb`.`inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(255),
  `itemtype` varchar(255),
  `quantity` decimal(10,0),
  `alertlimit` decimal(10,0),
  `purchaseprice` decimal(10,2),﻿
  `discountpercentage` decimal(10,0),
  `purchasedate` datetime,
  `saledate` datetime,
  `image` varchar(255),
  `category` varchar(255),
  `available` varchar(45),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,category,available) values ('Processor','intel I7',5,10,10000.00,10,'2012-01-01','2012-01-01','pros','1','yes');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,category,available) values ('Ram','DDR2',5,10,1000.00,10,'2014-01-05','2014-01-10','ram','1','yes');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,category,available) values ('Datacable','mobile',5,10,230.00,10,'2015-01-05','2015-01-10','dc','1','yes');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,category,available) values ('Processor','intel I7',5,10,10000.00,10,'2012-01-01','2012-01-01','pros','1','yes');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,category,available) values ('Ram','DDR2',5,10,1000.00,10,'2014-01-05','2014-01-10','ram','1','yes');
insert into inventory(itemname,itemtype,quantity,alertlimit,purchaseprice,discountpercentage,purchasedate,saledate,image,category,available) values ('Datacable','mobile',5,10,230.00,10,'2015-01-05','2015-01-10','dc','1','yes');





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




