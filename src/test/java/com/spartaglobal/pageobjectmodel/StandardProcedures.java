package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface StandardProcedures {
    WebElement selectCart(); //select cart

    WebElement selectLogo(); //select logo

    HomePage gotoHome(WebDriver webDriver); //click on logo to go home

    CheckoutSummary gotoCart(WebDriver webDriver); //click on cart to go to checkout
}
