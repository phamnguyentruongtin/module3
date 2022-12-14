create database furamaResort;
use furamaResort;
create table vi_tri(
 maViTri int,
 tenViTri nvarchar(45),
 constraint pk_primary_vitri primary key (maViTri)
);
create table trinhDo(
 matrinhdo int,
 tentrinhdo nvarchar(45),
 constraint pk_primary_trinhdo primary key (matrinhdo)
 );
 create table loaikhach(
 maloaikhach int,
 tenloaikhach nvarchar(45),
 constraint pk_primary_loaikhach primary key (maloaikhach)
 );
 create table boPhan(
 mabophan int,
 tenbophan nvarchar(45),
 constraint pk_primary_bophan primary key(mabophan)
 );
 create table loaidichvu(
 maloaidichvu int,
tenloaidichvu nvarchar(45),
constraint pk_primary_loaidichvu primary key(maloaidichvu)
 );
 create table kieuthue(
 makieuthue int ,
 tenkieuthue nvarchar(45),
 constraint pk_primary_kieuthue primary key(makieuthue)
 );
 create table nhanvien(
 manhanvien int,
 hotennhanvien nvarchar(45),
 ngaysinh date,
 socmnd varchar(45),
 luong double,
 sodienthoai varchar(45),
 email varchar(45),
 diachi varchar(45),
 mavitri int,
 matrinhdo int,
 mabophan int,
 constraint pk_nhanvien primary key (manhanvien),
 constraint foreign key fk_nhanvien1(mavitri) references vi_tri(maViTri),
 constraint foreign key fk_nhanvien2(matrinhdo) references trinhDo(matrinhdo),
 constraint foreign key fk_nhanvien3(mabophan) references boPhan(mabophan)
 );
 create table khachhang(
 makhachhang int,
 maloaikhachhang int,
 hotenkhachhang nvarchar(45),
 ngaysinh date,
 gioitinh bit(1),
 socmndkhachhang nvarchar(45),
 sodienthoai nvarchar(45),
 emailkhachhang nvarchar(45),
 diachikhachhang nvarchar(45),
 constraint  primary key (makhachhang),
 constraint  foreign key (maloaikhachhang) references loaikhach(maloaikhach)
 );
 create table dichvu(
 madichvu int,
 tendichvu nvarchar(45),
 dientich int,
 chiphithue double,
 songuoitoida int,
 makieuthue int,
 maloaidichvu int,
 tieuchuanphong nvarchar(10),
 motatiennghikhac nvarchar(45),
 dientichhoboi double,
 sotang int,
 constraint  primary key (madichvu),
 constraint  foreign key (makieuthue) references kieuthue(makieuthue),
 constraint  foreign key (maloaidichvu) references loaidichvu(maloaidichvu)
 );
  create table hopdongfurama(
 mahopdong int,
 ngaylamhopdong datetime,
 ngayketthuc datetime,
 tiendatcoc double,
 manhanvien int,
 makhachhang int,
 madichvu int,
 constraint pk_hopdong primary key (mahopdong),
 constraint foreign key (manhanvien) references nhanvien(manhanvien),
 constraint foreign key (makhachhang) references khachhang(makhachhang),
 constraint foreign key (madichvu) references dichvu(madichvu)
 );
 create table dichvudikem(
 madichvudikem int,
 tendichvudikem nvarchar(45),
 gia double,
 donvi varchar(35),
 trangthai varchar(45),
 constraint primary key(madichvudikem)
 );
  create table hopdongchitiet(
 mahopdongchitiet int,
 mahopdong int,
 madichvudikem int,
 soluong int,
 constraint  primary key(mahopdongchitiet),
 constraint  foreign key(mahopdong) references hopdongfurama(mahopdong),
 constraint  foreign key(madichvudikem) references dichvudikem(madichvudikem)
 );
 insert into vi_tri(maViTri,tenViTri)
 values(1,'gi??m ?????c'),
		(2,'qu???n l??'),
        (3,'gi??m s??t'),
        (4,'chuy??n vi??n'),
        (5,'ph???c v???'),
        (6,'l??? t??n');
