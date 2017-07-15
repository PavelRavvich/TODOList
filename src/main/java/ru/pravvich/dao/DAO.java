package ru.pravvich.dao;

import ru.pravvich.model.Task;

import java.util.List;

/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * CRUD DAO.
 */
public interface DAO {
    /**
     * Addition task.
     *
     * @param task for add.
     */
    void addTask(final Task task);

    /**
     * Get task by Id.
     *
     * @param id for select.
     * @return Task with same id.
     */
    Task getTaskById(final int id);

    /**
     * Check exist task.
     *
     * @param task fo check.
     * @return true if exist, else false.
     */
    boolean isExist(final Task task);

    /**
     * Update task without exist check.
     *
     * @param task new state.
     */

    void updateTask(final Task task);
    /**
     * Delete task.
     *
     * @param id of task for delete.
     */

    void deleteTask(final int id);

    /**
     * Get all task which contains in task table.
     *
     * @return all exist tasks.
     */
    List<Task> getAllTasks();
}
