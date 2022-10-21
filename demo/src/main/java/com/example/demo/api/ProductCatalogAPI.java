package com.example.demo.api;

import com.example.demo.HttpController;
import com.example.demo.model.Payment;
import org.springframework.web.bind.annotation.RestController;
import com.github.underscore.*;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductCatalogAPI {

    String operation;

    public String useCatalog(String operation) {
        String BaseURL="http://localhost:9003/rest/";
        return BaseURL+operation;
    }

    public void getProductByBarcode(String barcode) {
        HttpResponse<String> response = HttpController.getRequest(useCatalog("findByBarCode/"+barcode));
        HashMap<String,Object> map = (HashMap<String, Object>) U.fromXmlMap(response.body());
        HashMap<String, Object> productMap = (HashMap<String, Object>) map.get("product");
        System.out.println(productMap.get("name"));
        System.out.println(productMap.get("barCode"));
        System.out.println(map.get("product"));
        System.out.println(map);
        

        //createOrderLine(name, barcode, amount);
    }
}
