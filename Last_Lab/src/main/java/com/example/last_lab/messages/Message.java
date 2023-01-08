package com.example.last_lab.messages;

import com.example.last_lab.bank.Bank;
import com.example.last_lab.client.Client;

import java.util.Date;

public class Message {


    private static Boolean bankMessage;
    private static Boolean clientMessage;

    public static void bankSendsMessage(Bank bank, Client client, String message){
        bankMessage=false;
        System.out.println("Message to "+client.getName()+'\n'+new Date().toString() + " [" + bank.getBankCode()+ "] : " + message);
        bankMessage=true;
    }

    public static void clientSendsMessage(Bank bank, Client client, String message){
        clientMessage=false;
        System.out.println("Message to "+bank.getBankCode()+'\n'+new Date().toString() + " [" + client.getName()+ "] : " + message);
        clientMessage=true;
    }

    public static Boolean getBankMessage() {
        return bankMessage;
    }

    public static Boolean getClientMessage() {
        return clientMessage;
    }
}
