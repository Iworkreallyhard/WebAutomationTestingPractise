package cucumber.stepdefs;

import com.spartaglobal.pageobjectmodel.*;
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
    private ItemPage itemPage;

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
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ajax_cart_quantity")));
        String numOfProducts = webDriver.findElement(By.className("ajax_cart_quantity")).getText();
        Assertions.assertEquals(String.valueOf(arg0), numOfProducts);
    }

    @Given("the cart is not empty")
    public void theCartIsNotEmpty() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        webDriver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_wanted")));
        webDriver.findElement(By.id("quantity_wanted")).sendKeys(Keys.chord(Keys.BACK_SPACE,"1"));
        webDriver.findElement(By.id("add_to_cart")).click();
        itemPage = new ItemPage(webDriver);
        webDriver.findElement(By.cssSelector("img[class*='logo']")).click();
        webDriver.findElement(By.className("ajax_cart_quantity"));
    }

    @When("I add {int} items of a product")
    public void iAddItemsOfAProduct(int arg0) {

        webDriver.findElement(By.id("quantity_wanted")).sendKeys(Keys.chord(Keys.BACK_SPACE, String.valueOf(arg0)));
        webDriver.findElement(By.id("add_to_cart")).click();
    }

    @And("{int} more items are in the cart")
    public void moreItemsAreInTheCart(int arg0) {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ajax_cart_quantity")));
        String numOfProducts = webDriver.findElement(By.className("ajax_cart_quantity")).getText();
        Assertions.assertEquals(String.valueOf(arg0), numOfProducts);
        //nk
    }

    @When("I click continue shopping button")
    public void iClickContinueShoppingButton() {
        itemPage.continueShopping();
       // webDriver.findElement(By.className("continue btn btn-default button exclusive-medium")).click();
    }

    @Then("success message is closed")
    public void successMessageIsClosed() {
        itemPage.selectX();
     //   webDriver.findElement(By.className("cross")).click();
       // webDriver.findElement(By.linkText("Close window")).click();
    }

    @When("I click proceed to checkout button")
    public void iClickProceedToCheckoutButton() {
        webDriver.findElement(By.className("btn btn-default button button-medium")).click();
    }

    @Then("I go to checkout")
    public void iGoToCheckout() {
        //should take to shopping cart summary page
        checkoutSummary = new CheckoutSummary(webDriver);
    }

    @When("I click the remove button")
    public void iClickTheRemoveButton() {
        /* drop down from shopping cart different from shopping cart summary*/
    }

    @Then("the product is removed from the cart")
    public void theProductIsRemovedFromTheCart() {
    }

    @When("I click add")
    public void iClickAdd() {
        checkoutSummary.clickIncreaseQuantityOneProduct();
    }

    @Then("product quantity is increased by {int}")
    public void productQuantityIsIncreasedBy(int arg0) {
        checkoutSummary.insertQuantityIntoBox((String.valueOf(arg0)));
        //remove form-control grey potentially
        //webDriver.findElement(By.className("cart_quantity_input form-control grey")).sendKeys(Keys.chord(Keys.BACK_SPACE,String.valueOf(arg0)));
    }

    @When("I click decrease")
    public void iClickDecrease() {
        checkoutSummary.clickDecreaseQuantityOneProduct();
    }

    @Then("product quantity is decreased by {int}")
    public void productQuantityIsDecreasedBy(int arg0) {
        webDriver.findElement(By.className("cart_quantity_input form-control grey")).sendKeys(Keys.chord(Keys.BACK_SPACE,String.valueOf(arg0)));
    }

    @When("I click delete")
    public void iClickDelete() {
        checkoutSummary.clickTrashOneProduct();
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
        webDriver.close();
    }

    @And("open the browser")
    public void openTheBrowser() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
    }

    @Then("I see items has not changed")
    public void iSeeItemsHasNotChanged() {
    }
}
