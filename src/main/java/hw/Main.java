package hw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Customer.class)
//                .addAnnotatedClass(Product.class)
//                .buildSessionFactory();
//
//        Session session = null;
//        try {
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
////            Customer customer = session.get(Customer.class, 3);
////            System.out.println(customer);
//            List<Customer> customers = session.createQuery("from Customer").getResultList();
//            System.out.println(customers);
//
//            session.getTransaction().commit();
//
//        }
//        finally {
//            factory.close();
//            session.close();
//        }

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Service service = new Service(factory);

        service.showAllCustomers(); //Показать всех покупателей в базе

        //Создать нового Покупателя с Новыми продуктами
        Customer customer1 = new Customer("Vlad");
        List<Product> products = new ArrayList<>();
        //products.add(new Product("Milk",5.3f)); //Не удалось реализовать создание товаров налету в контектсте создания
        // Покупателя Вопрос в личке

        service.insertCustomerWithProducts(customer1,products);

        service.showAllCustomers(); //Показать всех Покупателей в базе после создания нового Покупателя

        service.showCustomerById(3); //Показать Покупателя по id

        service.showProductById(3); //Показать товар по id и его Покупателей

        service.deleteCustomerById(22); //Удаление Покупателя по id

        service.deleteProductById(5); //Удаление Продукта по id

        service.closeFactory();
    }
}
