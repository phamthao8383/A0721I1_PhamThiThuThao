use qlkh;
insert  into customer (cID,cName,cAge) values
(1,'Minh Quang',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into Orderr(oID,oDate,cId) values
(1,'2006-3-21',1),
(2,'2006-3-23',2),
(3,'2006-3-16',1);
select *from orderr;
insert into product(pID,pName,pPrice) values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa ',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into orderdetail(oID,pID,odQTY) values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả
-- các hóa đơn trong bảng Order
select oId,oDate,oTotalPrice
from orderr ;
-- Hiển thị danh sách các khách hàng đã mua hàng,
--  và danh sách sản phẩm được mua bởi các khách
-- customer join  orderr join orderdetail join product
select c.cName,p.pName
from customer as c join orderr o on c.cID=o.cID
join orderdetail as od on o.oID= od.oID
join product as p on p.pID=od.pID;
-- Hiển thị tên các khách hàng không mua bất kỳ một sản phẩm nào
select customer.cName
from customer
where cID NOT IN
(select c.cID
from customer as c  join orderr o on c.cID=o.cID
  join orderdetail as od on o.oID= od.oID
 join product as p on p.pID=od.pID);
 -- Hiển thị mã hóa đơn, ngày bán và 
 -- giá tiền của từng hóa đơn
 -- (giá một hóa đơn được tính bằng tổng giá bán của 
 -- từng loại mặt hàng xuất hiện trong hóa đơn.
 -- giá bán từng loại được tính = odQTY*pPrice)
 update orderr
 set oTotalPrice=60 where oID=1;
 update orderr
 set oTotalPrice=32 where oID=2;
 update orderr
 set oTotalPrice=24 where oID=3;
