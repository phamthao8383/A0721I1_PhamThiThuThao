select * from subject;
select * from mark;
select * from student;

-- Hiển thị tất cả các thông tin môn học (bảng subject)
-- có credit lớn nhất.
select  max(Credit)
from subject ;
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select max(mark) from mark ;


-- Hiển thị các thông tin sinh viên và điểm trung bình của 
-- mỗi sinh viên, 
-- xếp hạng theo thứ tự điểm giảm dần
select avg(mark) as diemtb, StudentName
from mark 
inner join student on mark.StudentId = student.StudentId
group by student.StudentId
order by diemtb desc;

