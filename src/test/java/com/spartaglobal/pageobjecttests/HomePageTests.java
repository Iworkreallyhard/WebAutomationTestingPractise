package com.spartaglobal.pageobjecttests;

import com.spartaglobal.pageobjectmodel.CheckoutSummary;
import com.spartaglobal.pageobjectmodel.HomePage;
import com.spartaglobal.pageobjectmodel.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HomePageTests {


    static Properties properties = new Properties();
    private SignInPage signInPage;
    private CheckoutSummary checkoutSummary;
    private static HomePage homePage;
    private static WebDriver webDriver;
    private static String username;
    private static String password;



    @BeforeAll
    static void doStuff() {
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
    void checkIsOnHomePage(){

    }

    @Test
    void checkCanAddItemToCart(){
        homePage.addTShirtToCart();
        checkoutSummary = homePage.proceedToCheckoutFromPopUp();
       Assertions.assertEquals("1", checkoutSummary.getQuantity());

    }



}
