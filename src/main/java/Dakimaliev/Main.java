package Dakimaliev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("daniar.xml").addAnnotatedClass(Person.class).buildSessionFactory();
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();

            Person person1 = new Person("Bob", 35);
            Person person2 = new Person("Alice", 45);
            Person person3 = new Person("Sem", 25);

            session.persist(person1);
            session.persist(person2);
            session.persist(person3);
            session.getTransaction().commit();
            System.out.println("Person saved!");
        } catch (Exception e) {
            e.printStackTrace();


    }finally{
        if (session != null)
            session.close();
        factory.close();
    }


    }
}