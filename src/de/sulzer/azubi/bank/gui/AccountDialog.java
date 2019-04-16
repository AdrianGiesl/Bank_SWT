package de.sulzer.azubi.bank.gui;

import java.time.LocalDateTime;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.sulzer.azubi.bank.business.model.Account;
import de.sulzer.azubi.bank.gui.bundle.I18NHelper;

import org.eclipse.swt.widgets.DateTime;

public class AccountDialog extends Dialog {

	private final class VerifyListenerImplementation implements VerifyListener {
		@Override
		public void verifyText(VerifyEvent event) {
			event.doit = false;

			char input = event.character;

			if (Character.isAlphabetic(input))
				event.doit = true;

			if (input == '\b')
				event.doit = true;

			if (account.getFirstName() != null)
				event.doit = true;

			if (account.getFirstName() != null)
				event.doit = true;

			if (account.getBirthday() != null)
				event.doit = true;
		}
	}

	private Text txtFirstName;
	private Text txtAddress;
	private Text txtPostal;
	private Text txtId;
	private Text txtLastName;
	private Account account;
	private DateTime dateTime;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AccountDialog(Shell parentShell, Account account) {
		super(parentShell);
		this.account = account != null ? account : new Account();

	}
	
	protected void configureShell(Shell parentShell) {
		super.configureShell(parentShell);
		parentShell.setText(I18NHelper.getMessage("accountdialog.title"));
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(8, false));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblName = new Label(container, SWT.NONE);
		lblName.setText(I18NHelper.getMessage("accountdialog.lbl.lastname"));
		new Label(container, SWT.NONE);

		txtLastName = new Text(container, SWT.BORDER);
		txtLastName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtLastName.addListener(SWT.Modify, event -> account.setLastName(txtLastName.getText()));
		txtLastName.addVerifyListener(new VerifyListenerImplementation());
		new Label(container, SWT.NONE);

		Label lblVorname = new Label(container, SWT.NONE);
		lblVorname.setText(I18NHelper.getMessage("accountdialog.lbl.name"));
		new Label(container, SWT.NONE);

		txtFirstName = new Text(container, SWT.BORDER);
		txtFirstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtFirstName.addListener(SWT.Modify, event -> account.setFirstName(txtFirstName.getText()));
		txtFirstName.addVerifyListener(new VerifyListenerImplementation());
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblKontonr = new Label(container, SWT.NONE);
		lblKontonr.setText(I18NHelper.getMessage("accountdialog.lbl.id"));
		new Label(container, SWT.NONE);

		txtId = new Text(container, SWT.BORDER);
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtId.setEditable(false);
		new Label(container, SWT.NONE);

		Label lblAdresse = new Label(container, SWT.NONE);
		lblAdresse.setText(I18NHelper.getMessage("accountdialog.lbl.address"));
		new Label(container, SWT.NONE);

		txtAddress = new Text(container, SWT.BORDER);
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtAddress.addListener(SWT.Modify, event -> account.setAddress(txtAddress.getText()));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblPostleitzahl = new Label(container, SWT.NONE);
		lblPostleitzahl.setText(I18NHelper.getMessage("accountdialog.lbl.postal"));
		new Label(container, SWT.NONE);

		txtPostal = new Text(container, SWT.BORDER);
		txtPostal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtPostal.addListener(SWT.Modify, event -> account.setPostal(txtPostal.getText()));
		txtPostal.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent event) {
				event.doit = false;

				char input = event.character;

				if (Character.isDigit(input))
					event.doit = true;

				if (input == '\b')
					event.doit = true;

				if (account.getPostal() != null)
					event.doit = true;

			}
		});
		new Label(container, SWT.NONE);

		Label lblGeburtstag = new Label(container, SWT.NONE);
		lblGeburtstag.setText(I18NHelper.getMessage("accountdialog.lbl.birthday"));
		new Label(container, SWT.NONE);

		dateTime = new DateTime(container, SWT.BORDER);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		dateTime.addListener(SWT.Selection, event -> account
				.setBirthday(LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), 0, 0)));

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
		return new Point(450, 300);
	}

	public void insertData() {

		getTxtFirstName().setText(account.getFirstName() != null ? account.getFirstName() : "");
		getTxtLastName().setText(account.getLastName() != null ? account.getLastName() : "");
		getTxtId().setText(account.getId() != null ? String.valueOf(account.getId()) : "");
		getTxtAddress().setText(account.getAddress() != null ? account.getAddress() : "");
		getTxtPostal().setText(account.getPostal() != null ? String.valueOf(account.getPostal()) : "");
		LocalDateTime birthday = account.getBirthday();
		if (birthday != null) {
			getDateTime().setDate(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth());
		}
		if (account.getBalance() == null) {
			account.setBalance(0.0);
		} else {
			account.getBalance();
		}
	}

	@Override
	protected void okPressed() {
		if (isInputValid()) {
			super.okPressed();
		}
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (txtFirstName.getText() == null || txtFirstName.getText().length() == 0) {
			errorMessage += I18NHelper.getMessage("accountdialog.error.name");
		}
		if (txtLastName.getText() == null || txtLastName.getText().length() == 0) {
			errorMessage += I18NHelper.getMessage("accountdialog.error.familyname");
		}
		if (txtAddress.getText() == null || txtAddress.getText().length() == 0) {
			errorMessage += I18NHelper.getMessage("accountdialog.error.address");
		}
		if (txtPostal.getText() == null || txtPostal.getText().length() == 0) {
			errorMessage += I18NHelper.getMessage("accountdialog.error.postal");
			if (txtPostal.getText().length() != 5) {
				errorMessage += I18NHelper.getMessage("accountdialog.error.postallength");
			}
		}

		if (dateTime.getYear() == 0 || dateTime.getMonth() == 0 || dateTime.getDay() == 0) {
			errorMessage += I18NHelper.getMessage("accountdialog.error.birthday");
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			MessageDialog.openError(getShell(), I18NHelper.getMessage("accountdialog.error"), errorMessage);
			return false;
		}
	}

	public Account getAccount() {
		return account;
	}

	public Text getTxtFirstName() {
		return txtFirstName;
	}

	public void setTxtFirstName(Text txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public Text getTxtAddress() {
		return txtAddress;
	}

	public void setTxtAddress(Text txtAddress) {
		this.txtAddress = txtAddress;
	}

	public Text getTxtPostal() {
		return txtPostal;
	}

	public void setTxtPostal(Text txtPostal) {
		this.txtPostal = txtPostal;
	}

	public Text getTxtId() {
		return txtId;
	}

	public void setTxtId(Text txtId) {
		this.txtId = txtId;
	}

	public Text getTxtLastName() {
		return txtLastName;
	}

	public void setTxtLastName(Text txtLastName) {
		this.txtLastName = txtLastName;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

}
