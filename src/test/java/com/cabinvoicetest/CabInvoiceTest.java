package com.cabinvoicetest;

import org.junit.Assert;
import org.junit.Test;

import com.cabinvoice.CabInvoiceGenerator;
import com.cabinvoice.Ride;

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
		Ride[] rides = { new Ride(5, 10), new Ride(10, 25) };
		double expectedTotalFare = 185;
		double epsilon = 1e-15;
		Assert.assertEquals(expectedTotalFare, cabInvoiceGenerator.generateTotalFare(rides), epsilon);

	}
}
