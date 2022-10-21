package com.example.demo.model;

import java.util.List;

public class Product {
    private String barcode;
    private String name;
    private int VAT;
    private List<String> keyWords;

    public Product(String barcode, String name, int VAT, List<String> keyWords) {
        this.barcode = barcode;
        this.name = name;
        this.VAT = VAT;
        this.keyWords = keyWords;
    }

    public Product(String barcode, String name) {
        this.barcode = barcode;
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }
}
