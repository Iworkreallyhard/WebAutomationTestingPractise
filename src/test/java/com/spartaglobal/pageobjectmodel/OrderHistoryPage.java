package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage implements StandardProcedures{

    private final WebDriver webDriver;
    By logo = By.cssSelector(".logo");

    public OrderHistoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean orderReferenceExist(String orderReference){
        try {
            webDriver.findElement(By.linkText(orderReference));
        }catch (Exception e){
            return false;
        }
        return true;
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
