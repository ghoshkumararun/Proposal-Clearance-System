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
@WebServlet(name="update", urlPatterns={"/update"})
public class update extends HttpServlet
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
        String update = request.getParameter("update");
        String delete = request.getParameter("delete");


        Connection con;
        Statement sp,sr,st,sg;
        ResultSet rs;

        try
        {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
                sp = con.createStatement();
                sr = con.createStatement();
                st = con.createStatement();
                
                rs = st.executeQuery("SELECT * FROM Employee_Master WHERE Emp_ID = '"+emid+"' ");
                if(update.length()!=0)
                {
                    while(rs.next())
                    {
                        if(empass.length()==0)
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Password = '"+rs.getString(3)+"' WHERE Emp_ID = '"+emid+"' ");
                        }
                        else
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Password = '"+empass+"' WHERE Emp_ID = '"+emid+"' ");
                        }

                        if(emdes.length()==0)
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Designation = '"+rs.getString(4)+"' WHERE Emp_ID = '"+emid+"' ");
                        }
                        else
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Designation = '"+emdes+"' WHERE Emp_ID = '"+emid+"' ");
                        }

                        if(emaddress.length()==0)
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Address = '"+rs.getString(5)+"' WHERE Emp_ID = '"+emid+"' ");
                        }
                        else
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Address = '"+emaddress+"' WHERE Emp_ID = '"+emid+"' ");
                        }

                        if(emsalary.length()==0)
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Salary = '"+rs.getString(6)+"' WHERE Emp_ID = '"+emid+"' ");
                        }
                        else
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Salary = '"+emsalary+"' WHERE Emp_ID = '"+emid+"' ");
                        }

                        if(emstatus.length()==0)
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Status = '"+rs.getString(7)+"' WHERE Emp_ID = '"+emid+"' ");
                        }
                        else
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Status = '"+emstatus+"' WHERE Emp_ID = '"+emid+"' ");
                        }

                        if(emexp.length()==0)
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Experience= '"+rs.getString(8)+"' WHERE Emp_ID = '"+emid+"' ");
                        }
                        else
                        {
                            sp.executeUpdate("UPDATE Employee_Master SET Experience= '"+emexp+"' WHERE Emp_ID = '"+emid+"' ");
                        }

                    }
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
