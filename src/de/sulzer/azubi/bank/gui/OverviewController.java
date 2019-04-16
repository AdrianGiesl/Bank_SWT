package de.sulzer.azubi.bank.gui;

import java.time.format.DateTimeFormatter;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;

import de.sulzer.azubi.bank.business.impl.Manager;
import de.sulzer.azubi.bank.business.model.Account;
import de.sulzer.azubi.bank.business.model.Transaction;
import de.sulzer.azubi.bank.gui.bundle.I18NHelper;
import de.sulzer.azubi.bank.gui.bundle.Language;

public class OverviewController {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private Overview overview;

	public OverviewController(Overview overview) {
		this.overview = overview;
	}

	public void setup() {
		overview.getAccountTable().setInput(Manager.getInstance().getAccounts());
		overview.getAccountTable().setLabelProvider(new AccountTableLabelProvider());
		overview.getTransactionTable().setLabelProvider(new TransactionTableLabelProvider());
		overview.getComboLanguage().setInput(Language.values());
		overview.getComboLanguage().setSelection(new StructuredSelection(I18NHelper.getLocale()));
		overview.getComboLanguage().setLabelProvider(new LanguageProvider());

		provideListener();
	}

	private void provideListener() {
		overview.getAccountTable().addSelectionChangedListener(event -> {
			Account a = getSelection(overview.getAccountTable());

			details(a);
		});

		overview.getBtnNew().addListener(SWT.Selection, event -> {
			// Aufrufen der NewOrEditAccountView
			AccountDialog dialog = new AccountDialog(overview.getShell(), null);

			if (Window.OK == dialog.open()) {
				Account account = dialog.getAccount();
				Manager.getInstance().addAccount(account);

				overview.getAccountTable().refresh();
			}

		});

		overview.getBtnEdit().addListener(SWT.Selection, event -> {
			if (!overview.getAccountTable().getSelection().isEmpty()) {
				// Aufrufen der NewOrEditAccountView
				Account acc = (Account) overview.getAccountTable().getStructuredSelection().getFirstElement();
				AccountDialog dialog = new AccountDialog(overview.getShell(), acc);

				if (Window.OK == dialog.open()) {
					overview.getAccountTable().refresh();

					details(acc);
					Manager.getInstance().saveAccount(acc);

				}
			}
		});

		overview.getBtnDelete().addListener(SWT.Selection, event -> {
			if (!overview.getAccountTable().getSelection().isEmpty()) {
				boolean result = MessageDialog.openConfirm(overview.getShell(),
						I18NHelper.getMessage("overviewcontroller.message.title"),
						I18NHelper.getMessage("overviewcontroller.message.text"));
				if (result) {
					Account a = getSelection(overview.getAccountTable());
					Manager.getInstance().deleteAccount(a);
					overview.getAccountTable().setInput(Manager.getInstance().getAccounts());
				}
			}
		});

		overview.getBtnTransaction().addListener(SWT.Selection, event -> {
			// Aufrufen der TransactionView
			if (!overview.getAccountTable().getSelection().isEmpty()) {
				TransactionDialog transDialog = new TransactionDialog(overview.getShell(), null);

				if (Window.OK == transDialog.open()) {
					Transaction transaction = transDialog.getTransaction();
					Account source = getSelection(overview.getAccountTable());
					Manager.getInstance().transfer(source, transaction);

					overview.getTransactionTable().refresh();
					overview.getAccountTable().refresh();
				}
			}
		});

		overview.getComboLanguage().addSelectionChangedListener(event -> {
			I18NHelper.updateLocale(getSelection(overview.getComboLanguage()));

			boolean result = MessageDialog.openConfirm(overview.getShell(),
					I18NHelper.getMessage("overviewcontroller.languagechange.title"),
					I18NHelper.getMessage("overviewcontroller.languagechange.text"));
			if (result) {
				System.exit(0);
			}
		});
	}

	private void details(Account a) {
		if (a != null) {
			overview.getTxtFirstName().setText(a.getFirstName());
			overview.getTxtLastName().setText(a.getLastName());
			overview.getTxtBirthday().setText(String.valueOf(a.getBirthday().format(FORMATTER)));
			overview.getTxtPostal().setText(String.valueOf(a.getPostal()));
			overview.getTxtId().setText(String.valueOf(a.getId()));
			overview.getTxtAddress().setText(a.getAddress());
			overview.getTransactionTable().setInput(a.getTransactions());
		}
	}

	private <T> T getSelection(StructuredViewer viewer) {
		ISelection iSelection = viewer.getSelection();
		if (iSelection != null) {
			StructuredSelection ss = (StructuredSelection) iSelection;
			return (T) ss.getFirstElement();
		}
		return null;
	}

}
