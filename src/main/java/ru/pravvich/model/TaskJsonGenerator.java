package ru.pravvich.model;

import com.google.gson.Gson;

import java.sql.Timestamp;

/**
 * Created by pavel on 16.07.17.
 */
public class TaskJsonGenerator {
    private Gson gson;

    public TaskJsonGenerator() {
        gson = new Gson();
    }

    public<T extends Task> String getJson(T obj) {
        return gson.toJson(obj);
    }
}
