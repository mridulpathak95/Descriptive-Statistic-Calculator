package com.soen6611.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    double arr[] = { 4, 66, 9, 22, 7, 44, 22 };
    
	/**
	 * This method runs before all test methods only one times
	 */
	@BeforeClass
	public static void beforeAllTesting() {
		System.out.println("Start tests are for Calculator.");
	}
	
	/**
	 * This Method runs before test methods
	 */
	@Before
	public void beforeTest() {
	}
	
	/**
	 * This method runs after all test methods only one time.
	 */
	@AfterClass
	public static void afterPerformingTests() {
		System.out.println("All tests are done for Calculator.");
	}
	
	/**
	 * This method tests max function.
	 */
	@Test
	public void testgetMaximum() {
		
		assertEquals(CalculatorFunctions.getMaximum(arr), 66, 0.01);
	}

    /**
     * This method tests minimum function.
     */
	@Test
	public void testgetMinimum() {
	    
	    assertEquals(CalculatorFunctions.getMinimum(arr), 4, 0.01);
	}
	/**
     * This method tests mode function.
     */
    @Test
    public void testgetMode() {
        
    	String outVal = CalculatorFunctions.getMode(arr);
        assertEquals(Double.parseDouble(outVal), 22.0, 0.01);
    }

    /**
     * This method tests median function.
     */
    @Test
    public void testgetMedian() {
        
        //setup
        double arr1[] = {4,5,6,5,7,8};
        
        //action and assertion
        assertEquals(CalculatorFunctions.getMedian(arr), 22, 0.01); //checking for odd values
        assertEquals(CalculatorFunctions.getMedian(arr1), 5.5, 0.01); //checking for even values
    }
    /**
     * This method tests arithmetic mean function.
     */
    @Test
    public void testgetArithmeticMean() {
        
        assertEquals(CalculatorFunctions.getArithmeticMean(arr), 24.85, 0.01);
    }

    /**
     * This method tests mean absolute deviation function.
     */
    @Test
    public void testgetMeanAbsoluteDeviation() {  
        assertEquals(CalculatorFunctions.getMeanAbsoluteDeviation(arr),17.22,0.01);
    }
    	
    /**
     * This method tests standard deviation function.
     */
    @Test
    public void testgetStandardDeviation() {
        assertEquals(CalculatorFunctions.getStandardDeviation(arr),20.97,0.01); 
    }
}