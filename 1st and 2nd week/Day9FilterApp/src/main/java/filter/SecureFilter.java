package filter;



import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecureFilter implements Filter{

    private static  final Logger logger = Logger.getLogger(SecureFilter.class);

    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = ((HttpServletRequest) servletRequest);


        if(httpServletRequest.getSession().getAttribute("isLogged") != null){
            boolean isLogged = (boolean)httpServletRequest.getSession().getAttribute("isLogged");
            if(isLogged)
                filterChain.doFilter(servletRequest, servletResponse);
            else{
                redirectWithRealPath(httpServletRequest,(HttpServletResponse)servletResponse);
            }
        }else{
            redirectWithRealPath(httpServletRequest,(HttpServletResponse)servletResponse);
        }



    }

    public void redirectWithRealPath(HttpServletRequest httpServletRequest , HttpServletResponse servletResponse) throws ServletException, IOException {
        String realPath = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
        httpServletRequest.getSession().setAttribute("realPath",realPath);
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("/login");
        dispatcher.forward(httpServletRequest, servletResponse);
    }


    public void destroy() {}
}