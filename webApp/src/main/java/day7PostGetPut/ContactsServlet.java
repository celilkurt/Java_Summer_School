package day7PostGetPut;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(urlPatterns = "/contacts")
public class ContactsServlet  extends HttpServlet {

    private MysqlHelper mysqlHelper = new MysqlHelper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("header","Contact List");
            request.getRequestDispatcher("/dashboard/header.jsp").include(request, response);
            request.setAttribute("contacts",getContacts());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/contacts.jsp");
        requestDispatcher.forward(request,response);

    }

    protected Collection<Contact> getContacts() throws SQLException {
        ResultSet results = mysqlHelper.getContacts();
        List<Contact> list = new ArrayList<>();

        while(results.next())
            list.add(new Contact(results.getString("name"),results.getString("tel_num")));

        return list;
    }

}