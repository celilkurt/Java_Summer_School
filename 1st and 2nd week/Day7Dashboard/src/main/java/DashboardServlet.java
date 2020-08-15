import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("proNo",2);
        request.setAttribute("totalTaxes",120);
        request.setAttribute("taxRate",8);
        request.setAttribute("totalSales",1500);
        request.setAttribute("email","abcd@mail.com");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard/main.jsp");
        dispatcher.forward(request, response);
    }



}
