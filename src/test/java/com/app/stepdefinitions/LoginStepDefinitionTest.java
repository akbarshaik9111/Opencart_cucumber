package com.app.stepdefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.app.factory.BaseClass;
import com.app.pageobjects.HomePage;
import com.app.pageobjects.LoginPage;
import com.app.pageobjects.MyAccountPage;
import com.app.utilities.DataReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitionTest {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage map;
	List<HashMap<String, String>> datamap;
	
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() {
		hp = new HomePage(BaseClass.getDriver());
		hp.clickOnMyAccount();
		hp.clickOnLogin();
	}
	
	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_email_and_password_as_password(String email, String password) {
		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);
	}
	
	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		lp.clickLogin();
	}
	
	@Then("the user should be redirected to the MyAccount page")
	public void the_user_should_be_redirected_to_the_MyAccount_page() {
		map = new MyAccountPage(BaseClass.getDriver());
		boolean message = map.checkMessage();
		Assert.assertEquals(true, message);
	}
	
	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows) {
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testdata\\Opencart_LoginData.xlsx", "Sheet1");

		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("username");
		String pwd = datamap.get(index).get("password");
		String exp_res = datamap.get(index).get("res");

		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);

		lp.clickLogin();
		map = new MyAccountPage(BaseClass.getDriver());
		try {
			boolean targetpage = map.checkMessage();
			System.out.println("target page: " + targetpage);
			if (exp_res.equals("Valid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(BaseClass.getDriver());
					map.clickOnLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp_res.equals("Invalid")) {
				if (targetpage == true) {
					map.clickOnLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {

			Assert.assertTrue(false);
		}
	}
	
	@Given("user enters valid email as {string} and password as {string}")
	public void user_enters_valid_email_as_email_and_password_as_password(String email, String password) {
		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
	}
}