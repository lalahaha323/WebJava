package lala.haha2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig(location="/home/lala")
@WebServlet("/ude.do")
public class Upload3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Part part = req.getPart("photo");
        String filename = getFilename(part);
        //System.out.println(filename);
        part.write(filename);
    }
    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        return filename;
    }
}
