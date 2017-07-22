package ru.pravvich.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import ru.pravvich.model.Task;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicReference;

import static org.mockito.Mockito.*;

public class TaskDAOTest {
    /**
     * Task object for tests.
     */
    private final Task task = new Task(3, "test",
            new Timestamp(System.currentTimeMillis()), false);
    /**
     * Mock Factory connections to database wrap in real atomic.
     */
    private AtomicReference<SessionFactory> factory;
    /**
     * Mock of Session obj.
     */
    @Mock
    private
    Session session;
    /**
     * Mock of Transaction obj.
     */
    @Mock
    private
    Transaction transaction;

    @Before
    public void before() {
        final SessionFactory fac = mock(SessionFactory.class);
        session = mock(Session.class);
        when(fac.openSession()).thenReturn(session);

        factory = new AtomicReference<>(fac);

        transaction = mock(Transaction.class);
        when(session.getTransaction()).thenReturn(transaction);

    }

    @Test
    public void saveTest() {

        final DAO<Task, Integer> dao = new TaskDAO(factory);
        dao.save(task);

        verify(session).beginTransaction();
        verify(session).save(task);
        verify(session).getTransaction();
        verify(transaction).commit();
    }

    @Test
    public void updateTest() {

        final DAO<Task, Integer> dao = new TaskDAO(factory);
        dao.update(task);

        verify(session).beginTransaction();
        verify(session).update(task);
        verify(session).getTransaction();
        verify(transaction).commit();
    }

    @Test
    public void deleteTest() {

        final DAO<Task, Integer> dao = new TaskDAO(factory);
        dao.delete(task);

        verify(session).beginTransaction();
        verify(session).delete(task);
        verify(session).getTransaction();
        verify(transaction).commit();
    }
}