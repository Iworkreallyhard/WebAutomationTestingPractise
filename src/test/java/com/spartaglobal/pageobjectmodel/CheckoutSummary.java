package com.spartaglobal.pageobjectmodel;

import com.spartaglobal.pageobjectmodel.enums.Product_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CheckoutSummary implements StandardProcedures{

    WebDriver webDriver;

    By plusIcon = By.className("icon-plus");
    By minusIcon = By.className("icon-minus");
    By trashIcon = By.className("icon-trash");
    By checkoutButton = By.linkText("Proceed to checkout");
    By quantityBox = By.className("cart_quantity_input form-control grey");
    By continueShopping = By.linkText("Continue shopping");
    By cart = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    By logo = By.cssSelector("#header_logo > a > img");

    public CheckoutSummary(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickIncreaseQuantityOneProduct() {
        webDriver.findElement(plusIcon).click();
    }

    public void clickDecreaseQuantityOneProduct() {
        webDriver.findElement(minusIcon).click();
    }

    public void clickIncreaseQuantityByID(Product_ID product_id) {
        webDriver.findElement(By.id(product_id.toString())).findElement(plusIcon).click();
    }

    public void clickDecreaseQuantityByID(Product_ID product_id) {
        webDriver.findElement(By.id(product_id.toString())).findElement(minusIcon).click();
    }

    public void clickTrashProductByID(Product_ID product_id) {
        webDriver.findElement(By.id(product_id.toString())).findElement(trashIcon).click();
    }


    public void clickTrashOneProduct() {
        webDriver.findElement(trashIcon).click();
    }

    public CheckoutSignInPage goToCheckoutNotLoggedIn() {
        webDriver.findElement(checkoutButton).click();
        return new CheckoutSignInPage(webDriver);
    }

    public AddressPage goToCheckoutLoggedIn() {
        webDriver.findElement(checkoutButton).click();
        return new AddressPage(webDriver);
    }

    public void insertQuantityIntoBox(String quantity) {
        webDriver.findElement(quantityBox).sendKeys(quantity);
    }

    public HomePage goBackToShopping() {
        webDriver.findElement(continueShopping).click();
        return new HomePage(webDriver);
    }

    public String getQuantity(){

        List<WebElement> inputs = webDriver.findElements(By.tagName("input"));

        for (WebElement webElement : inputs){
            if (webElement.getAttribute("name").equals("quantity_1_1_0_0_hidden")){
                return webElement.getAttribute("value");
            }
        }

        return null;
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
