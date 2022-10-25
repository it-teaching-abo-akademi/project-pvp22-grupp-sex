package com.example.demo.service;

import com.example.demo.api.CardReaderAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CardReaderService {

    private final CardReaderAPI cardReaderAPI;

    @Autowired
    public CardReaderService() {
        this.cardReaderAPI = new CardReaderAPI();
    }

    //methods to connect API with UI controller

    @GetMapping
    public void getStatus() {
        cardReaderAPI.getCardReaderStatus();
    }

    @GetMapping
    public void getResult() {
        cardReaderAPI.getCardReaderResult("result");
    }

    @PostMapping
    public void resetCardReader() {
        cardReaderAPI.resetCardReader();
    }

    @PostMapping
    public void abortPayment() {
        cardReaderAPI.abortPayment();
    }

    @PostMapping
    public void waitForPayment(String amount) {
        cardReaderAPI.waitForPayment(amount);
    }
}
