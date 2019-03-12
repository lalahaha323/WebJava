package cc.openhome;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/test")
public class testServlet extends HttpServlet {
    public static void main(String[] args) {
        System.out.println("la");
    }
}
