create database resort_management;
use resort_management;

create table position (
positionID INT primary key,
positionName varchar(45)
);
insert into Position (positionID,positionName) values
(1,"Quản Lý"),
(2,"Nhân Viên");

create table levels (
levelID int primary key,
levelName varchar(45)
);
insert into levels ( levelID,levelName) values
(1,"Trung Cấp"),
(2,"Cao Đẳng"),
(3,"Đại Hoc"),
(4,"Sau Đại Hoc");

create table departments (
departmentID int primary key,
departmentName varchar(45)
);
insert into departments (departmentID,departmentName) value
(1,"Sale-Marketing"),
(2,"Hành Chính"),
(3,"Phục Vụ"),
(4,"Quản Lý");
create table staffs (
staffID int primary key,
staffName varchar(45),
birthDay date,
IdCardPeople varchar(45),
salary double,
phoneNumber varchar(45),
email varchar(45),
address varchar(45),
positionID INT,
levelID int,
departmentID int,
foreign key (positionID)  references position (positionID),
foreign key (levelID)  references levels (levelID),
foreign key (departmentID)  references departments (departmentID)
);
create table type_customers(
type_customerID int primary key,
type_customerName varchar(45)
);
insert into type_customers(type_customerID,type_customerName) values
(1,"Diamond"),
(2,"Platinium"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");

create table customers(
customerID int primary key,
customerName varchar(45),
birthDay date,
gender bit,
IdCardPeople varchar(45),
phoneNumber varchar(45),
email varchar(45),
address varchar(45),
type_customerID int,
foreign key (type_customerID) references type_customers (type_customerID)
);

insert into customers(customerID,customerName,birthDay,gender,
IdCardPeople, phoneNumber,email,address,type_customerID) values
(1,"Nguyễn Thị Hào","1970-11-07",0,"643431213","0945423362","thihao07@gmail.com","23 Nguyễn Hoàng, Đà Nẵng",5),
(2,"Phạm Xuân Diệu","1992-08-08",1,"865342123","0954333333","xuandieu92@gmail.com","K77/22 Thái Phiên, Quảng Trị",3),
(3,"Trương Đình Nghệ","1990-02-27",1,"488645199","0373213122","nghenhan2702@gmail.com","K323/12 Ông Ích Khiêm, Vinh",1),
(4,"Dương Văn Quan","1970-11-07",0,"643431213","0945423362","thihao07@gmail.com","23 Nguyễn Hoàng, Đà Nẵng",5),
(5,"Hoàng Trần Nhi Nhi","1995-12-09",0,"795453345","0312345678","nhinhi123@gmail.com","224 Lý Thái Tổ, Gia Lai",4),
(6,"Tôn Nữ Mộc Châu","2005-12-06",0,"732434215","0988888844","tonnuchau@gmail.com","37 Yên Thế, Đà Nẵng",4),		
(7,"Nguyễn Mỹ Kim","1984-04-08",0,"856453123","0912345698","kimcuong84@gmail.com","K123/45 Lê Lợi, Hồ Chí Minh",1),		
(8,"Nguyễn Thị Hào","1999-04-08",0,"965656433","0763212345","haohao99@gmail.com","55 Nguyễn Văn Linh, Kon Tum",3),
(9,"Trần Đại Danh","1994-07-01",1,"432341235","0643343433","danhhai99@gmail.com","24 Lý Thường Kiệt,Quảng Ngãi",1),
(10,"Nguyễn Tâm Đắc","1989-07-01",1,"344343432","0987654321","dactam@gmail.com","22 Ngô Quyền, Đà Nẵng",2);

insert into staffs (staffID,staffName ,birthDay,IdCardPeople ,salary,phoneNumber ,email ,address ,positionID,
levelID ,departmentID) values 
(1,"Nguyễn Văn An","1970-11-07","456231786",10000000,"0901234121","annguyen@gmail.com","295 Nguyễn Tất Thành, Đà Nẵng ",1,3,1),
(2,"Lê Văn Bình","1997-04-09","654231234",7000000,"0934212314","binhlv@gmail.com","22 Yên Bái, Đà Nẵng",1,2,2),
(3,"Hồ Thị Yến","1995-12-12","999231723",14000000,"0412352315","thiyen@gmail.com","K234/11 Điện Biên Phủ, Gia Lai",1,3,2),
(4,"Võ Công Toản","1980-04-04","123231365",17000000,"0374443232","toan0404@gmail.com","77 Hoàng Diệu, Quảng Trị	",1,4,4),
(5,"Nguyễn Bỉnh Phát","1999-12-09","454363232",6000000,"0902341231","phatphat@gmail.com","43 Yên Bái, Đà Nẵng",2,1,1),
(6,"Khúc Nguyễn An Nghi","2000-11-08","964542311",7000000,"0978653213","annghi20@gmail.com","294 Nguyễn Tất Thành, Đà Nẵng",2,2,3),
(7,"Nguyễn Hữu Hà","1993-01-01","534323231",8000000,"0941234553","nhh0101@gmail.com","4 Nguyễn Chí Thanh, Huế",2,3,2),
(8,"Nguyễn Hà Đông","1989-09-03","234414123",9000000,"0642123111","donghanguyen@gmail.com","111 Hùng Vương, Hà Nội",2,4	,4),
(9,"Tòng Hoang","1982-09-03","256781231",6000000,"0245144444","hoangtong@gmail.com","213 Hàm Nghi, Đà Nẵng",2,4,4),
(10,"Nguyễn Công Đạo","1994-01-08","755434343",8000000,"0988767111","nguyencongdao12@gmail.com","6 Hoà Khánh, Đồng Nai",2,3,2);
select * from staffs;

create table type_rent(
type_rentID int primary key,
type_rentName varchar(45)
);
insert into type_rent(type_rentID,type_rentName) values
(1,"year"),
(2,"month"),
(3,"day"),
(4,"hour");

create table type_services(
type_serviceID int primary key,
type_serviceName varchar(45)
);
insert into type_services(type_serviceID,type_serviceName) values
(1,"Villa"),
(2,"House"),
(3,"Room");

create table services(
serviceID int primary key,
serviceName varchar(45),
area int,
rentalCosts double,
max_number_people int,
criterion varchar(45),
descriptions varchar(45),
pool_area double,
number_floors int,
type_rentID int,
type_serviceID int,
foreign key (type_rentID) references type_rent(type_rentID),
foreign key (type_serviceID) references type_services(type_serviceID)
); 
insert into services(serviceID,serviceName ,
area,rentalCosts,max_number_people,criterion,descriptions,pool_area,number_floors,
type_rentID,type_serviceID ) values
(1,"Villa Beach Front",	25000,10000000,10,"vip","Có hồ bơi",500,4,3,1),
(2,"House Princess 01",14000,5000000,7,"vip","Có thêm bếp nướng",null,3,2,2),
(3,"Room Twin 01",5000,1000000,2,"normal","Có tivi",null,null,4,3),
(4,"Villa No Beach Front",22000,9000000,8,"normal","Có hồ bơi",300,3,3,1),
(5,"House Princess 02",10000,4000000,5,"normal","Có thêm bếp nướng",null,2,3,2),
(6,"Room Twin 02",3000,900000,2,"normal","Có tivi",null,null,4,3);
select*from services;
create table Accompanied_service(
Accompanied_serviceID int primary key,
Accompanied_serviceName varchar(45),
price double,
unit varchar(10),
status varchar(45)
);
insert into Accompanied_service(Accompanied_serviceID,Accompanied_serviceName,price,unit,status) values
(1,"Karaoke",10000,"giờ","tiện nghi,hiện tại"),
(2,"Thuê xe máy",10000,"chiếc","hỏng 1 xe"),
(3,"Thuê xe đạp",20000,"chiếc","tốt"),
(4,"Buffet buổi sáng",15000,"suất","đầy đủ đồ ăn, tráng miệng"),
(5,"Buffet buổi trưa",90000,"suất","đầy đủ đồ ăn, tráng miệng"),
(6,"Buffet buổi tối",16000,"suất","đầy đủ đồ ăn, tráng miệng");

create table contract(
contractID  int primary key,
start_day datetime,
end_day datetime,
deposits double,
staffID int,
customerID int,
serviceID int,
foreign key (staffID) references staffs(staffID),
foreign key (customerID) references customers(customerID),
foreign key (serviceID) references services(serviceID)
);
insert into contract(contractID,start_day,end_day,deposits,
staffID,customerID,serviceID) values
(1,"2020-12-08","2020-12-08",0,3,1,3),
(2,"2020-07-14","2020-07-21",200000,7,3,1),
(3,"2021-03-15","2021-03-17",50000,3,4,2),
(4,"2021-01-14","2021-01-18",100000,7,5,5),
(5,"2021-07-14","2021-07-15",0,7,2,6),
(6,"2021-06-01","2021-06-03",0,7,7,6),
(7,"2021-09-02","2021-09-05",100000,7,4,4),
(8,"2021-06-17","2021-06-18",150000,3,4,1),
(9,"2020-11-19","2020-11-19",0,3,4,3),
(10,"2021-04-12","2021-04-14",0,10,3,5),
(11,"2021-04-25","2021-04-25",0,2,2,1),
(12,"2021-05-25","2021-05-27",0,7,10,1);

create table contract_details(
contract_detailsID int primary key,
quantily int,
contractID int,
Accompanied_serviceID int,
foreign key (contractID)references contract(contractID),
foreign key (Accompanied_serviceID) references Accompanied_service(Accompanied_serviceID)
);
insert into contract_details(contract_detailsID,quantily,contractID,Accompanied_serviceID)
values
(1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6,1,1,3),
(7,2,1,2),
(8,2,12,2);
-- TRUY VẤN CƠ BẢN
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống
--  có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
-- select * from staffs
-- where  staffs.staffName like "H%" or staffs.staffName like "T%" or staffs.staffName like "K%" 
-- and char_length(staffs.staffName)<=15 ;
-- 3.	Hiển thị thông tin của tất cả khách hàng có 
-- độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
--  use resort_management;
 SELECT * from customers
where address in('Quảng Trị','Đà Nẵng')and (curdate()-birthDay>(18*30*365)
and curdate()- birthDay<(50 *30*365));
  -- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
  -- Chỉ đếm những khách hàng nào có Tên loại khách hàng 
  -- là “Diamond”.  
 select c.customerID,c.customerName,  count(c.customerID) as number_bookings
  from (customers as c join contract as co on c.customerID=co.customerID
  join services as s on co.serviceID=s.serviceID
  join type_services as t on s.type_serviceID=t.type_serviceID
  join type_customers as tc on c.type_customerID=tc.type_customerID)
  where tc.type_customerName ="Diamond"
  group by c.customerID,c.customerName
  order by number_bookings ;
  -- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong,
  -- ten_dich_vu, 
  -- ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau:
  -- Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
  -- cho tất cả các khách hàng đã từng đặt phòng.
  -- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
    select c.customerID,c.customerName,tc.type_customerName,co.contractID,s.serviceName,co.start_day,co.end_day,
  sum( s.rentalCosts+cd.quantily*a.price) as total
  from customers as c left join type_customers as tc on c.type_customerID=tc.type_customerID
  left join contract as co on c.customerID=co.customerID
  left join services as s on co.serviceID=s.serviceID
  left join contract_details as cd on cd.contractID=co.contractID
  left join Accompanied_service as a on a.Accompanied_serviceID=cd.Accompanied_serviceID
  group by co.contractID;
     -- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,
     -- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng 
     -- thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select s.serviceID,s.serviceName,s.area,type_services.type_serviceName
from services as s join type_services on type_services.type_serviceID=s.type_serviceID
where not exists
(select contract.contractID from contract 
where (contract.start_day between "2021-01-01" and "2021-03-31")
and contract.serviceID=s.serviceID);
-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da,
--  chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- đã từng được khách hàng đặt phòng trong năm 2020
--  nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select* from services;
select services.serviceID,services.serviceName,services.area,services.max_number_people,
services.rentalCosts,type_services.type_serviceName
from services join type_services on services.type_serviceID=type_services.type_serviceID
where exists
(select contract.contractID from contract 
where year(contract.start_day)='2020'
and contract.serviceID=services.serviceID)
and not exists (select contract.contractID from contract 
where year(contract.start_day)='2021'
and contract.serviceID=services.serviceID);
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, 
-- với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- c1
select distinct customers.customerName
from customers;
-- c2
select customers.customerName
from customers
group by customers.customerName;
-- c3
select customers.customerName from
customers union select customers.customerName from
customers;
-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với
-- mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select temp.month,count(month(contract.start_day)) as amount_people
-- sum(contract.deposits) as total
from
(select 1 as month
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as temp
left join contract on month(contract.start_day)= temp.month
left join customers on customers.customerID=contract.customerID
where year(contract.start_day)='2021'
group by temp.month
order by temp.month;

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng
-- thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị 
-- bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tien_dat_coc, so_luong_dich_vu_di_kem
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select contract.contractID,contract.start_day,contract.end_day,
contract.deposits, count(contract_details.Accompanied_serviceID)
as service_quantily
from contract join contract_details on contract.contractID=contract_details.contractID
group by contract.contractID;
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được  sử dụng
-- bởi những khách hàng có ten_loai_khach là “Diamond”
-- và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select *
from Accompanied_service as a
-- join contract as c on c.contractID=a.contractID
join contract_details as cd on a.Accompanied_serviceID=cd.Accompanied_serviceID
join contract as c on cd.contractID=c.contractID
join customers on c.customerID=customers.customerID
join type_customers as t on customers.type_customerID=t.type_customerID
where customers.address in ("Vinh","Quảng Ngãi")
and t.type_customerName="Diamond";

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên),
-- ho_ten (khách hàng), so_dien_thoai (khách hàng),
-- ten_dich_vu, so_luong_dich_vu_di_kem
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),
-- tien_dat_coc của tất cả các dịch vụ đã từng 
-- được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

