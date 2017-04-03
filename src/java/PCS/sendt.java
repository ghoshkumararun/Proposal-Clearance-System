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
@WebServlet(name="sendt", urlPatterns={"/sendt"})
public class sendt extends HttpServlet
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
                Logger.getLogger(sendt.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(sendt.class.getName()).log(Level.SEVERE, null, ex);
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

        HttpSession sessionobj = request.getSession(true);
        String sendto = request.getParameter("sendto");
        String details = request.getParameter("details");
        String cate = request.getParameter("state");
        String uid = (String)sessionobj.getAttribute("eid");
        String docid = request.getParameter("docid");
        String projid=(String)sessionobj.getAttribute("project1");
        
        Connection con;
        Statement st,sp,sd;
        ResultSet rs,rd;
        
        try
        {
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
              st = con.createStatement();
              sp = con.createStatement();
              sd = con.createStatement();

              rs = sp.executeQuery("SELECT CURDATE()");
              while(rs.next())
              {
              rd = sd.executeQuery("SELECT CURTIME()");
              while(rd.next())
              {
              Date d1 = rs.getDate(1);
              Time t1 = rs.getTime(1);
              
              st.executeUpdate("INSERT INTO Document_Master (Document_ID,Sent_From,Sent_To,Document_Status,Project_ID,Description,Date) VALUES('"+docid+"','"+uid+"','"+sendto+"','"+cate+"','"+projid+"','"+details+"','"+d1+"')");
              out.println("Your Message has been Sent.");
              response.sendRedirect("workf.jsp");
              }
              }
              con.close();

        }
        catch(SQLException g)
        {
             out.println("Err");
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

