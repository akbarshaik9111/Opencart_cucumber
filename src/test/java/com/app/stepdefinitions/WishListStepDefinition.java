package com.app.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.app.factory.BaseClass;
import com.app.pageobjects.WishListPage;

import io.cucumber.java.en.Then;

public class WishListStepDefinition {
	
	public WebDriver driver;
	public WishListPage wlpage;
	
	@Then("verify the item {string} added to the cart")
	public void verify_the_item_added_to_the_cart(String productName) {
		wlpage = new WishListPage(BaseClass.driver);
		String searchProductName = wlpage.searchProductName();
		Assert.assertEquals("Invalid Product Added", productName, searchProductName);
	}
}
