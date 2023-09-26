package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * This class serves as the base class for setting up common configurations and
 * objects used across the test framework.
 */
public class Base implements IAuto {

	public static WebDriver driver;

	// Static block for setting up system properties for WebDriver
	static {
		
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	// Extent Reports for generating test reports
	public static ExtentReports extentReports;
	
	// Extent Test instance for logging
	public static ExtentTest extentTest;
	
	// Properties object for reading configuration data
	public static Properties prop;
	
	// FileInputStream for reading configuration files
	public static FileInputStream fis;

}
