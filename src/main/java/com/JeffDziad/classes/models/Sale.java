package com.JeffDziad.classes.models;

public class Sale {

    private String name;
    private String location;
    private float salePrice;
    private float saleTax;

    public Sale(String name, String location, float salePrice, float saleTax) {
        this.name = name;
        this.location = location;
        this.salePrice = salePrice;
        this.saleTax = saleTax;
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
}
