package org.generics;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class Base implements IAutoConstant{

	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	public static WebDriver driver;
	
	public static ExtentReports extentReports;
	
	public static ExtentTest extentTest;
	
	public static Properties prop;
	
	public static FileInputStream fis;
}
