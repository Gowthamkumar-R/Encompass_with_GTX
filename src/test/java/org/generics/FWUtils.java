package org.generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class FWUtils implements IAutoConstant {

	public static void verifyPage(WebDriver driver, String expected) throws InterruptedException {
		String actual = driver.getTitle();
		Thread.sleep(2000);
		Assert.assertEquals(actual, expected);
	}

	public static String readXLPages(WebDriver driver, String sheet, int row, int cell) {
		String data = "";
		try {
			Thread.sleep(2000);
			Workbook wb = WorkbookFactory.create(new FileInputStream(excelPath));
			data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void writeXLPages(WebDriver driver, String sheet, int row, int cell, String value) {
		try {
			Thread.sleep(2000);
			Workbook wb = WorkbookFactory.create(new FileInputStream(excelPath));
			wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
			wb.write(new FileOutputStream(excelPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String takesScreenShot(WebDriver driver, String screenShotName)
			throws InterruptedException, IOException {
		Thread.sleep(2000);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File sourceScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenShot = System.getProperty("user.dir") + "\\Screenshots\\" + screenShotName + dateName
				+ ".png";
		FileUtils.copyFile(sourceScreenShot, new File(destinationScreenShot));
		return destinationScreenShot;
	}

	public static byte[] getScreenShotByte(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		final byte[] sourceScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return sourceScreenShot;
	}

	public static void givenPDF(String pathOfPDF, String expected) throws IOException {
		FileInputStream fis = new FileInputStream(pathOfPDF);
		PdfReader reader = new PdfReader(fis);
		int pages = reader.getNumberOfPages();
		StringBuffer text = new StringBuffer();
		for (int i = 1; i <= pages; i++) {
			text.append(PdfTextExtractor.getTextFromPage(reader, i));
		}
		reader.close();
		String fullText = text.toString();
		System.out.println(fullText);
		fullText.contains(expected);
	}
	
	public static void givenPDF(WebDriver driver, String pathOfPDF) throws IOException {
		FileInputStream fis = new FileInputStream(pathOfPDF);
		PdfReader reader = new PdfReader(fis);
		int pages = reader.getNumberOfPages();
		StringBuffer text = new StringBuffer();
		for (int i = 1; i <= pages; i++) {
			text.append(PdfTextExtractor.getTextFromPage(reader, i));
		}
		reader.close();
		String fullText = text.toString();
		fullText.contains(FWUtils.readXLPages(driver,"statement",0,0));
	}
	
	public static void scrollUptoParticularElement(WebDriver driver,WebElement element) throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")");
	}
	
	public static void downloadPDF() throws InterruptedException, AWTException
	{
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}
	
}
