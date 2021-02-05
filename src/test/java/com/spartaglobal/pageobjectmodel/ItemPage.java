package com.spartaglobal.pageobjectmodel;

import com.spartaglobal.pageobjectmodel.enums.ProductColor;
import com.spartaglobal.pageobjectmodel.enums.ProductSize;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ItemPage implements StandardProcedures, ItemPopup {


    By logo = By.cssSelector(".logo");
    By cart = By.cssSelector("a[title*='shopping cart']");
    By checkout = By.linkText("Proceed to checkout");
    By continueButton = By.linkText("Continue shopping");
    By close = By.cssSelector("span[class='cross'][title*='close']");

    private final WebDriver webDriver;


    public ItemPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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
        return webDriver.findElement(checkout);
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

    public WebElement selectQuantity() {
        return webDriver.findElement(By.cssSelector("p[id*='quantity'] input[type*='text'][id*='quantity_wanted']"));
    }

    public WebElement selectPlusQuantity() {
        return webDriver.findElement(By.cssSelector("p[id*='quantity'] i[class*='plus']"));
    }

    public WebElement selectMinusQuantity() {
        return webDriver.findElement(By.cssSelector("p[id*='quantity'] i[class*='minus']"));
    }

    public WebElement selectColor(ProductColor color) {
        return webDriver.findElement(color.getSelector());
    }

    public WebElement selectSize(ProductSize productSize) {
        return webDriver.findElement(productSize.getSelector());
    }

    public WebElement selectAddToCart() {
        return webDriver.findElement(By.cssSelector("button[type='submit'][name='Submit']"));
    }

    public ItemPage changeQuantityTo(int quantity) {
        new Actions(webDriver).doubleClick(selectQuantity()).sendKeys(Keys.BACK_SPACE, String.valueOf(quantity)).perform();
        return this;
    }

    public ItemPage addQuantity() {
        new Actions(webDriver).click(selectPlusQuantity()).perform();
        return this;
    }

    public ItemPage minusQuantity() {
        new Actions(webDriver).click(selectMinusQuantity()).perform();
        return this;
    }

    public ItemPage select(ProductColor color) {
        new Actions(webDriver).click(selectColor(color)).perform();
        return this;
    }

    public ItemPage select(ProductSize productSize) {
        new Actions(webDriver).moveToElement(webDriver.findElement(By.cssSelector("select[id='group_1']")))
                .click(selectSize(productSize)).perform();
        return this;
    }

    public ItemPage addToCart() {
        new Actions(webDriver).click(selectAddToCart()).perform();
        return this;
    }
}
