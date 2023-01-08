package com.example.last_lab.test;

import org.junit.jupiter.api.Test;
import com.example.last_lab.client.ChildrenAccount;
import com.example.last_lab.client.Client;
import com.example.last_lab.accounts.Account;
import com.example.last_lab.client.ParentAccount;
import com.example.last_lab.exceptions.DepositException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChildrenParentAccount {
    private Client cl1 = new ParentAccount("Ionescu Ion", "Timisoara", Account.TYPE.EUR, "EUR124", 200.9).dateOfBirth("10 dec 2015").build();
    private Client children1=new ChildrenAccount("Ionescu Dan","Cluj", Account.TYPE.RON,"RON999",100).dateOfBirth("3 mai 2030").build();


    public ChildrenParentAccount() throws DepositException {
    }

    @Test
    void getAccount() throws DepositException {
        assertEquals("Account EUR [Account: code=PARENT_EUR124, amount=200.9]",cl1.getAccount("PARENT_EUR124").toString());
        assertEquals("Account RON [Account: code=CHILDREN_RON999, amount=100.0]",children1.getAccount("CHILDREN_RON999").toString());
    }
}
