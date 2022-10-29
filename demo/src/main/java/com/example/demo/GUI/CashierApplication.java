package com.example.demo.GUI;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CashierApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //register both guis
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cashier-view.fxml"));

        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/customer-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 623, 404);
        Scene scene2 = new Scene(fxmlLoader2.load(), 600, 440);
        CashierViewController cashvc=fxmlLoader.getController();
        CustomerViewController custvc= fxmlLoader2.getController();

        cashvc.registerController(custvc);
        custvc.registerController(cashvc);

        try {

            //open customer gui as well while you're at it
            Stage secondaryStage=new Stage();
            secondaryStage.setTitle("Customer View");
            secondaryStage.setScene(scene2);
            secondaryStage.show();



            primaryStage.setTitle("Cashier View");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
