create table products(
id int primary key,
productCode varchar(100),
productName varchar(100),
productAmount int,
productDescription varchar(255),
productStatus varchar(255)
);

insert into products(id,productCode,productName,productAmount,
productDescription,productStatus,productPrice) values
(1,'sp1','cafe',3,'ngon','da mua',45.6),
(2,'sp2','coca',4,'ngon','da mua',123.6),
(3,'sp3','sua',1,'ngon','da mua',12.5),
(4,'sp4','tra sua',3,'ngon','chua mua',10),
(5,'sp5','tra dao',3,'ngon','da mua',23);
-- Tạo Unique Index trên bảng Products
--  (sử dụng cột productCode để tạo chỉ mục)
CREATE UNIQUE INDEX product_productCode
ON products (productCode);
show index from products;
select*from products;
-- -- Tạo Composite Index trên bảng Products 
-- -- (sử dụng 2 cột productName và productPrice)

CREATE INDEX products_index
ON products (productName,productPrice);
-- -- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL 
-- -- của bạn thực thi như nào

explain select *from products where productStatus='damua';

-- Tạo view lấy về các thông tin: productCode, productName,
--  productPrice, productStatus
-- từ bảng products.
create view product_view 
as select productCode,productName,productPrice,productStatus
from products;

-- select *from product_view;
-- -- Tiến hành sửa đổi view
update product_view
set productStatus='chua mua'
where productName='tra dao';

-- select *from product_view;

-- Tiến hành xoá view
-- drop view product_view;
-- tạo store procedure lấy tất cả thông tin của
-- tất cả các sản phẩm 
-- trong bảng product

DELIMITER //
create procedure procedureProduct()
begin
select * from products;
end ,
DELIMITER ;
call procedureProduct();




