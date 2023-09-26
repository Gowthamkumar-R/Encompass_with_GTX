package guidGeneration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import stepdefinition.APIFunction;

public class WriteJSON {
	public static String rootPath = System.getProperty("user.dir");
	@SuppressWarnings({ "unchecked", "static-access" })
	public static void writeJSONForCreateQuoteExtended(String filename) throws JsonProcessingException
	{
		String GUID = GUIDGeneration.generateGUID();
		System.out.println("GUID"+GUID);
		String Date = "12/01/2020";
		OrderedJsonObject jsonObject = new OrderedJsonObject();
		  jsonObject.put("settlementStatementVersion", "CD");
	        jsonObject.put("lienPosition", 1);
	        jsonObject.put("loanAmount", 400000);
	        jsonObject.put("loanType", "Purchase");
	        jsonObject.put("salesPrice", 320000);
	        jsonObject.put("city", "Chattanooga");
	        jsonObject.put("isPrimary", true);
	        jsonObject.put("streetName", "123 Test Street");
	        jsonObject.put("streetNumber", "123 Test Street");
	        jsonObject.put("zip", "37412");
	        jsonObject.put("partnerID", 503);
	        jsonObject.put("partnerTypeID", 1);
	        jsonObject.put("productTypeID", 17);
	        jsonObject.put("transactionTypeID", 8);
	        jsonObject.put("titleCompanyID", 1);
	        jsonObject.put("netTangibleBenefitDateLoanClosed", Date); 
	        jsonObject.put("propertyRefinanceOriginalCostAmount", 300000);
	        jsonObject.put("toBePaidOffAmount", 10);
	        jsonObject.put("transactionId",GUID);
	        jsonObject.put("fipsCode", "47065");
	   
	       String jsonString = jsonObject.toJson();
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();

	        JsonElement jsonElement = JsonParser.parseString(jsonString);
            
	        String prettyJson = gson.toJson(jsonElement);

	       
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileWriter("C://Users//Gowthamkumar.R//eclipse-workspace//Cucumberwithapi//Data//CreateQuoteExtended.json"));
			fileWriter.write(prettyJson);
			fileWriter.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public static void writeJSONForCreateQuoteExtendedVal(String filename) throws IOException
	{
		String GUID = GUIDGeneration.generateGUID();
		System.out.println("GUID"+GUID);
		String Date = "12/01/2020";
		OrderedJsonObject jsonObject = new OrderedJsonObject();
		//JSONObject jsonObject = new JSONObject();
		jsonObject.put("settlementStatementVersion", "CD");
        jsonObject.put("lienPosition", 1);
        jsonObject.put("loanAmount", 400000);
        jsonObject.put("loanType", "Purchase");
        jsonObject.put("salesPrice", 320000);
        jsonObject.put("city", "Chattanooga");
        jsonObject.put("county", "Hamilton");
        jsonObject.put("isPrimary", true);
        jsonObject.put("state","TN");
        jsonObject.put("streetName", "123 Test Street");
        jsonObject.put("streetNumber", "123 Test Street");
        jsonObject.put("zip", "37412");
        jsonObject.put("name", "sudeshana");
        jsonObject.put("partnerID", 503);
        jsonObject.put("partnerTypeID", 1);
        jsonObject.put("productTypeID", 17);
        jsonObject.put("transactionTypeID", 8);
        jsonObject.put("titleCompanyID", 1);
        jsonObject.put("netTangibleBenefitDateLoanClosed", Date); 
        jsonObject.put("propertyRefinanceOriginalCostAmount", 300000);
        jsonObject.put("toBePaidOffAmount", 10);
        jsonObject.put("transactionId",GUID);
        jsonObject.put("fipsCode", "47065");
      
    	//Files.write(Paths.get(filename), jsonObject.toJSONString().getBytes());
       // APIFunction.WriteJSONStringToFile(rootPath + "/Data/CreateQuoteExtendedVal.json","");//APIFunction.BeautifyJSON(rootPath + "/Data/CreateQuoteExtendedVal.json"));
        String jsonString = jsonObject.toJson();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

       JsonElement jsonElement = JsonParser.parseString(jsonString);
      
      String prettyJson = gson.toJson(jsonElement);

	try
	{
		FileWriter fileWriter = new FileWriter("C://Users//Gowthamkumar.R//eclipse-workspace//Cucumberwithapi//Data//CreateQuoteExtendedVal.json");
		fileWriter.write(prettyJson);
		fileWriter.flush();
	}
	catch(Exception e)	{
		e.printStackTrace();
	}
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public static void writeJSONForCreateQuoteFIPS(String filename) throws JsonProcessingException
	{
		String GUID = GUIDGeneration.generateGUID();
		System.out.println("GUID"+GUID);
		String Date = "12/01/2020";
		OrderedJsonObject jsonObject = new OrderedJsonObject();
		jsonObject.put("settlementStatementVersion", "CD");
		jsonObject.put("lienPosition", 1);
		jsonObject.put("loanAmount", 400000);
		jsonObject.put("loanType", "Purchase");
		jsonObject.put("salesPrice", 320000);
        jsonObject.put("city", "Chattanooga");
        jsonObject.put("isPrimary", true);
        jsonObject.put("streetName", "123 Test Street");
        jsonObject.put("streetNumber", "123");
        jsonObject.put("zip", "37412");
        jsonObject.put("partnerID", 503);
        jsonObject.put("partnerTypeID", 1);
        jsonObject.put("productTypeID", 17);
        jsonObject.put("transactionTypeID", 8);
        jsonObject.put("titleCompanyID", 1);
        jsonObject.put("netTangibleBenefitDateLoanClosed", Date);
        jsonObject.put("propertyRefinanceOriginalCostAmount", 300000);
        jsonObject.put("toBePaidOffAmount", 10);
        jsonObject.put("transactionId",GUID);
        jsonObject.put("fipsCode", "47065");
        
        String jsonString = jsonObject.toJson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement jsonElement = JsonParser.parseString(jsonString);
        
        String prettyJson = gson.toJson(jsonElement);
		try
		{
			FileWriter fileWriter = new FileWriter("C://Users//Gowthamkumar.R//eclipse-workspace//Cucumberwithapi//Data//CreateQuoteFIPS.json");
			fileWriter.write(prettyJson);
			fileWriter.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
