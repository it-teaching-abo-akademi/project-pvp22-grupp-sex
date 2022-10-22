package com.example.demo.api;

import com.example.demo.HttpController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardReaderAPI {

    String operation;

    //base code for connecting to cardreader API
    public void useCardReader(String operation){
        String baseURL="http://localhost:9002/cardreader/";
        HttpController.postRequest(baseURL+operation);
    }
}
