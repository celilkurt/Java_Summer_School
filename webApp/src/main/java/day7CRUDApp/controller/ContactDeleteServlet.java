package day7CRUDApp.controller;

import day7CRUDApp.service.DBService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/contact/delete")
public class ContactDeleteServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ContactDeleteServlet.class);

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = DBService.getInstance().deleteContact(request.getParameter("name"));
        setAlertAttribute(request,message);
        forwardRequest(request,response,"/contacts");
        //response.sendRedirect("/contacts");
    }

    public void forwardRequest(HttpServletRequest request,HttpServletResponse response,String path ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/contactPut.jsp");
        requestDispatcher.forward(request,response);
    }

    public void setAlertAttribute(HttpServletRequest request,String message){
        request.setAttribute("hasAlert",true);
        request.setAttribute("alertMessage",message);
    }

}
