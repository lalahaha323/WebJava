package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("upload1.do")
public class Upload2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] body = readBody(request);
        String textBody = new String(body, "ISO-8859-1");
        String filename = getFilename(textBody);
        Position p =getFilePosition(request, textBody);
        writeTo(filename, body, p);

    }
    class Position {
        int begin;
        int end;
        Position(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
    private byte[] readBody(HttpServletRequest request) throws IOException {
        int formDataLength = request.getContentLength();
        DataInputStream dataStream = new DataInputStream(request.getInputStream());
        byte body[] = new byte[formDataLength];
        int totalBytes = 0;
        while (totalBytes < formDataLength) {
            int bytes = dataStream.read(body, totalBytes, formDataLength);
            totalBytes += bytes;
        }
        return body;
    }
    private Position getFilePosition(HttpServletRequest request, String textBody) throws IOException {
        String contentType = request.getContentType();
        String boundaryText = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
        int pos = textBody.indexOf("filename=\"");
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
        int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
        int end = ((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;
        return new Position(begin, end);
    }
    private String getFilename(String reqBody) {
        String filename = reqBody.substring(reqBody.indexOf("filename=\"") + 10);
        filename = filename.substring(0, filename.indexOf("\n"));
        filename = filename.substring(filename.lastIndexOf("\\") + 1, filename.indexOf("\""));
        return filename;
    }
    private void writeTo(String filename, byte[] body, Position p) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/home/lala/" + filename);
        fileOutputStream.write(body, p.begin, (p.end - p.begin));
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
