package com.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {
	
	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//table[contains(@class, 'table-bordered')]//tbody//tr//td[2]//a")
	WebElement prodName;
	
	public String searchProductName() {
		return prodName.getText();
	}
}