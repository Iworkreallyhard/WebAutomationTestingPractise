package com.spartaglobal.pageobjecttests;

import com.spartaglobal.pageobjectmodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CheckoutSignInPageTests {
    private static Properties properties = new Properties();
    private static HomePage homePage;
    private static WebDriver webDriver;
    private static String username;
    private static String password;


    @BeforeAll
    static void setup() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkDoesSignIn(){
        homePage.addTShirtToCart();
        CheckoutSummary checkoutSummary = homePage.proceedToCheckoutFromPopUp();
        CheckoutSignInPage signInPage = checkoutSummary.goToCheckoutNotLoggedIn();
        signInPage.enterEmailInLogIn(username);
        signInPage.enterPasswordInLogIn(password);
        signInPage.clickSignIn();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0",webDriver.getCurrentUrl());
    }


}
