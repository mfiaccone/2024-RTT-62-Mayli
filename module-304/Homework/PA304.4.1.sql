-- ###################### PA 304.4.1 #########################

-- Question 1
select productname as 'Name', productline as 'Product Line', buyprice as 'Buy Price'
from products
order by buyprice desc;

-- Question 2
select contactfirstname 'First Name', contactlastname 'Last Name', city 'City'
from customers c
where country = 'Germany'
order by contactlastname asc;

-- Question 3
select distinct status from orders order by status asc;

-- Question 4
select *
from payments
where paymentdate >= '2005-01-01' 
order by paymentdate asc;

-- Question 5
select e.lastname, e.firstname, e.email, e.jobtitle
from employees e, offices o
where e.officecode = o.officecode
and o.city = 'San Francisco'
order by e.lastname asc;

-- Question 6
select productname, productline, productscale, productvendor
from products
where productline = 'Classic Cars' or productline = 'Vintage Cars'
order by productline asc, productname asc;

-- ascending by year instead of alphabetically 





