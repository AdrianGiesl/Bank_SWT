package de.sulzer.azubi.bank.gui;

import org.eclipse.jface.viewers.LabelProvider;

import de.sulzer.azubi.bank.gui.bundle.Language;

public class LanguageProvider extends LabelProvider {

	public String getText(Object element) {
		if (element instanceof Language) {
			Language current = (Language) element;

			return String.valueOf(current.getLanguage());
		}
		return null;
	}

}
