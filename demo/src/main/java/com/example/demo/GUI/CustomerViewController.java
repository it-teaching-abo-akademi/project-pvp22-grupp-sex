package com.example.demo.GUI;

import com.example.demo.dao.Command;
import com.example.demo.dao.Commands.AddNewOrderLineCommand;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerViewController implements Initializable {

    private CashierApplication ca;
    private CashierViewController cashierViewController;
    @FXML
    public Label toPayField;
    @FXML
    public TableView<OrderLine> customerTable;
    @FXML
    public TableColumn<OrderLine, Integer> cu_quantity;
    @FXML
    public TableColumn<OrderLine, String> cu_name;
    @FXML
    public TableColumn<OrderLine, Double> cu_price;

    public Label getToPayField() {
        return toPayField;
    }
    public TableView<OrderLine> getCustomerTable() {
        return customerTable;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cu_quantity.setCellValueFactory( new PropertyValueFactory<OrderLine, Integer>("quantity"));
        cu_name.setCellValueFactory( new PropertyValueFactory<OrderLine, String>("name"));
        cu_price.setCellValueFactory( new PropertyValueFactory<OrderLine, Double>("price"));
    }
    public void executeCommand(Command command) {
        command.execute();
    }
    /*
    @FXML
    public void addLineToCustomerTable(Order currentOrder, OrderLine ol) {
        executeCommand(new AddNewOrderLineCommand(customerTable, currentOrder, ol));
    }
    */
    public void registerController(CashierViewController cashierViewController){
        this.cashierViewController = cashierViewController;
    }
}
