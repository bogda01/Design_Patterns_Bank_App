package com.example.last_lab.test;

import org.junit.jupiter.api.Test;
import com.example.last_lab.client.Client;
import com.example.last_lab.accounts.Account;
import com.example.last_lab.exceptions.DepositException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {
    private Client c1=new Client.ClientBuilder("Dan Andrei","Iasi", Account.TYPE.RON,"RON555",1000).dateOfBirth("3rd of march 2005").build();
    private Client c2=new Client.ClientBuilder("Dan Andrei","Iasi", Account.TYPE.RON,"RON555",1000).build();


    ClientTest() throws DepositException {
    }

    @Test
    void addAccount() throws DepositException {
        c1.addAccount(Account.TYPE.EUR,"EUR444",200);
        assertEquals("Account EUR [Account: code=EUR444, amount=200.0]",c1.getAccount("EUR444").toString());
    }

    @Test
    void getAccount() {
        assertEquals("Account RON [Account: code=RON555, amount=1000.0]",c1.getAccount("RON555").toString());
    }

    @Test
    void getName() {
        assertEquals("Dan Andrei",c1.getName());
    }

    @Test
    void getDateOfBirth() {
        assertEquals("3rd of march 2005",c1.getDateOfBirth());
        assertEquals(null,c2.getDateOfBirth());
    }

//    @Test
//    void setName() {
//        c1.setName("Razvan Mircea");
//        assertEquals("Razvan Mircea",c1.getName());
//    }
}