/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.apache.commons.io.FileUtils;
import java.io.*;


/**
 *
 * @author Anubhav_Pandey
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of doPost method, of class Login.
     */
    @Test
    public void testDoPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        
        
        when(request.getParameter("uid")).thenReturn("1301010");
        when(request.getParameter("userName")).thenReturn("Anubhav");
        when(request.getParameter("userType")).thenReturn("Attendee");
        when(request.getParameter("pass")).thenReturn("Anubhav!23");
        PrintWriter writer = new PrintWriter("testlogin.txt");
        when(response.getWriter()).thenReturn(writer);
        Login instance = new Login();
        instance.doPost(request, response);
        

        verify(request, atLeast(1)).getParameter("userName");
        writer.flush(); // it may not have been flushed yet...
        assertTrue(FileUtils.readFileToString(new File("testlogin.txt"), "UTF-8")
                   .contains("Login Successfull"));
        
    }
    
}
