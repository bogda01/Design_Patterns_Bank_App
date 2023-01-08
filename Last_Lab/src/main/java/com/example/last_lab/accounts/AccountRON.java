package com.example.last_lab.accounts;

import com.example.last_lab.accounts.Account;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;
import com.example.last_lab.interfaces.Transfer;

public class AccountRON extends Account implements Transfer {


	public AccountRON(String accountNumber, double balance) throws DepositException {
		super(accountNumber, balance);
	}

	public double getInterest() {
		if (amount < 500)
			return 0.03;
		else
			return 0.08;

	}

	@Override
	public String toString() {
		return "Account RON [" + super.toString() + "]";
	}

	@Override
	public void transfer(Account c, double s) throws DepositException, RetrieveException {
		c.retrieve(s);
		deposit(s);
	}
}
