package com.example.demo.GUI;

import com.example.demo.api.ProductCatalogAPI;
import com.example.demo.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ScannerViewController {

    @FXML
    public TextField barcodeScan;
    //private Observer cashvc;
    private CashierViewController cashierViewController;
    private CashierApplication ca;

    public ScannerViewController(){
    }
    public void openScanner() throws IOException {
        Stage scanner = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(CashierApplication.class.getResource("/scanner-view.fxml"));
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/cashier-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 300, 150);
        fxmlLoader1.load();

        CashierViewController cashvc = fxmlLoader1.getController();

        this.registerController(cashvc);
        cashvc.registerController(this);

        saveCashierController(cashierViewController);
        System.out.println(cashierViewController);



        scanner.setTitle("Barcode Scanner");
        scanner.setScene(scene);
        scanner.show();
    }
    @FXML
    public void addProductToSale(ActionEvent event) throws IOException {
        System.out.println("test");
        ProductCatalogAPI pcAPI = new ProductCatalogAPI();
        Product product = pcAPI.getProductByBarcode(barcodeScan.getText());
        if(product != null) {
            System.out.println(cashierViewController);
            cashierViewController.addProductToSale(product);
        }
    }

    public void registerController(CashierViewController cashierViewController) {
        System.out.println(cashierViewController);
        this.cashierViewController = cashierViewController;
    }

    public void saveCashierController(CashierViewController cashierViewController){
        this.cashierViewController = cashierViewController;
    }

    public TextField getBarcodeScan() {
        return barcodeScan;
    }
}
