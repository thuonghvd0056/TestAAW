package model;


import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerModel {
    private static Logger LOGGER = Logger.getLogger(CustomerModel.class.getSimpleName());

    public void save(Customer customer){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
            LOGGER.log(Level.INFO, String.format("Save student success with rollNumber %s", customer.getName()));
        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, String.format("Save student error, stack trace"), ex);
        }
    }
}
