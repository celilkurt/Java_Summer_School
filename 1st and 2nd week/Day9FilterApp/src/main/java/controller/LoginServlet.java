package controller;


import day9FilterApp.service.AuthService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setDefaultAttribute(request);
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if(name != null && password != null){
            if(AuthService.getInstance().auth(name,password)){

                request.getSession().setAttribute("isLogged",true);
                logger.info("Login successful!");
                request.getSession().setAttribute("name",name);

                if(request.getSession().getAttribute("realPath") != null){
                    String realPath = (String)request.getSession().getAttribute("realPath");
                    request.getSession().removeAttribute("realPath");
                    response.sendRedirect("/webApp/" + realPath);
                }
            }else{
                request.getSession().setAttribute("isLogged",false);
                logger.info("login failed!");
                setAlertAttribute(request,"login failed!");
                doGet(request,response);
            }

        }else{
            logger.info("Credentials invalid!");
            setAlertAttribute(request,"Credentials invalid!");
            doGet(request,response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getAttribute("alertMessage") == null)
            setDefaultAttribute(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("public/login.jsp");
            dispatcher.forward(req, resp);


    }

    public void setAlertAttribute(HttpServletRequest request,String message){

        request.setAttribute("hasAlert",true);
        request.setAttribute("alertMessage",message);
    }

    public void setDefaultAttribute(HttpServletRequest request){
        request.getSession().setAttribute("header","Login Page");
        request.setAttribute("hasAlert",false);
    }
}
