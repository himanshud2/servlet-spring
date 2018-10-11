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
<%
ServletContext ctx= getServletContext();
String path=ctx.getInitParameter("datasoursePath");
HttpSession session= request.getSession();
String topic="";
 if(session==null)
{
	response.sendRedirect("HomePage.jsp");
}
else
{
	topic=(String)session.getAttribute("topic");
	if(topic.equals("") || topic==null)
	{
		response.sendRedirect("HomePage.jsp");
	}
} 
DAOOperation obj=new DAOOperation();
ResultSet rs=obj.getQuiz(topic, path);
%>
<body>
<form action="QuizSubmit" method="post">
<%
int counter=1;
while(rs.next()&&counter<=5)
{
%>
<fieldset>
<div style="font-size: 15px;font-weight: bold;"><%=counter%>. <%=rs.getString(2) %></div>
<div style="font-size: 12px;"><input type="radio" name=<%="userAnswer"+counter %> value='a' checked="checked" > <%=rs.getString(3) %></div>
<div style="font-size: 12px;"><input type="radio" name=<%="userAnswer"+counter %> value='b' > <%=rs.getString(4) %></div>
<div style="font-size: 12px;"><input type="radio" name=<%="userAnswer"+counter %> value='c' > <%=rs.getString(5) %></div>
<div style="font-size: 12px;"><input type="radio" name=<%="userAnswer"+counter %> value='d' > <%=rs.getString(6) %></div>
<input type="hidden" name=<%="correctAnswer"+counter%> value=<%=rs.getString(7) %>>
</fieldset> 
<%
counter++;
} 
%>
<input type="submit" value="Submit">
<input type="submit" value="Reset">
</form>
</body>
</html>