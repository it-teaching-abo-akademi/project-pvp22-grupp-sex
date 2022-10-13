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
    public CardReaderService(CardReaderAPI cardReaderAPI) {
        this.cardReaderAPI = cardReaderAPI;
    }

    //methods to connect API with UI controller

    @GetMapping
    public String getStatus() {
        return cardReaderAPI.useCardReader("status");
    }

    @GetMapping
    public String getResult() {
        return cardReaderAPI.useCardReader("result");
    }

    @PostMapping
    public void resetCardReader() {
        cardReaderAPI.useCardReader("reset");
    }

    @PostMapping
    public void abortPayment() {
        cardReaderAPI.useCardReader("abort");
    }

    @PostMapping
    public void waitForPayment(String amount) {
        cardReaderAPI.useCardReader("waitForPayment/?"+amount);
    }
}