select contract.contractID,staffs.staffName,customers.customerName,
customers.phoneNumber,services.serviceName,
count(contract_details.Accompanied_serviceID) as so_lan
from contract join staffs on contract.staffID=staffs.staffID
join customers on contract.customerID=customers.customerID
join services on services.serviceID=contract.serviceID
join contract_details on contract.contractID=contract_details.contractID
where not exists(select contract.contractID where
contract.start_day between "2021-01-01" and"2021-06-30")
and  exists(select contract.contractID where
contract.start_day between "2021-09-01" and"2021-12-30");
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được
--  sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có
-- số lần sử dụng nhiều như nhau).
create temporary table temp
select Accompanied_service.Accompanied_serviceName as name,
 count(contract_details.Accompanied_serviceID) as so_lan
 from contract_details join Accompanied_service
 on Accompanied_service.Accompanied_serviceID=contract_details.Accompanied_serviceID
group by Accompanied_service.Accompanied_serviceName;

select *from temp;
create temporary table temp1
select max(temp.so_lan)as max_so_lan
from temp;
select *from temp1;

select temp.name, temp.so_lan
from temp join temp1 on temp.so_lan=temp1.max_so_lan;
drop temporary table temp;
drop temporary table temp1;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng 
-- nào từ năm 2019 đến năm 2021.
delete from staffs where not exists(select staffs.staffID 
from contract where contract.start_day between '2019-01-01' and '2021-12-31' and contract.staffID=staffs.staffID );

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung
--  (được tính dựa trên việc count các ma_dich_vu_di_kem).
select contract.contractID,type_services.type_serviceName,Accompanied_service.Accompanied_serviceName,count(contract_details.Accompanied_serviceID) as so_lan
from contract join services ON contract.serviceID=services.serviceID
join type_services on services.type_serviceID=type_services.type_serviceID
join contract_details on contract.contractID=contract_details.contractID
join Accompanied_service on Accompanied_service.Accompanied_serviceID=contract_details.Accompanied_serviceID
group by Accompanied_service.Accompanied_serviceName
having so_lan=1;

-- -- 17.	Cập nhật thông tin những khách hàng có
--  ten_loai_khach từ Platinum lên Diamond,
--  chỉ cập nhật những khách hàng đã từng đặt phòng với 
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ






