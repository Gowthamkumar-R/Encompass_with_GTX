package stepdefinition;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Base;
import com.utilities.FWUtils;

import guidGeneration.GUIDGeneration;
import guidGeneration.WriteJSON;
import guidGeneration.WriteJSON;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * This class defines the step definitions for the cucumber feature file. It
 * inherits from the 'Base' class which provides common setup and utility
 * methods.
 */
public class Steps extends Base {

	// Store the current directory path.
	public static String rootPath = System.getProperty("user.dir");

	// Create an instance of the APIFunction class for API interactions.
	APIFunction API = new APIFunction();

	// Store the prettified JSON content.
	public String prettyJson;

	/**
	 * Cucumber step definition to indicate starting the connection with RestAssured
	 * API.
	 */
	@Given("^I want to connect with RestAssured API$")
	public void IwanttoconnectwithRestAssuredAPI() {
		// Start a test in the extent report.
		extentTest = extentReports.startTest("connect with RestAssured API Started");
		System.out.println("I want to connect with RestAssured API");
		System.out.println("system get user property" + System.getProperty("user.dir"));
		extentTest.log(LogStatus.INFO, "connected with RestAssured API");
	}

	/**
	 * Cucumber step definition to test the API connection.
	 */
	@And("^Test API Connection$")
	public void TestAPIConnection() {
		System.out.println("Test API Connection");
		extentTest.log(LogStatus.INFO, "Tested API Connection");
	}

	/**
	 * Cucumber step definition to validate the RestAssured API response.
	 */
	@When("^Validate Rest Assured Response$")
	public void ValidateRestAssuredResponse() {
		System.out.println("Validate Rest Assured Response");
		extentTest.log(LogStatus.INFO, "Validated Rest Assured Response");
	}

	/**
	 * Cucumber step definition to close the RestAssured API connection.
	 */
	@And("^Close RestAssured connection$")
	public void CloseRestAssuredconnection() {
		System.out.println("Close RestAssured connection");
		extentTest.log(LogStatus.INFO, "Closed RestAssured connection");
	}

	/**
	 * Cucumber step definition to connect to a JSON file.
	 */
	@Then("^Connect to JSON file$")
	public void ConnecttoJSONfile() {
		System.out.println("Connect to JSON file");
		extentTest.log(LogStatus.INFO, "Connected to JSON file");
		

	}

	/**
	 * Cucumber step definition to validate the JSON content using the API function.
	 */
	@And("^Validate JSON Content$")
	public void ValidaeJSONContent() throws InterruptedException, IOException {
		System.out.println("Validate JSON Content");
		API.APIPayload(rootPath + "/Data/CreateRequestBody.json");
		extentTest.log(LogStatus.INFO, "Validated JSON Content");
	}

	/**
	 * Cucumber step definition to generate an API request body using the API
	 * function.
	 */
	@Given("^Generate API Request Body$")
	public void GenerateAPIRequestBody() throws Exception {
		System.out.println("Generate API Request Body");
		API.CreateRequestBody();
		extentTest.log(LogStatus.INFO, "Generated API Request Body");
	}

	/**
	 * Cucumber step definition to format the API request body JSON using the API
	 * function.
	 */
	@And("^Format API RequestBody JSON$")
	public void Format_APIRequestBody_JSON() throws FileNotFoundException, IOException {
		System.out.println("Format API RequestBody JSON");
		prettyJson = API.BeautifyJSON(rootPath + "/Data/CreateRequestBody.json");
		extentTest.log(LogStatus.INFO, "Formated API RequestBody JSON");

	}

	/**
	 * Cucumber step definition to write back the formatted JSON to a specific file
	 * using the API function.
	 */
	@Then("^Write Back formated JSON to specific file$")
	public void Write_Back_formated_JSON_to_specific_file() {
		System.out.println("Write back the formatted JSON content to the specific file");
		API.WriteJSONStringToFile(rootPath + "/Data/RequestBodyJSONFormat.json", prettyJson);
		extentTest.log(LogStatus.INFO, "Write back the formatted JSON content to the specific file");
	}

	/**
	 * Cucumber step definition to provide login credentials for token generation
	 * API, generate a token, and use it to create an extended quote using the API
	 * function.
	 */
	@Given("^I want to provide login credentials for token generation API$")
	public void I_want_to_provide_login_credentials_for_token_generation_API() throws Exception {
		System.out.println("Generating the token");
       //FWUtils.readXLPages(driver, "TestData", 0, 1);
		String Token = API.GenerateTokenAuthorization();
		System.out.println("Token" + Token);
		//API.WriteJSONStringToFile(rootPath + "/Data/CreateQuoteExtended.json", GUIDGeneration.generateGUID());
		WriteJSON.writeJSONForCreateQuoteExtended((rootPath + "/Data/CreateQuoteExtended.json"));
		Thread.sleep(1000);
		//APIFunction.BeautifyJSON(rootPath + "/Data/CreateQuoteExtended.json");
		API.CreateQuoteExtended(rootPath + "/Data/CreateQuoteExtended.json");
		//extentTest.log(LogStatus.INFO, "Generated the token");
	}

	/**
	 * Cucumber step definition to verify the token in the response.
	 */
	@And("^verify the token in responce$")
	public void verify_the_token_in_responce() {
		System.out.println("Verify the token in responce");
		extentTest.log(LogStatus.INFO, "Verified the token in responce");
	}

	/**
	 * Cucumber step definition to provide settlement statement information.
	 */
	@Given("^the settlement statement information is provided$")
	public void the_settlement_statement_information_is_provided() throws InterruptedException, IOException {
		System.out.println("settlement statement information is provided");
		WriteJSON.writeJSONForCreateQuoteExtendedVal((rootPath + "/Data/CreateQuoteExtendedVal.json"));
		Thread.sleep(1000);
		//APIFunction.BeautifyJSON(rootPath + "/Data/CreateQuoteExtendedVal.json");
		//API.WriteJSONStringToFile(rootPath + "/Data/CreateQuoteExtendedVal.json", GUIDGeneration.generateGUID());
		API.CreateQuoteExtendedVal(rootPath + "/Data/CreateQuoteExtendedVal.json");
		//extentTest.log(LogStatus.INFO, "settlement statement information is provided");

	}

	/**
	 * Cucumber step definition for execution after providing settlement statement
	 * information.
	 */
	@When("^then feature file is executed$")
	public void then_feature_file_is_executed() {
		System.out.println("feature file is executed");
		//extentTest.log(LogStatus.INFO, "feature file is executed");

	}

	/**
	 * Cucumber step definition to verify the correctness of settlement statement
	 * details.
	 */
	@Then("^verify the settlement statement details are correctly recorded$")
	public void verify_the_settlement_statement_details_are_correctly_recorded() {
		System.out.println("settlement statement details are correctly recorded");
		//extentTest.log(LogStatus.INFO, "settlement statement details are correctly recorded");
	}

	/**
	 * Cucumber step definition to provide settlement FIPS information.
	 */
	@Given("^the settlement FIPS information is provided$")
	public void the_settlement_FIPS_information_is_provided() throws InterruptedException, IOException {
		System.out.println("settlement_FIPS_information_is_provided");
		WriteJSON.writeJSONForCreateQuoteFIPS((rootPath + "/Data/CreateQuoteFIPS.json"));
		//APIFunction.BeautifyJSON(rootPath + "/Data/CreateQuoteFIPS.json");
		//API.WriteJSONStringToFile(rootPath + "/Data/CreateQuoteFIPS.json", GUIDGeneration.generateGUID());
		API.CreateQuoteFIPS(rootPath + "/Data/CreateQuoteFIPS.json");
		//extentTest.log(LogStatus.INFO, "settlement FIPS information is provided");

	}

	/**
	 * Cucumber step definition for execution after providing settlement FIPS
	 * information.
	 */
	@When("^then FIPS feature file is executed$")
	public void then_FIPS_feature_file_is_executed() {
		System.out.println("FIPS feature file is executed");
		//extentTest.log(LogStatus.INFO, "FIPS feature file is executed");

	}

	/**
	 * Cucumber step definition to verify the correctness of settlement FIPS
	 * details.
	 */
	@Then("^verify the settlement FIPS details are correctly recorded$")
	public void verify_the_settlement_FIPS_details_are_correctly_recorded() {
		System.out.println("settlement FIPS details are correctly recorded");
		//extentTest.log(LogStatus.INFO, "settlement FIPS details are correctly recorded");
	}

