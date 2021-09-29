package com.cabinvoicetest;

import org.junit.Assert;
import org.junit.Test;

import com.cabinvoice.CabInvoiceGenerator;
import com.cabinvoice.Invoice;
import com.cabinvoice.Ride;
import com.cabinvoice.RideRepository;
import java.util.stream.Collectors;

public class CabInvoiceTest {

	@Test
	public void givenJourney_withCorrectExpectedFare_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Assert.assertEquals(66.2, cabInvoiceGenerator.generateFare(5.3, 13.20), 0.001);
	}

	@Test
	public void givenJourney_withMiniMumFare_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Assert.assertEquals(5, cabInvoiceGenerator.generateFare(0.2, 2.5), 0.001);

	}

	@Test
	public void givenMultipleRide_matchingWithExpectedFare_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new Ride(1, 5, 10));
		rideRepository.addRide(new Ride(1, 10, 25));

		double expectedTotalFare = 185;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFare, cabInvoiceGenerator.generateTotalFare(rideRepository.getRides()),
				epsilon);

	}

	@Test
	public void givenMultipleRide_matchingWithTotalNumberOfRide_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new Ride(1, 5, 10));
		rideRepository.addRide(new Ride(1, 10, 25));
		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());

		int expectedTotalRides = 2;
		Assert.assertEquals(expectedTotalRides, invoice.getTotalRides());

	}

	@Test
	public void givenMultipleRide_matchingWithTotalFare_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new Ride(1, 5, 10));
		rideRepository.addRide(new Ride(1, 10, 25));
		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());

		double expectedTotalFare = 185;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFare, invoice.getTotalFare(), epsilon);

	}

	@Test
	public void givenMultipleRide_matchingWithAverageFare_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(new Ride(1, 5, 10));
		rideRepository.addRide(new Ride(1, 10, 25));
		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(rideRepository.getRides());

		double expectedTotalFare = 92.5;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFare, invoice.getAvgfare(), epsilon);

	}

	@Test
	public void givenMultipleRideOfDifferentCustomer_matchingWithNUmberOfRidesOfCustomer1_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 5, 10));
		rideRepository.addRide(new Ride(2, 10, 25));
		rideRepository.addRide(new Ride(1, 12, 30));

		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserId() == 1).collect(Collectors.toList()));

		int expectedTotalRideofUser1 = 2;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalRideofUser1, invoice.getTotalRides(), epsilon);

	}

	@Test
	public void givenMultipleRideOfDifferentCustomer_matchingWithTotalFareOfCustomer1_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 5, 10));
		rideRepository.addRide(new Ride(2, 10, 25));
		rideRepository.addRide(new Ride(1, 12, 30));

		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserId() == 1).collect(Collectors.toList()));

		double expectedTotalFareofUser1 = 210;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFareofUser1, invoice.getTotalFare(), epsilon);

	}

	@Test
	public void givenMultipleRideOfDifferentCustomer_matchingWithAverageFareOfCustomer1_returnsTrue() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 5, 10));
		rideRepository.addRide(new Ride(2, 10, 25));
		rideRepository.addRide(new Ride(1, 12, 30));

		Invoice invoice = cabInvoiceGenerator.getEnhancedInvoice(
				rideRepository.getRides().stream().filter(ride -> ride.getUserId() == 1).collect(Collectors.toList()));

		double expectedTotalFareofUser1 = 105;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFareofUser1, invoice.getAvgfare(), epsilon);

	}
}
