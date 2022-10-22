package com.example.demo.model;

import javax.persistence.*;

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
    private String price;

    public Product() {
    }

    public Product(String barcode, String price) {
        this.barcode = barcode;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getPrice() {
        return price;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "Barcode=" + barcode +
                ", Price='" + price +
                '}';
    }

}
