package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/do")
public class HelloServlet2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        //设置响应的东西
        response.setContentType("html/text;charset=UTF-8");
        //取得代表响应输出的PrintWriter对象
        PrintWriter out = response.getWriter();
        //获取“请求参数”
        String name = request.getParameter("name");
        //一系列的html语句加java语句
        out.close();
    }
}