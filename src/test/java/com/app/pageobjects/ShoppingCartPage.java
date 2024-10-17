package com.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='table-responsive']//tbody//td[2]//a")
    WebElement productName;

    public String getProduct() {
        return productName.getText();
    }
}
