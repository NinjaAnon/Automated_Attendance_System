
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "seeattendance", urlPatterns = {"/seeattendance"})
public class seeattendance extends HttpServlet {
     
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String asname = request.getParameter("asname");
        // reads input file from an absolute path
        String filePath = "C:\\Users\\Anubhav_Pandey\\Bitnami Trac Stack projects\\Automated Attendance System\\AttendanceSheets\\"+asname;
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
         
        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);
         
        // obtains ServletContext
        ServletContext context = getServletContext();
         
