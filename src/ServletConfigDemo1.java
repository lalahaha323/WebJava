import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.io.PrintWriter;


public class ServletConfigDemo1 extends HttpServlet {

    private ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramVal = this.config.getInitParameter("name");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(paramVal);
        out.println("<hr/>");
        Enumeration<String> e = config.getInitParameterNames();
        while(e.hasMoreElements()) {
            String name = e.nextElement();
            String value = config.getInitParameter(name);
            out.println(name + "=" + value + "<br/>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
