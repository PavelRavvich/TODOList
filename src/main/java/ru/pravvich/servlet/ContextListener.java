package ru.pravvich.servlet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author : Pavel Ravvich.
 * Created : 22.07.17.
 * <p>
 * ContextListener inject database connection pool to servlet context.
 */
public class ContextListener implements ServletContextListener {
    /**
     * Database connection pool.
     */
    private SessionFactory factory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //Build connection pool.
        factory = new Configuration().configure().buildSessionFactory();

        final ServletContext servletContext = sce.getServletContext();

        //Inject connection pool to servlet context.
        servletContext.setAttribute(
                "factory", new AtomicReference<>(factory));

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        factory.close();
    }
}
