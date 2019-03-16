package cc.openhome1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name="ServletConfigDemo",
        urlPatterns = {"/conf"},
        initParams = {
                @WebInitParam(name = "PARAM1", value = "VALUE1"),
                @WebInitParam(name = "PARAM2", value = "VALUE2")
        }
)
public class ServletDemo3 extends HttpServlet {
    private String PARAM1;
    private String PARAM2;
    public void init() throws ServletException {
        PARAM1 = getServletConfig().getInitParameter("PARAM1");
        PARAM2 = getServletConfig().getInitParameter("PARAM2");
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(PARAM1);
        System.out.println(PARAM2);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
