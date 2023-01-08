package com.example.last_lab.client;

import com.example.last_lab.accounts.Account;

public class ParentAccount extends Client.ClientBuilder {

    public ParentAccount(String name, String address, Account.TYPE type, String accountNumber, double sum) {
        super(name, address, type, accountNumber, sum);
        this.accountNumber="PARENT_"+accountNumber;
    }
}
