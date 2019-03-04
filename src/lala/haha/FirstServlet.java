package lala.haha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/header.view")
public class FirstServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HeaderServlet</title>");
        out.println("<body>");
        out.println("<h1>HeaderServlet at" + req.getContextPath() + "</h1>");
        Enumeration<String> names = req.getHeaderNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            out.println(name + ": " + req.getHeader(name) + "<br>");
        }
        out.println("</head>");
        out.println("</html>");
        out.close();
    }
}
