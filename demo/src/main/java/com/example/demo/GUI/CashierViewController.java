package com.example.demo.GUI;

import com.example.demo.api.CashBoxAPI;
import com.example.demo.api.ProductCatalogAPI;
import com.example.demo.dao.Command;
import com.example.demo.dao.Commands.AddNewOrderLineCommand;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLine;
import com.example.demo.model.Product;
import com.example.demo.service.CardReaderService;
import com.example.demo.service.CashBoxService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CashierViewController implements Initializable {

    private CashierApplication ca;
    private final Order currentOrder;

    private CashBoxService cashBoxService;
    private final CardReaderService cardReaderService;
    @FXML
    public TextFlow searchResultField;
    @FXML
    public TableView<OrderLine> orderTable;
    @FXML
    public TableColumn<OrderLine, Integer> quantity;
    @FXML
    public TableColumn<OrderLine, String> name;
    @FXML
    public TableColumn<OrderLine, Double> price;
    @FXML
    public TextField enterBar;
    @FXML
    public TextField searchForProduct;
    @FXML
    public TextField productQuantity;

    public CashierViewController() {
        this.cardReaderService = new CardReaderService();
        this.currentOrder = new Order("1");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        quantity.setCellValueFactory( new PropertyValueFactory<OrderLine, Integer>("quantity"));
        name.setCellValueFactory( new PropertyValueFactory<OrderLine, String>("name"));
        price.setCellValueFactory( new PropertyValueFactory<OrderLine, Double>("price"));
    }

    public void registerView(CashierApplication ca){
        this.ca=ca;
    }
    public Order getCurrentOrder() {
        return currentOrder;
    }
    public void executeCommand(Command command) {
        command.execute();
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

    //input from GUI: Manually typed barcode
    //Takes a (list) from product catalog and returns matching product(s)
    //adds product(s) to currentOrder and updates GUI table
    @FXML
    public void getBarcode(ActionEvent event) throws IOException{
        ProductCatalogAPI pcAPI = new ProductCatalogAPI();
        Product product = pcAPI.getProductByBarcode(enterBar.getText());
        if(product != null) {
            addProductToSale(product);
        }
    }

    public void addProductToSale(Product product) {
        String orderNum = currentOrder.getOrderNumber();
        OrderLine ol = new OrderLine(orderNum, product);
        setProductQuantity(ol);
        executeCommand(new AddNewOrderLineCommand(orderTable, currentOrder, ol));
        System.out.println("current order number " + orderNum);
    }

    private void setProductQuantity(OrderLine ol) {
        if(!productQuantity.getText().isEmpty()) {
            System.out.println(productQuantity.getText());
            ol.changeQuantity(Integer.parseInt(productQuantity.getText()));
        }
    }
}