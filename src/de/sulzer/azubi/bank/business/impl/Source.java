package de.sulzer.azubi.bank.business.impl;

public enum Source {
	
	Raiffeisenbank("Raiffeisenbank", 1),
	Sparkasse("Sparkasse", 2);
	
	private String bank;
	private int numbre;
	
	private Source(String bank, int numbre) {
		this.bank = bank;
		this.numbre = numbre;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getNumbre() {
		return numbre;
	}

	public void setNumbre(int numbre) {
		this.numbre = numbre;
	}

}
