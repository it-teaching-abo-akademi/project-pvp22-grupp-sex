package com.example.demo.api;

import com.example.demo.HttpController;
import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.RestController;
import com.github.underscore.*;

import java.net.http.HttpResponse;
import java.util.HashMap;

@RestController
public class ProductCatalogAPI {

    String operation;

    public String useCatalog(String operation) {
        String BaseURL="http://localhost:9003/rest/";
        return BaseURL+operation;
    }

    public Product getProductByBarcode(String barcode) {
        HttpResponse<String> response = HttpController.getRequest(useCatalog("findByBarCode/"+barcode));
        HashMap<String,Object> map = (HashMap<String, Object>) U.fromXmlMap(response.body());
        System.out.println(response);
        HashMap<String, Object> productMap = (HashMap<String, Object>) map.get("product");
        if(productMap == null) {
            noSuchProductError(barcode);
            return null;
        }
        else {
            System.out.println(map.get("product"));
            System.out.println(map);
            String name = String.valueOf(productMap.get("name"));
            return new Product(barcode, name);
        }
    }
    public void noSuchProductError(String barcode) {
        System.out.println("No product with barcode: " + barcode + " was found.");
    }
}
