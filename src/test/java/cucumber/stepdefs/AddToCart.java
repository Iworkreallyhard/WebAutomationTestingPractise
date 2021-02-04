package cucumber.stepdefs;

import com.spartaglobal.pageobjectmodel.CheckoutSignInPage;
import com.spartaglobal.pageobjectmodel.CheckoutSummary;
import com.spartaglobal.pageobjectmodel.HomePage;
import com.spartaglobal.pageobjectmodel.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddToCart {

    private HomePage homePage;
    private SignInPage signInPage;
    private CheckoutSignInPage checkoutSignInPage;
    private CheckoutSummary checkoutSummary;

    private static WebDriver webDriver;

    @Given("the cart is empty")
    public void theCartIsEmpty() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        webDriver.findElement(By.className("ajax_cart_no_product"));
    }

    @When("I add {int} product")
    public void iAddProduct(int arg0) {
        webDriver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
        webDriver.findElement(By.id("quantity_wanted")).sendKeys(Keys.chord(Keys.BACK_SPACE, String.valueOf(arg0)));
        webDriver.findElement(By.id("add_to_cart")).click();
    }

    @Then("{int} more product is in the cart")
    public void moreProductIsInTheCart(int arg0) {
        WebDriverWait wait = new WebDriverWait(webDriver,1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ajax_cart_quantity")));
        String numOfProducts = webDriver.findElement(By.className("ajax_cart_quantity")).getText();
        Assertions.assertEquals(String.valueOf(arg0), numOfProducts);
    }

    @Given("the cart is not empty")
    public void theCartIsNotEmpty() {
        homePage = new HomePage(webDriver);
    }

    @When("I add {int} items of a product")
    public void iAddItemsOfAProduct(int arg0) {
    }

    @And("{int} more items are in the cart")
    public void moreItemsAreInTheCart(int arg0) {
    }

    @When("I click continue shopping button")
    public void iClickContinueShoppingButton() {
    }

    @Then("success message is closed")
    public void successMessageIsClosed() {
    }

    @When("I click proceed to checkout button")
    public void iClickProceedToCheckoutButton() {
    }

    @Then("I go to checkout")
    public void iGoToCheckout() {
    }

    @When("I click the remove button")
    public void iClickTheRemoveButton() {
    }

    @Then("the product is removed from the cart")
    public void theProductIsRemovedFromTheCart() {
    }

    @When("I click add")
    public void iClickAdd() {
    }

    @Then("product quantity is increased by {int}")
    public void productQuantityIsIncreasedBy(int arg0) {
    }

    @When("I click decrease")
    public void iClickDecrease() {
    }

    @Then("product quantity is decreased by {int}")
    public void productQuantityIsDecreasedBy(int arg0) {
    }

    @When("I click delete")
    public void iClickDelete() {
    }

    @Then("product is removed from the cart")
    public void productIsRemovedFromTheCart() {
    }

    @When("I hover over cart icon")
    public void iHoverOverCartIcon() {
    }

    @Then("I see contents of cart")
    public void iSeeContentsOfCart() {
    }

    @And("there is {int} item in cart")
    public void thereIsItemInCart(int arg0) {
    }

    @Then("I see shopping cart is empty message")
    public void iSeeShoppingCartIsEmptyMessage() {
    }

    @When("I close the browser")
    public void iCloseTheBrowser() {
    }

    @And("open the browser")
    public void openTheBrowser() {
    }

    @Then("I see items has not changed")
    public void iSeeItemsHasNotChanged() {
    }
}
