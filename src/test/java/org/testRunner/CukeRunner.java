package org.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Test",
		
		//features = "src/test/resources/Test/SettlementStatementFIPS.feature",
		glue = { "org.api.stepDefinitions" },

		plugin = { "pretty", "html:target/cucumber.html", "json:target/cucumber.json" },

		publish = true, monochrome = true, dryRun = false)

//@CucumberOptions(
//		features = "src/test/resources/Test",
//		glue = {"stepdefinition"},
//		plugin ={"pretty", 
//				"html:target/cucumber.html",
//				"json:target/cucumber.json"
//				},
//		/* can generate the repors as  Cucumber.html(html:target/cucumber-reports), cucumber.json(json:target/cucumber-reports/Cucumber.json), Cucumber.xml(junit:target/cucumber-reports/Cucumber.xml)*/
//		monochrome = false)  /* the monochrome option is set to false, then the console output is not as readable. if the monochrome is not defined in Cucumber Options, it takes it as false by default*/

public class CukeRunner {

}
