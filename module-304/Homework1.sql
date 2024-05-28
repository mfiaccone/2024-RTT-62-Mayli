-- Homework 1

-- Question 0.1
-- I want to see the count of the number of products in each line 
select pl.product_line, count(*) as products_count
from products p, productlines pl
where p.productline_id = pl.id
group by pl.id;

-- Question 0.2
-- I want to see a list of employees and all of the customers for that employee. Employee name will be duplicated in the result set. I want to see the employee first 
-- and last name and the customer contact first and last name as well as the customer name
select e.firstname, e.lastname, c.contact_firstname,  c.contact_lastname, c.customer_name
from employees e, customers c
where c.sales_rep_employee_id = e.id;
	
-- Question 0.3
-- I want to see a list of employees in each office. Show the office name and the employee name.
select o.city, e.lastname, e.firstname
from employees e, offices o
where e.office_id = o.id;

-- Question 0.4
-- I want to see the total number of each employee type based on job title and the number of employees with that job title
select e.job_title, count(e.job_title)
from employees e
group by e.job_title;

-- Question 0.5
-- I want to see a list of all payments each customer has made. Order the list by customer name ascending, then by the payment amount descending 
select c.customer_name, p.amount
from payments p, customers c
where p.customer_id = c.id
order by c.customer_name asc;

select c.customer_name, p.amount
from payments p, customers c
where p.customer_id = c.id
order by p.amount desc;


-- Question 0.6 - hard but try
-- I want to see a list of products that have never been sold. Use... where not in(select product_id from order_details) in your where clause
select * 
from products p
where p.id not in (select product_id from orderdetails);


-- Question 0.7
-- Are there any customers that have never made an order? 
select c.customer_name
from customers c
left join orders on c.id = orders.customer_id 
where orders.customer_id is null;

-- Question 1
-- How many cusotmers are handled by each office. I want to see the office name and the count of the number of customers in that office.
select o.city, count(c.customer_name)
from customers c, offices o, employees e
where c.sales_rep_employee_id = e.id
and e.office_id = o.id
group by o.city;


-- Question 2
-- I want to see the products with the most margin at the top of the table. Include the product name, buy price, and margin in the results. Margin is calculated (MSPR - buy_price)
select p.product_name, (p.msrp - p.buy_price) as margin, p.buy_price
from products p
order by margin desc;


-- Question 2.5
-- I want to see the top 5 customers in each state based on margin
select p.product_name, (p.msrp - p.buy_price) as margin, p.buy_price, c.state
from products p, customers c, orders o, orderdetails od
where c.id = o.customer_id
and o.id =  od.order_id
and od.product_id = p.id;


-- Question 3
-- I want to see the top 5 salesman in the company based on the total amount sold. 
select e.lastname, sum(od.quantity_ordered * od.price_each) as total_sold
from employees e, customers c, orders o, orderdetails od
where e.id = c.sales_rep_employee_id
and c.id = o.customer_id
and o.id = od.order_id
group by e.lastname
order by total_sold desc 
limit 5;


-- Question 4
-- I want to see the top five salesman based on overall profit (margin)
select e.lastname, sum(p.msrp - p.buy_price) as total_margin
from employees e, customers c, orders o, orderdetails od, products p
where e.id = c.sales_rep_employee_id
and c.id = o.customer_id
and o.id = od.order_id
and od.product_id = p.id
group by e.lastname
order by total_margin desc 
limit 5;

-- Question 5 - didn't go over in class/will require a lookup
-- I want to see all of the orders that were happened in 2004. You can use a function called year(order_date) = 2004
select  * 
from orders o, orderdetails od
where o.id = od.order_id
and year(order_date) = 2004;


-- Question  6
-- I want to see the total amount of all orders grouped by the year 
select year(o.order_date) as order_year, od.order_id, o.order_date
from orders o, orderdetails od
where o.id = od.order_id
order by order_year;


-- Question 7 10398
-- I want to see the top 5 products based on quantity sold across all orders 
select p.product_name, od.quantity_ordered
from orderdetails od, products p
where od.product_id = p.id
order by od.quantity_ordered desc 
limit 5;

-- Question 7.5
-- How many times has each product appeared in an order regardless of how many were purchased
select p.product_name, count(od.product_id) as appearance_number
from products p, orderdetails od 
where od.product_id = p.id
group by p.product_name;


-- Question 7.6 - data might not support this one 
-- How many products would be out of stock based on the amount sold accross time. Basically looking for any product where the sum 
-- of the quanitty sold is greater than the quantitiy in stock 
select p.product_name, (od.quantity_ordered - p.quantity_in_stock) as deficit 
from products p, orderdetails od 
where od.product_id = p.id
order by p.product_name;


-- Question 7.9 -- idk if this is right
-- I want to see the distinct order status ordered alphabetically
select o.id, o.status
from orders o
order by status asc;


-- Question 8 -- not sure if this is right, has duplicates
-- I want to see the office name and the product lines that have been sold in that office. This will require joining almost all the tables.
-- select distinct o.name as office_name, pl.productlines as product_line_name
select o.city as office_name, pl.product_line
from offices o, employees e, customers c, orders ord, orderdetails od, products p, productlines pl
where o.id = e.office_id
and e.id = c.sales_rep_employee_id
and c.id = ord.customer_id
and ord.id = od.order_id
and od.product_id = p.id
and p.productline_id = pl.id
order by office_name;





