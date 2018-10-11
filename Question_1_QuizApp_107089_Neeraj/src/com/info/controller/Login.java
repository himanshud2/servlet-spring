package com.info.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.database.DAOOperation;
import com.info.userbean.User;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("HomePage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		String datasoursePath = ctx.getInitParameter("datasoursePath");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DAOOperation obj = new DAOOperation();
		try {
			
			User user = obj.checkUser(username, password, datasoursePath);
			if(user!=null)
			{
				HttpSession session= request.getSession(true);
				session.setAttribute("username", username);
				session.setAttribute("topic", user.getTopic());
				response.sendRedirect("QuizPage.jsp");
			}
			else
			{
				response.sendRedirect("LoginPage.jsp");
			}
		} 
		catch (SQLException | NamingException e) {
			e.printStackTrace();
		}

	}

}
