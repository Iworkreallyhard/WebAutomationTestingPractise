package com.spartaglobal.pageobjecttests;

import com.spartaglobal.pageobjectmodel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PathTests {
	WebDriver webDriver;
	static Properties properties = new Properties();
	private static String username;
	private static String password;


	@BeforeEach
	void setup() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().setSize(new Dimension(1100,2500));

		try {
			properties.load(new FileReader("src/test/resources/login.properties"));
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Success Path One")
	void successPathOne() {
		HomePage homePage = new HomePage(webDriver);
		SignInPage signInPage = homePage.goToSignInPage();
		MyAccount myAccount = signInPage.signIn(username, password);

		homePage = myAccount.clickHomeButton();
		homePage.addTShirtToCart();
		homePage.proceedToCheckoutFromPopUp();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		CheckoutSummary checkoutSummary = homePage.goToCheckout();
		AddressPage addressPage = checkoutSummary.goToCheckoutLoggedIn();
		ShippingPage shippingPage = addressPage.goToCheckout();
		shippingPage.clickOnAgreeToTC();
		PaymentPage paymentPage = shippingPage.clickCheckout();
		ConfirmationPage confirmationPage = paymentPage.clickPayByBankWire();
		OrderConfirmationPage orderConfirmationPage = confirmationPage.clickConfirmMyOrder();

	}

	@Test
	@DisplayName("Login during checkout path")
	void loginDuringCheckoutPath() {
		HomePage homePage = new HomePage(webDriver);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homePage.addTShirtToCart();
		homePage.proceedToCheckoutFromPopUp();
		CheckoutSummary checkoutSummary = homePage.goToCheckout();
		CheckoutSignInPage checkoutSignInPage = checkoutSummary.goToCheckoutNotLoggedIn();

		AddressPage addressPage = checkoutSignInPage.signIn(username,password);
		ShippingPage shippingPage = addressPage.goToCheckout();
		shippingPage.clickOnAgreeToTC();
		PaymentPage paymentPage = shippingPage.clickCheckout();
		ConfirmationPage confirmationPage = paymentPage.clickPayByBankWire();
		OrderConfirmationPage orderConfirmationPage = confirmationPage.clickConfirmMyOrder();

	}

}
