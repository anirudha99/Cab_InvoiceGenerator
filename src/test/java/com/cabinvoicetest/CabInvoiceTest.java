package com.cabinvoicetest;

import org.junit.Assert;
import org.junit.Test;

import com.cabinvoice.CabInvoiceGenerator;

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
}
