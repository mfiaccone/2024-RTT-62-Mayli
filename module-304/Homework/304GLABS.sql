-- ############## GLAB 304.4.1 ###############

-- Example 1
select orderNumber, orderlinenumber, quantityOrdered * priceEach
from orderdetails
order by quantityOrdered * priceEach desc;

select orderNumber, orderlinenumber, quantityOrdered * priceEach as subtotal
from orderdetails
order by subtotal desc;

-- Example 2
select firstname, lastname, reportsto
from employees
order by reportsto;

select firstname, lastname, reportsto
from employees
order by reportsto desc;

-- ################ GLAB 304.5.1 ###################

-- Example 1
select ordernumber, sum(quantityordered) as QTY,
if (mod(sum(quantityordered),2), 'Odd', 'Even') as OddOrEven
from orderdetails
group by ordernumber
order by ordernumber;

-- Example 2
select truncate(1.555,1);

-- Example 3
select productcode, avg(quantityordered * priceeach) as avg_order__value
from orderdetails
group by productcode;
 

select productcode, round(avg(quantityordered * priceeach)) as avg_order_value
from orderdetails
group by productcode;


-- Example 4 -- needs where clause
update products
set productDescription = replace(productDescription, 'abuot','about');

