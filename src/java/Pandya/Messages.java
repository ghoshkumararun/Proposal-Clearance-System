/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hiren
 */
package Pandya;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class Messages
{
    String uid,project;
    public Messages(String id, String proje)
    {
        uid = id;
        project = proje;
    }


    public int ract() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                                ru = su.executeQuery("SELECT * FROM Document_Master WHERE Sent_To = '"+uid+"' AND Document_Status = 'In Process' AND Project_ID = '"+project+"' ");
                                while(ru.next())
                                {
                                        String sfrom = ru.getString(2);
                                        rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sfrom+"')");
                                        while(rg.next())
                                        {
                                            int n = rg.getInt(2);
                                            rh = sh.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                            while(rh.next())
                                            {
                                                int m = rh.getInt(2);
                                                if(n < m)
                                                {

                                    i = i + 1;

                                   }
                                   }
                                   }
                                   }

         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }
    
   public int racc() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                                ru = su.executeQuery("SELECT * FROM Document_Master WHERE Sent_To = '"+uid+"' AND Document_Status = 'In Process' AND Project_ID = '"+project+"' ");
                                    while(ru.next())
                                    {
                                        String sfrom = ru.getString(2);
                                        rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sfrom+"')");
                                        while(rg.next())
                                        {
                                            int n = rg.getInt(2);
                                            rh = sh.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                            while(rh.next())
                                            {
                                                int m = rh.getInt(2);
                                                if(n == m)
                                                {
                                                    i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

   public int rcap() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                                ru = su.executeQuery("SELECT * FROM Document_Master WHERE Sent_To = '"+uid+"' AND Document_Status = 'In Process' AND Project_ID = '"+project+"' ");
                                    while(ru.next())
                                    {
                                        String sfrom = ru.getString(2);
                                        rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sfrom+"')");
                                        while(rg.next())
                                        {
                                            int n = rg.getInt(2);
                                            rh = sh.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                            while(rh.next())
                                            {
                                                int m = rh.getInt(2);
                                                if(n > m)
                                                {
                                                    i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

   public int rcavd() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                                ru = su.executeQuery("SELECT * FROM Document_Master WHERE Sent_To = '"+uid+"' AND Document_Status = 'Approved' AND Project_ID = '"+project+"'");
                                    while(ru.next())
                                    {
                                        String sfrom = ru.getString(2);
                                        rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sfrom+"')");
                                        while(rg.next())
                                        {
                                            int n = rg.getInt(2);
                                            rh = sh.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                            while(rh.next())
                                            {
                                                int m = rh.getInt(2);
                                                if(n < m)
                                                {
                                                      i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

   public int rcbk() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                               ru = su.executeQuery("SELECT * FROM Document_Master WHERE Sent_To = '"+uid+"' AND Document_Status = 'Rejected' ");
                                    while(ru.next())
                                    {
                                        String sfrom = ru.getString(2);
                                        rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sfrom+"')");
                                        while(rg.next())
                                        {
                                            int n = rg.getInt(2);
                                            rh = sh.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                            while(rh.next())
                                            {
                                                int m = rh.getInt(2);
                                                if(n < m)
                                                {
                                                     i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

   public int sentapvd() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                               rt = st.executeQuery("SELECT * FROM Document_Master WHERE Sent_From = '"+uid+"' AND Document_Status = 'Approved' ");
                                   while(rt.next())
                                    {
                                        String sto = rt.getString(3);
                                        ru = su.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                        while(ru.next())
                                        {
                                            int n = ru.getInt(2);
                                            rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sto+"')");
                                            while(rg.next())
                                            {
                                                int m = rg.getInt(2);

                                                if(n < m)
                                                {
                                                     i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

   public int sentfw() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                               rt = st.executeQuery("SELECT * FROM Document_Master WHERE Sent_From = '"+uid+"' AND Document_Status = 'In Process' AND Project_ID = '"+project+"' ");
                                    while(rt.next())
                                    {
                                        String sto = rt.getString(3);
                                        ru = su.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                        while(ru.next())
                                        {
                                            int n = ru.getInt(2);
                                            rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sto+"')");
                                            while(rg.next())
                                            {
                                                int m = rg.getInt(2);

                                                if(n < m)
                                                {
                                                    i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

   public int sentback() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                              rt = st.executeQuery("SELECT * FROM Document_Master WHERE Sent_From = '"+uid+"' AND Document_Status = 'Rejected' ");
                                    while(rt.next())
                                    {
                                        String sto = rt.getString(3);
                                        ru = su.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                        while(ru.next())
                                        {
                                            int n = ru.getInt(2);
                                            rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sto+"')");
                                            while(rg.next())
                                            {
                                                int m = rg.getInt(2);

                                                if(n < m)
                                                {
                                                    i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

    public int sentcc() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                              rt = st.executeQuery("SELECT * FROM Document_Master WHERE Sent_From = '"+uid+"' AND Document_Status = 'In Process' AND Project_ID = '"+project+"' ");
                                    while(rt.next())
                                    {
                                        String sto = rt.getString(3);
                                        ru = su.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                        while(ru.next())
                                        {
                                            int n = ru.getInt(2);
                                            rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sto+"')");
                                            while(rg.next())
                                            {
                                                int m = rg.getInt(2);

                                                if(n == m)
                                                {
                                                    i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

    
public int sentcr() throws SQLException
    {
        int i = 0;
        try
        {
            Connection con;
            Statement st,su,sg,sh;
            ResultSet rs,rt,rg,rh,ru;

         try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            }

            catch (InstantiationException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
            st = con.createStatement();
            su = con.createStatement();
            sg = con.createStatement();
            sh = con.createStatement();


                              rt = st.executeQuery("SELECT * FROM Document_Master WHERE Sent_From = '"+uid+"' AND Document_Status = 'In Process' ");
                                   while(rt.next())
                                    {
                                        String sto = rt.getString(3);
                                        ru = su.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+uid+"')");
                                        while(ru.next())
                                        {
                                            int n = ru.getInt(2);
                                            rg = sg.executeQuery("SELECT * FROM Designation_Master WHERE Designation IN(SELECT Designation FROM Employee_Master WHERE Emp_ID = '"+sto+"')");
                                            while(rg.next())
                                            {
                                                int m = rg.getInt(2);

                                                if(n > m)
                                                {
                                                    i = i + 1;
                                                }
                                           }
                                       }
                                   }
         }
         catch(ClassNotFoundException e)
         {

         }
     }
     finally
     {
          System.out.close();
     }
     return(i);

  }

}
