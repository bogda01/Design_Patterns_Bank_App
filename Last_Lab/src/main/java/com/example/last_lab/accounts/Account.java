package com.example.last_lab.accounts;

import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;
import com.example.last_lab.interfaces.Operations;

public abstract class Account implements Operations {

	protected String accountCode = null;
	protected double amount = 0;

	public static enum TYPE {
		EUR, RON
	};

	protected Account(String accountNumber, double balance) throws DepositException {
		this.accountCode = accountNumber;
		deposit(balance);
	}

	@Override
	public double getTotalAmount() {

		return amount + amount * getInterest();
	}

	@Override
	public void deposit(double sum) throws DepositException{
		if(sum>0)
			this.amount += sum;
		else
			throw new DepositException("The deposited sum is smaller than 0. Please deposit a sum bigger than 0");
	}

	@Override
	public void retrieve(double sum) throws RetrieveException {
		if(sum<=amount && sum>0)
			this.amount -= sum;
		else
			throw new RetrieveException("The retrieved sum is either bigger than the available funds or a negative amounts was written");
	}

	public String toString() {
		return "Account: code=" + accountCode + ", amount=" + amount;
	}

	public String getAccountNumber() {
		return accountCode;
	}

}
