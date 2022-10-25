package com.example.demo.service;

import com.example.demo.api.CardReaderAPI;

public class CardReaderService {

    private final CardReaderAPI cardReaderAPI;

    public CardReaderService() {
        this.cardReaderAPI = new CardReaderAPI();
    }

    //methods to connect API with UI controller


    public String getStatus() {
        return cardReaderAPI.getCardReaderStatus();
    }

    public void getResult() {
        cardReaderAPI.getCardReaderResult("result");
    }


    public void resetCardReader() {
        cardReaderAPI.resetCardReader();
    }

    public void abortPayment() {
        cardReaderAPI.abortPayment();
    }

    public void waitForPayment(String amount) {
        cardReaderAPI.waitForPayment(amount);
    }
}
