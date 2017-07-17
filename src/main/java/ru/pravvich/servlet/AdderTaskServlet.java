package ru.pravvich.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pavel Ravvich on 15.07.17.
 *
 * Addition task to server.
 */
public class AdderTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        System.out.println(req.getParameter("data"));
        resp.getWriter().write("server messege");

    }
}
