package com.example.demo.api;

import com.example.demo.HttpController;
import com.github.underscore.U;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.HashMap;

@RestController
public class CardReaderAPI {

    String operation;

    //base code for connecting to cardreader API
    public void useCardReaderPost(String operation){
        String baseURL="http://localhost:9002/cardreader/";
        HttpController.postRequest(baseURL+operation);
    }

    public String useCardReaderGet(String operation){
        String baseURL="http://localhost:9002/cardreader/";
        return baseURL+operation;
    }

    public void resetCardReader(){
        useCardReaderPost("reset");
    }


    public void abortPayment(){
        useCardReaderPost("abort");
    }

    public void waitForPayment(String amount){
        useCardReaderPost("waitForPayment/?"+amount);
    }

    public HttpResponse<String> getCardReaderResult(String operation){
        HttpResponse<String> response = HttpController.getRequest(useCardReaderGet("result"));
        return response;
    }

    public void getCardReaderStatus(){
        HttpResponse<String> response = HttpController.getRequest(useCardReaderGet("status"));

    }
}
