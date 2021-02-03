package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


        public void addItemToBasket(){

        }



}
