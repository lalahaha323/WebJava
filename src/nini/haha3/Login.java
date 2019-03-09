package nini.haha3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;
import java.io.*;

@WebServlet(
        name="Login",
        urlPatterns = {"/login4.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS", value = "newsuccess.html"),
                @WebInitParam(name = "ERROR", value = "newerror.html")
        }
)

public class Login extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getInitParameter("SUCCESS");
        ERROR_VIEW = getInitParameter("ERROR");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        if("lala".equals(name) && "123456".equals(passwd)) {
            request.getRequestDispatcher(SUCCESS_VIEW)
                    .forward(request, response);
        } else {
            request.getRequestDispatcher(ERROR_VIEW)
                    .forward(request, response);
        }
    }

}
