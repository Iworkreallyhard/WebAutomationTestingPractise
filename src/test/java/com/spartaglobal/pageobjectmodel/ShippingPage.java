package com.spartaglobal.pageobjectmodel;

import io.cucumber.java.ro.Si;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {
    WebDriver webDriver;
    By checkoutButton = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    By continueShoppingButton = By.linkText("Continue shopping");
    By signIn = By.linkText("Sign in");
    By summary = By.linkText("Summary");
    By logo = By.cssSelector(".logo");
    By homeButton = By.linkText("Home");

    public ShippingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void clickOnAgreeToTC() {
        webDriver.findElement(By.id("cgv")).click();
    }

    public CheckoutSummary clickCheckout() {
        webDriver.findElement(checkoutButton).click();
        return new CheckoutSummary(webDriver);
    }

    public HomePage goBackToAddress() {
        webDriver.findElement(continueShoppingButton).click();
        return new HomePage(webDriver);
    }

    public HomePage clickHomeButton() {
        webDriver.findElement(homeButton).click();
        return new HomePage(webDriver);
    }

    public HomePage clickLogo() {
        webDriver.findElement(logo).click();
        return new HomePage(webDriver);
    }

    public SignInPage clickSignInTab(){
        webDriver.findElement(signIn).click();
        return new SignInPage(webDriver);
    }

    public CheckoutSummary clickSummaryTab(){
        webDriver.findElement(summary).click();
        return new CheckoutSummary(webDriver);
    }

    //need to test!!!
}
