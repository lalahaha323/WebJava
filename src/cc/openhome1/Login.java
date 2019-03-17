package cc.openhome1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
@WebServlet("/login.do")
public class Login extends HttpServlet {
    private Map<String, String> users;
    public Login() {
        users = new HashMap<String, String>();
        users.put("lala", "1234");
        users.put("nini", "1234");
        users.put("kaka", "1234");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        System.out.println(name);
        String page = "form.html";
        if (users.containsKey(name) && users.get(name).equals(passwd)) {
            request.getSession().setAttribute("user", name);
            page = "welcome.view";
        }
        response.sendRedirect(page);
    }
}
