package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount implements StandardProcedures{
	WebDriver webDriver;
	By homeButton = By.linkText("Home");
	By logo = By.cssSelector(".logo");

	public MyAccount(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public HomePage clickHomeButton(){
		webDriver.findElement(homeButton).click();
		return new HomePage(webDriver);
	}

	public HomePage clickLogo(){
		webDriver.findElement(logo).click();
		return new HomePage(webDriver);
	}

	@Override
	public WebElement selectCart() {
		return webDriver.findElement(By.cssSelector("a[title*='shopping cart']"));
	}

	@Override
	public WebElement selectLogo() {
		return webDriver.findElement(logo);
	}

	@Override
	public HomePage gotoHome(WebDriver webDriver) {
		selectLogo().click();
		return new HomePage(webDriver);
	}

	@Override
	public CheckoutSummary gotoCart(WebDriver webDriver) {
		selectCart().click();
		return new CheckoutSummary(webDriver);
	}
}
