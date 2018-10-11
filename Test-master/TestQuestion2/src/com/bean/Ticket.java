package com.bean;

public class Ticket {

	int ticketId;
	String cls;
	String source;
	String destination;
	int noOfPsg;
	int totalAmt;
	int tNo;
	public Ticket() {
		super();
	}
	public Ticket(int ticketId, String cls, String source, String destination, int noOfPsg, int totalAmt, int tNo) {
		super();
		this.ticketId = ticketId;
		this.cls = cls;
		this.source = source;
		this.destination = destination;
		this.noOfPsg = noOfPsg;
		this.totalAmt = totalAmt;
		this.tNo = tNo;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNoOfPsg() {
		return noOfPsg;
	}
	public void setNoOfPsg(int noOfPsg) {
		this.noOfPsg = noOfPsg;
	}
	public int getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", cls=" + cls + ", source=" + source + ", destination=" + destination
				+ ", noOfPsg=" + noOfPsg + ", totalAmt=" + totalAmt + ", tNo=" + tNo + "]";
	}
	
	
	
}
