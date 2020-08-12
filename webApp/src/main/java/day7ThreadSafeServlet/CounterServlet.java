package day7ThreadSafeServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {

    private int count;

    synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int temp = count;

        count++;

        System.out.println("Count: " + count);
        response.getWriter().write("Counter: " + count);

        if((temp+1) == count){
            response.setStatus(200);
        }else
            response.setStatus(500);

    }

}