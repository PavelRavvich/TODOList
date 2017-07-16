package ru.pravvich.servlet;

import com.google.gson.Gson;
import ru.pravvich.model.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Getter for task.
 */
public class TaskGetterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final Task task = new Task(1, "todo",
                new Timestamp(System.currentTimeMillis()), false);

        resp.getWriter().write(new Gson().toJson(task));
    }
}
