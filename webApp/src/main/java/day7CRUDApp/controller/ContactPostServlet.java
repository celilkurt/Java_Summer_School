package day7CRUDApp.controller;


import day7CRUDApp.dao.MysqlHelper;
import day7CRUDApp.entity.Contact;
import day7CRUDApp.entity.DBResult;
import day7CRUDApp.service.DBService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/contact/post")
public class ContactPostServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ContactPostServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBResult dbResult = DBService.getInstance().addContact(new Contact((String)request.getParameter("name"),(String)request.getParameter("tel_num")));
        setAlertAttribute(request,dbResult.getMessage());
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getAttribute("alertMessage") == null)
            request.setAttribute("hasAlert",false);

        request.setAttribute("header","Create Contact");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contactPost.jsp");
        dispatcher.forward(request, response);

    }

    public void setAlertAttribute(HttpServletRequest request,String message){
        request.setAttribute("hasAlert",true);
        request.setAttribute("alertMessage",message);
    }



}
