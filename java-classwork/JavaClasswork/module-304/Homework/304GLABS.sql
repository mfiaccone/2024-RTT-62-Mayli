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

-- Example 5
SELECT orderNumber, DATEDIFF(requiredDate, shippedDate) as  daysLeft
FROM     orders
ORDER BY  daysLeft DESC;

SELECT orderNumber, DATEDIFF(requiredDate, orderDate) as remaining_days
FROM    orders
WHERE    status = 'In Process'
ORDER BY remaining_days;

SELECT 
    orderNumber,
    ROUND(DATEDIFF(requiredDate, orderDate) / 7, 2),
    ROUND(DATEDIFF(requiredDate, orderDate) / 30,2)
FROM     orders 
WHERE    status = 'In Process';

-- Example 6

SELECT 
    orderNumber,
    DATE_FORMAT(orderdate, '%Y-%m-%d') orderDate,
    DATE_FORMAT(requireddate, '%a %D %b %Y') requireddate,
    DATE_FORMAT(shippedDate, '%W %D %M %Y') shippedDate
FROM    orders;

SELECT     orderNumber,
    DATE_FORMAT(shippeddate, '%W %D %M %Y')  as 'Shipped date'
FROM    orders
ORDER BY shippeddate;

-- Example 7

SELECT firstName, LPAD(firstName,10,'kk'), LPAD(firstName,5,'kk'), LPAD(firstName,4,'kk') FROM classicmodels.employees;

SELECT TRIM(' SQL TRIM Function ');

SELECT LTRIM('  SQL LTRIM function');

SELECT RTRIM('SQL RTRIM function   ');

-- Example 8
SELECT YEAR('2002-01-01');

SELECT YEAR(shippeddate) as year,  COUNT(ordernumber) as orderQty
FROM    orders 
GROUP BY YEAR(shippeddate)
ORDER BY YEAR(shippeddate);

-- Example 9
SELECT DAY('2022-01-15');

SELECT  DAY(orderdate) as dayofmonth, COUNT(*)
FROM    orders WHERE    YEAR(orderdate) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;


-- ################ GLAB 304.5.2 ###################

-- Example 1
SELECT    customername, country
FROM    customers
WHERE    country = 'USA' OR country = 'France';

-- Example 2
SELECT    customername, country, creditLimit  
FROM    customers
WHERE (country = 'USA' OR country = 'France') AND creditlimit > 100000;

SELECT  customername, country, creditLimit FROM    customers
WHERE    country = 'USA' OR country = 'France' AND creditlimit > 100000;

-- Example 3
SELECT     productCode,  productName,  buyPrice 
FROM    products
WHERE     buyPrice BETWEEN 90 AND 100;

SELECT productCode, productName, buyPrice 
FROM products
WHERE  buyPrice >= 90 AND buyPrice <= 100;

SELECT productCode, productName, buyPrice FROM products 
WHERE buyPrice NOT BETWEEN 20 AND 100;

SELECT productCode, productName, buyPrice FROM products
WHERE  buyPrice < 20     OR     buyPrice > 100; 

-- Example 4
SELECT customerName, country, salesrepemployeenumber
FROM customers
WHERE salesrepemployeenumber IS NULL
ORDER BY  customerName; 

SELECT customerName, country, salesrepemployeenumber
FROM  customers
WHERE  salesrepemployeenumber IS NOT NULL
ORDER BY customerName;

SELECT  c.customerNumber, c.customerName,  orderNumber, o.STATUS
FROM customers c
LEFT JOIN orders o 
ON c.customerNumber = o.customerNumber
WHERE  orderNumber IS NULL;

-- ################ GLAB 304.6.1 ###################

-- Example 1
select c.customerName as 'Customer Name', concat(e.lastName, ', ', e.firstName) as 'Sales Rep'
from customers c JOIN employees e 
on c.salesRepEmployeeNumber = e.employeeNumber
order by c.customerName asc;

-- Example 2
select p.productName as 'Product Name', sum(od.quantityOrdered) as 'Total # Ordered', sum(od.quantityOrdered * od.priceEach) as 'Total Sale'
from products p LEFT JOIN orderdetails od 
on p.productCode=od.productCode
group by p.productName, p.buyPrice
order by 3 desc;

-- Example 3
select status as 'Order Status', count(status) as 'Total Orders'
from orders
group by status
order by status;

-- Example 4
select 
     pl.productLine as 'Product Line', 
     count(od.productCode) as 'total Sold'
from productLines pl join products p 
on pl.productLine=p.productLine
 JOIN orderdetails od on p.productCode=od.productCode
group by pl.productLine
order by 2 desc;

-- Example 5
select 
   monthname(paymentDate) AS Month, 
   year(paymentDate) AS Year,
   format(sum(amount), 2) AS 'Payments Received'
from payments
group by year(paymentDate), monthname(paymentDate) 
order by paymentDate;

-- Example 6
SELECT p.productName Name, p.productLine AS `Product Line`, p.productScale AS `Scale`, p.productVendor AS `Vendor` FROM productlines l NATURAL JOIN products p 
WHERE l.productLine = "Classic Cars" OR l.productLine = "Vintage Cars"
ORDER BY p.productLine DESC, p.productName ASC;


-- ################ GLAB 304.6.2 ###################

-- Example 1
SELECT p.`NAME` AS "Product", pt.`NAME` AS "Type"
FROM product p INNER JOIN product_type pt
ON p.product_type_cd = pt.product_type_cd;

-- Example 2
SELECT b.`name`, b.city, e.LAST_NAME, e.TITLE
FROM employee e INNER JOIN branch b
ON b.BRANCH_ID = e.ASSIGNED_BRANCH_ID;

-- Example 3
SELECT distinct TITLE FROM employee;

-- Example 4
SELECT e.LAST_NAME AS "Name", e.TITLE AS "Title", m.LAST_NAME AS "Boss Name", m.TITLE AS "Boss Title"
FROM employee e LEFT JOIN employee m
ON e.SUPERIOR_EMP_ID = m.EMP_ID;

-- Example 5
SELECT p.NAME, a.AVAIL_BALANCE, i.LAST_NAME FROM account a
INNER JOIN product p ON a.PRODUCT_CD = p.PRODUCT_CD
LEFT JOIN customer c ON a.CUST_ID = c.CUST_ID
LEFT JOIN individual i ON c.CUST_ID = i.CUST_ID;

-- Example 6
SELECT ac.*, i.LAST_NAME FROM acc_transaction ac
INNER JOIN account a ON ac.ACCOUNT_ID = a.ACCOUNT_ID
INNER JOIN customer c ON a.CUST_ID = c.CUST_ID
INNER JOIN individual i ON c.CUST_ID = i.CUST_ID
WHERE i.LAST_NAME RLIKE "T.*"; -- same as LIKE "T%";





