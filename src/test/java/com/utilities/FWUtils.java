package com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class FWUtils extends Base {
	
	@SuppressWarnings("resource")
	public static int getRowCount(WebDriver driver, String sheet) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
	       XSSFSheet sheetcount = workbook.getSheet(sheet);
	       int rows = sheetcount.getPhysicalNumberOfRows();
	      // int rowc = sheetcount.getLastRowNum();
	       return rows;
	}

	public static String readXLPages(WebDriver driver, String sheet, int row, int cell) throws InterruptedException
	{
		Thread.sleep(3000);
		String data = "";
		try
		{
			
		        
			Workbook wb = WorkbookFactory.create(new FileInputStream(excelPath));
			data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	        
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static void writeXLPages(WebDriver driver, String sheet, int row, int cell, String value)
			throws InterruptedException
	{
		//Thread.sleep(3000);
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(excelPath));
			Thread.sleep(2000);
			
			wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
			wb.write(new FileOutputStream(excelPath));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
