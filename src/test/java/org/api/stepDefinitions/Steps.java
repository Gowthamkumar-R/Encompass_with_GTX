package org.api.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps{

	public static String rootPath = System.getProperty("user.dir");
	APIFunction API = new APIFunction();
	public String prettyJson;

	@Given("^I want to connect with RestAssured API$")
	public void IwanttoconnectwithRestAssuredAPI() {
		System.out.println("I want to connect with RestAssured API");
		System.out.println("system get user property" + System.getProperty("user.dir"));
	}

	@And("^Test API Connection$")
	public void TestAPIConnection() {
		System.out.println("Test API Connection");
	}

	@When("^Validate Rest Assured Response$")
	public void ValidateRestAssuredResponse() {
		System.out.println("Validate Rest Assured Response");
	}

	@And("^Close RestAssured connection$")
	public void CloseRestAssuredconnection() {
		System.out.println("Close RestAssured connection");
	}

	@Then("^Connect to JSON file$")
	public void ConnecttoJSONfile() {
		System.out.println("Connect to JSON file");
	}

	@And("^Validate JSON Content$")
	public void ValidaeJSONContent() throws InterruptedException, IOException {
		//System.out.println("Create Quote Extended");
		//API.APIPayload(rootPath + "/payload/CreateRequestBody.json");
	}

	@Given("^Generate API Request Body$")
	public void GenerateAPIRequestBody() throws Exception {
		//System.out.println("Generate API Request Body");
		API.CreateRequestBody();
	}

	@And("^Format API RequestBody JSON$")
	public void Format_APIRequestBody_JSON() throws FileNotFoundException, IOException {
		//System.out.println("Format API RequestBody JSON");
		prettyJson = API.BeautifyJSON(rootPath + "/payload/CreateRequestBody.json");
	}

	@Then("^Write Back formated JSON to specific file$")
	public void Write_Back_formated_JSON_to_specific_file() {
		//System.out.println("Write back the formatted JSON content to the specific file");
		API.WriteJSONStringToFile(rootPath + "/payload/RequestBodyJSONFormat.json", prettyJson);
	}

	@Given("^I want to provide login credentials for token generation API$")
	public void I_want_to_provide_login_credentials_for_token_generation_API() throws Exception {
//		System.out.println("Generating the token");
//		String Token = API.GenerateTokenAuthorization();
//		System.out.println("Token" + Token);
		WriteJSON.writeJSONForCreateQuoteExtended((rootPath + "/Data/CreateQuoteExtended.json"));
		System.out.println("Create Quote Extended");
		API.CreateQuoteExtended(rootPath + "/payload/CreateQuoteExtended.json");
	}

	@And("^verify the token in responce$")
	public void verify_the_token_in_responce() {
		System.out.println("Verify the token in responce");
	}

	@Given("^the settlement statement information is provided$")
	public void the_settlement_statement_information_is_provided() throws InterruptedException, IOException {
		System.out.println("Create Quote Extendedval");
		//System.out.println("Generating the token");
		//String Token = API.GenerateTokenAuthorization();
		//System.out.println("Token" + Token);
		WriteJSON.writeJSONForCreateQuoteExtendedVal((rootPath + "/Data/CreateQuoteExtendedVal.json"));
		API.CreateQuoteExtendedVal(rootPath + "/payload/CreateQuoteExtendedVal.json");
	}

	@When("^then feature file is executed$")
	public void then_feature_file_is_executed() {
		System.out.println("feature file is executed");
	}

	@Then("^verify the settlement statement details are correctly recorded$")
	public void verify_the_settlement_statement_details_are_correctly_recorded() {
		System.out.println("settlement statement details are correctly recorded");
	}

	@Given("^the settlement FIPS information is provided$")
	public void the_settlement_FIPS_information_is_provided() throws InterruptedException, IOException {
		//System.out.println("settlement_FIPS_information_is_provided");
		//System.out.println("Generating the token");
		//String Token = API.GenerateTokenAuthorization();
		//System.out.println("Token" + Token);
		WriteJSON.writeJSONForCreateQuoteFIPS((rootPath + "/Data/CreateQuoteFIPS.json"));
		API.CreateQuoteFIPS(rootPath + "/payload/CreateQuoteFIPS.json");
	}

	@When("^then FIPS feature file is executed$")
	public void then_FIPS_feature_file_is_executed() {
		System.out.println("FIPS feature file is executed");
	}

	@Then("^verify the settlement FIPS details are correctly recorded$")
	public void verify_the_settlement_FIPS_details_are_correctly_recorded() {
		System.out.println("settlement FIPS details are correctly recorded");
	}

	@Given("^the settlement Create Order information is provided$")
	public void the_settlement_Create_Order_information_is_provided() throws InterruptedException, IOException {
		System.out.println("settlement Create Order information is provided");
		API.CreateOrder(rootPath + "/payload/CreateQuoteOrder.json");
	}

	@When("^then Create Order feature file is executed$")
	public void then_Create_Order_feature_file_is_executed() {
		System.out.println("Create Order feature file is executed");
	}

	@Then("^verify the settlement Create Order details are correctly recorded$")
	public void verify_the_settlement_Create_Order_details_are_correctly_recorded() {
		System.out.println("settlement Create Order details are correctly recorded");
	}
}
