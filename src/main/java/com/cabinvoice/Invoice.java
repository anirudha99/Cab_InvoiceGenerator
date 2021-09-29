package com.cabinvoice;

public class Invoice {

	int totalRides;
	double totalFare;
	double avgfare;

	public Invoice(int totalRides, double totalFare) {
		this.totalRides = totalRides;
		this.totalFare = totalFare;
		this.avgfare = this.totalFare / this.totalRides;
	}

	public double getAvgfare() {
		return avgfare;
	}

	public int getTotalRides() {
		return totalRides;
	}

	public void setTotalRides(int totalRides) {
		this.totalRides = totalRides;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public void setAvgfare(double avgfare) {
		this.avgfare = avgfare;
	}

}
