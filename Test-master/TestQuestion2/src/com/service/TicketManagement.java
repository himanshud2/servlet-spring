package com.service;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.TicketDao;
import com.exception.LoginException;

public class TicketManagement {

	
	
	TicketDao dao=new TicketDao();
	public void Login(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Name");
		String unm=sc.nextLine();
		System.out.println("Enter Password");
		String pwd=sc.nextLine();
		try {
			dao.login(unm, pwd);
			showTrains();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void showTrains(){
		//ticketDao.showTrains();
	}
}
