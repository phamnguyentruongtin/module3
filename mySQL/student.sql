create database student;
use student;
create table Class(
id int primary key not null,
name varchar(30) not null
);
create table Teacher(
id int primary key not null,
name varchar(30) not null,
age int not null,
country varchar(100) not null
);

insert into Teacher
values(1,"nam",12,"Quang Nam"),
      (2,"bao",12,"Quang Nam"),
      (3,"tin",12,"Quang Nam"),
      (4,"thao",12,"Quang Nam");
insert into Class
values(1,"phat"),
      (2,"nhan"),
      (3,"quoc"),
      (4,"linh");
select * from Teacher;
select * from Class;

drop table Teacher;
drop table Class;
  
