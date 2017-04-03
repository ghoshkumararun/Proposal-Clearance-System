/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PCS;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import javax.servlet.http.*;
import java.io.*;

/**
 *
 * @author Hiren
 */
@WebServlet(name="approve", urlPatterns={"/approve"})
public class approve extends HttpServlet
{

     @Override

     public void init()
     {
         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }
            catch (InstantiationException ex)
            {
                Logger.getLogger(approve.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(approve.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         catch(ClassNotFoundException e)
         {

         }
     }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pro = request.getParameter("pr");
        
        Connection con;
        Statement st,sg,sr,sd,sh;
        ResultSet rd;
        
        try
        {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
                st = con.createStatement();
                sg = con.createStatement();
                sr = con.createStatement();
                sd = con.createStatement();
                sh = con.createStatement();

                rd = sd.executeQuery("SELECT CURDATE()");
                while(rd.next())
                {
                Date d1 = rd.getDate(1);
                st.executeUpdate("UPDATE Project_Master SET Project_Status = 'Approved' WHERE Project_ID = '"+pro+"' ");
                sh.executeUpdate("UPDATE Project_Master SET Completed_Date = '"+d1+"' WHERE Project_ID = '"+pro+"' ");
                sg.executeUpdate("UPDATE Employee_Master SET Status = 'Available' WHERE Current_Project = '"+pro+"' ");
                sr.executeUpdate("UPDATE Employee_Master SET Current_Project = 'NULL' WHERE Current_Project = '"+pro+"' ");

                response.sendRedirect("statusr.jsp");
                }
                con.close();
         }
        catch(SQLException g)
        {
             out.println("Erro");
        }
        finally
        {
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
