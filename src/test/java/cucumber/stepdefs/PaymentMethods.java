package cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentMethods {
    @Given("I am logged in as a user")
    public void iAmLoggedInAsAUser() {
    }

    @And("I have {int} item(s) in my/the cart")
    public void iHaveItemsInMyCart(int arg0) {
    }

    @Given("I am at selecting payment method/step")
    public void iAmAtSelectingPaymentMethodStep() {
    }

    @When("I select pay by bank wire")
    public void iSelectPayByBankWire() {
    }

    @And("I confirm the order")
    public void iConfirmTheOrder() {
    }

    @Then("I am shown an order confirmation")
    public void iAmShownAnOrderConfirmation() {
    }

    @And("My cart is empty")
    public void myCartIsEmpty() {
    }

    @When("I select pay by check")
    public void iSelectPayByCheck() {
    }

    @And("My order should be logged with payment method {string}")
    public void myOrderShouldBeLoggedAsWithPaymentMethod(String arg0) {
    }
}
