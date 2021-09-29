package com.cabinvoice;

import java.util.List;

public class CabInvoiceGenerator {

	private final int MINIMUM_FARE = 5;
	
	/**
	 * @param distance=total distance of journey in km
	 * @param time=total     time taken in journey in minutes
	 * @return the fare of the ride
	 */
	public double generateFare(double distance, double time) {
		double cost = (distance * 10) + (1 * time);
		return cost > MINIMUM_FARE ? cost : MINIMUM_FARE;
	}
	
	/**
	 * @param rides=list of rides with distance and time
	 * @return the total fare of the multiple rides.
	 */
	public double generateTotalFare(List<Ride> rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += generateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}
	
	/**
	 * @param rides=list of rides with distance and time
	 * @return the invoice generated for multiple rides.
	 */
	public Invoice getEnhancedInvoice(List<Ride> rides) {
		double totalFare = generateTotalFare(rides);
		Invoice invoice = new Invoice(rides.size(), totalFare);

		return invoice;

	}


}
