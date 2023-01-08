package com.example.last_lab.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.last_lab.accounts.AccountEURO;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;

import static org.junit.jupiter.api.Assertions.*;

class AccountEUROTest {

    AccountEURO accountEURO;

    AccountEUROTest() throws DepositException {
        accountEURO=new AccountEURO("EUR444",200);
    }

    @Test
    void getInterest() {
        assertEquals(0.01,accountEURO.getInterest());
    }

    @Test
    void transfer() throws DepositException, RetrieveException {
        accountEURO.transfer(accountEURO,100);
        assertEquals(200+200*0.01,accountEURO.getTotalAmount());
    }
}