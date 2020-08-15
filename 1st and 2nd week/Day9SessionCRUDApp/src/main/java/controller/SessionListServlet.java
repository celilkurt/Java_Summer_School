package controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/list-session-attributes")
public class SessionListServlet  extends HttpServlet {

    private static final Logger logger = Logger.getLogger(SessionListServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = request.getSession(true);
        request.getSession().setAttribute("header","Attributes List");
        request.getSession().setAttribute("example","this is a attribute1");
        request.getSession().setAttribute("asdw","this is a attribute");

        logger.info(request.getAttribute("example"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/sessionList.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
