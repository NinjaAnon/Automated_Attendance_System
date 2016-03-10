/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anubhav_Pandey
 *
 */
@WebServlet(name = "GiveAttendance", urlPatterns = {"/giveattendance"})
public class GiveAttendance extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.io.FileNotFoundException
     * @throws com.google.zxing.NotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException, NotFoundException {
        HttpSession session = request.getSession();
        
        String userType = (String) session.getAttribute("usertype");
        if(userType.equals("Attendee"))
        {
        String fileName = request.getParameter("acode");
        String asname = request.getParameter("asname");
        String filePath = "C:\\Users\\Anubhav_Pandey\\Bitnami Trac Stack projects\\Automated Attendance System\\AttendanceSheets\\" + fileName+".png";
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map hintMap = new HashMap();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PrintWriter out1;
        out1 = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Anubhav_Pandey\\Bitnami Trac Stack projects\\Automated Attendance System\\AttendanceSheets\\" + asname, true)));
                System.out.println(readQRCode(filePath, charset, hintMap));
        out.println("Data read from QR Code: "
    + readQRCode(filePath, charset, hintMap));
        }
        else
        {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(" ACCESS DENIED: You are not an attendee");}

