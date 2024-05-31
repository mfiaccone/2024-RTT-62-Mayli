select p.id, od.id
from products p, orderdetails od
where p.id = od.product_id;

-- KBA note -- the ambiguous id is the employee_id (it is in both tables) / we will have to guess this without seeing EER diagram
select employee_id, salary
from employees inner join salaries on employee_id = employee_id
where salary >= 75000;
-- this is the exact question answer: employee_id

select * from employees where firstname like 'A%'
union -- this is equivalent to distinct
select * from employees where firstname like 'G%'
union all
select * from employees where lastname like 'B%';


-- I want to see the list of products that have never been sold
select * from products p where p.id not in (select product_id from orderdetails);

select *, (select count(*) from orderdetails od where od.product_id = p.id ) as product_count
from products p
order by product_count desc;
-- above two are very common 

-- Eric refrains from doing this when he can bc it makes the query hard to read / use when you start thinking about your where clause and it gets complicated
select * from (select * from products p where p.product_name like '19%') as a
where productline_id = 2;


-- SBA Review 

select p.product_name, max(buy_price) as max_offer, min(buy_price) as min_offer, round(avg(buy_price),2) as avg_buy_price
from products p, orderdetails od
where p.id = od.product_id
group by od.product_id;

-- to get two decimal places
select p.product_name, format(max(buy_price),2) as max_offer, format(min(buy_price),2) as min_offer, round(avg(buy_price),2) as avg_buy_price, count(*) as product_count
from products p, orderdetails od
where p.id = od.product_id
group by od.product_id;




-- testing save

select l.name, min(o.amount) as min_offer, round(avg(o.amount),2) as avg_offer, max(o.amount) as max_offer, count(*) as offers
from lots l, offers o
where l.id = o.lot_id
group by o.lot_id
order by offers desc;

select * from offers, lots;


-- SBA 2 Notes

-- Query 1
select d.name, count(c.id)
from department d, course c
where d.id = c.deptID
group by d.id
order by count(c.id) asc, d.name asc;

-- 3b
select c.name, count(sc.studentId)
from course c, studentCourse sc
where c.id = sc.courseid
group by c.id
order by count(sc.studentId) desc, c.name asc;

-- 3c1
select c.name
from course c
where c.id not in (select courseID from facultyCourse)
order by c.name asc;

-- 3c2
select c.name, count(sc.studentid) as cnt
from course c, studentcourse sc
where c.id not in (select courseID from facultyCourse)
and c.id = sc.courseid
group by c.id
order by cnt desc, c.name asc;

-- 3d make sure you use the distinct studentid 
select count(distinct sc.studentid) as Students, year(startdate) as year 
from studentcourse sc
group by year(sc.startdate)
order by year asc, students desc;

-- 3e
select sc.startdate, count(distinct sc.studentid) as students
from studentcourse sc 
where month(startdate) = 8
group by startdate
order by startdate asc, students asc;

-- 3f
select s.firstname, s.lastname, count(sc.courseid) as course_count
from student s, studentcourse sc, course c
where s.id = sc.studentid
and sc.courseid = c.id
and c.deptid = s.majorid
group by s.id
order by course_count desc, firstname asc, lastname asc; 

-- 3g -- may need to use round instead of format
select s.firstname, s.lastname, format(avg(progress),1) as avg_progress
from student s, studentcourse sc 
where s.id = sc.studentid
group by s.id
having avg_progress < 50
order by avg_progress desc, firstname asc, lastname asc;

-- 3h1
select c.name, avg(progress) as avg_progress
from course c, studentcourse sc
where c.id = sc.courseid
group by c.id
order by avg_progress desc, c.name asc;

-- 3h2
select format(avg(progress),1) as avg_progress, c.name
from course c, studentcourse sc
where c.id = sc.courseid
group by c.id
order by avg_progress desc, c.name asc
limit 1;

-- 3h3
select firstname, lastname
from faculty f, facultycourse fc, studentcourse sc
where f.id = fc.facultyid
and fc.courseid = sc.courseid
group by f.id
order by avg_progress desc; 

-- 3i
select firstname, lastname, min(progress), max(progress),
case
when min(progress) < 40 then 'F'
when min(progress) < 50 then 'D'
when min(progress) < 60 then 'C'
when min(progress) < 70 then 'b'
else 'A'
end as min_grade,
case
when max(progress) < 40 then 'F'
when max(progress) < 50 then 'D'
when max(progress) < 60 then 'C'
when max(progress) < 70 then 'B'
else 'A'
end as max_grade
from student s, studentcourse sc
where s.id = sc.student_id 
group by s.id;

