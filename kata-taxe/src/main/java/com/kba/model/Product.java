package com.kba.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal price;
    private boolean isImported;
    private boolean isTaxExempt;

    public Product(String name, BigDecimal price, boolean isImported, boolean isTaxExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isTaxExempt = isTaxExempt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isTaxExempt() {
        return isTaxExempt;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        /*
        * setScale pour definir le nombre de chiffres après la virgule décimale
        * RoundingMode.HALF_UP, pour arrondir vers le haut le chiffre > 5 .
        */
        return name + " : " + price.setScale(2, RoundingMode.HALF_UP);
    }

}
