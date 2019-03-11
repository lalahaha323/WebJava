package cc.openhome;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
public class Hello implements Servlet {
    //初始化该Servlet，类似于构造函数，只是第一次调用时调用
    public void init(ServletConfig parm1) throws ServletException {
        System.out.println("init it");
    }
    //得到servlet配置文件，与生命周期无关
    public ServletConfig getServletConfig() {
        return null;
    }
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("service it");
        PrintWriter out = resp.getWriter();
        out.println("Hello World");
    }
    public String getServletInfo() {
        return "";
    }
    public void destroy() {
        System.out.println("destroy it");
    }
}
