package ru.pravvich.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.pravvich.model.Task;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author : Pavel Ravvich.
 * Created : 21.07.17.
 * <p>
 * TaskDAO database layer for Task entity.
 */
public class TaskDAO implements DAO<Integer, Task> {
    /**
     * Factory connections to database.
     */
    private final AtomicReference<SessionFactory> factory;

    /**
     * Default constructor;
     *
     * @param factory of session to database.
     */
    public TaskDAO(final AtomicReference<SessionFactory> factory) {
        this.factory = factory;
    }

    /**
     * Save task to database.
     *
     * @param task for save.
     */
    @Override
    public void save(final Task task) {

        try (final Session session = factory.get().openSession()) {

            session.beginTransaction();

            session.save(task);

            session.getTransaction().commit();
        }
    }

    /**
     * Update done status.
     *
     * @param id of task.
     * @param done new status.
     */
    @Override
    public void updateDone(int id, boolean done) {

        try (final Session session = factory.get().openSession()) {

            String hql = "update Task set done = :newDone where id = :oldId";

            final Query query = session.createQuery(hql)
                    .setParameter("oldId", id)
                    .setParameter("newDone", done);

            final Transaction transaction = session.beginTransaction();

            query.executeUpdate();

            transaction.commit();
        }
    }

    /**
     * Update task in database.
     *
     * @param task for update.
     */
    @Override
    public void update(final Task task) {

        try (final Session session = factory.get().openSession()) {

            session.beginTransaction();

            session.update(task);

            session.getTransaction().commit();
        }
    }

    /**
     * Delete task from database.
     *
     * @param task for delete.
     */
    @Override
    public void delete(final Task task) {

        try (final Session session = factory.get().openSession()) {

            session.beginTransaction();

            session.delete(task);

            session.getTransaction().commit();
        }
    }

    /**
     * Get Task by id.
     *
     * @param id for select.
     * @return Task with unique id same param.
     */
    @Override
    public Task getById(final Integer id) {

        Task result;

        try (final Session session = factory.get().openSession()) {

            session.beginTransaction();

            result = session.get(Task.class, id);

            session.getTransaction().commit();
        }

        return result;
    }

    /**
     * Get all tasks from table tasks.
     *
     * @return all tasks.
     */
    @Override
    public List<Task> getAll() {

        List<Task> result;

        final String query = "select tk from Task tk where tk.id > 0";

        try (final Session session = factory.get().openSession()) {

            result = session.createQuery(query, Task.class).getResultList();
        }

        return result;
    }
}
