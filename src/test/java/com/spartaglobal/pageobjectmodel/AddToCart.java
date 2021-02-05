package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.WebElement;

public interface AddToCart {
    WebElement selectAddToCart(WebElement product); //select add to cart button

    void addToCart(WebElement product); //click on addToCart button
}
