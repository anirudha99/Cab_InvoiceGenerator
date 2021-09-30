package com.cabinvoice;

import java.util.List;

public class CabInvoiceGenerator {

	private final int NORMAL_MINIMUM_FARE = 5;
	private final int PREMIUM_MINIMUM_FARE = 20;
	private final int CHARGE_PER_MINUTE_NORMAL = 1;
	private final int CHARGE_PER_MINUTE_PREMIUM = 2;
	private final int CHARGE_PER_KM_PREMIUM = 15;
	private final int CHARGE_PER_KM_NORMAL = 10;


	/**
	 * * @param type = Type of ride customer chose i.e premium or normal
	 * @param distance = total distance of journey in km
	 * @param time = total time taken in journey in minutes
	 * @return the fare of the ride
	 */
	public double generateFare(String type, double distance, double time) {
		double cost;
		if (type.equalsIgnoreCase("premium")) {
			cost = (distance * CHARGE_PER_KM_PREMIUM) + (CHARGE_PER_MINUTE_PREMIUM * time);
			return cost > PREMIUM_MINIMUM_FARE ? cost : PREMIUM_MINIMUM_FARE;
		} else {
			cost = (distance * CHARGE_PER_KM_NORMAL) + (CHARGE_PER_MINUTE_NORMAL * time);
			return cost > NORMAL_MINIMUM_FARE ? cost : NORMAL_MINIMUM_FARE;
		}
	}


		/**
		 * @param rides=list of rides with distance and time
		 * @return the total fare of the multiple rides.
		 */
		public double generateTotalFare(List<Ride> rides) {
			double totalFare = 0;
			for (Ride ride : rides) {
				totalFare += generateFare(ride.getRideType(), ride.getDistance(), ride.getTime());
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
