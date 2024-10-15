package com.app.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='content'] //h2[text()='My Account']") // MYACCOUNT PAGE HEADING
	private WebElement msgHeading;
	
	@FindBy(xpath = "//aside[@id='column-right'] //a[text()='Logout']") 
	WebElement linkLogout;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement txtSearch;
	
	@FindBy(xpath="//span[@class='input-group-btn']//button")
	WebElement btnSearch;
	
	@FindBy(xpath="//div[@class='product-thumb']//h4")
	List<WebElement> listOfProds;
	
	@FindBy(xpath="//button[@data-original-title='Add to Wish List']")
	WebElement btnWish;
	
	@FindBy(xpath="//a[@id='wishlist-total']//span")
	WebElement linkWishList;
	 
	public boolean checkMessage() { // MYACCOUNT PAGE HEADING DISPLAY STATUS
		try {
			return msgHeading.isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
	
	public void clickOnLogout() {
		linkLogout.click();
	}
	
	public void searchProduct(String product) {
		txtSearch.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		btnSearch.click();
	}
	
	public void selectProductFromTheList(String product) {
		for(WebElement prod : listOfProds) {
			if(prod.getText().equalsIgnoreCase(product)) {
				btnWish.click();
			}
		}
	}
	
	public void goToWishList() {
		linkWishList.click();
	}
}