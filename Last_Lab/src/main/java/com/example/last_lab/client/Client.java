package com.example.last_lab.client;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.last_lab.accounts.Account;
import com.example.last_lab.accounts.Account.TYPE;
import com.example.last_lab.accounts.AccountEURO;
import com.example.last_lab.accounts.AccountFactory;
import com.example.last_lab.accounts.AccountRON;
import com.example.last_lab.bank.Bank;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.messages.Message;

public class Client {
	public static final int MAX_ACCOUNT_NUMBER = 5;

	private String name;
	private String address;

	private ArrayList<Account> accounts;

	private String dateOfBirth;

	public Client(ClientBuilder clientBuilder) throws DepositException {
		this.name = clientBuilder.name;
		this.address = clientBuilder.address;
		this.dateOfBirth=clientBuilder.dateOfBirth;
		accounts = new ArrayList<>();
		addAccount(clientBuilder.type, clientBuilder.accountNumber, clientBuilder.sum);
	}

	public void addAccount(TYPE type, String accountNumber, double sum) throws DepositException {
		Account c;
		AccountFactory accountFactory = new AccountFactory();
		c = accountFactory.createAccount(accountNumber, sum, type);
		accounts.add(c);
	}

	public Account getAccount(String accountCode)  {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber().equals(accountCode)) {
				return accounts.get(i);
			}
		}
		return null;
	}

	public void sendMessage(Bank bank, Client client, String message){
		Message.clientSendsMessage(bank,client,message);
	}

	@Override
	public String toString() {
		return "\n\tClient [name=" + name +", birthdate= "+dateOfBirth+ ", address="+ address + ", accounts=" + accounts + "]";
	}

	public String getName() {
		return name;
	}

	//setters are commented for immutability

//	public void setName(String name) {
//		this.name = name;
//	}

	public String getAddress() {
		return address;
	}

//	public void setAddress(String address) {
//		this.address = address;
//	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

//	public void setDateOfBirth(String dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}

	public static class ClientBuilder {

		public static final int MAX_ACCOUNT_NUMBER = 5;

		public String name;
		public String address;

		public String dateOfBirth; //not mandatory

		public String accountNumber;

		public  double sum;

		public TYPE type;

		public ClientBuilder(String name, String address, TYPE type, String accountNumber, double sum) {
			this.name = name;
			this.address = address;
			this.type = type;
			this.accountNumber = accountNumber;
			this.sum = sum;
		}

		public ClientBuilder dateOfBirth(String dateOfBirth) {
			this.dateOfBirth=dateOfBirth;
			return this;
		}

		public Client build() throws DepositException {
			Client client=new Client(this);
			return client;
		}
	}
}
