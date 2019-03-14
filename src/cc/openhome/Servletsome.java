package cc.openhome;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/some2")
public class Servletsome extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Some do one...");
        RequestDispatcher dispatcher = req.getRequestDispatcher("other.view?data=12345");
        dispatcher.forward(req, resp);
        out.println("Some do two...");
        out.close();
    }
}
