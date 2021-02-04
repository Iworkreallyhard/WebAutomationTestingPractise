package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private final WebDriver webDriver;

    public ConfirmationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public PaymentPage clickOnOtherPaymentMethods(){
        webDriver.findElement(By.partialLinkText("Other payment")).click();
        return new PaymentPage(webDriver);
    }

    public OrderConfirmationPage clickConfirmMyOrder(){
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
        return new OrderConfirmationPage(webDriver);
    }
}
