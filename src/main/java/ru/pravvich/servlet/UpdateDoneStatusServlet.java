package ru.pravvich.servlet;

import ru.pravvich.dao.DAO;
import ru.pravvich.model.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pavel on 17.07.17.
 */
public class UpdateDoneStatusServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final int id = Integer.parseInt(req.getParameter("id"));

        boolean done = req.getParameter("done").equals("1");

        taskDAO.updateDone(id, done);

        System.out.println(id);
        System.out.println(done);
    }
}
