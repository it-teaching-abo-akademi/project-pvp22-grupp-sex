package com.example.demo.api;

import com.example.demo.HttpController;
import com.example.demo.model.Product;
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
        System.out.println(HttpController.postRequest(baseURL+operation));
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

    public void getCardReaderResult(String operation){
        HttpResponse<String> response = HttpController.getRequest(useCardReaderGet("result"));
        System.out.println(response);
        HashMap<String, Object> map = (HashMap<String, Object>) U.fromXmlMap(response.body());
        System.out.println(map);
        HashMap<String, Object> ResultMap = (HashMap<String, Object>) map.get("result");
        System.out.println(ResultMap);
        String name = String.valueOf(ResultMap.get("bonusState"));
        System.out.println(name);
        //return new name;
    }

    public String getCardReaderStatus(){
        HttpResponse<String> response = HttpController.getRequest(useCardReaderGet("status"));
        System.out.println(response.body());
        return response.body();

    }
}
