package de.sulzer.azubi.bank.business.impl;

public final class IdGenerator {
	
	private static Long ACCOUNTID = (long) 0;
	private static Long TRANSACTIONID = (long) 0;
	
	private IdGenerator() {}
	
	public static Long nextValAccount() {
		ACCOUNTID++;
		return ACCOUNTID;
	}
	
	public static Long nextValTrans() {
		TRANSACTIONID++;
		return TRANSACTIONID;
	}

}
