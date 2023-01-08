package com.example.last_lab.accounts;

import com.example.last_lab.exceptions.DepositException;

public class AccountFactory {
    public Account createAccount(String accountNumber, double sum, Account.TYPE type) throws DepositException {

        if(type==Account.TYPE.EUR){
            return new AccountEURO(accountNumber, sum);
        }
        if(type==Account.TYPE.RON){
            return new AccountRON(accountNumber, sum);
        }

        return null;
    }
}
