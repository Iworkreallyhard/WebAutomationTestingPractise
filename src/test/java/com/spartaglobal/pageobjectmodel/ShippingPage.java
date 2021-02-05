package com.spartaglobal.pageobjectmodel;

import io.cucumber.java.ro.Si;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage implements StandardProcedures{
    WebDriver webDriver;
    By checkoutButton = By.name("processCarrier");
    By continueShoppingButton = By.linkText("Continue shopping");
    By signIn = By.linkText("Sign in");
    By summary = By.linkText("Summary");
    By logo = By.cssSelector(".logo");
    By address = By.linkText("Address");
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

    public PaymentPage clickCheckout() {
        webDriver.findElement(checkoutButton).click();
        return new PaymentPage(webDriver);
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

    public AddressPage clickAddressTab() {
        webDriver.findElement(address).click();
        return new AddressPage(webDriver);
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

    //need to test!!!
}
