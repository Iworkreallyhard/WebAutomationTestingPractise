package com.spartaglobal;

import com.spartaglobal.pageobjectmodel.CheckoutSummary;
import com.spartaglobal.pageobjectmodel.HomePage;
import com.spartaglobal.pageobjectmodel.MyAccount;
import com.spartaglobal.pageobjectmodel.SignInPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestingMethods {
    static Properties properties = new Properties();
    private SignInPage signInPage;
    private CheckoutSummary checkoutSummary;
    private static String username;
    private static String password;
    @BeforeAll
    static void doStuff() {
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }
    @AfterEach
    void tearDown() {
        //webDriver.close();
    }
    @Test
    public void shouldAnswerWithTrue() {
        WebDriver webDriver = new ChromeDriver();
        HomePage homePage = new HomePage(webDriver);
        signInPage = homePage.goToSignInPage();
        signInPage.enterEmailInLogIn(username);
        signInPage.enterPasswordInLogIn(password);
        MyAccount myAccount = signInPage.clickSignIn();
        homePage = myAccount.clickHomeButton();
        homePage.addTShirtToCart();
        checkoutSummary = homePage.proceedToCheckoutFromPopUp();
        checkoutSummary.clickIncreaseQuantityOneProduct();
        checkoutSummary.clickIncreaseQuantityOneProduct();
        checkoutSummary.clickDecreaseQuantityOneProduct();
        checkoutSummary.clickTrashOneProduct();
        checkoutSummary.goBackToShopping();

    }

    @AfterAll
    static void afterAll() {
        //webDriver.quit();
    }
}