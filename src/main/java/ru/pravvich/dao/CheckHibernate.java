package ru.pravvich.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pravvich.model.Task;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author : Pavel Ravvich.
 * Created : 20.07.17.
 * <p>
 * CheckHibernate
 */
public class CheckHibernate {

//    public static void main(String[] args) {
//        final SessionFactory factory =
//                new Configuration().configure().buildSessionFactory();
//
//
//        new TaskDAO(new AtomicReference<>(factory)).updateDone(1, true);
//        try {
//
//        factory.close();
//        } finally {
//            factory.close();
//        }
//
//    }
}
