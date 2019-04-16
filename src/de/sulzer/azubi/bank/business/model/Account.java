package de.sulzer.azubi.bank.business.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Account.
 */
public class Account {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDateTime birthday;
	private String address;
	private String postal;
	private Double balance;
	private List<Transaction> transactions = new ArrayList<>();

	
	public Account() { transactions = new ArrayList<>();}
	
	public Account(String firstName, String lastName, Long id, String address, String postal, LocalDateTime birthday,
			Double balance, List<Transaction> transactions) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.address = address;
		this.postal = postal;
		this.birthday = birthday;
		this.balance = balance;
		this.transactions = transactions;
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name.
	 *
	 * @param firstName the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name.
	 *
	 * @param lastName the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets birthday.
	 *
	 * @return the birthday
	 */
	public LocalDateTime getBirthday() {
		return birthday;
	}

	/**
	 * Sets birthday.
	 *
	 * @param birthday the birthday
	 */
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets address.
	 *
	 * @param address the address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * Gets transactions.
	 *
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * Sets transactions.
	 *
	 * @param transactions the transactions
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
