package com.example.last_lab.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.last_lab.accounts.AccountRON;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;

import static org.junit.jupiter.api.Assertions.*;

class AccountRONTest {

    AccountRON accountRON;
    private double amount = 600;

    AccountRONTest() throws DepositException {
        accountRON=new AccountRON("RON666",700);
    }

    @Test
    void getInterest() {
        assertEquals(0.08,accountRON.getInterest());
    }

    @Test
    void transfer() throws DepositException, RetrieveException {
        accountRON.transfer(accountRON,100);
        assertEquals(700+700*8/100,accountRON.getTotalAmount());
    }
}