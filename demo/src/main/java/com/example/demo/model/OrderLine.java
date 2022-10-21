package com.example.demo.model;

public class OrderLine {
    private final String name;
    private final String barcode;
    private int quantity;
    private final String orderNumber;

    public OrderLine(String orderNumber, String barcode, int quantity, String name) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.barcode = barcode;
        this.quantity = quantity;
    }

    public OrderLine(String orderNumber, Product product) {
        this.orderNumber = orderNumber;
        this.name = product.getName();
        this.barcode = product.getBarcode();
        this.quantity = 1;
    }

    protected String getBarcode() {
        return barcode;
    }

    public String getLineInfo() {
        return name + ";" + barcode + ";" + quantity + ";" + orderNumber;
    }

    public void changeQuantity(int i) {
        this.quantity = i;
    }
}
