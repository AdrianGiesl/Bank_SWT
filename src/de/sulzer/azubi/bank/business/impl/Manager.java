package de.sulzer.azubi.bank.business.impl;

import java.time.LocalDateTime;
import java.util.List;

import de.sulzer.azubi.bank.business.model.Account;
import de.sulzer.azubi.bank.business.model.Transaction;

public class Manager {

	private static Manager INSTANCE;
	private DataSource dataSource;

	public static Manager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Manager();
		}
		return INSTANCE;
	}

	private Manager() {
		this.dataSource = new StaticDataSource();
	}

	public Account getAccount(Long id) {
		return dataSource.getAccount(id);
	}

	public Account addAccount(Account a) {
		if (getAccount(a.getId()) == null) {
			dataSource.addAccount(a);
		}
		return a;
	}

	public Account saveAccount(Account account) {
		return dataSource.saveAccount(account);
	}

	public void deleteAccount(Account account) {
		dataSource.deleteAccount(account);
	}

	public void transfer(Account source, Transaction transaction) {
		dataSource.transfer(source, transaction);
	}

	public void addAccount(String firstName, String lastName, Long id, String address, String postal,
			LocalDateTime birthday, Double balance) {
		dataSource.addAccount(firstName, lastName, address, postal, birthday, balance);
	}

	public List<Account> getAccounts() {
		return dataSource.getAccounts();
	}
}
