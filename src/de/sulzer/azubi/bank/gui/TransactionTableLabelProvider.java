package de.sulzer.azubi.bank.gui;

import java.time.format.DateTimeFormatter;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.sulzer.azubi.bank.business.model.Account;
import de.sulzer.azubi.bank.business.model.Transaction;

public class TransactionTableLabelProvider extends LabelProvider implements ITableLabelProvider {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		return null;
	}

	@Override
	public String getColumnText(Object arg0, int arg1) {
		if (arg0 instanceof Transaction) {
			Transaction t = (Transaction) arg0;
			switch (arg1) {
			case 0:
				Account a = t.getSource();
				return a.getFirstName() + " " + a.getLastName();
			case 1:
				Account b = t.getTarget();
				return b.getFirstName() + " " + b.getLastName();
			case 2:
				return t.getUsage();
			case 3:
				return String.valueOf(t.getAmount());
			case 4:
				return String.valueOf(t.getTimestamp().format(FORMATTER));
			}
			return null;
		}
		return "";
	}

}
