package com.example.last_lab.bank;

import com.example.last_lab.client.Client;
import com.example.last_lab.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private final static int MAX_CLIENTS_NUMBER = 100;
	private List<Client> clients;
	private int clientsNumber;



	private String bankCode = null;

	private static Bank bankInstance=null;


	public static Bank getInstance(String bankCode_){
		if(bankInstance == null){
			synchronized (Bank.class){
				if(bankInstance == null){
					bankInstance = new Bank(bankCode_);
				}
			}
		}
		return bankInstance;
	}
	private Bank(String bankCode) {
		this.bankCode = bankCode;
		clients=new ArrayList<>();
	}

	public void addClient(Client c) {
		clients.add(c);
	}

	
	public Client getClient(String name) {
		for (Client client:clients) {
			if (client.getName().equals(name)) {
				return client;
			}
		}
		return null;
	}
	public String getBankCode() {
		return bankCode;
	}

	public void sendMessage(Bank bank, Client client, String message){
		Message.bankSendsMessage(bank,client,message);
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder("Bank [code="+bankCode+ ", clients=\n");
		for(Client client: clients)
			stringBuilder.append(client.toString()+"\n");
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
