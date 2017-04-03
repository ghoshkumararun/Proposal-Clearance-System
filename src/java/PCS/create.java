

package PCS;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import javax.servlet.http.*;
import java.io.*;


@WebServlet(name="create", urlPatterns={"/create"})
public class create extends HttpServlet
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
                Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
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
        String projid = request.getParameter("newprojid");
        String projname = request.getParameter("newprojname");

        sessionobj.setAttribute("project1",projid);
        String uid = (String)sessionobj.getAttribute("eid");
        String design = (String)sessionobj.getAttribute("designation");


        Connection con;
        Statement st,sr,sg,sh,sp,sd;
        ResultSet rs,rd;

        try
        {
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
               sd = con.createStatement();
               st = con.createStatement();
               sr = con.createStatement();
               sp = con.createStatement();
               rd = sd.executeQuery("SELECT CURDATE()");
               while(rd.next())
               {
                   Date d1 = rd.getDate(1);
               st.executeUpdate("INSERT INTO Project_Master (Project_ID,Project_Name,Emp_ID,Project_Status,Started_Date,Completed_Date) VALUES('"+projid+"','"+projname+"','"+uid+"','In Process','"+d1+"','"+d1+"')");
               sp.executeUpdate("INSERT INTO Emp_Project (Project_ID,Emp_ID,Designation) VALUES('"+projid+"','"+uid+"','"+design+"')");
               rs = sr.executeQuery("SELECT * FROM Employee_Master WHERE Emp_ID = '"+uid+"' ");
               while(rs.next())
               {
                    sg = con.createStatement();
                    sh = con.createStatement();
                    sg.executeUpdate("UPDATE Employee_Master SET Status = 'Selected' WHERE Emp_ID = '"+uid+"' ");
                    sh.executeUpdate("UPDATE Employee_Master SET Current_Project = '"+projid+"' WHERE Emp_ID = '"+uid+"' ");
               }
               }
               response.sendRedirect("created.jsp");
               


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
