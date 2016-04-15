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
public class TakeAttendanceTest {
    
    public TakeAttendanceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of processRequest method, of class TakeAttendance.
     */
    @Test
    public void testProcessRequest() throws Exception {
        
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        
        
        when(request.getParameter("asname")).thenReturn("1301010");
        when(request.getParameter("day")).thenReturn("Anubhav");
        when(request.getParameter("uids")).thenReturn("Attendee");
        
        PrintWriter writer = new PrintWriter("testtakeattendance.txt");
        when(response.getWriter()).thenReturn(writer);
        TakeAttendance instance = new TakeAttendance();
        instance.doPost(request, response);
        

        verify(request, atLeast(1)).getParameter("asname");
        writer.flush(); // it may not have been flushed yet...
        assertTrue(FileUtils.readFileToString(new File("testtakeattendance.txt"), "UTF-8")
                   .contains("Attendance Added"));
        
    }
    }

    

    
    

