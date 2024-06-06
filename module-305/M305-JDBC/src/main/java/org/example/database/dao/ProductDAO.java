package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {

   private SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public Product findById(Integer id) {

        Session session = factory.openSession();

        String hql = "select p from Product p where p.id = :id";

        TypedQuery<Product> query = session.createQuery(hql,Product.class);

        query.setParameter("id", id);

        try {
            // get single result will throw an exception if no records are found
            Product product = query.getSingleResult();

            // if we get here then a record was found so we can return it
            return product;
        } catch (NoResultException e) {
            // if we land here its bc there was an exception where there was no result
            // the standard design pattern is to return null when no record was found
            return null;
        } finally {
            //no matter what happens we want to close the hibernate session
            session.close();
        }
    }

    public List<Product> findByName(String name) {

        Session session = factory.openSession();

        // this is referred to HQL or JQL (vs SQL) and both mean the same thing
        //HQL USES THE JAVA CLASS NAMES !!!!!!!!!!!!!
        //HQL USES THE JAVA CLASS NAMES !!!!!!!!!!!!!!!
        //HQL USES THE JAVA CLASS NAMES !!!!!!!!!!!!!!!!!!!!
        String hql = "select p from Product p where p.productName = :productName";

        TypedQuery<Product> query = session.createQuery(hql,Product.class);
        query.setParameter("productName", name);

        //this will always return a list so we do not have to worry about it being null
        // if there were no results found then the list will be empty
        List<Product> products = query.getResultList();

        session.close();

        return products;

    }

    public List<Product> findLikeName(String productName) {

        Session session = factory.openSession();

        //create the query to be ... select * from products where product_name like '%name%';
        // basically the CONCAAT adds the % to the beginning and the end of the incoming variable
        // % is a wildcard meaning match any character any number of times
        // by adding the lower function to the product names and the incoming variable you make this query case insensitive
        String hql = "select p from Product p where lower(p.productName) like lower(CONCAT('%', :productName, '%'))";

        TypedQuery<Product> query = session.createQuery(hql,Product.class);
        query.setParameter("productName", productName);


        List<Product> products = query.getResultList();

        session.close();

        return products;

    }

    public void update(Product product) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(product);

        session.getTransaction().commit();
        session.close();
    }
}
