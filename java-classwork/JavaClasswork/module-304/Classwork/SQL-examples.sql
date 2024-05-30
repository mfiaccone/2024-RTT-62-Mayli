-- I want to see all employees that work in an office in the USA
select * from employees;
select * from offices;
select e.*, o.city
from employees e, offices o
where e.office_id = o.id
	and o.country = 'USA';
    
    -- lets just start looking at what is in the various tables
    select * from orders;
    select * from orderDetails;
    
    -- calculate the total price for each line item in the order 1013
    select od.*, (quantity_ordered * price_each) as total_price 
    from orderdetails od
    where order_id = 10103
    order by order_line_number;
    
    -- now add the product into this query result 
    select od.*, (quantity_ordered * price_each) as total_price, p.product_name
    from orderdetails od, products p
    where order_id = 10103
		and p.id = od.product_id
    order by order_line_number;
    
    -- now lets add the date of the order
    select * from orders where id = 10103; -- this only returns a single record
    -- however when we join against the order table the order date is duplicated because each line item in the order details 
    -- was essentially ordered on the same day 
    
        -- now lets add the date of the order
    select od.*, (quantity_ordered * price_each) as total_price, p.product_name, o.order_date
    from orderdetails od, products p, orders o
    where order_id = 10103
		and p.id = od.product_id
        and o.id = od.order_id
    order by order_line_number;
    
    -- now lets add the customer name
        select od.*, (quantity_ordered * price_each) as total_price, p.product_name, o.order_date, c.customer_name
    from orderdetails od, products p, orders o, customers c
    where order_id = 10103
		and p.id = od.product_id
        and o.id = od.order_id
        and o.customer_id = c.id
    order by order_line_number;
    
    select * from employees;
