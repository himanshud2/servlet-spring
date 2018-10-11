package com.main;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aspect.MyAspect;
import com.bean.Admin;
import com.dao.TicketDao;
import com.exception.LoginException;
import com.service.TicketManagement;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scanner sc=new Scanner(System.in);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
		TicketDao ticketDao = (TicketDao) applicationContext.getBean("ticketdao");
		MyAspect asp=applicationContext.getBean("aspect",MyAspect.class);
		//TicketManagement tmgmt = (TicketManagement) applicationContext.getBean("ticketmgmt");
		Admin admin = (Admin) applicationContext.getBean("admin");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name");
		String unm=sc.nextLine();
		System.out.println("Enter Password");
		String pwd=sc.nextLine();
		try {
			ticketDao.login(unm,pwd);
			ticketDao.showTrains();
			while(true){
				System.out.println("1. View Trains");
				System.out.println("2. Book Tickets");
				System.out.println("3. Cancel Tickets");
				System.out.println("4. Exit");
				int ch=Integer.parseInt(sc.nextLine());
				switch(ch){
				case 1:  ticketDao.showTrains();
					break;
				case 2: 
					System.out.println("Enter Train Number");
					int trainno=Integer.parseInt(sc.nextLine());
					ticketDao.bookTicket(trainno);
					break;
				case 3:System.out.println("Enter Ticket Number");
				int ticketno=Integer.parseInt(sc.nextLine());
				ticketDao.cancelTicket(ticketno);
					break;
				case 4: System.exit(0);
					break;
				default:
					System.out.println("Wrong Input");
				}
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}//end main

}
