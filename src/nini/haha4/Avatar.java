package nini.haha4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(
        urlPatterns = {"/avatar.view"},
        initParams = {
                @WebInitParam(
                        name = "AVATAR_DIR",
                        value = "/"
                )
        }
)
public class Avatar extends HttpServlet {
    private String AVATAR_DIR;

    @Override
    public void init() throws ServletException {
        AVATAR_DIR = getInitParameter("AVATAR_DIR");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         out.println("<html>");
         out.println("<head>");
         out.println("<title>头像显示</title>");
         out.println("</head>");
         out.println("<body>");
         for(String avatar : getServletContext().getResourcePaths(AVATAR_DIR)) {
                avatar = avatar.replaceFirst("/", "");
                out.println("<img src='" + avatar + "'>");
         }
         out.println("</body>");
         out.println("</html>");
         out.close();
    }
}
