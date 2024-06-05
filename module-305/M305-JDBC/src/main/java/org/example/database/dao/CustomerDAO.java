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

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customer c where c.customerName = :customername";

        TypedQuery<Customer> query = session.createQuery(hql,Customer.class);

        query.setParameter("customername", customerName);

        List<Customer> result = query.getResultList();

        session.close();

        return result;
    }


    public List<Customer> findByContactFirstName(String contactFirstName) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customer c where c.contactFirstName = :firstname";


        TypedQuery<Customer> query = session.createQuery(hql,Customer.class);

        query.setParameter("firstname", contactFirstName);

        List<Customer> result = query.getResultList();

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


        session.delete(customer);

        session.getTransaction().commit();
        session.close();
    }



    public Customer findById (Integer id) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customer c where c.id = :id";
        
        TypedQuery<Customer> query = session.createQuery(hql,Customer.class);

        query.setParameter("id", id);

        try {
            Customer result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {


            session.close();
        }
    }
}
