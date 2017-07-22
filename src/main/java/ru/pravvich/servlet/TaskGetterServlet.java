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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final DAO<Integer, Task> taskDAO = getDAOTask(req);

        final List<Task> allTask = taskDAO.getAll();

        allTask.forEach(System.out::println);

        resp.getWriter().write(new Gson().toJson(allTask));
    }

    /**
     * Get DAOTask instance.
     */
    private DAO<Integer, Task> getDAOTask(final HttpServletRequest req) {

        return (DAO<Integer, Task>) req.getServletContext()
                .getAttribute("daoTask");
    }
}
