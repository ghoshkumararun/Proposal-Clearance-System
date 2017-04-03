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
@WebServlet(name="dcreate", urlPatterns={"/dcreate"})
public class dcreate extends HttpServlet
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
                Logger.getLogger(dcreate.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(dcreate.class.getName()).log(Level.SEVERE, null, ex);
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
        String proj = request.getParameter("proje");
        sessionobj.setAttribute("pro", proj);
        String design = (String)sessionobj.getAttribute("designation");
        String uid = (String)sessionobj.getAttribute("eid");
        
        Connection con;
        Statement st;
        ResultSet rs;

        try
        {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
                st = con.createStatement();
                if(uid.equals("Admin"))
                {
                    response.sendRedirect("dworkf.jsp");
                }
                else
                {
                    rs = st.executeQuery("SELECT Current_Project FROM Employee_Master WHERE Emp_ID='"+uid+"' ");
                    while(rs.next())
                    {
                        if(rs.getString(1).equals(proj))
                        {
                            response.sendRedirect("dworkf.jsp");
                        }
                        else
                        {
                            response.sendRedirect("homepage.jsp");
                        }
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
