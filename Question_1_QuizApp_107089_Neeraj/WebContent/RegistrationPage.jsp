<%@page import="java.sql.ResultSet"%>
<%@page import="com.info.database.DAOOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ServletContext ctx= getServletContext();
String path=ctx.getInitParameter("datasoursePath");
DAOOperation obj=new DAOOperation();
ResultSet rs=obj.getTopic(path);
%>
<table style="text-align: center;">
<form action="RegisterUser.jsp">
<tr>
<td><b>Username : </b></td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td><b>Password : </b></td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><b>Age : </b></td>
<td><input type="text" name="age"></td>
</tr>
<tr>
<td><b>Topic : </b></td>
<td><select name="topic">
<% 
while(rs.next())
{
%>
<option value=<%=rs.getString(1)%>><%=rs.getString(1) %></option>
<%
}
%>
</select></td>
</tr>
<tr><td><input type="submit" value="Register"></td></tr>
</form>
</table>
</body>
</html>