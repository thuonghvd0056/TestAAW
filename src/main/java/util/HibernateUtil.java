package util;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            ourSessionFactory = new Configuration().configure("hibernate.xml").buildSessionFactory();
        }catch (Throwable ex){
            throw new ExceptionInInitializerError();
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(String[] args) throws Exception{
        final Session session = getSession();
        Transaction transaction = null;
        try{

            transaction = session.beginTransaction();
//            Student student = Student.Builder.aStudent()
//                    .withRollNumber("A023")
//                    .withName("Thuong")
//                    .withEmail("thuong1@gmail.com")
//                    .build();
//            student.setAccount(account);
//            account.setStudent(student);
//            Credential credential = new Credential();
//            credential.setAccount(account);
//            account.addCredential(credential);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

}
