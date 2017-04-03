/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PCS;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Hiren
 */
@WebServlet(name="rcapprove", urlPatterns={"/rcapprove"})
public class rcapprove extends HttpServlet
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
                Logger.getLogger(rcapprove.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(rcapprove.class.getName()).log(Level.SEVERE, null, ex);
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
        String uid = (String)sessionobj.getAttribute("eid");
        String userid = request.getParameter("userid");
        String docid = request.getParameter("docid");
        String status = request.getParameter("status");
        Connection con;
        Statement st,sr,sd;
        ResultSet rs,rd;

        try
        {  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            sr = con.createStatement();
            sd = con.createStatement();
            rd = sd.executeQuery("SELECT CURDATE()");
            while(rd.next())
            {
            Date d1 = rd.getDate(1);
            rs = st.executeQuery("SELECT Current_Project FROM Employee_Master WHERE Emp_ID = '"+uid+"' ");
            while(rs.next())
            {
                String pro = rs.getString(1);
                sr.executeUpdate("INSERT INTO Document_Master (Document_ID,Sent_From,Sent_To,Document_Status,Project_ID,Description,Date) VALUES('"+docid+"','"+uid+"','"+userid+"','"+status+"','"+pro+"','NULL','"+d1+"')");
                sr.executeUpdate("UPDATE Document_Master SET Document_Status = 'Done' WHERE Document_ID = '"+docid+"' AND Sent_From = '"+userid+"' AND Sent_To = '"+uid+"' AND Project_ID = '"+pro+"' ");
                response.sendRedirect("rcap.jsp");
            }
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
