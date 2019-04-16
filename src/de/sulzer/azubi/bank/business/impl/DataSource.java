package de.sulzer.azubi.bank.business.impl;

import java.time.LocalDateTime;
import java.util.List;

import de.sulzer.azubi.bank.business.model.Account;
import de.sulzer.azubi.bank.business.model.Transaction;

public interface DataSource {

	Account getAccount(Long id);

	Account saveAccount(Account account);

	void deleteAccount(Account account);

	void transfer(Account source, Transaction transaction);

	Account addAccount(Account a);

	void addAccount(String firstName, String lastName, String address, String postal, LocalDateTime birthday, Double balance);

	List<Account> getAccounts();

}
