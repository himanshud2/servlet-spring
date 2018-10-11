<%@page import="p1.DaoOperation"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CheckLogin</title>
</head>
<body>
<% 
String username = request.getParameter("uname");
String password = request.getParameter("pwd");
DaoOperation dao=new DaoOperation();
boolean result=dao.checkLogin(username,password);
if(result==true){
	session.setAttribute("username", username);
	 RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");  
     rd.forward(request, response);  
}
else if(result==false){
	%>
	Login Failed
	<% 
}
%>
</body>
</html>