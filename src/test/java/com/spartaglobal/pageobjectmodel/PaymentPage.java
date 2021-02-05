package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage implements StandardProcedures{

    private final WebDriver webDriver;
    By logo = By.cssSelector(".logo");

    public PaymentPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public ConfirmationPage clickPayByBankWire(){
        webDriver.findElement(By.className("bankwire")).click();
        return new ConfirmationPage(webDriver);
    }

    public ConfirmationPage clickPayByCheck(){
        webDriver.findElement(By.className("cheque")).click();
        return new ConfirmationPage(webDriver);
    }

    @Override
    public WebElement selectCart() {
        return webDriver.findElement(By.cssSelector("a[title*='shopping cart']"));
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
}
