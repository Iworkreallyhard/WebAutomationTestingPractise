package com.spartaglobal.pageobjectmodel.enums;

public enum Product_ID {

    T_SHIRT("product_1_1_0_0"),
    BLOUSE("product_2_7_0_0"),
    PRINTED_DRESS_1("product_3_13_0_0"),
    PRINTED_DRESS_2("product_4_16_0_0"),
    PRINTED_SUMMER_DRESS_1("product_5_19_0_0"),
    PRINTED_SUMMER_DRESS_2("product_6_31_0_0"),
    PRINTED_CHIFFON("product_7_34_0_0");

    private String product_ID;

    Product_ID(String product_ID) {
        this.product_ID = product_ID;
    }

    @Override
    public String toString() {
        return product_ID;
    }

}
