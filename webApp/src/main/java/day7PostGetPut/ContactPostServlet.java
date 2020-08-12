package day7PostGetPut;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/contact/post")
public class ContactPostServlet extends HttpServlet {

    private MysqlHelper mysqlHelper = new MysqlHelper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Contact contact = new Contact((String)request.getParameter("name"),(String)request.getParameter("tel_num"));
        try {
            mysqlHelper.addContact(contact);
            System.out.println("Request to create contact: " + contact.toString());
            response.sendRedirect("/webApp/contacts");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            response.sendRedirect("/webApp/errorPages/SQLExecption.jsp");
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("header","Create Contact");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contactPost.jsp");
        dispatcher.forward(request, response);

    }



}
