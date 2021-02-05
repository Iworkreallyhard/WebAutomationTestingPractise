package com.spartaglobal.pageobjectmodel.enums;

import org.openqa.selenium.By;

public enum ProductColor {
    WHITE("White"),
    BLACK("Black"),
    ORANGE("Orange"),
    BLUE("Blue"),
    BEIGE("Beige"),
    GREEN("Green"),
    YELLOW("Yellow"),
    PINK("Pink");

    private String color;

    ProductColor(String color){
        this.color = color;
    }

    public By getSelector(){
        return By.cssSelector("ul[id*='color_to_pick'] a[title='"+color+"']");
    }

    @Override
    public String toString() {
        return color;
    }
}
