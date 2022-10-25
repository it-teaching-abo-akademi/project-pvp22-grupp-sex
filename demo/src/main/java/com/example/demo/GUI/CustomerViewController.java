package com.example.demo.GUI;

import com.example.demo.model.OrderLine;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CustomerViewController {

    private CashierApplication ca;

    private Text t=new Text("15");
    private TextFlow toPayField = new TextFlow(t);

    public void registerView(CashierApplication ca){
        this.ca=ca;
    }

    //test method. Doesn't work
    public void displayToPay(){
        Text t= new Text ("15");
        toPayField.getChildren().add(t);
    }
    @FXML
    public TableView<OrderLine> customerTable;
    @FXML
    public void addLineToCustomerTable(OrderLine ol) {
        customerTable.getItems().add(ol);
    }
}
