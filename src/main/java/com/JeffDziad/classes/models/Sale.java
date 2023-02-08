package com.JeffDziad.classes.models;

import java.util.ArrayList;

public class Sale {

    private String name;
    private String location;
    private float salePrice;
    private float saleTax;
    private float saleShipping;

    public Sale(String name, String location, float salePrice, float saleTax) {
        this.name = name;
        this.location = location;
        this.salePrice = salePrice;
        this.saleTax = saleTax;
        this.saleShipping = 0;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public float getSaleTax() {
        return saleTax;
    }

    public float getSaleShipping() { return saleShipping; }

    public void setSaleShipping(float shippingAmount) {
        saleShipping = shippingAmount;
    }

    public float getSaleTotal() { return this.salePrice + this.saleTax + this.saleShipping; }

    public String toString() {
        return String.format("%s", "test");
    }

    public String[] toFieldArray() {
        return new String[]{ getName(), getLocation(), Float.toString(getSalePrice()), Float.toString(getSaleTax()), Float.toString(getSaleShipping()), };
    }
}
