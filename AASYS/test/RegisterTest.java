/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Anubhav_Pandey
 */
public class RegisterTest {
    
    public RegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of processRequest method, of class Register.
     * @throws java.lang.Exception
     */
    @Test
    public void testProcessRequest() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("uid")).thenReturn("me");
        when(request.getParameter("pass")).thenReturn("secret");
        PrintWriter writer = new PrintWriter("testregister.txt");
        when(response.getWriter()).thenReturn(writer);
        Register instance = new Register();
        instance.doPost(request, response);
        

        verify(request, atLeast(1)).getParameter("name"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        assertTrue(FileUtils.readFileToString(new File("testregister.txt"), "UTF-8")
                   .contains("You are sucessfully registered"));
    }

    /**
     * Test of doGet method, of class Register.
     */
    

    /**
     * Test of doPost method, of class Register.
     */
    

    /**
     * Test of getServletInfo method, of class Register.
     */
    
    
}
