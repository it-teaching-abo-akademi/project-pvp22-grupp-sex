package com.example.demo.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ScannerViewController {

    public void openScanner() throws IOException {
        Stage scanner = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(CashierApplication.class.getResource("/scanner-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 150);

        scanner.setTitle("Barcode Scanner");
        scanner.setScene(scene);
        scanner.show();
    }


    @FXML
    public TextField scanBarcode;
    @FXML
    public void addProductToSale(KeyEvent keyEvent) {
    }
}
