package com.example.demo.api;

import com.example.demo.HttpController;
import org.springframework.web.bind.annotation.RestController;
import com.github.underscore.*;

import java.net.http.HttpResponse;
import java.util.Map;

@RestController
public class ProductCatalogAPI {

    String operation;

    public String useCatalog(String operation) {
        String BaseURL="http://localhost:9003/rest/";
        return BaseURL+operation;
    }

    public void getProductByBarcode(String barcode) {
        HttpResponse<String> response = HttpController.getRequest(useCatalog("findByBarCode/420"));
    }
}
