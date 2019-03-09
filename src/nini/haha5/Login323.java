package nini.haha5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/login323.do")
public class Login323 extends HttpServlet {
    private Map<String, String> users;

    public Login323() {
        users = new HashMap<String, String>();
        users.put("lala","123456");
        users.put("haha", "zxcvbnm");
        users.put("kaka", "111111");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        String page = "Newlogin1.html";
        if(users.containsKey(name) && users.get(name).equals(passwd)) {
            User user = new User(name);
            request.getSession().setAttribute("user", name);
            page = "welcome.view";
        }
        response.sendRedirect(page);
    }

}
