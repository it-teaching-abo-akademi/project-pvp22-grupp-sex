package com.example.demo.GUI;

import com.example.demo.model.Order;
import com.example.demo.model.OrderLine;
import com.example.demo.model.OrderList;
import com.example.demo.model.Product;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CustomerViewController {

    private CustomerApplication ca;

    private Text t=new Text("15");
    private TextFlow toPayField = new TextFlow(t);


    public void registerView(CustomerApplication ca){
        this.ca=ca;
    }

    //test method. Doesn't work
    public void displayToPay(){
        Text t= new Text ("15");
        toPayField.getChildren().add(t);
    }

}
