package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSignInPage implements Login{
    WebDriver webDriver;
    By createEmail = By.id("email_create");
    By submitCreateAccount = By.id("SubmitCreate");
    By loginEmail = By.id("email");
    By loginPassword = By.id("passwd");
    By submitLogin = By.id("SubmitLogin");
    By logo = By.cssSelector(".logo");

    By accountName = By.cssSelector(".account");

    public CheckoutSignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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

    public AddressPage clickSignIn(){
        webDriver.findElement(submitLogin).click();
        return new AddressPage(webDriver);
    }

    public AddressPage SignIn(String email, String password){
        enterEmailInLogIn(email);
        enterPasswordInLogIn(password);
        return clickSignIn();
    }

    public HomePage clickLogo(){
        webDriver.findElement(logo).click();
        return new HomePage(webDriver);
    }

    public AddressPage ifSignedIn(){
        if(webDriver.findElements(accountName).size() != 0){
            return new AddressPage(webDriver);
        }
        return null;
    }


}
