package stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.utilities.FWUtils;

import io.cucumber.messages.internal.com.google.common.base.CharMatcher;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Excel extends FWUtils {
	
	// Store the current directory path.
		public static String rootPath = System.getProperty("user.dir");

		// Initialize properties and configuration file variables.
		static Properties prop = new Properties();
		static File Propfile = new File(
				"C:\\Users\\Sunil.SKumbar\\eclipse-workspace\\Cucumberwithapi\\Config.prop\\config.properties");

		@SuppressWarnings("unchecked")
		public static String GTXTokenGeneration() throws IOException {

			JSONObject body = new JSONObject();

			FileInputStream propfile = new FileInputStream(Propfile);
			prop.load(propfile);

			body.put("userName", prop.getProperty("GTX.api.username"));
			body.put("password", prop.getProperty("GTX.api.password"));
			body.put("titleCompanyID", prop.getProperty("GTX.api.titleCompanyID"));

			Response res = given().baseUri(prop.getProperty("GTX.baseURI")).header("Content-Type", "application/json")
					.contentType(ContentType.JSON).body(body.toJSONString()).when().post("/GtxToken").then().extract()
					.response();

			String resbody = res.asString();

			System.out.println("Token is " + resbody);

			return resbody;

		}

	@SuppressWarnings("unchecked")
	public static String data() throws IOException, InterruptedException  {	

		int rowCountTotal = FWUtils.getRowCount(driver, "APICreatePlaceOrder");

		System.out.println("Row count from the Excel is " + rowCountTotal);

		for (int i = 1; i <= rowCountTotal; i++) {
			
			// format.formatCellValue(cell)
			
			try {
				
				Object	loanIdentifier = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 0);
			
			String loanNumber = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 1);
			String previousLoanNumber = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 2);

			String clientIDString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 3);
			double clientIDDouble = Double.parseDouble(clientIDString);
			int clientID = (int) clientIDDouble;

			String titleCompanyIDString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 4);
			double titleCompanyIDDouble = Double.parseDouble(titleCompanyIDString);
			int titleCompanyID = (int) titleCompanyIDDouble;

			// attributes:
			String key = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 6);
			String value = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 7);
			// subjectPropertyAddress:
			String streetAddress1 = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 9);

			String streetAddress2 = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 10);
			String city = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 11);
			String county = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 12);

			String fipScodeString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 13);
			double fipScodeDouble = Double.parseDouble(fipScodeString);
			int fipScode = (int) fipScodeDouble;

			String state = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 14);

			String unitString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 15);
			double unitDouble = Double.parseDouble(unitString);
			int unit = (int) unitDouble;

			String zipCode = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 16);
			// borrowerSellers:
			String actionType = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 18);
			String borrowerSellerID = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 19);
			String borrowerSellerEntityType = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 20);
			String borrowerSellerType = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 21);
			String entityTypeName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 22);
			String entityTypeTaxID = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 23);
			String firstName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 24);
			String middleName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 25);
			String lastName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 26);
			String maritalStatus = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 27);
			String spouse = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 28);
			String ssn = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 29);
			String email = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 30);
			String phone = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 31);
			String address_StreetAddress1 = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 32);
			String address_StreetAddress2 = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 33);
			String address_City = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 34);
			String address_County = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 35);
			String address_State = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 36);

			String address_UnitString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 37);
			double address_UnitDouble = Double.parseDouble(address_UnitString);
			int address_Unit = (int) address_UnitDouble;

			String address_ZipCode = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 38);
			// lenders:
			String actionTypelenders = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 40);
			String lenderID = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 41);
			String lendingName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 42);
			String lendingCompanyName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 43);
			String contactFirstName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 44);
			String contactLastName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 45);
			String contactPhone = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 46);
			String contactEmail = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 47);
			// String contactEmail = CharMatcher.is('\"').trimFrom(result);
			String lenderCity = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 48);
			String lenderCounty = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 49);
			String lenderState = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 50);
			String lenderStreetAddress = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 51);

			String lenderUnitString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 52);
			double lenderUnitDouble = Double.parseDouble(lenderUnitString);
			int lenderUnit = (int) lenderUnitDouble;

			String lenderZipCode = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 53);
			// lenderUsers:
			String lenderGuid = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 55);
			String userType = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 56);
			String firstNamelend = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 57);
			String lastNamelend = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 58);
			String emaillend = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 59);
			String phonelend = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 60);
			// titleOrder:
			String amortizationType = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 62);
			String propertyType = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 63);
			String lienPosition = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 64);

			String loanAmountString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 65);
			double loanAmountDouble = Double.parseDouble(loanAmountString);
			int loanAmount = (int) loanAmountDouble;

			String loanPurpose = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 66);
			String loanType = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 67);

			String originalLoanAmountString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 68);
			double originalLoanAmountDouble = Double.parseDouble(originalLoanAmountString);
			int originalLoanAmount = (int) originalLoanAmountDouble;

			String priorPolicyDate = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 69);
			String secondMortgageType = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 70);
			String propertyUse = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 71);

			String salePriceString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 72);
			double salePriceDouble = Double.parseDouble(salePriceString);
			int salePrice = (int) salePriceDouble;

			String unpaidBalanceString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 73);
			double unpaidBalanceDouble = Double.parseDouble(unpaidBalanceString);
			int unpaidBalance = (int) unpaidBalanceDouble;

			// noteCocs
			String id = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 75);
			String noteSubject = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 76);
			String noteBody = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 77);
			// documents

			String documentTypeIDString = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 79);
			double documentTypeIDDouble = Double.parseDouble(documentTypeIDString);
			int documentTypeID = (int) documentTypeIDDouble;

			String documentDescription = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 80);
			String documentFileName = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 81);
			String documentBytes = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 82);
			String documentAZPath = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 83);

			JSONObject mainBody = new JSONObject();
			mainBody.put("loanIdentifier", loanIdentifier);
			mainBody.put("loanNumber", loanNumber);
			mainBody.put("previousLoanNumber", previousLoanNumber);
			mainBody.put("clientID", clientID);
			mainBody.put("titleCompanyID", titleCompanyID);

			JSONObject attributes = new JSONObject();
			attributes.put("key", key);
			attributes.put("value", value);

			JSONObject subjectPropertyAddress = new JSONObject();
			subjectPropertyAddress.put("streetAddress1", streetAddress1);
			subjectPropertyAddress.put("streetAddress2", streetAddress2);
			subjectPropertyAddress.put("city", city);
			subjectPropertyAddress.put("county", county);
			subjectPropertyAddress.put("fipScode", fipScode);
			subjectPropertyAddress.put("state", state);
			subjectPropertyAddress.put("unit", unit);
			subjectPropertyAddress.put("zipCode", zipCode);

			JSONObject borrowerSellers = new JSONObject();
			borrowerSellers.put("actionType", actionType);
			borrowerSellers.put("borrowerSellerID", borrowerSellerID);
			borrowerSellers.put("borrowerSellerEntityType", borrowerSellerEntityType);
			borrowerSellers.put("borrowerSellerType", borrowerSellerType);
			borrowerSellers.put("entityTypeName", entityTypeName);
			borrowerSellers.put("entityTypeTaxID", entityTypeTaxID);
			borrowerSellers.put("firstName", firstName);
			borrowerSellers.put("middleName", middleName);
			borrowerSellers.put("lastName", lastName);
			borrowerSellers.put("maritalStatus", maritalStatus);
			borrowerSellers.put("spouse", spouse);
			borrowerSellers.put("ssn", ssn);
			borrowerSellers.put("email", email);
			borrowerSellers.put("phone", phone);
			borrowerSellers.put("address_StreetAddress1", address_StreetAddress1);
			borrowerSellers.put("address_StreetAddress2", address_StreetAddress2);
			borrowerSellers.put("address_City", address_City);
			borrowerSellers.put("address_County", address_County);
			borrowerSellers.put("address_State", address_State);
			borrowerSellers.put("address_Unit", address_Unit);
			borrowerSellers.put("address_ZipCode", address_ZipCode);

			JSONArray borrowerSellersArray = new JSONArray();
			borrowerSellersArray.add(borrowerSellers);

			JSONObject lendersbody = new JSONObject();
			lendersbody.put("actionType", actionTypelenders);
			lendersbody.put("lenderID", lenderID);
			lendersbody.put("lendingName", lendingName);
			lendersbody.put("lendingCompanyName", lendingCompanyName);
			lendersbody.put("contactFirstName", contactFirstName);
			lendersbody.put("contactLastName", contactLastName);
			lendersbody.put("contactPhone", contactPhone);
			lendersbody.put("contactEmail", contactEmail);
			lendersbody.put("lenderCity", lenderCity);
			lendersbody.put("lenderCounty", lenderCounty);
			lendersbody.put("lenderState", lenderState);
			lendersbody.put("lenderStreetAddress", lenderStreetAddress);
			lendersbody.put("lenderUnit", lenderUnit);
			lendersbody.put("lenderZipCode", lenderZipCode);

			JSONObject lenderUsers = new JSONObject();
			lenderUsers.put("lenderGuid", lenderGuid);
			lenderUsers.put("userType", userType);
			lenderUsers.put("firstName", firstNamelend);
			lenderUsers.put("lastName", lastNamelend);
			lenderUsers.put("email", emaillend);
			lenderUsers.put("phone", phonelend);

			JSONArray lenderUsersArray = new JSONArray();
			lenderUsersArray.add(lenderUsers);

			lendersbody.put("lenderUsers", lenderUsersArray);

			JSONArray lendersArray = new JSONArray();
			lendersArray.add(lendersbody);

			JSONObject titleOrder = new JSONObject();
			titleOrder.put("amortizationType", amortizationType);
			titleOrder.put("propertyType", propertyType);
			titleOrder.put("lienPosition", lienPosition);

			titleOrder.put("loanAmount", loanAmount);
			titleOrder.put("loanPurpose", loanPurpose);
			titleOrder.put("loanType", loanType);
			titleOrder.put("originalLoanAmount", originalLoanAmount);
			titleOrder.put("priorPolicyDate", priorPolicyDate);
			titleOrder.put("secondMortgageType", secondMortgageType);
			titleOrder.put("propertyUse", propertyUse);
			titleOrder.put("salePrice", salePrice);
			titleOrder.put("unpaidBalance", unpaidBalance);

			JSONObject notesDocsbody = new JSONObject();
			notesDocsbody.put("id", id);
			notesDocsbody.put("noteSubject", noteSubject);
			notesDocsbody.put("noteBody", noteBody);

			JSONObject documents = new JSONObject();
			documents.put("documentTypeID", documentTypeID);
			documents.put("documentDescription", documentDescription);
			documents.put("documentFileName", documentFileName);
			documents.put("documentBytes", documentBytes);
			documents.put("documentAZPath", documentAZPath);

			JSONArray documentsArray = new JSONArray();
			documentsArray.add(documents);

			notesDocsbody.put("documents", documentsArray);
			titleOrder.put("notesDocs", notesDocsbody);

			mainBody.put("attributes", attributes);
			mainBody.put("subjectPropertyAddress", subjectPropertyAddress);
			mainBody.put("borrowerSellers", borrowerSellersArray);
			mainBody.put("lenders", lendersArray);
			mainBody.put("titleOrder", titleOrder);

			String jsonString = mainBody.toJSONString();

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			JsonElement jsonElement = JsonParser.parseString(jsonString);

			String prettyJson = gson.toJson(jsonElement);

			System.out.println(prettyJson);

			Response res = (Response) given()
					.header("Authorization", "Bearer " + GTXTokenGeneration())
					.header("Content-Type", "application/json").body(prettyJson).when().post("https://qagtx.greenlight-connect.com/GtxAPI/CreatePlaceOrder").then()
					.extract().response();

			String ResponseFile = res.body().asPrettyString();
			
			System.out.println("Response from the API is " + ResponseFile);
			
			//Actual Status Code
			int Actual = res.getStatusCode(); //200 from server
			String ActualStatusCode = String.valueOf(Actual);
			FWUtils.writeXLPages(driver, "APICreatePlaceOrder", i, 86, ActualStatusCode);
			System.out.println("Actul Status code form the server " + Actual);
			
			//Expected Status code
			String expect = FWUtils.readXLPages(driver, "APICreatePlaceOrder", i, 84);
			double expectstring = Double.parseDouble(expect);
			int ExpectedStatusCode = (int) expectstring;
            System.out.println("Expected status code in excel is " + ExpectedStatusCode);
           /* try {
            	given().baseUri(prop.getProperty("GTX.api.GTXOrder")).header("Authorization", "Bearer " + GTXTokenGeneration())
				.header("Content-Type", "application/json").body(resbody).when().post("/PlaceOrderToReware").then()
				.statusCode(200).log().all();

            }
			*/
			
			int TestStatus = 85;	
			
			if (Actual == ExpectedStatusCode) {
				
				//FWUtils.writeXLPages(driver, "APICreatePlaceOrder", i, Scenario, "Case" + i);
				FWUtils.writeXLPages(driver, "APICreatePlaceOrder", i, TestStatus, "PASS");

				System.out.println("Scenario : Case " + i);
				System.out.println("Test Status : " + "PASS");
				
			}
			
            else {

				//FWUtils.writeXLPages(driver, "APICreatePlaceOrder", i, Scenario, "Case" + i);
				FWUtils.writeXLPages(driver, "APICreatePlaceOrder", i, TestStatus, "FAIL");

				System.out.println("Scenario : Case " + i);
				System.out.println("Test Status : " + "FAIL");
				}
			
			} 
			
			
			catch (Exception e) {
				// TODO Auto-generated catch block
				String Error = e.getMessage();
				FWUtils.writeXLPages(driver, "APICreatePlaceOrder", i, 87, Error);
			}
			
		} 	
		
		return rootPath;
		
		
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub

		data();
		
		
	}

}
