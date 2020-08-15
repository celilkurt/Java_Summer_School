package controller;

import org.apache.log4j.Logger;
import service.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sign-up")
public class SignUpServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setDefaultAttribute(request);
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if(name != null && password != null){

            String message = AuthService.getInstance().signUp(name,password);
            logger.info(message);
            setAlertAttribute(request,message);

        }else{
            logger.info("Credentials invalid!");
            setAlertAttribute(request,"Error!");
        }
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getAttribute("alertMessage") == null)
            setDefaultAttribute(req);

        RequestDispatcher dispatcher = req.getRequestDispatcher("public/sign-up.jsp");
        dispatcher.forward(req, resp);

    }

    public void setAlertAttribute(HttpServletRequest request,String message){

        request.setAttribute("hasAlert",true);
        request.setAttribute("alertMessage",message);
    }

    public void setDefaultAttribute(HttpServletRequest request){
        request.getSession().setAttribute("header","Sign Up");
        request.setAttribute("hasAlert",false);
    }
}