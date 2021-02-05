package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressPage implements StandardProcedures {

    WebDriver webDriver;

    By checkoutButton = By.name("processAddress");
    By continueShoppingButton = By.linkText("Continue shopping");
    By logo = By.cssSelector(".logo");
    By updateButton = By.linkText("Update");
    By addressDropDown = By.id("id_address_delivery");
    By addressCheckbox = By.id("addressesAreEquals");
    By firstLineOfAddress = By.cssSelector("#address_delivery > .address_address1");
    By billingAddress = By.cssSelector("#address_invoice > .address_address1");

    public AddressPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ShippingPage goToCheckout() {
        webDriver.findElement(checkoutButton).click();
        return new ShippingPage(webDriver);
    }

    public CheckoutSummary continueShopping() {
        webDriver.findElement(continueShoppingButton).click();
        return new CheckoutSummary(webDriver);
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

    public void clickUpdateButton(){
        webDriver.findElement(updateButton).click();
    }

    public Select getAddressDropDown(){
        return new Select(webDriver.findElement(addressDropDown));
    }

    public void clickCheckbox(){
        webDriver.findElement(addressCheckbox).click();
    }

    public WebElement getFirstLineOfAddress(){
        return webDriver.findElement(firstLineOfAddress);
    }

    public WebElement getBillingAddress(){
        return webDriver.findElement(billingAddress);
    }

}
