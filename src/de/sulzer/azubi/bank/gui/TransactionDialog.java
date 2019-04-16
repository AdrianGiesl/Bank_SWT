package de.sulzer.azubi.bank.gui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.sulzer.azubi.bank.business.impl.Manager;
import de.sulzer.azubi.bank.business.model.Account;
import de.sulzer.azubi.bank.business.model.Transaction;
import de.sulzer.azubi.bank.gui.bundle.I18NHelper;

public class TransactionDialog extends Dialog {
	private Text txtAmount;
	private Text txtUsage;
	private ComboViewer comboAccounts;

	private Transaction transaction;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public TransactionDialog(Shell parentShell, Transaction transaction) {
		super(parentShell);
		this.transaction = transaction != null ? transaction : new Transaction();
	}
	
	protected void configureShell(Shell parentShell) {
		super.configureShell(parentShell);
		parentShell.setText(I18NHelper.getMessage("transactiondialog.title"));
	}


	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(4, false));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblEmpfnger = new Label(container, SWT.NONE);
		lblEmpfnger.setText(I18NHelper.getMessage("transactiondialog.lbl.target"));
		new Label(container, SWT.NONE);

		comboAccounts = new ComboViewer(container, SWT.READ_ONLY);
		Combo combo = comboAccounts.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboAccounts.setContentProvider(new ArrayContentProvider());
		comboAccounts.addSelectionChangedListener(event -> {
			Object firstElement = event.getStructuredSelection().getFirstElement();
			if (firstElement instanceof Account) {
				Account target = (Account) firstElement;
				transaction.setTarget(target);

			}
		});
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblVerwendung = new Label(container, SWT.NONE);
		lblVerwendung.setText(I18NHelper.getMessage("transactiondialog.lbl.usage"));
		new Label(container, SWT.NONE);

		txtUsage = new Text(container, SWT.BORDER);
		txtUsage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtUsage.addListener(SWT.Modify, event -> transaction.setUsage(txtUsage.getText()));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblBetragIn = new Label(container, SWT.NONE);
		lblBetragIn.setText(I18NHelper.getMessage("transactiondialog.lbl.amount"));
		new Label(container, SWT.NONE);

		txtAmount = new Text(container, SWT.BORDER);
		txtAmount.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtAmount.addListener(SWT.Modify, event -> transaction.setAmount(Double.parseDouble(txtAmount.getText())));
		txtAmount.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent event) {
				event.doit = false;

				char input = event.character;

				if (Character.isDigit(input))
					event.doit = true;

				if (input == '\b')
					event.doit = true;

			}
		});

		insertData();
		return container;
	}

	

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(300, 300);
	}

	private void insertData() {
		getComboAccounts().setInput(Manager.getInstance().getAccounts());
		getComboAccounts().setLabelProvider(new ComboLabelProvider());
	}

	@Override
	protected void okPressed() {
		if (isInputValid()) {
			super.okPressed();
		}
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (txtUsage.getText() == null || txtUsage.getText().length() == 0) {
			errorMessage += I18NHelper.getMessage("transactiondialog.error.usage");
		}
		if (txtAmount.getText() == null || txtUsage.getText().length() == 0) {
			errorMessage += I18NHelper.getMessage("transactiondialog.error.amount");
		}
		if (comboAccounts.getStructuredSelection().isEmpty()) {
			errorMessage += I18NHelper.getMessage("transactiondialog.error.target");
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			MessageDialog.openConfirm(getShell(), I18NHelper.getMessage("transactiondialog.error"), errorMessage);
			return false;
		}
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public Text getTxtAmount() {
		return txtAmount;
	}

	public Text getTxtUsage() {
		return txtUsage;
	}

	public ComboViewer getComboAccounts() {
		return comboAccounts;
	}

}
