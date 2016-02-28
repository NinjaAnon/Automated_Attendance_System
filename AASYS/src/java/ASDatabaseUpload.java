import java.sql.*;

public class ASDatabaseUpload
 {
    public ASUpload(string name)
    {
     try{
    //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/aasys","root","apple123");
         PreparedStatement ps =con.prepareStatement
                             ("create table AS_"+name+"");
        }
         catch(Exception e)
      {
          e.printStackTrace();
      }
    }
}
