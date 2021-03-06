package com.spartaglobal.pageobjecttests;

import com.spartaglobal.pageobjectmodel.CheckoutSignInPage;
import com.spartaglobal.pageobjectmodel.CheckoutSummary;
import com.spartaglobal.pageobjectmodel.HomePage;
import com.spartaglobal.pageobjectmodel.SignInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CheckoutSummaryTests {


    private static final Properties properties = new Properties();
    private static HomePage homePage;
    private static WebDriver webDriver;
    private static String username;
    private static String password;


    @BeforeEach
    void setup() {
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
    void canGoToSignIn() {
        homePage.addTShirtToCart();
        CheckoutSummary checkoutSummary = homePage.proceedToCheckoutFromPopUp();
        CheckoutSignInPage signInPage = checkoutSummary.goToCheckoutNotLoggedIn();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0", webDriver.getCurrentUrl());
    }

    @Test
    void canGoToAddressPage() {
        SignInPage signInPage = homePage.goToSignInPage();
        signInPage.signIn(username, password);
        signInPage.clickLogo();
        homePage.addTShirtToCart();
        CheckoutSummary checkoutSummary = homePage.proceedToCheckoutFromPopUp();
        checkoutSummary.goToCheckoutLoggedIn();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&step=1", webDriver.getCurrentUrl());
    }

    @AfterEach
    void close() {
        webDriver.close();
    }


}
