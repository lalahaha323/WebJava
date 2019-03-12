package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/*")
public class PathServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>lala</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(request.getRequestURI() + "<br>");
        out.println(request.getContextPath() + "<br>");
        out.println(request.getServletPath() + "<br>");
        out.println(request.getPathInfo() + "<br>");
        out.println("</body>");
        out.println("</html>");
    }
}
