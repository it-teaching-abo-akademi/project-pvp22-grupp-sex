package com.example.demo.GUI;

import com.example.demo.api.CashBoxAPI;
import com.example.demo.service.CashBoxService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class CashierApplication extends Application {

    private static CashierViewController cashvc;
    private static CustomerViewController custvc;
    private CustomerApplication custapp;

    public static void main(String[] args) {
        cashvc = new CashierViewController();
        custvc = new CustomerViewController();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //register both guis
        FXMLLoader fxmlLoader = new FXMLLoader(CashierApplication.class.getResource("/cashier-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 623, 404);

        FXMLLoader fxmlLoader2 = new FXMLLoader(CustomerApplication.class.getResource("/customer-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load(), 600, 440);
        
        try {
            cashvc.registerView(this);

            primaryStage.setTitle("Cashier View");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            custvc.registerView(custapp);

            //open customer gui as well while you're at it
            Stage secondaryStage=new Stage();
            secondaryStage.setTitle("Customer View");
            secondaryStage.setScene(scene2);
            secondaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public CashierViewController getCashvc() {
        return cashvc;
    }
}

