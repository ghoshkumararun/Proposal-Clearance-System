<%-- 
    Document   : created
    Created on : Jan 20, 2012, 11:40:47 PM
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
    <%@page import="java.sql.*;" %>
    <%@page import="Pandya.Messages;" %>

    <%
              String design =(String)session.getAttribute("designation");
              String projid=(String)session.getAttribute("project1");
              String eid = (String)session.getAttribute("eid");
              String ename = (String)session.getAttribute("ename");
              String state = (String)session.getAttribute("state");
              String project = (String)session.getAttribute("project");

              if(state.equals("false"))
              {
                  response.sendRedirect("login.jsp");
              }

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

              Connection con;
              Statement st,sp;
              ResultSet rs,rp;
            
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
              st = con.createStatement();
              sp = con.createStatement();
              
              
     %> 
<body>
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
<div id="content" style=" background-color:white">
    <div id="column-1" style=" background-color:white"><br></br>
                
                <div style=" background-color: inactiveborder">
                    <h2>Your Current Project : <%=projid%></h2><br></br>
                    <form action="selected">   
                      <table style=" background-color:white">
                        <tr align="center">
                            <td align="center" style=" background: #4A4A4A url('../img/menu-bg.gif') repeat-x 0 0"><h2 style=" color: white">Available Users :</h2></td>
                            <td rowspan="2" align="center"><input type="image" src="enter3.jpg"></input></td>
                            <td align="center" style=" background: #4A4A4A url('../img/menu-bg.gif') repeat-x 0 0"><h2 style=" color: white">Selected Users :</h2></td>
                        </tr>
                        <tr align="center">
                            <td align="center">
                                <select multiple="multiple" name="avail">
                                    <%
                                        rs = st.executeQuery("select Emp_ID from Employee_Master where Status='Available' ");

                                        while(rs.next()){%>
                                    <option><%=rs.getString(1)%></option>
                                    <%}%>
                                </select>
                            </td>
                            <td align="center">
                                <select name="selected" multiple="multiple">
                                    <%
                                         rp = sp.executeQuery("SELECT Emp_ID FROM Employee_Master WHERE Status = 'Selected' AND Current_Project = '"+projid+"' ");
                                         while(rp.next()){%>
                                    <option><%=rp.getString(1)%></option>
                                    <%}
                                        con.close();
                                    %>
                                </select>
                            </td>
                        </tr>
                    </table>
                    </form><br></br>
                    <form action="workf.jsp">
                         <input type="submit" value="Show"></input>
                    </form>
                 </div>
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
