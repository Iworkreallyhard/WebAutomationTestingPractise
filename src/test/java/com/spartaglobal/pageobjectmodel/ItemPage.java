package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ItemPage implements StandardProcedures, ItemPopup {


    By logo = By.cssSelector(".logo");
    By cart = By.cssSelector("a[title*='shopping cart']");
    By checkout = By.linkText("Proceed to checkout");
    By continueButton = By.linkText("Continue shopping");
    By close = By.cssSelector("span[class='cross'][title*='close']");

    private WebDriver webDriver;


    public ItemPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    
    @Override
    public WebElement selectCart() {
        return webDriver.findElement(cart);
    }
    @Override
    public WebElement selectLogo(){
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


    @Override
    public WebElement selectCheckoutButton() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return  webDriver.findElement(checkout);
    }

    @Override
    public WebElement selectContinueToShopping() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return webDriver.findElement(continueButton);
    }

    @Override
    public WebElement selectX() {
        return webDriver.findElement(close);
    }

    @Override
    public CheckoutSummary gotoCheckout(WebDriver webDriver) {
        selectCheckoutButton().click();
        return new CheckoutSummary(webDriver);
    }

    @Override
    public void close() {
        selectX().click();
    }

    @Override
    public void continueShopping() {
        selectContinueToShopping().click();
    }







}
