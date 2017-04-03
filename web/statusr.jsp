<%-- 
    Document   : statusr
    Created on : Jan 21, 2012, 1:58:38 PM
    Author     : Hiren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <meta name="Description" content="..."></meta>
        <meta name="Keywords" content="..."></meta>
        <meta name="robots" content="all,follow"></meta>
        <meta name="author" content="..."></meta>
        <meta name="copyright" content="Mantis-a [http://www.mantisa.cz/]"></meta>
        <meta http-equiv="Content-Script-Type" content="text/javascript"></meta>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"></link>
        <link rel="stylesheet" href="css/style-print.css" type="text/css" media="print"></link>
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"></link>
        <title>Proposal Clearance System</title>
   </head>
<body>
    <%
            String design =(String)session.getAttribute("designation");
            String eid = (String)session.getAttribute("eid");
            String ename = (String)session.getAttribute("ename");
            String state = (String)session.getAttribute("state");
            String project = (String)session.getAttribute("project");

            if(state.equals("false"))
            {
                response.sendRedirect("login.jsp");
            }
    %>
<div id="wrapper">

	<!-- Header -->
	<div id="header">

            <h1 style=" color:black">MHM Consultancy Services</h1>
            <h2 style=" color:black">Proposal Clearance System</h2>
            <h2 style=" color:black">UserID : <%=eid%></h2>
            <h2 style=" color:black">Name&nbsp;&nbsp;&nbsp;: <%=ename%></h2>

         </div>
	<!-- Header end -->

	<!-- Menu -->
	<div id="menu-box"  class="cleaning-box">

		<ul id="menu">
                    <li><a href="#" class="active" style=" background-color:olive">DASHBOARD</a></li>
                    <li style=" color:white"><b style=" font-size: 150%">Designation : <%=design%></b></li>
                        <li><a href="homepage.jsp">HOME</a></li>
                        <% if(design.equals("Project Manager")){%>
                        <li><a href="crdoc.jsp">CREATE &nbsp;DOCUMENT</a></li><%}%>
                        <% if(eid.equals("Admin")){%>
                        <li><a href="admin.jsp">ADMINISTRATION</a></li><%}%>
			<li><a href="#">MHM</a></li>
			<li><a href="logout">LOGOUT</a></li>
		</ul>
        </div>
	<!-- Menu end -->

<hr class="noscreen"/>
<div id="skip-menu"></div>

<%@page import="java.sql.*;" %>
<%@page import="Pandya.Messages;" %>

<%
                    Connection con;
                    Statement sg,sp,sb;
                    ResultSet rg,rp,rb;

              Class.forName("com.mysql.jdbc.Driver").newInstance();
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
              sg = con.createStatement();
              sp = con.createStatement();
              sb = con.createStatement();
