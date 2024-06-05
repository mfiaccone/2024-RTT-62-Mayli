package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDAO {

    public List<Customer> findByCustomerName (String customerName) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        // SQL - "select * from employees e where e.firstname = ?"
        String hql = "SELECT c FROM Customer c where c.customerName = :customername";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
        // this is similar to the prepared statement, we are going to set the value in the query :firstname
        // to the value passed into the function
        query.setParameter("customername", customerName);

        // when we know we are getting 0 or more records we use getResultList
        List<Customer> result = query.getResultList();

        // finally we close the hibernate session so that it can release the resources its holding
        // specifically the connection pool and close the transaction
        session.close();

        return result;
    }


    public List<Customer> findByContactFirstName(String contactFirstName) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        // SQL - "select * from employees e where e.firstname = ?"
        String hql = "SELECT c FROM Customer c where c.contactFirstName = :firstname";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
        // this is similar to the prepared statement, we are going to set the value in the query :firstname
        // to the value passed into the function
        query.setParameter("firstname", contactFirstName);

        // when we know we are getting 0 or more records we use getResultList
        List<Customer> result = query.getResultList();

        // finally we close the hibernate session so that it can release the resources its holding
        // specifically the connection pool and close the transaction
        session.close();

        return result;
    }

    public void insert( Customer customer ) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(customer);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();

    }

    public void update(Customer customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();

        session.merge(customer);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Customer customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.delete(customer);

        session.getTransaction().commit();
        session.close();
    }



    public Customer findById (Integer id) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customer c where c.id = :id";


        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
        // this is similar to the prepared statement, we are going to set the value in the query :firstname
        // to the value passed into the function
        query.setParameter("id", id);

        try {
            Customer result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {

            // finally we close the hibernate session so that it can release the resources its holding
            // specifically the connection pool and close the transaction
            session.close();
        }
    }
}
