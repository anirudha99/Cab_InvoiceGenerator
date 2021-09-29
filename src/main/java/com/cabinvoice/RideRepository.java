package com.cabinvoice;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {

	List<Ride> rides;

	public RideRepository() {
		this.rides = new ArrayList<Ride>();
	}

	public List<Ride> getRides() {
		return rides;
	}

	public void addRide(Ride ride) {
		rides.add(ride);
	}
}
