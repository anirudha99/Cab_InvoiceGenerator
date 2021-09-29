package com.cabinvoice;

public class Ride {
	
	int userId;
	double distance, time;

	public Ride(int userId,double distance, double time) {
		this.distance = distance;
		this.time = time;
		this.userId = userId;
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
