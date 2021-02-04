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

public class ShippingPageTests {

    private static Properties properties = new Properties();
    private static HomePage homePage;
    private static ShippingPage shippingPage;
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
    void checkDoesGoToPaymentPage(){
        homePage.addTShirtToCart();
        CheckoutSummary checkoutSummary = homePage.proceedToCheckoutFromPopUp();
        CheckoutSignInPage signInPage = checkoutSummary.goToCheckoutNotLoggedIn();
        signInPage.enterEmailInLogIn(username);
        signInPage.enterPasswordInLogIn(password);
        AddressPage addressPage = signInPage.clickSignIn();
        shippingPage = addressPage.goToCheckout();
        shippingPage.clickOnAgreeToTC();
        PaymentPage paymentPage = shippingPage.clickCheckout();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&multi-shipping=",webDriver.getCurrentUrl());
    }




}
