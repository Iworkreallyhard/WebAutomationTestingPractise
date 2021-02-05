package com.spartaglobal.pageobjectmodel.enums;

import org.openqa.selenium.By;

public enum ProductSize {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L");

    private String title;

    ProductSize(String title){
        this.title = title;
    }

    public By getSelector(){
        return By.cssSelector("option[title='"+title+"']");
    }

    @Override
    public String toString() {
        return title;
    }
}
