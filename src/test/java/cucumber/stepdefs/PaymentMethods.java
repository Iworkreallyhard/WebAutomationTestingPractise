package cucumber.stepdefs;

import com.spartaglobal.pageobjectmodel.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PaymentMethods {

    HomePage homePage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    OrderConfirmationPage orderConfirmationPage;
    Properties properties = new Properties();

    {
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Given("I am logged in as a user")
    public void iAmLoggedInAsAUser() {
        homePage = new HomePage(new ChromeDriver());
        homePage.goToSignInPage().signIn(properties.getProperty("username"), properties.getProperty("password"))
                .clickHomeButton();
    }

    @And("I have {int} item(s) in my/the cart")
    public void iHaveItemsInMyCart(int arg0) {
        for (int i = 0; i < arg0 ; i++) {
            homePage.addTShirtToCart();
        }
    }

    @Given("I am at selecting payment method/step")
    public void iAmAtSelectingPaymentMethodStep() {
        ShippingPage shippingPage = homePage.goToCheckout().goToCheckoutLoggedIn().goToCheckout();
        shippingPage.clickOnAgreeToTC();
        paymentPage = shippingPage.clickCheckout();
    }

    @When("I select pay by bank wire")
    public void iSelectPayByBankWire() {
        confirmationPage = paymentPage.clickPayByBankWire();
    }

    @And("I confirm the order")
    public void iConfirmTheOrder() {
        orderConfirmationPage = confirmationPage.clickConfirmMyOrder();
    }

    @Then("I am shown an order confirmation")
    public void iAmShownAnOrderConfirmation() {
//        Assertions.assertTrue(orderConfirmationPage.showsConfirmation());
    }

    @And("My cart is empty")
    public void myCartIsEmpty() {
//        Assertions.assertTrue(orderConfirmationPage.cartIsEmpty());
    }

    @When("I select pay by check")
    public void iSelectPayByCheck() {
        confirmationPage = paymentPage.clickPayByCheck();
    }

    @And("My order should be logged with payment method {string}")
    public void myOrderShouldBeLoggedAsWithPaymentMethod(String arg0) {

    }
}
