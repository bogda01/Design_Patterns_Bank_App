package com.example.last_lab.accounts;

import com.example.last_lab.accounts.Account;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;
import com.example.last_lab.interfaces.Transfer;

public class AccountEURO extends Account implements Transfer {

	public AccountEURO(String accountNumber, double sum) throws DepositException {
		super(accountNumber, sum);
	}

	public double getInterest() {
		return 0.01;

	}

	@Override
	public String toString() {
		return "Account EUR [" + super.toString() + "]";
	}

	@Override
	public void transfer(Account c, double s) throws DepositException, RetrieveException {
		c.retrieve(s);
		deposit(s);
	}
}
