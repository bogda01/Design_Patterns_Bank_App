package com.example.last_lab.test;

import org.junit.jupiter.api.Test;
import com.example.last_lab.accounts.Account;
import com.example.last_lab.bank.Bank;
import com.example.last_lab.client.Client;
import org.junit.jupiter.api.Test;
import com.example.last_lab.bank.Bank;
import com.example.last_lab.client.Client;
import com.example.last_lab.accounts.Account;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.messages.Message;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    private Client c1=new Client.ClientBuilder("Dan Andrei","Iasi", Account.TYPE.RON,"RON555",1000).dateOfBirth("3rd of march 2005").build();
    Bank b1=Bank.getInstance("BT");

    public MessageTest() throws DepositException {
    }

    @Test
    void showMessage(){
        c1.sendMessage(b1,c1,"Hey");
        b1.sendMessage(b1,c1,"Hi");
        assertEquals(true, Message.getBankMessage());
        assertEquals(true,Message.getClientMessage());
    }
}
