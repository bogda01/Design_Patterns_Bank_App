package com.example.last_lab.interfaces;

import com.example.last_lab.accounts.Account;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;

public interface Transfer {
	public void transfer(Account c, double s) throws DepositException, RetrieveException;
}
