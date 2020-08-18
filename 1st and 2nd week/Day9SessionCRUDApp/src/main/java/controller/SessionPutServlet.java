package controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/session/update")
public class SessionPutServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("currentKey","Key");
        if(req.getParameter("key") != null){
            String key = req.getParameter("key");
            req.getSession().setAttribute("currentKey",key);
        }

        req.getSession().setAttribute("header","Update Attribute");
        req.getRequestDispatcher("/session/put.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("key");
        String value = req.getParameter("value");
        req.getSession().setAttribute(key,value);

        resp.sendRedirect("/Day9SessionCRUDApp/session/list");

    }
}
