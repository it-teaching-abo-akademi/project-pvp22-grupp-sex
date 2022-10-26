package com.example.demo.GUI;

import com.example.demo.api.CashBoxAPI;
import com.example.demo.api.ProductCatalogAPI;
import com.example.demo.api.ProductController;
import com.example.demo.dao.Command;
import com.example.demo.dao.Commands.AddNewOrderLineCommand;
import com.example.demo.dao.Commands.RemoveOrderLineCommand;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CashierViewController implements Initializable {

    @FXML
    public Label toPayLabel;
    @FXML
    public Label statusLabel;
    @FXML
    public Label bonusCardLabel;
    @FXML
    public TextField cashInput;
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
    private double cashPayed;
    private double tempTotal;

    private double totalPrice1;

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
        System.out.println("test");
        System.out.println(toPayLabel.getText());
        System.out.println(currentOrder.getOrderLineSet());

        cashPayed = Double.parseDouble(cashInput.getText());
        tempTotal = Double.parseDouble(toPayLabel.getText());
        toPayLabel.setText(Double.toString(round(tempTotal-cashPayed,2)));
    }


    public void addFiftyDiscount(MouseEvent mouseEvent) {
        // return Payment.getPrice()*0.5;
    }

    public void addSeventyDiscount(MouseEvent mouseEvent) {
        // return Payment.getPrice()*0.3;
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

    //start by resetting card reader to idle
    //then call waitforpayment
    //wait until customer has completed payment (or failed to do so) and return the result
    public void cardPayment(MouseEvent mouseEvent){
        cardReaderService.resetCardReader();
        cardReaderService.waitForPayment(toPayLabel.getText());
        String status = cardReaderService.getStatus();
        while (status=="WAITING_FOR_PAYMENT") {

        }
        if (cardReaderService.getStatus()=="IDLE"){
            System.out.println("No transaction taking place");
        }
        else {
            cardReaderService.getResult();
        }
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

    public void cashPayed(ActionEvent event){
        cashPayed = Double.parseDouble(cashInput.getText());
        tempTotal = Double.parseDouble(toPayLabel.getText());
        toPayLabel.setText(Double.toString(round(tempTotal-cashPayed,2)));
        CashBoxAPI cashAPI = new CashBoxAPI();
        cashAPI.openCashbox();

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    public double getCash(){
        return cashPayed;
    }


    public void abortPayment(MouseEvent mouseEvent) {
        if (cardReaderService.getStatus()=="WAITING_FOR_PAYMENT") {
            cardReaderService.abortPayment();
        }
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
    public void getProductByName(ActionEvent event) throws IOException {
        ProductCatalogAPI pcAPI = new ProductCatalogAPI();
        Product product = pcAPI.getProductByName(searchForProduct.getText());
        if (product != null) {
            addProductToSale(product);
        }
    }

    public void addProductToSale(Product product) {
        String orderNum = currentOrder.getOrderNumber();
        OrderLine ol = new OrderLine(orderNum, product);
        setProductQuantity(ol);
        totalPrice1 += ol.getTotalPrice();
        toPayLabel.setText(Double.toString(round(totalPrice1,2)));
        executeCommand(new AddNewOrderLineCommand(orderTable, currentOrder, ol));
    }

    @FXML
    public void removeProductFromSale(KeyEvent event) throws IOException {
        //orderTable.getItems().clear();
        if (event.getCode() == KeyCode.DELETE) {
            executeCommand(new RemoveOrderLineCommand(orderTable, currentOrder));
        }
    }

    private void setProductQuantity(OrderLine ol) {
        if(!productQuantity.getText().isEmpty()) {
            System.out.println(productQuantity.getText());
            ol.changeQuantity(Integer.parseInt(productQuantity.getText()));
        }
    }
}