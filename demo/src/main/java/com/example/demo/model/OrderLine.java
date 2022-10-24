package com.example.demo.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class OrderLine {
    private final String name;
    private final String barcode;
    private int quantity;
    private double price;
    private double totalPrice;
    private final String orderNumber;

    private SimpleIntegerProperty tableQuantity;
    private SimpleStringProperty tableName;
    private SimpleDoubleProperty tablePrice;
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
        this.price = product.getPrice();
        this.quantity = 1;
        this.tableName = new SimpleStringProperty(name);
        this.tablePrice = new SimpleDoubleProperty(price);
        this.tableQuantity = new SimpleIntegerProperty(quantity);
    }

    public String getBarcode() {
        return barcode;
    }

    public int getQuantity() {
        return quantity;
    }
    public void changeQuantity(int i) {
        this.quantity = i;
        this.tableQuantity = new SimpleIntegerProperty(i);
        this.totalPrice = quantity * price;
    }

    public SimpleDoubleProperty priceProperty() {
        return tablePrice;
    }

    public SimpleStringProperty nameProperty() {
        System.out.println(tableName.get());
        return tableName;
    }

    public SimpleIntegerProperty quantityProperty() {
        return tableQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
