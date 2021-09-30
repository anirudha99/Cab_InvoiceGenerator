package com.cabinvoice;

public class Ride {

	int userId;
	double distance, time;
	String rideType;

	public Ride(int userId,double distance, double time, String rideType) {
		this.distance = distance;
		this.time = time;
		this.userId = userId;
		this.rideType = rideType;
	}

	public String getRideType() {
		return rideType;
	}

	public void setRideType(String rideType) {
		this.rideType = rideType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

}
