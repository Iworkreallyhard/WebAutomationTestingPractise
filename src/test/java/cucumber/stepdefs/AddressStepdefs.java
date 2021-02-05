package cucumber.stepdefs;

import com.spartaglobal.pageobjectmodel.AddressPage;
import com.spartaglobal.pageobjectmodel.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AddressStepdefs {
	WebDriver webDriver;
	Properties properties = new Properties();
	AddressPage addressPage;
	private String username;
	private String password;
	private final boolean headless = true;

	@Given("I have logged in and checking out with a product")
	public void iHaveLoggedInAndCheckingOutWithAProduct() {
		try {
			properties.load(new FileReader("src/test/resources/login.properties"));
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(headless) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			webDriver = new ChromeDriver(chromeOptions);
		}else {
			webDriver = new ChromeDriver();
		}

		webDriver.manage().window().setSize(new Dimension(1100,2500));
		HomePage homepage = new HomePage(webDriver);
		homepage.goToSignInPage().login(username,password).gotoHome(webDriver).addTShirtToCart();
		addressPage = homepage.gotoCheckout(webDriver).goToCheckoutLoggedIn();

	}


	@When("I click update address")
	public void iClickUpdateAddress() {
		addressPage.clickUpdateButton();
	}

	@Then("I should be redirected to update address page")
	public void iShouldBeRedirectedToUpdateAddressPage() {

		Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=address&back=order.php%3Fstep%3D1&id_address"));
	}

	@When("I choose a different address")
	public void iChooseADifferentAddress() {
		addressPage.getAddressDropDown().selectByVisibleText("New address");

	}

	@Then("my address should change")
	public void myAddressShouldChange() {
		Assertions.assertEquals("New address", addressPage.getAddressDropDown().getFirstSelectedOption().getText().trim());
	}

	@When("I uncheck using same delivery address checkbox")
	public void iUncheckUsingSameDeliveryAddressCheckbox() {
		addressPage.clickCheckbox();
	}

	@Then("I should have different delivery and billing addresses")
	public void iShouldHaveDifferentDeliveryAndBillingAddresses() {
		Assertions.assertNotEquals(addressPage.getFirstLineOfAddress().getText(), addressPage.getBillingAddress().getText());

	}

	@When("I click proceed to checkout")
	public void iClickProceedToCheckout() {
		addressPage.goToCheckout();
	}

	@Then("I should be redirected to Shipping")
	public void iShouldBeRedirectedToShipping() {
		Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
	}
}
