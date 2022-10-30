package com.example.demo.GUI;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CashierApplication extends Application {

    Stage appStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        setAppStage(primaryStage);
        //register both guis
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cashier-view.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/customer-view.fxml"));
        //FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("/scanner-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 623, 404);
        Scene scene2 = new Scene(fxmlLoader2.load(), 600, 440);
        //fxmlLoader3.load();

        CashierViewController cashvc = fxmlLoader.getController();
        CustomerViewController custvc = fxmlLoader2.getController();
        //ScannerViewController scanvc = fxmlLoader3.getController();

        //cash<->cust
        cashvc.registerController(custvc);
        custvc.registerController(cashvc);

        cashvc.registerView(this);

        //cash<->scanner
        /*
        scanvc.registerController(cashvc);
        cashvc.registerController(scanvc);
         */

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

    public void setAppStage(Stage appStage) {
        this.appStage = appStage;
    }

    public Stage getAppStage() {
        return appStage;
    }
}
