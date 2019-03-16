package cc.openhome1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/2.do")
public class aboutServlet2 extends HttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String client_randomNum = request.getParameter("randomNum");
        String session_randomNum = (String) request.getSession().getAttribute("randomNum");
        if(client_randomNum == null || session_randomNum == null || !client_randomNum.equals(session_randomNum)) {
            System.out.println("验证码错误了！！！");
            return ;
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
