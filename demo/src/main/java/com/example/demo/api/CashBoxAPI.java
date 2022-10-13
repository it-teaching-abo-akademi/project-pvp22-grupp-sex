package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashBoxAPI {

    private String operation;

    //base code for connecting to cashbox API
    public String useCashBox(String operation){
        String BaseURL="http://localhost:9001/cashbox/";
        return BaseURL+operation;
    }

}
