package com.example.demo.GUI;

import com.example.demo.api.CashBoxAPI;
import com.example.demo.api.ProductCatalogAPI;
import com.example.demo.model.Order;
import com.example.demo.service.CardReaderService;
import com.example.demo.service.CashBoxService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class CashierViewController {

    private CashierApplication ca;
    private Order order;
    private CashBoxService cashBoxService;
    private CardReaderService cardReaderService;
    private TextFlow searchResultField;

    public CashierViewController() {
        this.cardReaderService = new CardReaderService();
    }

    public void registerView(CashierApplication ca){
        this.ca=ca;
    }

    public void addThirtyDiscount(MouseEvent mouseEvent) {
        // return Payment.getPrice()*0.7;
    }


    public void addFiftyDiscount(MouseEvent mouseEvent) {
        // Payment.getPrice();
    }

    public void addSeventyDiscount(MouseEvent mouseEvent) {
        // Payment.getPrice();
    }

    public void barcodeSearchResults(KeyEvent keyEvent, String amount) {
        //input from GUI: Manually typed barcode
        //Takes a (list) from product catalog and returns matching product(s)
        //adds product(s) to shopping cart
        //if implementable, preferably first shows products and then you can add them by clicking
        //CashierController.barcodeSearchResults(keyEvent, amount);
    }

    public void displayShoppingCart(){
        //gets all data about products to both GUI:s
    }

    public void productSearchResults(KeyEvent keyEvent) {
        //input from GUI: Manual product search field
    }

    public void withdrawAmountFromTotal(MouseEvent mouseEvent) {
        //return Payment.calculateToPay()- InputScanner.keyboardInput();
        //substitutes the keyboard input from the total fee of the checkout.
        // if the input doesnt equal the fee, theres either change to be given back or more to pay
        // should return double
    }

    public void addProductToTable(MouseEvent mouseEvent) {
    }

    public void barcodeSearchResults(KeyEvent keyEvent) {
    }

    //if cashbox is closed, open it. Else, do nothing.
    public void openCashbox(MouseEvent mouseEvent) {
        CashBoxAPI cashAPI = new CashBoxAPI();
        cashAPI.openCashbox();
    }

    //start by resetting card reader to idle
    //then call waitforpayment
    //wait until customer has completed payment (or failed to do so) and return the result
    public void cardPayment(MouseEvent mouseEvent) {
        cardReaderService.resetCardReader();
        cardReaderService.waitForPayment("40");
        /*while(cardReaderService.getStatus()=="WAITING_FOR_PAYMENT"){
            ;
        }
        if (cardReaderService.getStatus()=="IDLE"){
            return "No transaction taking place here officer";
        }
        return cardReaderService.getResult();

         */
    }

    public void abortPayment(MouseEvent mouseEvent) {
        /*if (cardReaderService.getStatus()=="WAITING_FOR_PAYMENT") {
            cardReaderService.abortPayment();
        }

         */
    }

    public void OpenScanner(MouseEvent mouseEvent) throws IOException {
        ScannerViewController scanvc = new ScannerViewController();
        scanvc.openScanner();
    }

    @FXML
    public TextField enterBar;

    @FXML
    public TextField searchForProduct;
    @FXML
    public void getBarcode(ActionEvent event) throws IOException{
        ProductCatalogAPI pcAPI = new ProductCatalogAPI();
        pcAPI.getProductByBarcode(enterBar.getText());
    }
}
