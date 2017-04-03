<%-- 
    Document   : fileupload
    Created on : May 22, 2012, 12:22:24 AM
    Author     : Hiren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Infosysy Technology</title>
    </head>
    <body>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con;
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcsdb","root","hirenpandya");
      Statement s = null;
      ResultSet rs = null;
      s = con.createStatement();

	//to get the content type information from JSP Request Header
	String contentType = request.getContentType();

	if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
 		DataInputStream in = new DataInputStream(request.
                getInputStream());
		//we are taking the length of Content type data
		int formDataLength = request.getContentLength();
		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		//this loop converting the uploaded file into byte code
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead,
                formDataLength);
			totalBytesRead += byteRead;
			}

		String file = new String(dataBytes);
		//for saving the file name
		String saveFile = file.substring(file.indexOf("filename=\"") + 10);
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\")+ 1,saveFile.indexOf("\""));
		int lastIndex = contentType.lastIndexOf("=");
		String boundary = contentType.substring(lastIndex + 1,contentType.length());
		int pos;
		//extracting the index of file
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes()).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;


		FileOutputStream fileOut = new FileOutputStream("C:/Users/Hiren/Documents/NetBeansProjects/PCS_Pr/web/fileuploading/upload/"+saveFile);
		fileOut.write(dataBytes, startPos, (endPos - startPos));
		fileOut.flush();
		fileOut.close();
                String command = "INSERT INTO Document_Master (filename)  VALUES ('"+saveFile+"')";
                s.executeUpdate(command);
                rs = s.executeQuery("select filename from Document_Master");
int i=1;
		%><Br><table border="2"><tr><th colspan="3"><b>You have successfully
 upload the file by the name of:</b>
		<% out.println(saveFile); %></th></tr></table>
   <TABLE BORDER="1">

      <%
   while(rs.next()){

       if(i%3 == 1)
        { %>
         <tr>
       <%
}
%>
<TD><img alt="" src="upload/<%= rs.getString(1) %>" height="150px" width="150px"> </TD>


        <%
  if(i%3==0)
      {%>
         </tr>
<%   }    i++;  }
%>
   </TABLE>

                <%
		}
%>
    </body>
</html>
