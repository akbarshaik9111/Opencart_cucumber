package com.app.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.app.factory.BaseClass;
import com.app.pageobjects.MyAccountPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountPageStepDefinitionTest {
	
	WebDriver driver;
	MyAccountPage macc;
	
	@When("user search the item {string}")
	public void user_search_the_item(String product) throws InterruptedException {
		Thread.sleep(2000);
		macc = new MyAccountPage(BaseClass.getDriver());
		macc.searchProduct(product);
		macc.clickSearchBtn();
	}
	
	@When("add searched item {string} to wish list")
	public void add_searched_item_to_wishlist(String product) {
		macc.selectProductFromTheList(product);
	}
	
	@Then("go to the wishlist page")
	public void go_to_the_wishlist_page() throws InterruptedException {
		Thread.sleep(1000);
		macc.goToWishList();
	}
}