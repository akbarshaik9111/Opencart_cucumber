package com.app.stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.app.factory.BaseClass;
import com.app.pageobjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardStepDefinitionTest {
	
	WebDriver driver;
	Properties props;
	HomePage hp;
	
	@Given("the user navigates to the dashboard page")
	public void the_user_navigates_to_the_dashboard_page() {
		hp = new HomePage(BaseClass.getDriver());
	}
	
	@When("verify the page URL")
	public void verify_the_page_url() throws IOException {
		props = BaseClass.getProperties();
		String expected_url = props.getProperty("appurl");
		String actual_url = hp.getCurrentURL();
		Assert.assertEquals("Incorrect URL", expected_url, actual_url);
	}
	
	@Then("verify the page title")
	public void verify_the_page_title() throws IOException {
		props = BaseClass.getProperties();
		String expected_title = props.getProperty("title");
		String actual_title = hp.getTitle();
		Assert.assertEquals("Incorrect Title", expected_title, actual_title);
	}
}