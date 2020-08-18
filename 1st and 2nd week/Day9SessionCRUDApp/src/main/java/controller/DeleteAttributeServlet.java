package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns="/session/delete")
public class DeleteAttributeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("key")!=null){
            String key = req.getParameter("key");
            req.getSession().removeAttribute(key);
        }

        resp.sendRedirect("/Day9SessionCRUDApp/session/list");


    }
}
