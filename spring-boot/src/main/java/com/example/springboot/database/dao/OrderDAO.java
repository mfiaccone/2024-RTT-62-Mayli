package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderDAO extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerId(Integer customerId);



    // each Map in the list represents a row in the result set from the database
    // in this result the String is the column name and the Object is the value in the column
    //we are using native SQL so we need to give the flag in the Query annotation to be nativeQuery=true
    @Query(value="select o.id as order_id, o.order_date, od.quantity_ordered, p.product_name, p.id as product_id, " +
            "od.price_each, (od.quantity_ordered * od.price_each) as line_item_total " +
            "from orderdetails od, products p, orders o " +
            "where od.product_id = p.id and o.id = od.order_id and o.id = :orderId " +
            "order by order_id;", nativeQuery = true)
    public List<Map<String,Object>> getOrderDetails(Integer orderId);

    //so the basics are the value= and then the query from the database in nativesql, and then the nativeQuery=true
    // there needs to be a space after each line and the " otherwise it would read as one long native sql with no space between the next line
    // trigger for this is when you need to have more than one column from more than one table
}
