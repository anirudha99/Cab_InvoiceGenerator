package com.cabinvoice;

public class CabInvoiceGenerator {

	private final int MINIMUM_FARE = 5;

	public double generateFare(double distance, double time) {
		double cost = (distance * 10) + (1 * time);
		return cost > MINIMUM_FARE ? cost : MINIMUM_FARE;
	}


}
