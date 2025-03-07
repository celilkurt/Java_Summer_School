package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/session/create")
public class SessionPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("header","Create Session");
        forwardWithDispatcher(req,resp,"/session/post.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("key");
        String value = req.getParameter("value");
        req.getSession().setAttribute(key,value);
        resp.sendRedirect("/Day9SessionCRUDApp/session/list");

    }

    public void forwardWithDispatcher(HttpServletRequest req, HttpServletResponse resp,String path) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req,resp);

    }
}