package com.example.demo.model;

public class Payment {
    public int getPrice(Integer barcode) {
        if (barcode == 12345) {
            return 12;
        }else{
            return 0;
        }
    }
}
