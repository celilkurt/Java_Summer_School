package day7SecureFilter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest) {

            if(((HttpServletRequest)servletRequest).getRequestURL().toString().contains("secured")){
                servletResponse.getWriter().println("it is secured");
                ((HttpServletResponse)servletResponse).sendError(403);
            }
        }

            filterChain.doFilter(servletRequest, servletResponse);

    }



    public void destroy() {}
}