package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSummary {

    WebDriver webDriver;

    By plusIcon = By.className("icon-plus");
    By minusIcon = By.className("icon-minus");
    By trashIcon = By.className("icon-trash");
    By checkoutButton = By.linkText("Proceed to checkout");
    By quantityBox = By.className("cart_quantity_input form-control grey");
    By continueShopping = By.linkText("Continue shopping");

    public CheckoutSummary(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickIncreaseQuantity() {
        webDriver.findElement(plusIcon).click();
    }

    public void clickDecreaseQuantity() {
        webDriver.findElement(minusIcon).click();
    }

    public void clickTrashProduct() {
        webDriver.findElement(trashIcon).click();
    }

    public CheckoutSignInPage goToCheckout() {
        webDriver.findElement(checkoutButton).click();
        return new CheckoutSignInPage(webDriver);
    }

    public void insertQuantityIntoBox(String quantity) {
        webDriver.findElement(quantityBox).sendKeys(quantity);
    }

    public HomePage goBackToShopping() {
        webDriver.findElement(continueShopping).click();
        return new HomePage(webDriver);
    }






}
