package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage implements Login, StandardProcedures{
	WebDriver webDriver;
	By createEmail = By.id("email_create");
	By submitCreateAccount = By.id("SubmitCreate");
	By loginEmail = By.id("email");
	By loginPassword = By.id("passwd");
	By submitLogin = By.id("SubmitLogin");
	By logo = By.cssSelector(".logo");
	By checkout = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");


	public SignInPage(WebDriver webDriver){
		this.webDriver = webDriver;
	}

	public String getUrl(){
		return webDriver.getCurrentUrl();
	}

	public void enterEmailInCreateAccount(String email){
		webDriver.findElement(createEmail).sendKeys(email);
	}

	public void clickCreateAccount(){
		webDriver.findElement(submitCreateAccount).click();
	}

	public void createAccount(String email){
		enterEmailInCreateAccount(email);
		clickCreateAccount();
	}

	public void enterEmailInLogIn(String email){
		webDriver.findElement(loginEmail).sendKeys(email);
	}

	public void enterPasswordInLogIn(String password){
		webDriver.findElement(loginPassword).sendKeys(password);
	}

	public MyAccount clickSignIn(){
		webDriver.findElement(submitLogin).click();
		return new MyAccount(webDriver);
	}

	public MyAccount signIn(String email, String password){
		enterEmailInLogIn(email);
		enterPasswordInLogIn(password);
		return clickSignIn();
	}

	public HomePage clickLogo(){
		webDriver.findElement(logo).click();
		return new HomePage(webDriver);
	}

	public CheckoutSummary clickCheckout(){
		webDriver.findElement(checkout).click();
		return new CheckoutSummary(webDriver);
	}

	@Override
	public WebElement selectLoginEmail() {
		return null;
	}

	@Override
	public WebElement selectLoginPassword() {
		return null;
	}

	@Override
	public WebElement selectLoginButton() {
		return null;
	}

	@Override
	public MyAccount login(String username, String password) {
		return null;
	}
}
