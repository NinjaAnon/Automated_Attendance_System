/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anubhav_Pandey
 */
@WebServlet(name = "TakeAttendance", urlPatterns = {"/takeattendance"})
public class TakeAttendance extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userType = (String) session.getAttribute("usertype");
        if (userType.equals("Admin")) {
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter test = response.getWriter();
            String asname = request.getParameter("asname");
            String day = request.getParameter("day");
            String UIDs = request.getParameter("uids");
            PrintWriter out = null;
            try {
                out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Anubhav_Pandey\\Bitnami Trac Stack projects\\Automated Attendance System\\AttendanceSheets\\" + asname, true)));
                out.println("Attendance for day :" + day + " Roll Numbers present:   " + UIDs);
                //uncomment for test test.println("Attendance Added");
            } catch (IOException e) {
                test.println(e);
            } finally {
                if (out != null) {
                    out.close();
                }
            }
