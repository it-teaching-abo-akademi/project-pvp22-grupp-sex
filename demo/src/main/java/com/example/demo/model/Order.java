package com.example.demo.model;


import java.util.ArrayList;
import java.util.Optional;

//class to represent one transaction, order or payment
public class Order {

    private String orderNumber;
    //price basically
    private double orderTotal;
    private ArrayList<OrderLine> orderLineList;

    public Order(double orderTotal) {
        this.orderTotal = orderTotal;
        this.orderLineList = new ArrayList<>();
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void addOrderLine(OrderLine ol) {
        orderLineList.add(ol);
    }

    public void removeOrderLine(OrderLine ol) {
        orderLineList.remove(ol);
    }
    public void removeOrderLineByBarcode(String barcode) {
        Optional<OrderLine> olToRemove = orderLineList.stream().filter(o -> o.getBarcode().equals(barcode)).findFirst();
        if(olToRemove.isPresent()) {
            orderLineList.remove(olToRemove);
        }
    }

    public String getCurrentOrderNumber() {
        return orderNumber;
    }
}