%>
<div id="content" style=" background-color:white">
            <div id="column-1" style=" background-color:white"><br></br>
                <%
                    if(eid.equals("Admin"))
                    {

                    }
                    else
                    {
                %>
                <h2>You have Worked on Following Projects :</h2><br></br>
                <table style=" margin-left: 25px" border="1">
                    <tr style="background: #4A4A4A url('../img/menu-bg.gif') repeat-x 0 0">
                        <td style=" color: white">Project ID</td>
                        <td style=" color: white">Your Designation</td>
                        <td style=" color: white">Project_Status</td>
                    </tr>
            <%
              rp=sp.executeQuery("SELECT * FROM Emp_Project WHERE Emp_ID = '"+eid+"' ");
              while(rp.next())
              {
                   String pro = rp.getString(1);
                   rg = sg.executeQuery("SELECT Project_Status FROM Project_Master WHERE Project_ID = '"+pro+"' ");
                   while(rg.next()) {
            %>
            <tr>
                <td align="center"><%=rp.getString(1)%></td>
                <td align="center"><%=rp.getString(3)%></td>
                <td align="center"><%=rg.getString(1)%></td>
            </tr>
            <%}
              }
              
             %>
            </table>
             <%}%>

             <%

                                   Messages msg = new Messages(eid,project);
                                   int ract = msg.ract();
                                   int racc = msg.racc();
                                   int rcap = msg.rcap();
                                   int rcavd = msg.rcavd();
                                   int rcbk = msg.rcbk();
                                   int sentapvd = msg.sentapvd();
                                   int sentfw = msg.sentfw();
                                   int sentbk = msg.sentback();
                                   int sentcc = msg.sentcc();
                                   int sentcr = msg.sentcr();
                                
                    rb = sb.executeQuery("SELECT Project_ID FROM Project_Master WHERE Emp_ID = '"+eid+"' AND Project_Status = 'In Process' ");
                    
             %>
             <br></br><br></br>
                <div>
                    <table><tr style="background-color: black"><td style="width: 1150px"></td></tr></table>
                </div><br></br>
                <%
                    if(eid.equals("Admin"))
                    {
                %>
                <h2 style=" color: black">Admin Transactions&nbsp;&nbsp;&nbsp;:</h2><br></br>

                
                <%
                    rp = sp.executeQuery("SELECT Document_ID,Sent_From,Sent_To,Document_Status,Date FROM Document_Master WHERE (Document_Status = 'Approved' OR Document_Status = 'Done' OR Document_Status = 'In Process') AND (Sent_To = 'Admin' OR Sent_From = 'Admin') ");
                %>
               <table style=" text-align: center" border="1">
                    <tr align="center" style=" background: #4A4A4A url('../img/menu-bg.gif') repeat-x 0 0">
                        <td style="color: white">Document_ID</td>
                        <td style="color: white">Sent_From</td>
                        <td style="color: white">Sent_To</td>
                        <td style="color: white">Document_Status</td>
                        <td style="color: white">Date</td>
                    </tr>
                    <%
                        while(rp.next())
                        {
                    %>
                    <tr style=" background-color: white">
                        <td><%=rp.getString(1)%></td>
                        <td><%=rp.getString(2)%></td>
                        <td><%=rp.getString(3)%></td>
                        <td><%=rp.getString(4)%></td>
                        <td><%=rp.getDate(5)%></td>
                        
                        
                    </tr>
                    <%}

                    %>
                </table><br></br>

                <% }
                   else
                   {
                %>

                <h2 style=" color: black">Current Project Transactions&nbsp;&nbsp;&nbsp;:</h2><br></br>

                    <%
                      if(design.equals("Project Manager"))
                      {
                         rp = sp.executeQuery("SELECT Document_ID,Sent_From,Sent_To,Document_Status,Date FROM Document_Master WHERE Project_ID = '"+project+"' AND (Document_Status = 'Approved' OR Document_Status = 'Done') ");
                    %>
                <table style=" text-align: center" border="1">
                    <tr align="center" style=" background: #4A4A4A url('../img/menu-bg.gif') repeat-x 0 0">
                        <td style="color: white">Document_ID</td>
                        <td style="color: white">Sent_From</td>
                        <td style="color: white">Sent_To</td>
                        <td style="color: white">Document_Status</td>
                        <td style="color: white">Date</td>
                    </tr>
                    <%
                        while(rp.next())
                        {
                    %>
                    <tr style=" background-color: white">
                        <td><%=rp.getString(1)%></td>
                        <td><%=rp.getString(2)%></td>
                        <td><%=rp.getString(3)%></td>
                        <td><%=rp.getString(4)%></td>
                        <td><%=rp.getDate(5)%></td>

                        
                    </tr>
                    <%}
                      
                    %>
                </table><br></br>


              <form action="approve">
              <h2 style=" color: black">Approve the Project :
                  
                    <select name="pr">
                        <% while(rb.next()) {%>
                                   <option><%=rb.getString(1)%></option>
                             <%}%>
                     </select>
                     <input type="submit" value="Done"></input>
               </h2>
              </form><br></br>
               <div>
                    <table><tr style="background-color: black"><td style="width: 1150px"></td></tr></table>
               </div>
               <%}
                    else
                    {
                        rp = sp.executeQuery("SELECT Document_ID,Sent_From,Sent_To,Document_Status,Date FROM Document_Master WHERE Project_ID = '"+project+"' AND (Document_Status = 'Approved' OR Document_Status = 'Done') AND (Sent_To = '"+eid+"' OR Sent_From = '"+eid+"') ");
                    
               %>
               <table style=" text-align: center" border="1">
                    <tr align="center" style=" background: #4A4A4A url('../img/menu-bg.gif') repeat-x 0 0">
                        <td style="color: white">Document_ID</td>
                        <td style="color: white">Sent_From</td>
                        <td style="color: white">Sent_To</td>
                        <td style="color: white">Document_Status</td>
                        <td style="color: white">Date</td>
                    </tr>
                    <%
                        while(rp.next())
                        {
                    %>
                    <tr style=" background-color: white">
                        <td><%=rp.getString(1)%></td>
                        <td><%=rp.getString(2)%></td>
                        <td><%=rp.getString(3)%></td>
                        <td><%=rp.getString(4)%></td>
                        <td><%=rp.getDate(5)%></td>

                        
                    </tr>
                    <%}
                      
                    %>
                </table><br></br>
                <%}
                  }
                  con.close();
                %>

                    
            </div>
            <div id="column-2" style="background: #4A4A4A url('../img/menu-bg.gif') repeat-x 0 0">
			<h3 style=" font-size: 14px">Pending Items</h3>
                        <div class="content">
                            <a href="ract.jsp"><b>Rcvd for Action (<%=ract%>)</b></a><br></br>
                            <a href="rcbk.jsp">Rcvd Back (<%=rcbk%>)</a><br></br>
                            <a href="rcap.jsp">Rcvd for Approve (<%=rcap%>)</a><br></br>
                            <a href="racc.jsp">Rcvd As CC (<%=racc%>)</a><br></br>
                            <a href="rcavd.jsp">Rcvd Approved (<%=rcavd%>)</a>
                        </div>

			<h3 style=" font-size: 14px">In Process Items</h3>

				<div class="content">
                                    <a href="sentcr.jsp">Sent Created (<%=sentcr%>)</a><br></br>
                                    <a href="sentfw.jsp">Sent Forward (<%=sentfw%>)</a><br></br>
                                    <a href="sentback.jsp">Sent Back (<%=sentbk%>)</a><br></br>
                                    <a href="sentcc.jsp">Sent As CC (<%=sentcc%>)</a><br></br>
                                    <a href="sentapvd.jsp">Sent Approved (<%=sentapvd%>)</a>
                                </div>
                        <h3 style=" font-size: 14px">Completed Items</h3>

                               <div class="content">
                                    <a href="#">Archived</a><br></br>
                                    <a href="#">Search Archived</a><br></br>
                                    <a href="#">Search As CC</a>
                               </div>

                        <h3 style=" font-size: 14px">Action Pane</h3>

                               <div class="content">
                                    <a href="statusr.jsp">Project Reports</a><br></br>
                                    <a href="#">Edit Profile</a><br></br>
                                    <a href="#">Change Password</a><br></br>
                                    <a href="#">Help</a>
                               </div>
                </div>

		<div class="cleaner"> </div>
	</div>

<hr class="noscreen"/><!-- Footer --><div id="footer">
		<div id="footer-in">
                    <p class="footer-left">© <a href="#">Pandya Consultancy Services</a></p>
		</div>
	</div>
	<!-- Footer end -->

</div>
</body>
</html>
