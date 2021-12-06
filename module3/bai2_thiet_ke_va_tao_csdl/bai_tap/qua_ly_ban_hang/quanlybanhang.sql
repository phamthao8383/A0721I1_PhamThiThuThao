CREATE database QLKH;
USE QLKH;
create table customer(
cID int primary key,
cName varchar(100) not null,
cAge int
);
create table product(
pID int primary key,
pName varchar(100) not null,
pPrice double

);
create table orderr (
oID int primary key,
oDate date,
oTotalPrice double,
cID int,
foreign key (cID)references customer(cID)
);
create table OrderDetail(
oID int,
pID int,
odQTY int,
foreign key (oID) references orderr(oID),
foreign key(pID) references product(pID)
);