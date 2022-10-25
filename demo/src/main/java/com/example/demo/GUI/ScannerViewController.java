package com.example.demo.GUI;

import com.example.demo.api.ProductCatalogAPI;
import com.example.demo.model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ScannerViewController {

    public ScannerViewController(){
    }
    public void openScanner() throws IOException {
        Stage scanner = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(CashierApplication.class.getResource("/scanner-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 150);

        scanner.setTitle("Barcode Scanner");
        scanner.setScene(scene);
        scanner.show();

        //FXMLLoader cashierGuiLoader = new FXMLLoader()
    }
    @FXML
    public TextField barcodeScan;
    @FXML
    public void addProductToSale(KeyEvent keyEvent) {
        ProductCatalogAPI pcAPI = new ProductCatalogAPI();
        Product product = pcAPI.getProductByBarcode(barcodeScan.getText());
    }

}
