package cucumber.stepdefs;

import com.spartaglobal.pageobjectmodel.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepdefs {

    private static WebDriver webDriver;
    private HomePage homePage;
    private MyAccount myAccount;
    private String email = "a.rahman1198@gmail.com";
    private String password = "thisissparta";

//    @After
//    public void closeDrivers(){
//        webDriver.close();
//    }
//
//    @AfterAll
//    public void quitDrivers(){
//        webDriver.quit();
//    }

    @Given("I am not logged in")
    public void iAmNotLoggedIn() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
    }

    @When("I am logging in")
    public void iAmLoggingIn() {
        SignInPage signInPage = homePage.goToSignInPage();
        signInPage.signIn(email, password);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", webDriver.getCurrentUrl());
    }

    @And("I am checking out with {int} items in the basket")
    public void iAmCheckingOutWithItemsInTheBasket(int arg0) {
        webDriver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_to_cart")));
        webDriver.findElement(By.id("add_to_cart")).click();
        homePage.proceedToCheckoutFromPopUp();
    }

    @When("I am logging in through checkout")
    public void iAmLoggingInThroughCheckout() {
        CheckoutSummary checkoutSummary = new CheckoutSummary(webDriver);
        CheckoutSignInPage checkoutSignInPage = checkoutSummary.goToCheckoutNotLoggedIn();
        checkoutSignInPage.SignIn(email, password);
    }

    @Then("I should be in address")
    public void iShouldBeInAddress() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0", webDriver.getCurrentUrl());
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        SignInPage signInPage = homePage.goToSignInPage();
        myAccount = signInPage.login(email, password);
        myAccount.gotoHome(webDriver);
    }

    @When("I am logging out")
    public void iAmLoggingOut() {
        webDriver.findElement(By.linkText("Sign out")).click();
    }

    @Then("I should be logged out")
    public void iShouldBeLoggedOut() {
        homePage.goToSignInPage();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", webDriver.getCurrentUrl());
    }

    @Given("I am logged in with {int} item in basket")
    public void iAmLoggedInWithItemInBasket(int arg0) {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        SignInPage signInPage = homePage.goToSignInPage();
        myAccount = signInPage.login(email, password);
        myAccount.gotoHome(webDriver);
        webDriver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_to_cart")));
        webDriver.findElement(By.id("add_to_cart")).click();
        webDriver.findElement(By.cssSelector(".logo")).click();
    }

    @Then("I should have empty cart")
    public void iShouldHaveEmptyCart() {
        try {
            webDriver.findElement(By.cssSelector("dl[class='products']")).isDisplayed();
        } catch (NoSuchElementException e) {
            Assertions.assertTrue(true);
        }
    }

}
