package com.example.demo.model;

public class OrderLine {
    private String name;
    private String barcode;
    private int quantity;
    private String orderNumber;

    public OrderLine(String name, String barcode, int quantity, String orderNumber) {
        this.name = name;
        this.barcode = barcode;
        this.quantity = quantity;
        this.orderNumber = orderNumber;
    }

    protected String getBarcode() {
        return barcode;
    }
}
