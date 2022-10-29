package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private String barcode;
    private String name;
    private int VAT;
    private double price;
    //private List<String> keyWords;

    public Product() {
    }

    public Product(String barcode, String name, int VAT, List<String> keyWords) {
        this.barcode = barcode;
        this.name = name;
        this.VAT = VAT;
        //this.keyWords = keyWords;

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

    //Barcode, Price
    /*Map<String, Double> pricemap;

    pricemap.get("111")
    pricemap.put("111", 29.0)
     */
}