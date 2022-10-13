package com.example.demo.model;


//class to represent one transaction, order or payment
public class Order {

    //price basically
    private String amount;

    public Order(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }
}
