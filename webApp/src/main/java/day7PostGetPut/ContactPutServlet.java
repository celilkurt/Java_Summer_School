package day7PostGetPut;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/contact/put")
public class ContactPutServlet  extends HttpServlet {

    private MysqlHelper mysqlHelper = new MysqlHelper();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contact contact = new Contact((String)request.getParameter("name"),(String)request.getParameter("tel_num"));
        try {
            mysqlHelper.updateContact(contact);
            System.out.println("Request to update contact: " + contact.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect("/webApp/contacts");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("header","Update Contact");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/contactPut.jsp");
        requestDispatcher.forward(request,response);

    }

}
