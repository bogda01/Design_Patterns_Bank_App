package com.example.last_lab.interfaces;

import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;

public interface Operations {
	public double getTotalAmount();

	public double getInterest();

	public void deposit(double amount) throws DepositException;

	public void retrieve(double amount) throws RetrieveException;
}
