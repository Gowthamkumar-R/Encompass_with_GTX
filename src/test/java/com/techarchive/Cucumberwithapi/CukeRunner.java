package com.techarchive.Cucumberwithapi;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * This class serves as the Cucumber test runner for executing feature files and
 * step definitions.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/GTX",
		
		// Specifies the package containing step definitions
		glue = { "stepdefinition", "com.techarchive.Cucumberwithapi" },
		
		// Specifies the plugins for generating different types of reports
		plugin = { "pretty", "html:target/cucumber.html", "json:target/cucumber.json" },
		
		// Publishes the generated reports
		publish = true,
		
		// Enables or disables colorful console output (true: colorful, false: black and
		// white)
		monochrome = true,
		
		// Whether to run the scenarios to check if steps have matching step definitions
		dryRun = false)


public class CukeRunner {

}
