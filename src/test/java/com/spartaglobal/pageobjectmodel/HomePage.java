package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage {

        WebDriver webDriver;

        public HomePage(WebDriver driver) {
            this.webDriver = driver;
            webDriver.get("http://automationpractice.com/index.php");
        }


        public SignInPage goToSignInPage(){
            webDriver.findElement(By.linkText("Sign in")).click();
            return new SignInPage(webDriver);
        }


        public CheckoutSummary goToCheckout(){
            webDriver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")).click();
            return new CheckoutSummary(webDriver);
        }


        public void addTShirtToCart(){
           webDriver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")).click();
        }


        public CheckoutSummary proceedToCheckoutFromPopUp(){

            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            webDriver.findElement(By.linkText("Proceed to checkout")).click();
            return new CheckoutSummary(webDriver);
        }



}
