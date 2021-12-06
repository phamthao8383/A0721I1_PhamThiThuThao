USE QuanLySinhVien;
-- hien thi tên sv bat dau băng 'h'
select * from student
where student.StudentName
like "h%";
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from Class 
where StartDate="2021-12-05";
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject
where Credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.

SET SQL_SAFE_UPDATES = 0;
update student
set ClassId= 2 where StudentName='Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark.
-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần.
-- nếu trùng sắp theo tên tăng dần.
select s.StudentName,sb.SubName,m.Mark
from student s join mark as m on s.StudentId=m.StudentId 
join subject as sb on sb.SubId=m.SubId
order by m.Mark desc;
