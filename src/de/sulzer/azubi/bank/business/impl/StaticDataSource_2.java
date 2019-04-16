package de.sulzer.azubi.bank.business.impl;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import de.sulzer.azubi.bank.business.model.Account;
import de.sulzer.azubi.bank.business.model.Transaction;

public class StaticDataSource_2 implements DataSource{
	
	private List<Account> accounts = new ArrayList<>();
	
	public StaticDataSource_2() {
		addAccount("Thomas", "Müller", "Straße 123", "12345", LocalDateTime.now(), 2000.00);
		addAccount("Daniel", "Düsentrieb", "Straße 321", "54321", LocalDateTime.now(), 5000.00);
	}
	
	@Override
	public Account getAccount(Long id) {
		for (Account acc : accounts) {
			if (acc.getId() == id) {
				return acc;
			}
		}
		return null;
	}

	@Override
	public Account addAccount(Account a) {
		if (getAccount(a.getId()) == null) {
			if(a.getId() == null) {
				a.setId(IdGenerator.nextValAccount());
			}
			accounts.add(a);
		}
		return a;
	}

	@Override
	public Account saveAccount(Account account) {
		return account;
	}

	@Override
	public void deleteAccount(Account account) {
		accounts.remove(account);
	}

	@Override
	public void transfer(Account source, Transaction transaction) {
		transaction.setId(IdGenerator.nextValTrans());
		transaction.setTimestamp(LocalDateTime.now());
		transaction.setSource(source);

		source.getTransactions().add(transaction);
		transaction.getTarget().getTransactions().add(transaction);

		source.setBalance(source.getBalance() - transaction.getAmount());
		transaction.getTarget().setBalance(transaction.getTarget().getBalance() + transaction.getAmount());
	}

	@Override
	public List<Account> getAccounts() {
		return accounts;
	}

	@Override
	public void addAccount(String firstName, String lastName, String address, String postal, LocalDateTime birthday,
			Double balance) {
		Account account = new Account(firstName, lastName, IdGenerator.nextValAccount(), address, postal, birthday, balance, new ArrayList<>());
		addAccount(account);
	}

}
