package ru.pravvich.servlet;

import com.google.gson.Gson;
import ru.pravvich.model.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Getter for task.
 */
public class TaskGetterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final Task task = new Task(1, "todo",
                new Timestamp(System.currentTimeMillis()), false);

        final Task task1 = new Task(2, "todo2",
                new Timestamp(System.currentTimeMillis()), true);

        final Task task2 = new Task(3, "todo3",
                new Timestamp(System.currentTimeMillis()), false);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task1);
        tasks.add(task2);



        resp.getWriter().write(new Gson().toJson(tasks));
    }
}
