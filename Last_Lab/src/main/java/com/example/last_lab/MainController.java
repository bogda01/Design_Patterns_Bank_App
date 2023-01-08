package com.example.last_lab;

import com.example.last_lab.accounts.Account;
import com.example.last_lab.accounts.AccountEURO;
import com.example.last_lab.accounts.AccountRON;
import com.example.last_lab.bank.Bank;
import com.example.last_lab.client.ChildrenAccount;
import com.example.last_lab.client.Client;
import com.example.last_lab.client.ParentAccount;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    Label label_bank;
    @FXML
    Label label_username;
    @FXML
    private Button button_send;
    @FXML
    private Button button_add;
    @FXML
    Label label_balance;
    @FXML
    private TextField tf_receiver;
    @FXML
    private TextField tf_send;
    @FXML
    private TextField tf_add;

    private Bank bcr;
    private Client cl1;
    private Client children1;
    private AccountEURO c1;
    private AccountEURO c2;

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }



    public void setLabel_bank(Bank bcr){label_bank.setText(bcr.getBankCode());}

    public void setLabel_username(Client cl){label_username.setText(cl.getName());}

    public void setLabel_balance(AccountEURO accountEURO){label_balance.setText(String.valueOf(accountEURO.getTotalAmount()));}

    //checks if input is a numeric value

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bcr = Bank.getInstance("BCR");
        // create client Ionescu with 2 accounts one in EUR and one in RON
        try {
            cl1 = new ParentAccount("Ionescu Ion", "Timisoara", Account.TYPE.EUR, "EUR124", 200.9).dateOfBirth("10 dec 2015").build();
        } catch (DepositException e) {
            throw new RuntimeException(e);
        }
        try {
            children1=new ChildrenAccount("Ionescu Dan","Cluj", Account.TYPE.EUR,"EUR999",100).dateOfBirth("3 mai 2030").build();
        } catch (DepositException e) {
            throw new RuntimeException(e);
        }
        bcr.addClient(cl1);
        bcr.addClient(children1);
        c1=(AccountEURO) cl1.getAccount("PARENT_EUR124");
        c2=(AccountEURO) children1.getAccount("CHILDREN_EUR999");
        System.out.println(c1);
        System.out.println(bcr);
        System.out.println(bcr.getBankCode());
        setLabel_bank(bcr);
        setLabel_balance(c1);
        setLabel_username(cl1);

        button_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    add_money(tf_add.getText());
                    System.out.println(bcr);
                } catch (DepositException e) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The deposited sum is smaller than 0. Please deposit a sum bigger than 0");
                    alert.show();
                    throw new RuntimeException(e);
                }
                setLabel_balance(c1);
            }
        });

        button_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(children1.getAccount(tf_receiver.getText())!=null) {
                    try {
                        send_money(tf_send.getText());
                    } catch (DepositException e) {
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The deposited sum is smaller than 0. Please deposit a sum bigger than 0");
                        alert.show();
                        throw new RuntimeException(e);
                    } catch (RetrieveException e) {
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The retrieved sum is either bigger than the available funds or a negative amounts was written");
                        alert.show();
                        throw new RuntimeException(e);
                    }
                    System.out.println(bcr);
                    setLabel_balance(c1);
                }
                else{
                    System.out.println("Account Code does not exist");
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please type a valid account code");
                    alert.show();
                }
            }
        });
    }

    private void add_money(String amount) throws DepositException {
        if(isDouble(amount)){
            double x=Double.parseDouble(amount);
            c1.deposit(x);
        }
        else{
            System.out.println("Add money format incorrect");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please type a valid amount");
            alert.show();
        }
    }

    private void send_money(String amount) throws DepositException, RetrieveException {
        if(isDouble(amount)){
            double x=Double.parseDouble(amount);
            c2.transfer(c1,x);
        }
        else{
            System.out.println("Add money format incorrect");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please type a valid amount");
            alert.show();
        }
    }

    private boolean isDouble(String numb) {
        if(numb==null)
            return false;
        try{
            double x=Double.parseDouble(numb);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}