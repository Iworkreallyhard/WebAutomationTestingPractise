package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {
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



}
