--drop table appuser--

CREATE TABLE appuser( id SERIAL PRIMARY KEY,
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
orderdate date,
amount numeric(10,2),
createdby varchar(255),
createdtimestamp date,
modifiedby varchar(255),
modifiedtimestamp date
);

--drop table Customer;
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
aboutcompany varchar(255),
createdby varchar(255),
createdtimestamp date,
modifiedby varchar(255),
modifiedtimestamp date
);

---drop table catalog;
CREATE TABLE catalog (
id SERIAL PRIMARY KEY,
model varchar(60),
price numeric(10,2),
discount numeric(10,2),
image varchar(60),
createdby varchar(255),
createdtimestamp date,
modifiedby varchar(255),
modifiedtimestamp date
);

--drop table expense;
CREATE TABLE expense (
id SERIAL PRIMARY KEY,
username varchar(60),
createddate date,
currency varchar(60),
amount numeric(10,2),
type varchar(60),
createdby varchar(255),
createdtimestamp date,
modifiedby varchar(255),
modifiedtimestamp date
);

---MySql Script For Bse Application--

--1.Extract and Retrive
---csvlist table---
--CREATE TABLE  `csvdb`.`csvlist` (
--  `sno` int(10) unsigned NOT NULL AUTO_INCREMENT,
--  `csvfiles` longblob,
--  `date` varchar(50) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL DEFAULT '',
--  PRIMARY KEY (`sno`)
--) ENGINE=InnoDB AUTO_INCREMENT=659 DEFAULT CHARSET=latin1;

---2.Bulkeals---
--bulkdeals table---
--CREATE TABLE  `csvdb`.`bulkdeals` (
--  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
--  `csvfiles` longblob,
--  `date` varchar(45) DEFAULT NULL,
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;

--drop table article;
--CREATE TABLE article(
--    id     SERIAL PRIMARY KEY,
--    title varchar(255),
--    publishdate date,
--    content varchar(255),
--    category varchar(25),
--    type varchar(255),
--    item varchar(255),
--    summary varchar(255)
--);≈

--select * from article;






