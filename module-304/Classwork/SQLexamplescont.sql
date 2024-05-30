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



