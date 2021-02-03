package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

        WebDriver webDriver; // Home page only!!!
        By comments = new By.ByLinkText("comments"); //elements of the page you want to interact with
        By past = new By.ByLinkText("past");


        public HomePage(WebDriver driver) {
            this.webDriver = driver;
        }

        public void goToHomePage() {
            webDriver.get("http://automationpractice.com/index.php");
        }

        /*

        public LoginPage goToLoginPage(){
            webDriver.findElement(By.linkText("Sign in"));
            return new LoginPage(webDriver);
        }


        public CheckoutSummary goToCheckout(){
            webDriver.findElement(By.linkText())
        }

         */

}
