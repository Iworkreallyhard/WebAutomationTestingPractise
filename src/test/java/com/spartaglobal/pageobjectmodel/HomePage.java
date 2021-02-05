package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage implements StandardProcedures, ItemPopup{

    By logo = By.cssSelector(".logo");
    By signIn = By.linkText("Sign in");
    By cart = By.cssSelector("a[title*='shopping cart']");
    By checkout = By.linkText("Proceed to checkout");
    By continueButton = By.linkText("Continue shopping");
    By close = By.cssSelector("span[class='cross'][title*='close']");
    By TShirtProduct = By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a");





        private WebDriver webDriver;

        public HomePage(WebDriver driver) {
            this.webDriver = driver;
            webDriver.get("http://automationpractice.com/index.php");
        }


        public SignInPage goToSignInPage(){
            webDriver.findElement(signIn).click();
            return new SignInPage(webDriver);
        }


        public CheckoutSummary goToCheckout(){
            webDriver.findElement(cart).click();
            return new CheckoutSummary(webDriver);
        }


        public void addTShirtToCart(){
           webDriver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")).click();
        }

        public CheckoutSummary proceedToCheckoutFromPopUp(){

            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            webDriver.findElement(checkout).click();
            return new CheckoutSummary(webDriver);
        }
        
        
        public String getUrl(){
            return webDriver.getCurrentUrl();
        }

    @Override
    public WebElement selectCart() {
        return webDriver.findElement(cart);
    }
    @Override
    public WebElement selectLogo(){
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

    public TShirtProductPage goToTShirtProductsPage() {
        webDriver.findElement(TShirtProduct).click();
        return new TShirtProductPage(webDriver);
    }

    public ItemPage addTShirtViaItemPage() {
        List<WebElement> webElementList= webDriver.findElements(By.className("product-container"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElementList.get(0)).click(webElementList.get(0).findElement(By.cssSelector("div[class='left-block']")));
        actions.perform();

        return new ItemPage(webDriver);
    }
}
