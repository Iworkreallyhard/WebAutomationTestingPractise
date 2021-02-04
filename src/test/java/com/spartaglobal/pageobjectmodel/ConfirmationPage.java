package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage implements StandardProcedures {

    private final WebDriver webDriver;
    By logo = By.cssSelector(".logo");

    public ConfirmationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public PaymentPage clickOnOtherPaymentMethods() {
        webDriver.findElement(By.partialLinkText("Other payment")).click();
        return new PaymentPage(webDriver);
    }

    public OrderConfirmationPage clickConfirmMyOrder() {
        webDriver.findElement(By.cssSelector("button[type='submit']:not([name*='search'])")).click();
        return new OrderConfirmationPage(webDriver);
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
