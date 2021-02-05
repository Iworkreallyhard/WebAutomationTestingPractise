package com.spartaglobal.pageobjectmodel;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BrowserUtility {

    public static void resizeWindow(WebDriver webDriver, int width, int height){
        Dimension dimension = new Dimension(width,height);
        webDriver.manage().window().setSize(dimension);
    }

    public static void fullscreenWindow(WebDriver webDriver){
        webDriver.manage().window().fullscreen();
    }

    public static void setImplicitWay(WebDriver webDriver, long milliseconds){
        webDriver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }
}
