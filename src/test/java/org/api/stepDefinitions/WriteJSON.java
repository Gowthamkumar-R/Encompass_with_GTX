package org.api.stepDefinitions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;

public class WriteJSON {
	public static String rootPath = System.getProperty("user.dir");

	@SuppressWarnings({ "unchecked", "static-access" })
	public static void writeJSONForCreateQuoteExtended(String filename) throws JsonProcessingException {
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
		jsonObject.put("transactionId", GUIDGeneration.generateGUID());
		jsonObject.put("fipsCode", "47065");

		String jsonString = jsonObject.toJson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonElement jsonElement = JsonParser.parseString(jsonString);

		String prettyJson = gson.toJson(jsonElement);
		System.out.println("Responce from the write json file"+prettyJson);
		try {
			PrintWriter fileWriter = new PrintWriter(new FileWriter(
					"C:\\Users\\Sunil.SKumbar\\git\\EncompassAPITest\\CucumberEncopassAPI\\payload\\CreateQuoteExtended.json"));
			fileWriter.write(prettyJson);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public static void writeJSONForCreateQuoteExtendedVal(String filename) throws IOException {
		String Date = "12/01/2020";
		OrderedJsonObject jsonObject = new OrderedJsonObject();
		jsonObject.put("settlementStatementVersion", "CD");
		jsonObject.put("lienPosition", 1);
		jsonObject.put("loanAmount", 400000);
		jsonObject.put("loanType", "Purchase");
		jsonObject.put("salesPrice", 320000);
		jsonObject.put("city", "Chattanooga");
		jsonObject.put("county", "Hamilton");
		jsonObject.put("isPrimary", true);
		jsonObject.put("state", "TN");
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
		jsonObject.put("transactionId", GUIDGeneration.generateGUID());
		jsonObject.put("fipsCode", "47065");
		
		String jsonString = jsonObject.toJson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonElement jsonElement = JsonParser.parseString(jsonString);

		String prettyJson = gson.toJson(jsonElement);
		System.out.println("Responce from the write json file"+prettyJson);
		try {
			FileWriter fileWriter = new FileWriter(
					"C:\\Users\\Sunil.SKumbar\\git\\EncompassAPITest\\CucumberEncopassAPI\\payload\\CreateQuoteExtendedVal.json");
			fileWriter.write(prettyJson);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "static-access", "resource" })
	public static void writeJSONForCreateQuoteFIPS(String filename) throws JsonProcessingException {
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
		jsonObject.put("transactionId", GUIDGeneration.generateGUID());
		jsonObject.put("fipsCode", "47065");

		String jsonString = jsonObject.toJson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonElement jsonElement = JsonParser.parseString(jsonString);

		String prettyJson = gson.toJson(jsonElement);
		System.out.println("Responce from the write json file"+prettyJson);
		try {
			FileWriter fileWriter = new FileWriter(
					"C:\\Users\\Sunil.SKumbar\\git\\EncompassAPITest\\CucumberEncopassAPI\\payload\\CreateQuoteFIPS.json");
			fileWriter.write(prettyJson);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}