	/**
	 * Cucumber step definition to provide settlement Create Order information.
	 */
	@Given("^the settlement Create Order information is provided$")
	public void the_settlement_Create_Order_information_is_provided() throws InterruptedException, IOException {
		System.out.println("settlement Create Order information is provided");
		API.CreateOrder(rootPath + "/Data/CreateQuoteOrder.json");
		//extentTest.log(LogStatus.INFO, "Create Order information is provided");

	}

	/**
	 * Cucumber step definition for execution after providing settlement Create
	 * Order information.
	 */
	@When("^then Create Order feature file is executed$")
	public void then_Create_Order_feature_file_is_executed() {
		System.out.println("Create Order feature file is executed");
		//extentTest.log(LogStatus.INFO, "Create Order feature file is executed");
	}

	/**
	 * Cucumber step definition to verify the correctness of settlement Create Order
	 * details.
	 */
	@Then("^verify the settlement Create Order details are correctly recorded$")
	public void verify_the_settlement_Create_Order_details_are_correctly_recorded() {
		System.out.println("settlement Create Order details are correctly recorded");
		//extentTest.log(LogStatus.INFO, "Create Order details are correctly recorded");
	}
	
	
	
/******************************** GTX Validations 
 * @throws IOException 
 * @throws InterruptedException 
 * @throws ParseException ****************************************************************************************************/
	/*  AmeriSavePlaceOrder Validation */
	
	@Given("^POST the API request with informations$")
	public void post_the_api_request_with_informations() throws InterruptedException, IOException, ParseException {
		
		
		
	    //String GTXToken = API.GTXTokenGeneration();
	    API.AmerisaveOrder(rootPath + "/TestData/TestData.xlsx");
		//System.out.println("GTX Token sucessfully extracted from the server  " + GTXToken);
		
	}

	@When("^Response from the server executed$")
	public void response_from_the_server_executed() throws InterruptedException, IOException {
		
		System.out.println("Response from the server");
		
		//API.AmerisaveOrder(rootPath + "/TestData/TestData.xlsx");
		
	    	    
	}

	@Then("^Validate the response$")
	public void validate_the_response() {
		
	    System.out.println("Validate the Response from server");
	    
	}
	/**
	 * @throws InterruptedException 
	 * @throws ParseException *******************************************************************************************************************/
	@Given("^POST the GTXApi request$")
	public void post_the_gtx_api_request() throws IOException, InterruptedException, ParseException {
		
		API.GTXAPI(rootPath + "/Data/GTXApi.json");
	}

	@When("^Response retrieved from the server$")
	public void response_retrieved_from_the_server() {
	   
	}

	@Then("^Validate the Response is sucessful$")
	public void validate_the_response_is_sucessful() {
	    
	}

	/**
	 * @throws IOException ************************************************************************************************************/
	
	@Given("^POST the GTXOrder API request$")
	public void post_the_gtx_order_api_request() throws IOException {
		
	   // API.GTXOrder(rootPath + "/Data/GTXOrder.json");
	    
	    API.GTXOrder(rootPath + "/TestData/TestData.xlsx");
	}

	@When("^Retrieve the response from the server$")
	public void retrieve_the_response_from_the_server() {
	   
	}

	@Then("^Validate the GTX Order response is sucessful$")
	public void validate_the_gtx_order_response_is_sucessful() {
	   
	}

/******************************************AmeriSaveDocumnets
 * @throws InterruptedException 
 * @throws IOException ********************************************************************************/
	

@Given("POST the AmeriSave API")
public void post_the_ameri_save_api() throws IOException, InterruptedException {
    API.AmeriSaveDocument();
    
}

@Given("Retrieve the response from server")
public void retrieve_the_response_from_server() {
    
}

@Then("Validate the AmeriSave Response")
public void validate_the_ameri_save_response() {
   
}
	
/*******************************************************AmeriSaveSendNotes*************************************/

@Given("POST the AmeriSaveSendNotes API")
public void post_the_ameri_save_send_notes_api() throws InterruptedException, IOException {
	API.AmeriSaveSendNotes();
}

@Given("Extract the Response from the server for AmeriSaveAPI")
public void extract_the_response_from_the_server_for_ameri_save_api() {
   
}

@Then("Validate the Response Body of AmeriSaveSendNotes")
public void validate_the_response_body_of_ameri_save_send_notes() {	

    
}

}
