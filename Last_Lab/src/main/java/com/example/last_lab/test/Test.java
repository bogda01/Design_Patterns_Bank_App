package com.example.last_lab.test;

import com.example.last_lab.accounts.Account;
import com.example.last_lab.accounts.AccountRON;
import com.example.last_lab.bank.Bank;
import com.example.last_lab.client.ChildrenAccount;
import com.example.last_lab.client.Client;
import com.example.last_lab.client.ParentAccount;
import com.example.last_lab.exceptions.DepositException;
import com.example.last_lab.exceptions.RetrieveException;

import javax.sql.rowset.serial.SQLOutputImpl;

public class Test {

	public static void main(String[] args) throws DepositException, RetrieveException {
		/**
		 * Create BCR bank with 2 clients
		 */
		Bank bcr = Bank.getInstance("BCR");
		// create client Ionescu with 2 accounts one in EUR and one in RON
		Client cl1 = new ParentAccount("Ionescu Ion", "Timisoara", Account.TYPE.EUR, "EUR124", 200.9).dateOfBirth("10 dec 2015").build();
		Client children1=new ChildrenAccount("Ionescu Dan","Cluj", Account.TYPE.RON,"RON999",100).dateOfBirth("3 mai 2030").build();
		bcr.addClient(cl1);
		bcr.addClient(children1);
		System.out.println("Date of birth cl1: "+cl1.getDateOfBirth());
		System.out.println("Date of birth children1: "+children1.getDateOfBirth());
		cl1.addAccount(Account.TYPE.RON, "RON1234", 400);
		cl1.sendMessage(bcr,cl1,"I lost my wallet");
		bcr.sendMessage(bcr,cl1,"We are very sorry to hear this. In order to cancel the account you will need to come and sign a few documents");
		// create client Marinecu with an account in RON
		Client cl2 = new Client.ClientBuilder("Marinescu Marin", "Timisoara", Account.TYPE.RON, "RON126", 100).build();
		bcr.addClient(cl2);
		System.out.println("Date of birth cl2: "+cl2.getDateOfBirth());
		System.out.println(bcr);

		/**
		 * Create bank CEC with one client
		 */
		Bank cec = Bank.getInstance("CEC");
		Client clientCEC = new Client.ClientBuilder("Vasilescu Vasile", "Brasov", Account.TYPE.EUR, "EUR128", 700).build();
		cec.addClient(clientCEC);
		System.out.println(cec);

		// deposit in account RON126 of client Marinescu
		Client cl = bcr.getClient("Marinescu Marin");
		if (cl != null) {
			cl.getAccount("RON126").deposit(400);
			System.out.println(cl);
		}

		// retrieve from account RON126 of Marinescu client
		if (cl != null) {
			cl.getAccount("RON126").retrieve(67);
			System.out.println(cl);
		}

		// transfer between accounts RON126 si RON1234
		AccountRON c1 = (AccountRON) cl.getAccount("RON126");
		AccountRON c2 = (AccountRON) bcr.getClient("Ionescu Ion").getAccount("RON1234");
		c1.transfer(c2, 40);
		System.out.println(bcr);

	}

}
