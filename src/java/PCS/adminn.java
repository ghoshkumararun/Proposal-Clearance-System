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
@WebServlet(name="adminn", urlPatterns={"/adminn"})
public class adminn extends HttpServlet
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
                Logger.getLogger(adminn.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(adminn.class.getName()).log(Level.SEVERE, null, ex);
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
        String emid = request.getParameter("emid");
        String emname = request.getParameter("emname");
        String emdes = request.getParameter("emdes");
        String emsalary = request.getParameter("emsalary");
        String emaddress = request.getParameter("emaddress");
        String emexp = request.getParameter("emexp");
        String empass = request.getParameter("empass");
        String emstatus = request.getParameter("emstatus");
        String add = request.getParameter("add");
        String update = request.getParameter("update");
        String delete = request.getParameter("delete");


        Connection con;
        Statement sp;

        try
        {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
                sp = con.createStatement();
                if(add.length()!=0)
                {
                    sp.executeUpdate("INSERT INTO Employee_Master (Emp_ID,Emp_Name,Password,Designation,Address,Salary,Status,Experience,Current_Project) VALUES('"+emid+"','"+emname+"','"+empass+"','"+emdes+"','"+emaddress+"','"+emsalary+"','"+emstatus+"','"+emexp+"','NULL')");
                }

                response.sendRedirect("admin.jsp");
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
