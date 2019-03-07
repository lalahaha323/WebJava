package nini.haha1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/logout2.view")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("login");
        session.invalidate();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>注销</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>用户 " + user + " 已注销</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
