package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ItemPopup {
    WebElement selectCheckoutButton(); //select the checkout button

    WebElement selectContinueToShopping(); //select the continue to shopping button

    WebElement selectX(); //select the x round button

    CheckoutSummary gotoCheckout(WebDriver webDriver); //click on the checkout button

    void close(); //click on the x round button

    void continueShopping(); //click on the continue to shopping button

}
