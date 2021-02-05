package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage implements StandardProcedures {

    WebDriver webDriver;

    By checkoutButton = By.name("processAddress");
    By continueShoppingButton = By.linkText("Continue shopping");
    By logo = By.cssSelector(".logo");

    public AddressPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ShippingPage goToCheckout() {
        webDriver.findElement(checkoutButton).click();
        return new ShippingPage(webDriver);
    }

    public CheckoutSummary continueShopping() {
        webDriver.findElement(continueShoppingButton).click();
        return new CheckoutSummary(webDriver);
    }

    @Override
    public WebElement selectCart() {
        return webDriver.findElement(By.cssSelector("a[title*='shopping cart']"));
    }

    @Override
    public WebElement selectLogo() {
        return webDriver.findElement(logo);
    }

    @Override
    public HomePage gotoHome(WebDriver webDriver) {
        selectLogo().click();
        return new HomePage(webDriver);
    }

    @Override
    public CheckoutSummary gotoCart(WebDriver webDriver) {
        selectCart().click();
        return new CheckoutSummary(webDriver);
    }
}
