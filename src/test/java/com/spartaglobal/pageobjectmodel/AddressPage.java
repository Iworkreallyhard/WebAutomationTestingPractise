package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage {

    WebDriver webDriver;

    By checkoutButton = By.linkText("Proceed to checkout");
    By continueShoppingButton = By.linkText("Continue shopping");
    
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
}
