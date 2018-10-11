<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
 HttpSession session= request.getSession();
String username="";
if(session==null)
{
	response.sendRedirect("HomePage.jsp");
}
else
{
	username=(String)session.getAttribute("username");
} 
Date d= new Date();
SimpleDateFormat fd= new SimpleDateFormat("dd-MMM-yyyy");
String date=fd.format(d);
%>
<body>
<h1>Congratulation <%=username%>!</h1>
<br><br>
<h2>You Have Won ABC Movie ticket of date : <%=date %></h2>
</body>
</html>