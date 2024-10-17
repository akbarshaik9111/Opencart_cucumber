package com.app.stepdefinitions;

import com.app.factory.BaseClass;
import com.app.pageobjects.ShoppingCartPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ShoppingCartStepDefinitionTest {
    public WebDriver driver;
    public ShoppingCartPage scp;

    @Then("^verify the searched item (.+) added to the cart$")
    public void verify_the_searched_item_added_to_the_cart(String product) {
        scp = new ShoppingCartPage(BaseClass.getDriver());
        String searchProd = scp.getProduct().toLowerCase();
        Assert.assertEquals("Product Not Matched", product, searchProd);
    }
}
