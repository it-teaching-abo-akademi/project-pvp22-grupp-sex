package com.example.demo.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardReaderAPI {

    String operation;

    //base code for connecting to cardreader API
    public String useCardReader(String operation){
        String baseURL="http://localhost:9002/cardreader/";
        return baseURL+operation;
    }

}
