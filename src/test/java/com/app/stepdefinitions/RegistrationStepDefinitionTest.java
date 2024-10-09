package com.app.stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.app.factory.BaseClass;
import com.app.pageobjects.AccountRegistrationPage;
import com.app.pageobjects.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinitionTest {
	
	public WebDriver driver;
	public HomePage hp;
	public AccountRegistrationPage regpage;
	
	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_Register_Account_page() {
		hp = new HomePage(BaseClass.getDriver());
		hp.clickOnMyAccount();
		hp.clickOnRegister();
	}
	
	@When("the user enters the details in below fields")
	public void the_user_enters_the_details_in_below_fields(DataTable datatable) {
		Map<String, String> dataMap = datatable.asMap(String.class, String.class);
		regpage = new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setUserFirstName(dataMap.get("firstName"));
		regpage.setUserLastName(dataMap.get("lastName"));
		regpage.setEmail(BaseClass.randomAlphaNumberic()+"@gmail.com");
		regpage.setTelephone(dataMap.get("telephone"));
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("password"));
	}
	
	@When("the user selects Privacy Policy")
	public void the_user_selects_Privacy_Policy() {
		regpage.clickChkbox();
	}
	
	@When("the user clicks on Continue button")
	public void the_user_clicks_on_Continue_button() {
		regpage.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
		String message = regpage.getConfirmationMsg();
		Assert.assertEquals("Your Account Has Been Created!", message);
	}

}