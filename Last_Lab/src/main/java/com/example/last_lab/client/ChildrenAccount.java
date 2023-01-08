package com.example.last_lab.client;

import com.example.last_lab.accounts.Account;
import com.example.last_lab.exceptions.DepositException;

public class ChildrenAccount extends Client.ClientBuilder {

    public ChildrenAccount(String name, String address, Account.TYPE type, String accountNumber, double sum) {
        super(name, address, type, accountNumber, sum);
        this.accountNumber="CHILDREN_"+accountNumber;
    }

    //mai trebuie tostring schimbat si adaugat alte beneficii(inca o metoda care sa faca ceva)
}
