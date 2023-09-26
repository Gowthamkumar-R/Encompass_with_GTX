package org.api.stepDefinitions;

import org.generics.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GUIDGeneration extends Base {

	public static String generateGUID() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/Sunil.SKumbar/Downloads/chrome-win64/chrome-win64/chrome.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://guidgenerator.com/online-guid-generator.aspx");
		driver.findElement(By.xpath("//input[@name='btnGenerate']")).click();
		String text = driver.findElement(By.xpath("//textarea[@id='txtResults']")).getText();
		System.out.println(text);
		driver.close();
		return text;
	}

}