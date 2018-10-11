package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Ticket;
import com.bean.Train;
import com.exception.LoginException;
import com.utility.ConnectionProvider;

public class TicketDao {

	
	Connection connection;
	PreparedStatement ps;
	//TicketDao dao=new TicketDao();
	public void login(String unm,String pwd)throws LoginException{
		try {
			connection = ConnectionProvider.getCon();
			ps = connection.prepareStatement("Select * from Admin_login where unm=? and pwd=?");
			ps.setString(1, unm);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//System.out.println("empty");
			}
			else{
				throw new LoginException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end login
	
	public void showTrains(){
		try {
			connection = ConnectionProvider.getCon();
			ps = connection.prepareStatement("Select * from Train_Details");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.print("Train Number:- "+rs.getInt(1));
				System.out.print("Train Name:- "+rs.getString(2));
				System.out.print("Source:- "+rs.getString(3));
				System.out.print("Destination:- "+rs.getString(4));
				System.out.print("Fare:- "+rs.getFloat(5));
				System.out.println("\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end showTrains
	
	public void bookTicket(int trainno){
		Scanner sc = new Scanner(System.in);
		int ticketId=(int)(Math.random()+2)*1000;
		
		String cls = null;
		int fare;
		Train train=trainInfo(trainno);
		//System.out.println(train.getDestination());
		fare=(int) train.getFare();
		System.out.println("Choose Your Class");
		System.out.println("1.AC\n2.SL");
		int ch=Integer.parseInt(sc.nextLine());
		if(ch==1){
			cls="AC";
			fare=fare+200;
		}
		else if(ch==2){
			cls="SL";
		}
		else{
			System.out.println("Wrong Choice");
		}
		System.out.println("Enter No of Passengers");
		int noOfPsg=Integer.parseInt(sc.nextLine());
		int totalamt=noOfPsg*fare;
		try {
			connection = ConnectionProvider.getCon();
			ps = connection.prepareStatement("insert into Ticket_Details values(?,?,?,?,?,?,?)");
			ps.setInt(1, ticketId);
			ps.setString(2, cls);
			ps.setString(3, train.getSource());
			ps.setString(4, train.getDestination());
			ps.setInt(5,noOfPsg);
			ps.setInt(6, totalamt);
			ps.setInt(7,trainno);
			int result=ps.executeUpdate();
			if(result!=0){
				System.out.println("Ticket booked your ticket id is "+ticketId);
			}
			else{
				System.out.println("Ticket Not Booked");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Train trainInfo(int trainno){
		Train train = null;
		try {
			connection = ConnectionProvider.getCon();
			ps = connection.prepareStatement("Select * from Train_Details where tNo=?");
			ps.setInt(1, trainno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				train=new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5));
			}
			return train;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}//end trainInfo
	
	public void cancelTicket(int ticketNo){
		Ticket ticket=ticketInfo(ticketNo);
		String cls=ticket.getCls();
		System.out.println(cls);
		int fare=ticket.getTotalAmt();
		int psg=ticket.getNoOfPsg();
		if(cls.equals("SL")){
			for(int i=0;i<psg;i++){
			  fare=fare-50;
			}
		}
		if(cls.equals("AC")){
			for(int i=0;i<psg;i++){
				  fare=fare-100;
			}
		}
		try {
			connection = ConnectionProvider.getCon();
			ps = connection.prepareStatement("delete from Ticket_Details where ticketid=?");
			ps.setInt(1, ticketNo);
			int result=ps.executeUpdate();
			if(result!=0){
				System.out.println("Your ticket is cancelled your refunded amount is "+fare);
			}
			else{
				System.out.println("Ticket Not Cancelled");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Ticket ticketInfo(int ticketNo){
		Ticket ticket = null;
		try {
			connection = ConnectionProvider.getCon();
			ps = connection.prepareStatement("Select * from Ticket_Details where ticketid=?");
			ps.setInt(1, ticketNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ticket=new Ticket(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
			}
			return ticket;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
