package cucumber.stepdefs;

import com.spartaglobal.pageobjectmodel.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class PaymentMethods {
    WebDriver webDriver = new ChromeDriver();
    Properties properties = new Properties();
    HomePage homePage = new HomePage(webDriver);
    SignInPage signInPage;
    CheckoutSummary checkoutSummary;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    OrderConfirmationPage orderConfirmationPage;

    @Given("I am logged in as a user")
    public void iAmLoggedInAsAUser() {
        signInPage = homePage.goToSignInPage();
        signInPage.signIn(properties.getProperty("username"),properties.getProperty("password"));
    }

    @And("I have {int} item(s) in my/the cart")
    public void iHaveItemsInMyCart(int arg0) {
        homePage = new HomePage(webDriver);
        for (int i = 0; i < arg0; i++) {
            homePage.addTShirtToCart();
        }
    }

    @Given("I am at selecting payment method/step")
    public void iAmAtSelectingPaymentMethodStep() {
        checkoutSummary = homePage.goToCheckout();
        addressPage = checkoutSummary.goToCheckoutLoggedIn();
        shippingPage = addressPage.goToCheckout();
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
        Assertions.assertEquals(
                "Your order on My Store is complete.",
                webDriver.findElement(By.className("dark")).getText());
    }

    @Then("My cart is empty")
    public void myCartIsEmpty() {

    }

    @When("I select pay by check")
    public void iSelectPayByCheck() {
        confirmationPage = paymentPage.clickPayByCheck();
    }

    @Then("My order should be logged with payment method {string}")
    public void myOrderShouldBeLoggedAsWithPaymentMethod(String arg0) {

    }
}
