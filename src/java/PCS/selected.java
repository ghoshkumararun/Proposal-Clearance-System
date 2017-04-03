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



@WebServlet(name="selected", urlPatterns={"/selected"})
public class selected extends HttpServlet
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
                Logger.getLogger(selected.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(selected.class.getName()).log(Level.SEVERE, null, ex);
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
        String empid = request.getParameter("avail");
        String projid = (String)sessionobj.getAttribute("project1");
               
        Connection con;
        Statement st,sg,sr,sp;
        ResultSet rs;

        try
        {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
                st = con.createStatement();
                sg = con.createStatement();
                sr = con.createStatement();
                sp = con.createStatement();
                st.executeUpdate("update Employee_Master set Status='Selected' where Emp_ID='"+empid+"'");
                sr.executeUpdate("update Employee_Master set Current_Project='"+projid+"' where Emp_ID='"+empid+"' ");
                rs = sg.executeQuery("SELECT * FROM Employee_Master WHERE Emp_ID = '"+empid+"' ");
                while(rs.next())
                {
                    String sdes = rs.getString(4);
                    out.println(sdes);
                    sp.executeUpdate("INSERT INTO Emp_Project (Project_ID,Emp_ID,Designation) VALUES('"+projid+"','"+empid+"','"+sdes+"')");
                }
                response.sendRedirect("created.jsp");
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
