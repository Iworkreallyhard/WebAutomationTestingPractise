package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {

    private final WebDriver webDriver;

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

}
