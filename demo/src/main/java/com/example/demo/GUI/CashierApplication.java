package com.example.demo.GUI;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CashierApplication extends Application {

    private static CashierViewController cashvc;
    private static CustomerViewController custvc;

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

            //open customer gui as well while you're at it
            Stage secondaryStage=new Stage();
            secondaryStage.setTitle("Customer View");
            secondaryStage.setScene(scene2);
            secondaryStage.show();

            cashvc.registerView(this);

            primaryStage.setTitle("Cashier View");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

