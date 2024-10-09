package com.app.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//src/test/java/com/app/features/",
		//features={"@target/rerun.txt"},
		glue = {"com.app.stepdefinitions","com.app.hooks"},
		dryRun=false,
		plugin = {"pretty",
			"html:reports/myreport.html",
			"rerun:target/rerun.txt",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		publish = true
		//tags = "@sanity or @regression"
		)
public class TestRunner {

}
