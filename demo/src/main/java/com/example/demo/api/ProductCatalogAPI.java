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
        String BaseURL = "http://localhost:9003/rest/";
        return BaseURL + operation;
    }

    public Product getProductByBarcode(String barcode) {
        HttpResponse<String> response = HttpController.getRequest(useCatalog("findByBarCode/" + barcode));
        HashMap<String, Object> map = (HashMap<String, Object>) U.fromXmlMap(response.body());
        System.out.println(response);
        HashMap<String, Object> productMap = (HashMap<String, Object>) map.get("product");
        if (productMap == null) {
            noSuchProductErrorBarcode(barcode);
            return null;
        } else {
            System.out.println(map.get("product"));
            System.out.println(map);
            String name = String.valueOf(productMap.get("name"));
            return new Product(barcode, name);
        }
    }

    public void noSuchProductErrorBarcode(String barcode) {
        System.out.println("No product with barcode: " + barcode + " was found.");
    }

    public void noSuchProductErrorText(String name) {
        System.out.println("No product with name or keyword: " + name + " was found.");
    }

    public Product getProductByName(String text) {
        HttpResponse<String> response = HttpController.getRequest(useCatalog("findByName/" + text));
        HashMap<String, Object> map = (HashMap<String, Object>) U.fromXmlMap(response.body());
        System.out.println(response);
        HashMap<String, Object> productsMap = (HashMap<String, Object>) map.get("products");
        HashMap<String, Object> productMap = (HashMap<String, Object>) productsMap.get("product");
        if (productMap == null) {

            HttpResponse<String> response2 = HttpController.getRequest(useCatalog("findByKeyword/" + text));
            HashMap<String, Object> map2 = (HashMap<String, Object>) U.fromXmlMap(response2.body());
            System.out.println(response2);
            HashMap<String, Object> productsMap2 = (HashMap<String, Object>) map2.get("products");
            HashMap<String, Object> productMap2 = (HashMap<String, Object>) productsMap2.get("product");
            if (productMap2 == null) {
                noSuchProductErrorText(text);
                return null;
            }
            System.out.println(map2.get("product"));
            System.out.println(map2);
            String barcode = String.valueOf(productMap2.get("barCode"));
            String name = String.valueOf(productMap2.get("name"));
            return new Product(barcode, name);
        } else {
            System.out.println(map.get("product"));
            System.out.println(map);
            String barcode = String.valueOf(productMap.get("barCode"));
            String name = String.valueOf(productMap.get("name"));
            return new Product(barcode, name);
        }
    }
}
