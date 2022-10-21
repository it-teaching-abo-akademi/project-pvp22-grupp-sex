package com.example.demo.model;

import java.util.Map;

public class OrderList {
    private Map<Integer, Order> orderList;
    private Order currentOrder;

    public Map<Integer, Order> getOrderList() {
        return orderList;
    }

    public String getCurrentOrderNumber() {
        if (currentOrder == null) {
            return null;
        }
        return currentOrder.getCurrentOrderNumber();
    }

    public void addToCurrentOrder(OrderLine ol) {
        currentOrder.addOrderLine(ol);
    }

    private void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
