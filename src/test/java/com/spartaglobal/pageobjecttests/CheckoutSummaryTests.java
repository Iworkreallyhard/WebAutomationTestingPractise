package com.spartaglobal.pageobjecttests;

import com.spartaglobal.pageobjectmodel.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CheckoutSummaryTests {


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
    void canGoToSignIn(){
        homePage.addTShirtToCart();
        CheckoutSummary checkoutSummary = homePage.proceedToCheckoutFromPopUp();
        CheckoutSignInPage signInPage = checkoutSummary.goToCheckoutNotLoggedIn();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0", webDriver.getCurrentUrl());
    }
    @Test
    void canGoToAddressPage(){
        WebDriver driver = new ChromeDriver();
        HomePage testHomePage = new HomePage(driver);
        SignInPage signInPage = testHomePage.goToSignInPage();
        signInPage.signIn(username,password);
        signInPage.clickLogo();
        homePage.addTShirtToCart();
        CheckoutSummary checkoutSummary = testHomePage.proceedToCheckoutFromPopUp();
        checkoutSummary.goToCheckoutLoggedIn();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&step=1", driver.getCurrentUrl());
    }

    @AfterEach
    void close(){
        webDriver.close();
    }




}
