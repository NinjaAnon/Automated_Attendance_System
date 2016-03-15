
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

@WebServlet(name = "ImageReceiver", urlPatterns = {"/receiver"})

public class ImageReceiver extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            StringBuffer buffer = new StringBuffer();
            Reader reader = request.getReader();
            int current;

            while ((current = reader.read()) >= 0) {
                buffer.append((char) current);
            }

            String data = new String(buffer);
            data = data.substring(data.indexOf(",") + 1);

            System.out.println("PNG image data on Base64: " + data);
            int name = new Random().nextInt(100000);
            FileOutputStream output = new FileOutputStream(new File("C:\\Users\\Anubhav_Pandey\\Bitnami Trac Stack projects\\Automated Attendance System\\AttendanceSheets\\"
                    + name + ".png"));


            output.write(new BASE64Decoder().decodeBuffer(data));
            output.flush();
            output.close();

            response.setContentType("text/html");
             PrintWriter out = response.getWriter();
             out.print(name);
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

