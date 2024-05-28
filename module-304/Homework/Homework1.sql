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
select * from products where id not in ( select product_id from orderdetails);


-- Question 0.7
-- Are there any customers that have never made an order? 
select o.order_date, c.customer_name
from orders o, customers c
where o.customer_id = c.id
and count(o.order_date) = is null;

-- Question 1
-- How many cusotmers are handled by each office. I want to see the office name and the count of the number of customers in that office.

-- Question 2
-- I want to see the products with the most margin at the top of the table. Include the product name, buy price, and margin in the results. Margin is calculated (MSPR - buy_price)

-- Question 2.5
-- I want to see the top 5 customers in each state based on margin

-- Question 3
-- I want to see the top 5 salesman in the company based on the total amount sold. 

-- Question 4
-- I want to see the top five salesman based on overall profit (margin)

-- Question 5 - didn't go over in class/will require a lookup
-- I want to see all of the orders that were happened in 2004. You can use a function called year(order_date) = 2004

-- Question  6
-- I want to see the total amount of all orders grouped by the year 

-- Question 7
-- I want to see the top 5 products based on quantity sold across all orders 

-- Question 7.5
-- How many times has each product appeared in an order regardless of how many were purchased

-- Question 7.6 - data might not support this one 
-- How many products would be out of stock based on the amount sold accross time. Basically looking for any product where the sum 
-- of the quanitty sold is greater than the quantitiy in stock 

-- Question 7.9
-- I want to see the distinct order status ordered alphabetically

-- Question 8
-- I want to see the office name and the product lines th at have been sold in that office. This will require joining almost all the tables.
select distinct o.name as office_name, pl.productlines as product_line_name


