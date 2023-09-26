package com.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.cucumber.messages.internal.com.google.common.base.CharMatcher;

public class AmeriSaveOrder_Data extends Base {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public AmeriSaveOrder_Data(String ExcelPathAmer) throws IOException {
		
		 workbook = new XSSFWorkbook(ExcelPathAmer);
		 sheet = workbook.getSheet("AmeriSaveOrder");
		
		
	}
	@SuppressWarnings({ "unchecked", "unused" })
	public String AmerExcel() throws InterruptedException {
		
		int rowcount = sheet.getPhysicalNumberOfRows();
	
		for(int i=1;i<=5;i++)
		{
		
		DataFormatter format = new DataFormatter();
				
		//format.formatCellValue(cell)
		String loanReason = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 0);
		String languagePreference = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 1);
		//Loans:
		String loanIdentifier = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 3);
		String lenderName = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 4);
		String loanNumber = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 5);
		String loanAmount = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 6);
		double loanAmountDouble = Double.parseDouble(loanAmount);
		int loanAmountInt = (int)loanAmountDouble;
		String purchasePrice = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 7);
		double purchasePriceDouble = Double.parseDouble(purchasePrice);
		int purchasePriceInt = (int)purchasePriceDouble;
		String loanType = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 8);
		String lienPosition = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 9);
		double lienPositionDouble = Double.parseDouble(lienPosition);
		int lienPositionInt = (int)lienPositionDouble;

		//String rate = format.formatCellValue(sheet.getRow(1).getCell(10));
		//double rateInt = Integer.parseInt(rate);
		String rate = FWUtils.readXLPages(driver, "AmeriSaveOrder", i, 10);
		double rateDouble = Double.parseDouble(rate);
		int  rateInt = (int)rateDouble;
		String term = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 11);
		double termDouble = Double.parseDouble(term);
		int termInt = (int)termDouble;
		String PriorPolicyDate = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 12);
		//Properties:
		String propertyId = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 14);
		//address:
		String address1Prop = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 16);
		String address2Prop = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 17);
		String cityProp = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 18);
		String stateProp = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 19);
		String fipsProp = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 20);
		String zipCodeProp = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 21);
		double zipCodePropDouble = Double.parseDouble(zipCodeProp);
		int zipCodePropInt = (int)zipCodePropDouble;
		String zipCodePropString = Integer.toString(zipCodePropInt);
		String countyProp = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 22);
		String propertyUsageTypeProp = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 23);
		String propertyTypeProp = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 24);
		//contacts:
		String contactTypeCont = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 26);
		String contactIdCont = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 27);
		String firstNameCont = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 28);
		String lastNameCont = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 29);
		String companyNameCont = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 30);
		String phoneCont = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 31);
		//address:
		String address1 = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 33);
		String address2 = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 34);
		String city = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 35);
		String state = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 36);
		String fips = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 37);
		String zipCode = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 38);
		String county = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 39);
		String email = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 40);
		String contacttype = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 41);
		String contactId = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 42);
		String firstName = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 43);
		String middleName = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 44);
		String lastName = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 45);
		//Object suffix = format.formatCellValue(sheet.getRow(1).getCell(46));

		String result = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 46);
		String suffix = CharMatcher.is('\"').trimFrom(result);

		String ssn = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 47);
		String companyname = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 48);
		//address:
		String address1IND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 50);
		String address2IND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 51);
		String cityIND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 52);
		String stateIND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 53);
		String fipsIND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 54);
		String zipCodeIND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 55);
		String countyIND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 56);
		String phoneIND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 57);
		String emailIND = FWUtils.readXLPages(driver,"AmeriSaveOrder", i, 58);
