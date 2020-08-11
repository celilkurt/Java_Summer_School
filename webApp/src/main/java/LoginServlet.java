import javax.annotation.Resource;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private String message;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("j_username");
        String password = request.getParameter("j_password");

        /*RequestDispatcher dispatcher;
        if(id.equals("user1") && password.equals("pass")){

            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }else{
            dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("login.jsp");
    }



}