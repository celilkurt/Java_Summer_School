package controller;

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

@WebServlet(urlPatterns = "/contact/put")
public class ContactPutServlet  extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ContactPostServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBResult dbResult = DBService.getInstance().updateContact(new Contact((String)request.getParameter("name"),(String)request.getParameter("tel_num")));
        setAlertAttribute(request,dbResult.getMessage());
        doGet(request,response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setDefaulthAttribute(request);

        if(request.getAttribute("alertMessage") == null){
            request.setAttribute("hasAlert",false);
        }

        if(request.getParameter("name") == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/contactPut.jsp");
            requestDispatcher.forward(request,response);
        }else {
            DBResult dbResult = DBService.getInstance().getContactWithName(request.getParameter("name"));
            if(dbResult.isSuccessful())
                request.setAttribute("contact", dbResult.getResult());
            else
                setAlertAttribute(request,dbResult.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/contactPut.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    public void forwardRequest(HttpServletRequest request,HttpServletResponse response,String path ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request,response);
    }

    public void setAlertAttribute(HttpServletRequest request,String message){
        request.setAttribute("hasAlert",true);
        request.setAttribute("alertMessage",message);
    }

    public void setDefaulthAttribute(HttpServletRequest request ){
        request.setAttribute("header","Update Contact");
        request.setAttribute("contact",new Contact("Name","Tel Number"));

    }

}
