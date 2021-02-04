package com.spartaglobal.pageobjectmodel;

import com.spartaglobal.pageobjectmodel.enums.Product_ID;
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

    public void clickIncreaseQuantityOneProduct() {
        webDriver.findElement(plusIcon).click();
    }

    public void clickDecreaseQuantityOneProduct() {
        webDriver.findElement(minusIcon).click();
    }

    public void clickIncreaseQuantityByID(Product_ID product_id) {
        webDriver.findElement(By.id(product_id.toString())).findElement(plusIcon).click();
    }

    public void clickDecreaseQuantityByID(Product_ID product_id) {
        webDriver.findElement(By.id(product_id.toString())).findElement(minusIcon).click();
    }

    public void clickTrashProductByID(Product_ID product_id) {
        webDriver.findElement(By.id(product_id.toString())).findElement(trashIcon).click();
    }


    public void clickTrashOneProduct() {
        webDriver.findElement(trashIcon).click();
    }

    public CheckoutSignInPage goToCheckoutNotLoggedIn() {
        webDriver.findElement(checkoutButton).click();
        return new CheckoutSignInPage(webDriver);
    }

    public AddressPage goToCheckoutLoggedIn() {
        webDriver.findElement(checkoutButton).click();
        return new AddressPage(webDriver);
    }

    public void insertQuantityIntoBox(String quantity) {
        webDriver.findElement(quantityBox).sendKeys(quantity);
    }

    public HomePage goBackToShopping() {
        webDriver.findElement(continueShopping).click();
        return new HomePage(webDriver);
    }






}
