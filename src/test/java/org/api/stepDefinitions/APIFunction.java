package org.api.stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static org.hamcrest.Matchers.equalTo;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class APIFunction {

	public static String rootPath = System.getProperty("user.dir");
	static Properties prop = new Properties();
	static File Propfile = new File("C:\\Users\\Sunil.SKumbar\\Downloads\\EncompassAPI\\EncompassAPI\\Config.properties\\config.properties");
			
	public String APIPayload(String FileNamePath) throws InterruptedException, IOException {

		String responseBody = null;
		FileInputStream propfile = new FileInputStream(Propfile);
		prop.load(propfile);

		// String FileNamePath = rootPath + "/Data/CreateRequestBody.json";
		try {
//			test = extent.createTest("ExecuteAPI - Payload");

			File file = new File(FileNamePath);
			System.out.println("Read Request payload from  json file  - Success");

			Response res = given().baseUri(prop.getProperty("api.baseUri"))
					.header("Authorization", "Bearer  " + GenerateTokenAuthorization()).body(file).

					 when().post("​/CreateQuoteExtended").

					then().statusCode(200).assertThat().statusCode(200).extract().response();
			System.out.println("Token" + res.body().prettyPrint());
			responseBody = res.body().prettyPrint(); // res.asString()

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Assertion Error:  ----- check the API status code in response " + e.getMessage());
		}
		return responseBody;
	}

	@SuppressWarnings("unchecked")
	public String GenerateTokenAuthorization() throws InterruptedException, IOException {

		JSONObject body = new JSONObject();
		FileInputStream propfile = new FileInputStream(Propfile);
		prop.load(propfile);
		body.put("userName", prop.getProperty("api.username"));
		body.put("password", prop.getProperty("api.password"));
		body.put("titleCompanyID", prop.getProperty("api.titleCompanyID"));

		String response = given().baseUri(prop.getProperty("baseURI")).contentType(ContentType.JSON)
				.body(body.toString()).when().post("/Token").then().statusCode(200).body("userName", equalTo("user3"))
				.extract().path("accessToken");

		System.out.println("accessToken from response:::::::: " + response);
		return response;
	}

	public void CreateQuoteExtended(String fileName) throws InterruptedException, IOException {
		File file = new File(fileName);

		FileInputStream propfile = new FileInputStream(Propfile);
		prop.load(propfile);

		given().baseUri(prop.getProperty("api.baseUri"))
				.header("Authorization", "Bearer  " + GenerateTokenAuthorization())
				.header("Content-Type", "application/json").body(file).

				when().post("/CreateQuoteExtended").

				then().log().all().statusCode(200);
	}

	public void CreateQuoteExtendedVal(String fileName) throws InterruptedException, IOException {
		File file = new File(fileName);

		given().baseUri(prop.getProperty("api.baseUri"))
				.header("Authorization", "Bearer  " + GenerateTokenAuthorization())
				.header("Content-Type", "application/json").body(file).

				when().post("/CreateQuoteExtendedVal").

				then().log().all().statusCode(200);
	}

	public void CreateQuoteFIPS(String fileName) throws InterruptedException, IOException {
		File file = new File(fileName);

		given().baseUri(prop.getProperty("api.baseUri"))
				.header("Authorization", "Bearer  " + GenerateTokenAuthorization())
				.header("Content-Type", "application/json").body(file).

				when().post("/CreateQuoteFIPS").

				then().log().all().statusCode(200);
	}

	public void CreateOrder(String fileName) throws InterruptedException, IOException {
		File file = new File(fileName);

		given().baseUri(prop.getProperty("api.baseUri"))
				.header("Authorization", "Bearer  " + GenerateTokenAuthorization())
				.header("Content-Type", "application/json").body(file).

				when().post("/CreateOrder").

				then().log().all().statusCode(200);
	}

	@SuppressWarnings("unchecked")
	public static void writeJsonSimpleDemo(String filename) throws Exception {

		JSONObject sampleObject = new JSONObject();
		FileInputStream propfile = new FileInputStream(Propfile);
		prop.load(propfile);
		sampleObject.put("userName", prop.getProperty("api.username"));
		sampleObject.put("password", prop.getProperty("api.password"));
		sampleObject.put("titleCompanyID", prop.getProperty("api.titleCompanyID"));
//		FWUtils.readXLPages(driver, "TestData", 0, 1);
		Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
//	    BeautifyJSON();
		WriteJSONStringToFile(rootPath + "/Data/CreateRequestBody.json",
				BeautifyJSON(rootPath + "/Data/CreateRequestBody.json"));

	}

	/*
	 * Creating Request Body using random parameters
	 */
	public void CreateRequestBody() throws Exception {
		writeJsonSimpleDemo(rootPath + "/Data/CreateRequestBody.json");
	}

	/*
	 * Beautify JSON used to Generate Pretty JSON from Existing JSON file
	 */
	public static String BeautifyJSON(String FileNamepath) throws FileNotFoundException, IOException {
		Object simpleObj = null;
		JSONParser parser = new JSONParser();
		try {
			simpleObj = parser.parse(new FileReader(FileNamepath));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (simpleObj != null) {
			System.out.println("Simple JSON Result:\n" + simpleObj.toString());
		}
		String prettyJson = null;
		if (simpleObj != null) {
			prettyJson = crunchifyPrettyJSONUtility(simpleObj.toString());
		}
		System.out.println("\n======== Pretty JSON Result: ==========\n" + prettyJson);
//	        WriteJSONStringToFile("/src/main/resources/resources/RequestBodyJSONFormat.json",prettyJson);
		return prettyJson;

	}

	/*
	 * Write Back the formatted JSON in pretty format into specific file.
	 */
	public static void WriteJSONStringToFile(String Filename, String PrettyJsonContent) {
		// Write JSON string to a file
		try {
			FileWriter file = new FileWriter(Filename);
			file.write(PrettyJsonContent); // json is a JSON string , the content which we are going to write here
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Prettify JSON Utility
	 */
	public static String crunchifyPrettyJSONUtility(String simpleJSON) {
		// parseString: Parses the specified JSON string into a parse tree
		JsonObject crunchifyJSON = JsonParser.parseString(simpleJSON).getAsJsonObject();
		// JsonParser crunhifyParser = new JsonParser();
		// JsonObject json = crunhifyParser.parse(simpleJSON).getAsJsonObject();
		// Gson: This is the main class for using Gson. Gson is typically used by first
		// constructing
		// a Gson instance and then invoking toJson(Object) or fromJson(String, Class)
		// methods on it.
		// Gson instances are Thread-safe so you can reuse them freely across multiple
		// threads.
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		// setPrettyPrinting(): Configures Gson to output Json that fits in a page for
		// pretty printing.
		// This option only affects Json serialization.
		String prettyJson = prettyGson.toJson(crunchifyJSON);
		// toJson: Converts a tree of JsonElements into its equivalent JSON
		// representation.
		return prettyJson;
	}

}
