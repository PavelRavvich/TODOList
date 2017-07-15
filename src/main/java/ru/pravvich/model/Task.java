package ru.pravvich.model;

import java.sql.Timestamp;

/**
 * Task model.
 */
public class Task {
    /**
     * Id of task.
     */
    private int id;
    /**
     * Description of task.
     */
    private String desc;
    /**
     * Create time.
     */
    private Timestamp create;
    /**
     * Task status. true - done, false processing.
     */
    private boolean done;

    /**
     * Default constructor.
     */
    public Task(final int id,
                final String desc,
                final Timestamp create,
                final boolean done) {
        this.id = id;
        this.desc = desc;
        this.create = create;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
