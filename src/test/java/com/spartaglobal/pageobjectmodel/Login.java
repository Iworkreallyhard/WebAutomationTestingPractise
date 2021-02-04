package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.WebElement;

public interface Login {
    WebElement selectLoginEmail(); //select the textBox for login email

    WebElement selectLoginPassword(); //select the textBox for login password

    WebElement selectLoginButton(); //select the login button

    MyAccount login(String username, String password); //fill login fields and click on button
}
