package nini.haha6;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(
        filterName="performance",
        urlPatterns={"/*"}
)
public class PerformanceFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        chain.doFilter(request, response);
        config.getServletContext().log("Request process in " + (System.currentTimeMillis() - begin) + " milliseconds");
    }
    @Override
    public void destroy() {}
}