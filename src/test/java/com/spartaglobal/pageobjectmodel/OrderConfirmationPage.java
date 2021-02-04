package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private final WebDriver webDriver;

    public OrderConfirmationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderHistoryPage clickBackToOrders(){
        webDriver.findElement(By.cssSelector("#center_column > p.cart_navigation.exclusive > a"));
        return new OrderHistoryPage(webDriver);
    }
}
