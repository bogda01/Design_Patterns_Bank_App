package com.example.last_lab.test;

import org.junit.jupiter.api.Test;
import com.example.last_lab.accounts.AccountEURO;
import com.example.last_lab.accounts.AccountRON;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private double amount = 400;
    AccountRON accountRON;
    AccountEURO accountEURO;

    AccountTest() throws DepositException {
        accountEURO=new AccountEURO("EUR444",200);
        accountRON=new AccountRON("RON666",700);
    }

    @Test
    void getTotalAmount() {
        assertEquals(200+200*0.01,accountEURO.getTotalAmount());
        assertEquals(700+700*0.08,accountRON.getTotalAmount());
    }

    @Test
    void deposit() throws DepositException {
        accountEURO.deposit(100);
        accountRON.deposit(300);
        assertEquals(303,accountEURO.getTotalAmount());
        assertEquals(1080,accountRON.getTotalAmount());
    }

    @Test
    void retrieve() throws RetrieveException {
        accountRON.retrieve(50);
        accountEURO.retrieve(100);
        assertEquals(101,accountEURO.getTotalAmount());
        assertEquals(702,accountRON.getTotalAmount());
    }

    @Test
    void getAccountNumber() {
        assertEquals("EUR444",accountEURO.getAccountNumber());
        assertEquals("RON666",accountRON.getAccountNumber());
    }
}