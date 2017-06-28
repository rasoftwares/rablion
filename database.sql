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
 
 
 

--drop table inventory;

CREATE TABLE inventory( 
id SERIAL PRIMARY KEY,
name varchar(255),
type varchar(255),
quantity numeric(10),
alertlimit numeric(100),
price numeric(10,2),
discount numeric(10),
image varchar(255),
createdby varchar(60),
createdtimestamp date,
modifiedby varchar(60),
modifiedtimestamp date
);

insert into inventory(name,type,quantity,alertlimit,price,discount,image,createdby,createdtimestamp,modifiedby,modifiedtimestamp) values ('saree','cotton',15,10,10000.00,4,'data:image/jpeg;base64,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','mari',CURRENT_TIMESTAMP,'mari',CURRENT_TIMESTAMP);
insert into inventory(name,type,quantity,alertlimit,price,discount,image,createdby,createdtimestamp,modifiedby,modifiedtimestamp) values ('saree','silk',30,10,10000.00,4,'data:image/jpeg;base64,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','mari',CURRENT_TIMESTAMP,'mari',CURRENT_TIMESTAMP);
insert into inventory(name,type,quantity,alertlimit,price,discount,image,createdby,createdtimestamp,modifiedby,modifiedtimestamp) values ('saree','worksaree',35,10,10000.00,4,'data:image/jpeg;base64,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','mari',CURRENT_TIMESTAMP,'mari',CURRENT_TIMESTAMP);

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

insert into discount(startdate,enddate,percentage,isactive,createdby,createdtimestamp,modifiedby,modifiedtimestamp) values ('01-FEB-2016','05-FEB-2016',10,'yes','mari','01-FEB-2016','mari','01-FEB-2016');


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



CREATE TABLE customer( 
id SERIAL PRIMARY KEY,
customerid varchar(255),
companyname varchar(255),
title varchar (255),
registrationno varchar(255),
registrationyear date,
ownername varchar(255),
photograph varchar(255),
shortdescription varchar(255),
registredaddress varchar(255),
officeaddress varchar(255),
landlineno numeric(15),
mobileno numeric(13),
emailid varchar(255),
website varchar(255),
aboutcompany varchar(255)
);

insert into customer(customerid,companyname,title,registrationno,registrationyear,ownername,photograph,shortdescription,registredaddress,
officeaddress,landlineno,mobileno,emailid,website,aboutcompany) values 
('ID0021','rablion','rablion','RA1234','May-06-2015','Rajesh','1.jpg','Software','Kelambakkam','Kelambakkam',12345657890,044123456,'info@rasoftwares.com','www.rablion.com','development');

select * from customer




--------->------->



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






