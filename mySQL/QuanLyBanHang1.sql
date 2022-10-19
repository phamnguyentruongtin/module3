create database QuanLyBanHang;
use QuanLyBanHang;
create table customer(
cID int primary key not null,
cName varchar(45),
cAge int(100)
);
create table `order`(
	oID int primary key not null,
    cID  int not null,
    oDate datetime,
    oTotalPrice int
);
create table Product (
pID int primary key not null,
pName varchar(45),
pPrice int
);
create table OrderDetail(
  oID int not null,
  pID int not null,
  odQTY int,
  primary key(oID,pID)
);
alter table `order`
add foreign key(cID) references customer(cID);

alter table	OrderDetail
add foreign key (oID) references `order`(oID),
add foreign key (pID) references Product(pID);

drop database QuanLyBanHang;
