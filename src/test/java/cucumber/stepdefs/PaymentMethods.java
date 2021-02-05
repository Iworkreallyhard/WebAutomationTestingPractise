package cucumber.stepdefs;

import com.spartaglobal.pageobjectmodel.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PaymentMethods {

    HomePage homePage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    OrderConfirmationPage orderConfirmationPage;
    Properties properties = new Properties();
    CheckoutSummary checkoutSummary;
    ShippingPage shippingPage;
    WebDriver webDriver;

    {
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Given("I am logged in as a user")
    public void iAmLoggedInAsAUser() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        homePage.goToSignInPage().signIn(properties.getProperty("username"), properties.getProperty("password"))
                .clickHomeButton();
    }

    @And("I have {int} item(s) in my/the cart")
    public void iHaveItemsInMyCart(int arg0) {
        checkoutSummary = homePage.goToTShirtProductsPage().addTShirtToCart().gotoCart(webDriver);
        if(arg0 > 1) {
            for (int i = 0; i < arg0 - 1; i++) {
                checkoutSummary.clickIncreaseQuantityOneProduct();
            }
        }
    }

    @Given("I am at selecting payment method/step")
    public void iAmAtSelectingPaymentMethodStep() {
        shippingPage = checkoutSummary.goToCheckoutLoggedIn().goToCheckout();
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
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("order-confirmation"));
//        get null pointer
    }

    @Then("My cart is empty")
    public void myCartIsEmpty() {

        WebElement webElement = orderConfirmationPage.selectCart();
        new Actions(webDriver).moveToElement(webElement).perform();
        boolean b = false;
        try {
            webElement.findElement(By.cssSelector("dl[class='products']"));
        } catch(Exception e) {
            b = true;
        }
        Assertions.assertTrue(b);
    }

    @When("I select pay by check")
    public void iSelectPayByCheck() {
        confirmationPage = paymentPage.clickPayByCheck();
    }

    @Then("My order should be logged with payment method {string}")
    public void myOrderShouldBeLoggedAsWithPaymentMethod(String arg0) {
        if (arg0.equals("Bank wire")) {
            String bankWire = webDriver.findElement(By.cssSelector("")).getText();
            Assertions.assertEquals("bank wire", bankWire);
        } else {
//            String check = webDriver.findElement().getText();
        }
    }
}
