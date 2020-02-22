package hw;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private SessionFactory factory;
    private Session session = null;

    public Service(SessionFactory factory) {
        this.factory = factory;
    }

    public void insertCustomerWithProducts(Customer customer, List<Product> products){
            session = factory.getCurrentSession();
            customer.setProducts(products);
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
    }

    public void showAllCustomers(){
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println(session.createQuery("from Customer").getResultList());
            session.getTransaction().commit();
    }

    public void closeFactory(){
        session.close();
        factory.close();
    }

    public void showCustomerById(Integer id){
        session = factory.getCurrentSession();
        session.beginTransaction();
        System.out.println(session.get(Customer.class,id));
        session.getTransaction().commit();
    }

    public void showProductById(Integer id){
        session = factory.getCurrentSession();
        session.beginTransaction();
        System.out.println(session.get(Product.class,id).whoBye());
        session.getTransaction().commit();
    }

    public void deleteProductById(Integer id){
        Product prodFordel = new Product();
        prodFordel.setId(id);
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(prodFordel);
        session.getTransaction().commit();
    }

    public void deleteCustomerById(Integer id){
        Customer custFordel = new Customer();
        custFordel.setId(id);
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(custFordel);
        session.getTransaction().commit();
    }

}