insert  into trinhDo(matrinhdo,tentrinhdo)
	values(1,'trung c???p'),
		  (2,'cao ?????ng'),
		  (3,'?????i h???c'),
		  (4,'sau ?????i h???c');
 insert into loaikhach(maloaikhach,tenloaikhach)
 VALUES  (1,'Diamond'),
		(2,'Platinium'),
		(3,'Gold'),
		(4,'Silver'),
		(5,'Member');
 insert into  khachhang (makhachhang,hotenkhachhang,ngaysinh,gioitinh,socmndkhachhang,sodienthoai,emailkhachhang,diachikhachhang,maloaikhachhang)
 VALUES 	 (1,'Nguy???n Th??? H??o','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng',5),
         (2,'Tr???n Cao V??n','1990-4-12',1,'488641231','031238123','vancao2702@gmail.com','K67/47 H?? Huy T???p, ???? N???ng',2),
         (3,'Tr????ng ????nh Ngh???','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh',1),
		 (4,'Nguy???n V??n Ch??','1990-5-11',1,'4886712393','09123712321','chinguyen123@gmail.com','Nguy???n V??n C???, H?? N???i',1),
         (5,'Ho??ng Tr???n Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai',4),
         (6,'T??n N??? M???c Ch??u','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Y??n Th???, ???? N???ng',4),
         (7,'Nguy???n M??? Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh',1),
         (8,'Nguy???n Th??? H??o','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum',3),
         (9,'Tr???n ?????i Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i',1);
insert into boPhan(mabophan,tenbophan)
VALUES 	(1,'Sale-Marketing'),
		(2,'H??nh Ch??nh'),
		(3,'Ph???c V???'),
		(4,'Qu???n L??');
 insert into kieuthue(makieuthue,tenkieuthue)
 VALUES (1,'year'),
	   (2,'month'),
	   (3,'day'),
	   (4,'hour');
insert into loaidichvu(maloaidichvu,tenloaidichvu)
VALUES  (1,'Villa'),
		(2,'House'),
		(3,'Room');   
insert into nhanvien(manhanvien,hotennhanvien,ngaysinh,socmnd,luong,sodienthoai,email,diachi,mavitri,matrinhdo,mabophan)     
VALUES  (1, 'Nguy???n Ng???c Trung B???o', '2003-6-25', '206493602', 1000, '0389056171', 'baokx2k3@gmail.com', 'Th??ng B??nh', 1, 4, 4 ),
		(2, 'Nguy???n Ng???c Huy B???o', '2003-6-25', '206493603', 800, '0329002453', 'hbkx22kx3@gmail.com', 'Th??ng B??nh', 3, 2, 1 ),
        (3, 'Hu???nh V??n Nam', '2003-3-10', '206493154', 1000, '0321724124', 'namhuynh@gmail.com', 'Th??ng B??nh', 2, 1, 4 ),
        (4, 'Ph???m Nguy???n Tr?????ng T??n', '2003-5-12', '206412171', 900, '0312388242', 'tinpham@gmail.com', 'N??i Th??nh', 4, 1, 2 ),
		(5, 'V?? Nguy???n Ph??t', '2003-6-19', '206492131', 1100, '0312324912', 'phatvo@gmail.com', 'N??ng S??n', 1, 3, 4 ),
		(6, 'D????ng T???n T??i', '2003-2-12', '206437123', 500, '0342417234', 'taiduong@gmail.com', 'Duy Xuy??n', 6, 1, 1 ),
		(7, 'Tr???n C??ng Nh???t', '2003-11-8', '206812337', 650, '0981234412', 'nhattran@gmail.com', 'Ph?? Ninh', 5, 2, 3 ),
		(8, 'Nguy???n ?????c Vi???t', '2003-4-12', '206781231', 480, '0931231284', 'vietnguyen@gmail.com', 'Th??ng B??nh', 6, 1, 4 ),
		(9, 'Ng?? Ng???c Huy', '2003-9-11', '206152351', 700, '09137127312', 'huyngo@gmail.com', 'N??i Th??nh', 3, 1, 4 ),
		(10, 'Ki???u Nh???t T??n', '2003-10-12', '206812312', 800, '0313192412', 'tankieu@gmail.com', 'Th??ng B??nh', 4, 2, 4 ),
		(11, 'Ph???m Th??? Thu?? H???ng', '2003-5-24', '206123144', 800, '0283183211', 'hangpham@gmail.com', 'Th??ng B??nh', 5, 2, 3);
insert into dichvu(madichvu,tendichvu,dientich,chiphithue,songuoitoida,tieuchuanphong,motatiennghikhac,dientichhoboi,sotang,makieuthue,maloaidichvu)
VALUES  (1,'Villa Beach Front',25000,10000000,10,'vip','C?? h??? b??i',500,4,3,1),
		(2,'House Princess 01',14000,5000000,7,'vip','C?? th??m b???p n?????ng',NULL,3,2,2),
		(3,'Room Twin 01',5000,1000000,2,'normal','C?? tivi',NULL,NULL,4,3),
		(4,'Villa No Beach Front',22000,9000000,8,'normal','C?? h??? b??i',300,3,3,1),
		(5,'House Princess 02',10000,4000000,5,'normal','C?? th??m b???p n?????ng',NULL,2,3,2),
		(6,'Room Twin 02',3000,900000,2,'normal','C?? tivi',NULL,NULL,4,3);
