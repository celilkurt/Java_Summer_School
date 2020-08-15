package controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/session/post")
public class SessionPostServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(SessionPostServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String key = request.getParameter("key");
        String value = request.getParameter("value");
        if(key != null || value != null)
            request.getSession().setAttribute(key,value);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list-session-attributes");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("header","Create Session");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/createSession.jsp");
        dispatcher.forward(request, response);

    }

}