import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String uid = request.getParameter("uid");
        String pass = request.getParameter("pass");
        
        if(Validate.checkUser(uid, pass))
        {
            RequestDispatcher rs =   request.getRequestDispatcher("welcome");
            rs.forward(request, response);
        }
        else
        {
            
           out.println("UID or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("login.html");
           rs.include(request, response);
        }
    }  
}