package controller;

import dao.MysqlHelper;
import entity.Contact;
import entity.DBResult;
import org.apache.log4j.Logger;
import service.DBService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/contacts")
public class ContactsServlet  extends HttpServlet {

    private static final Logger logger = Logger.getLogger(MysqlHelper.class);


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setDefaulthAttribute(request);
        DBResult dbResult = DBService.getInstance().getContacts();

        if(!dbResult.isSuccessful()){
            setAlertAttribute(request,dbResult.getMessage());
        }

        request.setAttribute("contacts", (List<Contact>)dbResult.getResult());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/contacts.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public void setAlertAttribute(HttpServletRequest request, String message){
        request.setAttribute("hasAlert",true);
        request.setAttribute("alertMessage",message);
    }

    public void setDefaulthAttribute(HttpServletRequest request){
        request.setAttribute("hasAlert",false);
        request.setAttribute("header","Contact List");
    }

    }