select * from dichvu;
insert into hopdongfurama(mahopdong,ngaylamhopdong,ngayketthuc,tiendatcoc,manhanvien,makhachhang,madichvu)
VALUES  (1,'2020-12-08','2020-12-08',0,3,1,3),
		(2,'2020-07-14','2020-07-21',200000,7,3,1),
		(3,'2021-03-15','2021-03-17',50000,3,4,2),
		(4,'2021-01-14','2021-01-18',100000,7,5,5),
		(5,'2021-07-14','2021-07-15',0,7,2,6),
		(6,'2021-06-01','2021-06-03',0,7,7,6),
		(7,'2021-09-02','2021-09-05',100000,7,4,4),
		(8,'2021-06-17','2021-06-18',150000,3,4,1),
		(9,'2020-11-19','2020-11-19',0,3,4,3),
		(10,'2021-04-12','2021-04-14',0,10,3,5),
		(11,'2021-04-25','2021-04-25',0,2,2,1),
		(12,'2021-05-25','2021-05-27',0,7,8,1);
select * from hopdongfurama;
insert into dichvudikem(madichvudikem,tendichvudikem,gia,donvi,trangthai)
VALUES  (1,'Karaoke',10000,'gi???','ti???n nghi, hi???n t???i'),
		(2,'Thu?? xe m??y',10000,'chi???c','h???ng 1 xe'),
		(3,'Thu?? xe ?????p',20000,'chi???c','t???t'),
		(4,'Buffet bu???i s??ng',15000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
		(5,'Buffet bu???i tr??a',90000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
		(6,'Buffet bu???i t???i',16000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng');
select * from dichvudikem;
insert into hopdongchitiet(mahopdongchitiet,soluong,mahopdong,madichvudikem)
VALUES  (1,5,2,4),
		(2,8,2,5),
		(3,15,2,6),
		(4,1,3,1),
		(5,11,3,2),
		(6,1,1,3),
		(7,2,1,2),
		(8,2,12,2);
select * from hopdongchitiet;
-- 2 Hi???n th??? th??ng tin c???a t???t c??? nh??n vi??n c?? trong h??? th???ng c?? t??n b???t ?????u l?? m???t trong c??c k?? t??? ???H???, ???T??? ho???c ???K??? v?? c?? t???i ??a 15 k?? t???.
select hotennhanvien from nhanvien
where hotennhanvien like 'H%' or 'T%' or 'K%'  limit 15;
-- 3 Hi???n th??? th??ng tin c???a t???t c??? kh??ch h??ng c?? ????? tu???i t??? 18 ?????n 50 tu???i v?? c?? ?????a ch??? ??? ??????? N???ng??? ho???c ???Qu???ng Tr??????.
select * from khachhang
where (timestampdiff(year,ngaysinh,curdate()) between 18 and 50) and diachikhachhang like '%_ ???? N???ng' or diachikhachhang like '%_ Qu???ng Tr???';
;
-- 4.	?????m xem t????ng ???ng v???i m???i kh??ch h??ng ???? t???ng ?????t ph??ng bao nhi??u l???n. 
-- K???t qu??? hi???n th??? ???????c s???p x???p t??ng d???n theo s??? l???n ?????t ph??ng c???a kh??ch h??ng. 
-- Ch??? ?????m nh???ng kh??ch h??ng n??o c?? T??n lo???i kh??ch h??ng l?? ???Diamond???.
select makhachhang, hotenkhachhang, count(hotenkhachhang) as solanthue
from khachhang kh
join loaikhach lk on kh.maloaikhachhang = lk.maloaikhach
where lk.tenloaikhach = 'Diamond'
group by hotenkhachhang 
;
-- c??u 5.
select * from khachhang;
-- c??u 6.
select dv.madichvu,dv.tendichvu,dv.dientich,dv.chiphithue,dv.maloaidichvu,tdv.tenloaidichvu,tdv.maloaidichvu 
from dichvu dv inner join loaidichvu tdv on dv.maloaidichvu = tdv.maloaidichvu
join hopdongfurama hd on dv.madichvu = hd.madichvu
where month(hd.ngaylamhopdong) between 4 and 12
group by dv.madichvu;
-- cau7.
select dv.madichvu,dv.tendichvu,dv.dientich,dv.chiphithue,dv.maloaidichvu,tdv.tenloaidichvu,tdv.maloaidichvu 
from dichvu dv inner join loaidichvu tdv on dv.maloaidichvu = tdv.maloaidichvu
join hopdongfurama hd on dv.madichvu = hd.madichvu
where year(hd.ngaylamhopdong) = '2020'
group by dv.madichvu;
-- cau8 .
select hotenkhachhang from khachhang
group by hotenkhachhang;
 SELECT hotenkhachhang from khachhang
 union
 SELECT hotenkhachhang from khachhang;
 SELECT  distinct hotenkhachhang from khachhang;
 -- cau9 .
 select month(ngaylamhopdong) as 'thang',count(ngaylamhopdong) as 'so lan dap' from hopdongfurama
 where year(ngaylamhopdong) = '2021'
 group by month(ngaylamhopdong)
 order by month(ngaylamhopdong);
 -- cau10 .
 select hd.mahopdong,hd.ngaylamhopdong,hd.ngayketthuc,hd.tiendatcoc,sum(hdct.soluong) 
 from hopdongfurama hd left join hopdongchitiet hdct on hd.mahopdong = hdct.mahopdong
 group by hd.mahopdong;
 -- cau11 .
 select dvdk.madichvudikem,dvdk.tendichvudikem,hdct.madichvudikem,
 hd.mahopdong,hdct.mahopdong,hd.makhachhang,kh.makhachhang,lk.maloaikhach
 from dichvudikem dvdk,khachhang kh,hopdongfurama hd,loaikhach lk,hopdongchitiet hdct
 where dvdk.madichvudikem = hdct.madichvudikem 
 and hdct.mahopdong = hd.mahopdong 
 and hd.makhachhang = kh.makhachhang
 and kh.maloaikhachhang = lk.maloaikhach
 and lk.tenloaikhach = 'Diamond' and (kh.diachikhachhang like '%Vinh' or kh.diachikhachhang like '%Qu???ng Ng??i');
 -- cau12 .
 select hd.mahopdong , nv.hotennhanvien as ho_ten_nhan_vien , kh.hotenkhachhang as ho_ten_khach_hang, kh.sodienthoai,dv.madichvu, dv.tendichvu, sum(hdct.soluong) as so_luong_dich_vu_di_kem , tiendatcoc from hopdongfurama hd

left join nhanvien nv on hd.manhanvien = nv.manhanvien
left join khachhang kh on hd.makhachhang = kh.makhachhang
left join dichvu dv on hd.madichvu = dv.madichvu
left join hopdongchitiet hdct on hdct.mahopdong = hd.mahopdong
WHERE
(ngaylamhopdong BETWEEN '2020-10-01'
AND '2020-12-30')
AND (
        ngaylamhopdong NOT BETWEEN '2021-01-01'
        AND '2021-06-30'
    )
GROUP by
    mahopdong;

;-- cau 13 .
select dvdk.madichvudikem, dvdk.tendichvudikem , sum(hdct.soluong) as so_luong_dich_vu_di_kem
from dichvudikem dvdk
join hopdongchitiet hdct on  dvdk.madichvudikem = hdct.madichvudikem
group by madichvudikem
having so_luong_dich_vu_di_kem = 15
;
-- cau 14 .
select hd.mahopdong, ldv.tenloaidichvu, dvdk.tendichvudikem, count(tendichvudikem) as solansudung from hopdongfurama hd
join dichvu dv on hd.madichvu = dv.madichvu
join loaidichvu ldv on dv.maloaidichvu = ldv.maloaidichvu
join hopdongchitiet hdct on hd.mahopdong = hdct.mahopdong
join dichvudikem dvdk on hdct.madichvudikem = dvdk.madichvudikem
group by tendichvudikem
having solansudung = 1
order by  hd.mahopdong 
;
-- cau15 .
SELECT
    manhanvien,
    hotennhanvien,
    tentrinhdo,
    tenbophan,
    sodienthoai,
    diachi,
    count(hd.manhanvien) as tong_so_hop_dong
FROM
    nhanvien
    JOIN trinhdo USING (matrinhdo)
    JOIN bophan USING (mabophan)
    JOIN hopdongfurama hd USING (manhanvien)
where
    year(ngaylamhopdong) BETWEEN 2020
    and 2021
GROUP by
    hd.manhanvien
having
    tong_so_hop_dong <= 3
order by  hd.manhanvien ;	


 







 