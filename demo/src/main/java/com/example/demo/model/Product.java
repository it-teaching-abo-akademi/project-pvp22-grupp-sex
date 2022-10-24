package com.example.demo.model;

import java.util.List;

public class Product {
    private String barcode;
    private String name;
    private int VAT;
    private double price;
    private List<String> keyWords;

    public Product(String barcode, String name, int VAT, List<String> keyWords) {
        this.barcode = barcode;
        this.name = name;
        this.VAT = VAT;
        this.keyWords = keyWords;

        setPrice();
    }

    public Product(String barcode, String name) {
        this.barcode = barcode;
        this.name = name;
        setPrice();
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        switch (barcode) {
            case "111" -> this.price = 9.99;
            case "222" -> this.price = 19.99;
            case "333" -> this.price = 29.99;
            case "420" -> this.price = 39.99;
        }
    }

}