package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TShirtProductPage implements StandardProcedures, ItemPopup{

    WebDriver webDriver;

    By cart = By.cssSelector("a[title*='shopping cart']");
    By logo = By.cssSelector("img[class*='logo']");
    By checkout = By.linkText("Proceed to checkout");
    By continueButton = By.linkText("Continue shopping");
    By close = By.cssSelector("span[class='cross'][title*='close']");

    public TShirtProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public TShirtProductPage addTShirtToCart(){
        Dimension d = new Dimension(1920, 1080);
        webDriver.manage().window().setSize(d);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> webElementList= webDriver.findElements(By.className("product-container"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElementList.get(0)).moveToElement(webElementList.get(0).findElement(By.className("button-container"))).click();
        actions.perform();
        return this;
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
