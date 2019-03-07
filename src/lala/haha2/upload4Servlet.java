package lala.haha2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig(location="/home/lala")
@WebServlet("/upload3.do")
public class upload4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("lala");
        for(Part part : req.getParts()) {
            System.out.println("1");
            if(part.getName().startsWith("file")) {
                System.out.println("2");
                String filename =getFilename(part);
                part.write(filename);
            }
        }
    }
    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        System.out.println("haha");
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        System.out.println("kaka");
        return filename;
    }

}
