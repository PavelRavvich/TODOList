package ru.pravvich.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pravvich.model.Task;

import java.sql.Timestamp;

/**
 * Author : Pavel Ravvich.
 * Created : 20.07.17.
 * <p>
 * CheckHibernate
 */
public class CheckHibernate {

    public static void main(String[] args) {
        final SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        final Session session = factory.openSession();

        final Transaction transaction = session.beginTransaction();
        final Task task2 = new Task(3, "todo3",
                new Timestamp(System.currentTimeMillis()), false);

        session.save(task2);
//        session.createQuery("from Task").list();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

}
