package com.example.last_lab;

import com.example.last_lab.accounts.Account;
import com.example.last_lab.accounts.AccountRON;
import com.example.last_lab.bank.Bank;
import com.example.last_lab.client.ChildrenAccount;
import com.example.last_lab.client.Client;
import com.example.last_lab.client.ParentAccount;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("client.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws DepositException, RetrieveException {
        launch();
    }
}