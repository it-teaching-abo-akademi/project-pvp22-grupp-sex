package com.example.demo.GUI;

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
}
