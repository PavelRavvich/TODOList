package ru.pravvich.servlet;

import com.google.gson.Gson;
import ru.pravvich.dao.DAO;
import ru.pravvich.model.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Getter for task.
 */
public class TaskGetterServlet extends HttpServlet {
    /**
     * DAO layer for tasks.
     */
    private DAO<Integer, Task> taskDAO;

    @Override
    public void init() throws ServletException {
        this.taskDAO = (DAO<Integer, Task>) getServletContext()
                .getAttribute("daoTask");

        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final List<Task> allTask = taskDAO.getAll();

        resp.setContentType("text/json; charset=UTF-8");
        resp.getWriter().write(new Gson().toJson(allTask));
    }
}