/*********************************************************************************************************/
		JSONObject mainBody = new JSONObject();
        mainBody.put("loanReason", loanReason);
		mainBody.put("languagePreference", languagePreference);

		JSONObject loansBody = new JSONObject();
		loansBody.put("loanIdentifier",loanIdentifier);
		loansBody.put("lenderName",lenderName);
		loansBody.put("loanNumber",loanNumber);
		loansBody.put("loanAmount",loanAmount);
		loansBody.put("purchasePrice",0);
		loansBody.put("loanType",loanType);
		loansBody.put("lienPosition",1);
		loansBody.put("rate",5.625);
		loansBody.put("term",360);
		loansBody.put("PriorPolicyDate",PriorPolicyDate);

		JSONArray loansArray = new JSONArray();
        loansArray.add(loansBody);
        
        
/*********************************************************************************************************/
		JSONObject propertiesbody = new JSONObject();
		propertiesbody.put("propertyId",0);
		propertiesbody.put("propertyUsageType", propertyUsageTypeProp);
		propertiesbody.put("propertyType", propertyTypeProp);
		
		JSONObject addressprop = new JSONObject();
		addressprop.put("address1", address1Prop);
		addressprop.put("address2", address2Prop);
		addressprop.put("city", cityProp);
		addressprop.put("state", stateProp);
		addressprop.put("fips", fipsProp);
		addressprop.put("zipcode", zipCodeProp);
		addressprop.put("county", countyProp);
		
		propertiesbody.put("address", addressprop);
		
		JSONArray propertiesArray = new JSONArray();
		propertiesArray.add(propertiesbody);
/*********************************************************************************************************/
		JSONObject contactsbody = new JSONObject();
		contactsbody.put("contactType", contactTypeCont);
		contactsbody.put("contactId", contactIdCont);
		contactsbody.put("firstName", firstNameCont);
		contactsbody.put("lastName", lastNameCont);
		contactsbody.put("companyName", companyNameCont);
		contactsbody.put("phone", phoneCont);
		contactsbody.put("email", email);
		
		JSONObject addresscon = new JSONObject();
		addresscon.put("address1", address1);
		addresscon.put("address2", address2);
		addresscon.put("city", city);
		addresscon.put("state", state);
		addresscon.put("fips", fips);
		addresscon.put("zipcode", zipCode);
		addresscon.put("county", county);
		
        contactsbody.put("address", addresscon);		
		
		
/*********************************************************************************************************/		
		JSONObject lastbody = new JSONObject();
		lastbody.put("contacttype", contacttype);
		lastbody.put("contactId", contactId);
		lastbody.put("firstName", firstName);
		lastbody.put("middleName", middleName);
		lastbody.put("lastName", lastName);
		lastbody.put("suffix",null);
		lastbody.put("ssn", ssn);
		lastbody.put("companyname", companyname);
		lastbody.put("phone", phoneIND);
		lastbody.put("email", emailIND);
		
		JSONObject addresslastbody = new JSONObject();
		addresslastbody.put("address1", address1IND);
		addresslastbody.put("address2", address2IND);
		addresslastbody.put("city", cityIND);
		addresslastbody.put("state", stateIND);
		addresslastbody.put("fips", fipsIND);
		addresslastbody.put("zipcode", zipCodeIND);
		addresslastbody.put("county", countyIND);
		
		lastbody.put("address", addresslastbody);

/*********************************************************************************************************/	
		
		JSONArray contactsArray = new JSONArray();
		contactsArray.add(contactsbody);
		contactsArray.add(lastbody);
		
/*********************************************************************************************************/	
		
		mainBody.put("loans", loansArray);
		mainBody.put("properties", propertiesArray);
		mainBody.put("contacts", contactsArray);
		
		String jsonString = mainBody.toJSONString();
		
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement jsonElement = JsonParser.parseString(jsonString);
        
        String prettyJson = gson.toJson(jsonElement);
        
        System.out.println(prettyJson);
        
        try
		{
			PrintWriter fileWriter = new PrintWriter(new FileWriter("C://Users//Gowthamkumar.R//eclipse-workspace//Cucumberwithapi//Output_RequestBody//AmeriSaveOrder.json"));
			fileWriter.write(prettyJson);
			fileWriter.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return jsonString;

	}
		return null;
}
}
