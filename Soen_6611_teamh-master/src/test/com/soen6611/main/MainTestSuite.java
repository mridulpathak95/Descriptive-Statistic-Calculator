package com.soen6611.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.soen6611.calculator.CalculatorTestSuite;

/**
 *  This is a Test suite Class for All test Classes
 *
 * @author Mehul
 */
@RunWith(Suite.class)
@SuiteClasses({ CalculatorTestSuite.class })

public class MainTestSuite {

}
