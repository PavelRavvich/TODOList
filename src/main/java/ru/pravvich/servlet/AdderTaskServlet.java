package ru.pravvich.servlet;

import ru.pravvich.dao.DAO;
import ru.pravvich.model.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * Addition task to server.
 */
public class AdderTaskServlet extends HttpServlet {

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


        final String description = req.getParameter("data");

        if (description != null && description.length() > 1) {

            final Task task = new Task();
            task.setDesc(description);
            task.setCreate(new Timestamp(System.currentTimeMillis()));

            taskDAO.save(task);

            resp.getWriter().write("succses");

        } else {
            resp.getWriter().write("fail");
        }

        System.out.println(req.getParameter("data"));
    }
}
