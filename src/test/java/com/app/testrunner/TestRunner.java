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
		//tags = "@sanitytest"
		//tags = "@regressiontest"
		//tags = "@sanitytest or @regressiontest"
		)
public class TestRunner {
	
	/*
	 * For TestNG
	 * i. We have to comment @RunWith(Cucumber.class)
	 * ii. We have to extend this class to AbstractTestNGCucumberTests
	 * iii. Have to add cucumber-testng dependency
	 * iv. Have to update the imports from org.junit to org.testng
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}*/

}
