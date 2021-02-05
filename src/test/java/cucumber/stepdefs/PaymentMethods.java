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
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentMethods {

    HomePage homePage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    OrderConfirmationPage orderConfirmationPage;
    Properties properties = new Properties();
    CheckoutSummary checkoutSummary;
    ShippingPage shippingPage;
    WebDriver webDriver;
    OrderHistoryPage orderHistoryPage;

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
        } catch(NoSuchElementException e) {
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
        String word = null;
        if(arg0.equals("Bank wire")) {
            word = webDriver.findElement(By.cssSelector("div[class='box']")).getText();
        }
        if(arg0.equals("Payment by check")){
            word = webDriver.findElement(By.cssSelector("div[class='box order-confirmation']")).getText();
        }

        Pattern pattern = Pattern.compile(".*(?<reference>[A-Z]{9}).*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(word);
        String payment = "";
        System.out.println(word);
        if(matcher.matches()) {
            orderHistoryPage = orderConfirmationPage.clickBackToOrders();
            List<WebElement> list = webDriver.findElements(By.cssSelector("table#order-list tr[class*='item']"));
            for (WebElement webElement : list) {
                if(webElement.findElement(By.cssSelector("a[class='color-myaccount']")).getText().contains(matcher.group("reference"))) {
                    payment = webElement.findElement(By.cssSelector("td[class='history_method']")).getText();
                }
            }
        }
        Assertions.assertTrue(payment.contains(arg0));
    }
}
