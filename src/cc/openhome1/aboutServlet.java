package cc.openhome1;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/1.do")
public class aboutServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D  = (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, 80, 20);
        graphics2D.setFont(new Font(null, Font.BOLD, 20));
        graphics2D.setColor(Color.BLUE);
        String randomNum = makeNum();
        graphics2D.drawString(randomNum, 0, 20);
        request.getSession().setAttribute("randomNum", randomNum);
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Content-type", "image/jpeg");
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }
    private String makeNum() {
        Random random = new Random();
        int num = random.nextInt(999999);
        String randomNum = String.valueOf(num);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < 6 - randomNum.length(); i++) {
            stringBuffer.append("0");
        }
        return stringBuffer.append(randomNum).toString();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      processRequest(request, response);
    }
}
