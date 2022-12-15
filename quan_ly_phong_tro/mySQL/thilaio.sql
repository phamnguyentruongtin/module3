create database product;
use product;
create table product(
 id_product int primary key auto_increment,
 product_name nvarchar(45),
 price_product double,
 quantity_product int,
 color_product nvarchar(45),
 id_category int not null,
 foreign key (id_category) references category(id_category)
);

create table category(
 id_category int primary key not null,
 category_name nvarchar(45)
);
insert into category(id_category,category_name)
values (1,"Phone"),
		(2,"Television");


select*from category;
	


insert into product(product_name,price_product,quantity_product,color_product,id_category)
values ("IP13",350000,13,"red",1),
		("IP14",400000,13,"black",1);
    