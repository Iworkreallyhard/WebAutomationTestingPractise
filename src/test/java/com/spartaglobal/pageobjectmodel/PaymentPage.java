package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private final WebDriver webDriver;

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
}
