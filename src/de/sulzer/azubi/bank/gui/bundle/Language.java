package de.sulzer.azubi.bank.gui.bundle;

import java.util.Locale;

public enum Language {

	GERMAN("DE", Locale.GERMAN),
	ENGLISH("EN", Locale.ENGLISH),
	CHINESE("ZH", Locale.CHINESE),
	SPAIN("ES", Locale.forLanguageTag("es-ES"));

	private String language;
	private Locale locale;

	private Language(String language, Locale locale) {
		this.language = language;
		this.locale = locale;
	}

	public String getLanguage() {
		return language;
	}

	public Locale getLocale() {
		return locale;
	}

}
