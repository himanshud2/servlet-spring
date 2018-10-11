package com.bean;

public class Train {

	int tNo;
	String name;
	String source;
	String destination;
	float fare;
	public Train() {
		super();
	}
	public Train(int tNo, String name, String source, String destination, float fare) {
		super();
		this.tNo = tNo;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
	}
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Train [tNo=" + tNo + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ ", fare=" + fare + "]";
	}
	
	
	
}
