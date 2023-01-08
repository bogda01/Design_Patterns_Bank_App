package com.example.last_lab.test;

import org.junit.jupiter.api.Test;
import com.example.last_lab.bank.Bank;
import com.example.last_lab.client.Client;
import com.example.last_lab.accounts.Account;
import com.example.last_lab.exceptions.DepositException;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Client c1=new Client.ClientBuilder("Mircea Razvan","Cluj", Account.TYPE.EUR,"EUR333",107).build();
    Bank b1=Bank.getInstance("BT");

    BankTest() throws DepositException {
    }

    @Test
    void addClient() {
        b1.addClient(c1);
        assertEquals(c1,b1.getClient("Mircea Razvan"));
    }

    //didn't add getClient because we checked the function at addClient
}