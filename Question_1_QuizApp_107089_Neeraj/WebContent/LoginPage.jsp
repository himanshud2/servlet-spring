<%@page import="com.info.userbean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
request.getRequestDispatcher("Logout.jsp").include(request, response);
%>
<table style="text-align: center;">
<form action="Login" method="post">
<tr>
<td><b>Username : </b></td>
<td><input type="text" name="username"></td>
</tr>
<td><b>Password : </b></td>
<td><input type="password" name="password"></td>
</tr>
<tr><td><input type="submit" value="Login"></td></tr>
</form>
</table>
</body>
</html>