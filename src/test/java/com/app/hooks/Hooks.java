package com.app.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.app.factory.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	WebDriver driver;
	Properties props;
	
	@Before
	public void setup() throws IOException {
		driver = BaseClass.initializeBrowser();
		props = BaseClass.getProperties();
		driver.get(props.getProperty("appurl"));
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot ts = ((TakesScreenshot) driver);
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", scenario.getName());
		}
	}
}