package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage implements StandardProcedures {

    private final WebDriver webDriver;
    By logo = By.cssSelector("img[class*='logo']");
    By cart = By.cssSelector("div[class='shopping_cart']");

    public OrderConfirmationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderHistoryPage clickBackToOrders() {
        webDriver.findElement(By.cssSelector("#center_column > p.cart_navigation.exclusive > a"));
        return new OrderHistoryPage(webDriver);
    }

    @Override
    public WebElement selectCart() {
        return webDriver.findElement(cart);
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
