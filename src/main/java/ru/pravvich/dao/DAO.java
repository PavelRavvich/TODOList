package ru.pravvich.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * CRUD DAO.
 */
public interface DAO<Id extends Number, Entity extends Serializable> {

    /**
     * Addition task.
     *
     * @param task for save.
     */
    void save(final Entity task);

    /**
     * Get entity by Id.
     *
     * @param id for select.
     * @return entity with same id.
     */
    Entity getById(final Id id);

    /**
     * Update entity without exist check.
     *
     * @param entity new state.
     */
    void update(final Entity entity);

    /**
     * Delete entity.
     *
     * @param id of task for delete.
     */
    void delete(final Entity id);

    /**
     * Get all task which contains in task table.
     *
     * @return all exist tasks.
     */
    List<Entity> getAll();
}
