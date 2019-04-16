package de.sulzer.azubi.bank.gui;

import org.eclipse.jface.viewers.LabelProvider;

import de.sulzer.azubi.bank.business.model.Account;

public class ComboLabelProvider extends LabelProvider {

	public String getText(Object element) {
		if (element instanceof Account) {
			Account current = (Account) element;

			return current.getLastName() + " " + current.getFirstName();

		}
		return null;
	}

}
