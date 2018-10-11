package com.info.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuizSubmit
 */
public class QuizSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("HomePage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		int score=0;
		int i=0;
		String userAnswer;
		String correctAnswer;
		while(i<5)
		{
		userAnswer=request.getParameter("userAnswer"+(i+1));
		correctAnswer=request.getParameter("correctAnswer"+(i+1));
		System.out.println(userAnswer);
		System.out.println("correct : "+correctAnswer);
		if(userAnswer.equals(correctAnswer))
		{
			score++;
		}
		i++;
		}
		System.out.println(score);
		if(score<3)
		{
			out.print("Please Try Again after 10 days <a href='HomePage.jsp'>Home Page</a>");
		}
		else if(score==5)
		{
			response.sendRedirect("MovieTicket.jsp");
		}
		else
		{
			out.print("Nice try  <a href='HomePage.jsp'>Home Page</a>");
		}
		
	}

}
