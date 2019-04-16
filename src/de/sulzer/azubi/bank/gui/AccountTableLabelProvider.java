package de.sulzer.azubi.bank.gui;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.sulzer.azubi.bank.business.model.Account;

public class AccountTableLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		return null;
	}

	@Override
	public String getColumnText(Object arg0, int i) {
		if (arg0 instanceof Account) {
			Account a = (Account) arg0;
			switch (i) {
			case 0:
				return a.getFirstName() + " " + a.getLastName();
			case 1:
				return String.valueOf(a.getId());
			case 2:
				return String.valueOf(a.getBalance());
			}
			return null;
		}
		return "";
	}

}
