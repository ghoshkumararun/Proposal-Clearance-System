<%-- 
    Document   : sentbk
    Created on : Jan 21, 2012, 1:31:30 PM
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
   <%@page import="java.sql.*;" %>
   <%@page import="Pandya.Messages;" %>

        <%
              String design =(String)session.getAttribute("designation");
              String uid = (String)session.getAttribute("eid");
              String ename = (String)session.getAttribute("ename");
              String state = (String)session.getAttribute("state");
              String project = (String)session.getAttribute("project");
            if(state.equals("false"))
            {
                response.sendRedirect("login.jsp");
            }

                                   Messages msg = new Messages(uid,project);
                                   int ract = msg.ract();
                                   int racc = msg.racc();
                                   int rcap = msg.rcap();
                                   int rcavd = msg.rcavd();
                                   int rcbk = msg.rcbk();
                                   int sentapvd = msg.sentapvd();
                                   int sentfw = msg.sentfw();
                                   int sentcc = msg.sentcc();
                                   int sentcr = msg.sentcr();

              Connection con;
              Statement st,su,sg;
              ResultSet rt,ru,rg;

              Class.forName("com.mysql.jdbc.Driver").newInstance();
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");

        %>
<div id="wrapper">

	<!-- Header -->
	<div id="header">

            <h1 style=" color:black">MHM Consultancy Services</h1>
            <h2 style=" color:black">Proposal Clearance System</h2>
            <h2 style=" color:black">UserID : <%=uid%></h2>
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
                        <% if(uid.equals("Admin")){%>
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
                
                <h2 style=" color: black">Your Current Project Messages :</h2>

                    <%
                                st = con.createStatement();
                                su = con.createStatement();
                                sg = con.createStatement();
                                
                                 int i = 0;  
                                 rt = st.executeQuery("SELECT * FROM Document_Master WHERE Sent_From = '"+uid+"' AND Document_Status = 'Rejected' AND Project_ID = '"+project+"'");
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
                                                    //rh = sh.executeQuery("SELECT * FROM Document_Master WHERE Sent_From = '"+uid+"' AND Sent_To = '"+sto+"' AND Project_ID = '"+pr+"' AND Document_Status = 'Rejected' ");
                                                    //while(rh.next()){
                                    %>
                                                <br></br>
                                                <div style=" background-color:inactiveborder">
                                                    <h2 style=" background:#4A4A4A url('../img/menu-bg.gif') repeat-x 0 0"><b style=" color: white">Message <%=(i+1)%> : <%=rt.getDate(7)%></b></h2>
                                                    <h2>Send To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=rt.getString(3)%></h2>
                                                    <h2>Project Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=rt.getString(5)%></h2>
                                                    <h2>Document ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=rt.getString(1)%></h2>
                                                    <h2>Document Status  : <%=rt.getString(4)%></h2>
                                                    <h2>Attachment Files&nbsp;&nbsp;:</h2>
                                                    <h2>Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <br></br><%=rt.getString(6)%></h2>

                                                </div><br></br>
                             <%
                                   i = i + 1;
                                   
                                   }
                                   }
                                   }
                                   }

                                   session.setAttribute("sentbk",i);
                                   int sentbk = (Integer)session.getAttribute("sentbk");

                                   
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
