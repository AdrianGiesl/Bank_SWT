package de.sulzer.azubi.bank.gui;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import de.sulzer.azubi.bank.business.model.Account;
import de.sulzer.azubi.bank.business.model.Transaction;
import de.sulzer.azubi.bank.gui.bundle.I18NHelper;

public class Overview extends Composite {

	private Text txtLastName;
	private Text txtFirstName;
	private Text txtId;
	private Text txtPostal;
	private Text txtAddress;
	private Button btnTransaction;
	private Button btnNew;
	private Button btnEdit;
	private Button btnDelete;
	private TableViewer accountTable;
	private TableViewer transactionTable;
	private Text txtBirthday;
	private ComboViewer comboLanguage;

	public Overview(Composite parent) {
		super(parent, SWT.NONE);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(composite, SWT.BORDER);
		sashForm.setSashWidth(2);

		Composite compoLeft = new Composite(sashForm, SWT.NONE);
		compoLeft.setEnabled(true);
		compoLeft.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm_1 = new SashForm(compoLeft, SWT.VERTICAL);

		Composite compoAccounts = new Composite(sashForm_1, SWT.NONE);
		compoAccounts.setLayout(new FillLayout(SWT.HORIZONTAL));

		accountViewer(compoAccounts, accountTable);

		Composite compoBtn = new Composite(sashForm_1, SWT.NONE);
		compoBtn.setLayout(new RowLayout(SWT.HORIZONTAL));

		btnTransaction = new Button(compoBtn, SWT.CENTER);
		btnTransaction.setToolTipText(I18NHelper.getMessage("overview.button.transaction.tooltip"));
		btnTransaction.setText(I18NHelper.getMessage("overview.button.transaction"));

		btnNew = new Button(compoBtn, SWT.CENTER);
		btnNew.setToolTipText(I18NHelper.getMessage("overview.button.new.tooltip"));
		btnNew.setText(I18NHelper.getMessage("overview.button.new"));

		btnEdit = new Button(compoBtn, SWT.CENTER);
		btnEdit.setToolTipText(I18NHelper.getMessage("overview.button.edit.tooltip"));
		btnEdit.setText(I18NHelper.getMessage("overview.button.edit"));

		btnDelete = new Button(compoBtn, SWT.CENTER);
		btnDelete.setToolTipText(I18NHelper.getMessage("overview.button.delete.tooltip"));
		btnDelete.setText(I18NHelper.getMessage("overview.button.delete"));

		comboLanguage = new ComboViewer(compoBtn, SWT.READ_ONLY);
		Combo combo = comboLanguage.getCombo();
		comboLanguage.setContentProvider(new ArrayContentProvider());

		sashForm_1.setWeights(new int[] { 9, 1 });

		Composite compoRechts = new Composite(sashForm, SWT.NONE);
		compoRechts.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashFormDetails = new SashForm(compoRechts, SWT.VERTICAL);

		Composite compoDetails = new Composite(sashFormDetails, SWT.NONE);
		compoDetails.setLayout(new GridLayout(4, false));

		Label lblKontoübersicht = new Label(compoDetails, SWT.NONE);
		lblKontoübersicht.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblKontoübersicht.setText(I18NHelper.getMessage("overview.lbl.accountoverview"));
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);

		Label lblName = new Label(compoDetails, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText(I18NHelper.getMessage("overview.lbl.lastname"));

		txtLastName = new Text(compoDetails, SWT.BORDER);
		txtLastName.setEditable(false);
		txtLastName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblGeburtstag = new Label(compoDetails, SWT.NONE);
		lblGeburtstag.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGeburtstag.setText(I18NHelper.getMessage("overview.lbl.birthday"));

		txtBirthday = new Text(compoDetails, SWT.BORDER);
		txtBirthday.setEditable(false);
		txtBirthday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);

		Label lblVorname = new Label(compoDetails, SWT.NONE);
		lblVorname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVorname.setText(I18NHelper.getMessage("overview.lbl.name"));

		txtFirstName = new Text(compoDetails, SWT.BORDER);
		txtFirstName.setEditable(false);
		txtFirstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblPostleitzahl = new Label(compoDetails, SWT.NONE);
		lblPostleitzahl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPostleitzahl.setText(I18NHelper.getMessage("overview.lbl.postal"));

		txtPostal = new Text(compoDetails, SWT.BORDER);
		txtPostal.setEditable(false);
		txtPostal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);
		new Label(compoDetails, SWT.NONE);

		Label lblKontonr = new Label(compoDetails, SWT.NONE);
		lblKontonr.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblKontonr.setText(I18NHelper.getMessage("overview.lbl.id"));

		txtId = new Text(compoDetails, SWT.BORDER);
		txtId.setEditable(false);
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblAdresse = new Label(compoDetails, SWT.NONE);
		lblAdresse.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAdresse.setText(I18NHelper.getMessage("overview.lbl.address"));

		txtAddress = new Text(compoDetails, SWT.BORDER);
		txtAddress.setEditable(false);
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Composite compoTransaction = new Composite(sashFormDetails, SWT.NONE);
		compoTransaction.setLayout(new FillLayout(SWT.HORIZONTAL));

		transactionViewer(compoTransaction, transactionTable);

		sashFormDetails.setWeights(new int[] { 206, 137 });
		sashForm.setWeights(new int[] { 4, 7 });
	}

	private void accountViewer(Composite compoAccounts, final TableViewer viewer) {
		accountTable = new TableViewer(compoAccounts, SWT.BORDER | SWT.FULL_SELECTION);
		create_3_Columns(compoAccounts, accountTable);
		Table table = accountTable.getTable();
		table.setHeaderVisible(true);
		accountTable.setContentProvider(new ArrayContentProvider());
	}

	private void create_3_Columns(Composite compoAccounts, final TableViewer viewer) {
		String[] columnTitles = { I18NHelper.getMessage("overview.column.name"),
				I18NHelper.getMessage("overview.column.id"), I18NHelper.getMessage("overview.column.balance") };
		int[] bounds = { 100, 100, 100 };

		// Erste Spalte
		TableViewerColumn col1 = createTableViewerColumnAccount(columnTitles[0], bounds[0], 0);
		col1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Account) {
					Account a = (Account) element;
					return a.getLastName() + " " + a.getFirstName();
				}
				return "";
			}
		});

		// Zweite Spalte
		TableViewerColumn col2 = createTableViewerColumnAccount(columnTitles[1], bounds[1], 1);
		col2.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Account) {
					Account a = (Account) element;
					return String.valueOf(a.getId());
				}
				return "";
			}
		});

		// Dritte Spalte
		TableViewerColumn col3 = createTableViewerColumnAccount(columnTitles[2], bounds[2], 2);
		col3.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Account) {
					Account a = (Account) element;
					return String.valueOf(a.getBalance());
				}
				return "";
			}
		});
	}

//////////////////////////////////////Überweisungstabelle/////////////////
	private void transactionViewer(Composite compoTransaction, final TableViewer viewer) {
		transactionTable = new TableViewer(compoTransaction, SWT.BORDER | SWT.FULL_SELECTION);
		create_6_Columns(compoTransaction, transactionTable);
		Table table = transactionTable.getTable();
		table.setHeaderVisible(true);
		transactionTable.setContentProvider(new ArrayContentProvider());
	}

	private void create_6_Columns(final Composite compoTransaction, final TableViewer viewer) {
		String[] columnTitles = { I18NHelper.getMessage("overview.column.source"),
				I18NHelper.getMessage("overview.column.target"), I18NHelper.getMessage("overview.column.usage"),
				I18NHelper.getMessage("overview.column.amount"), I18NHelper.getMessage("overview.column.date") };
		int[] bounds = { 100, 100, 100, 100, 150 };

		// Erste Spalte
		TableViewerColumn col = createTableViewerColumnTransaction(columnTitles[0], bounds[0], 0);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Transaction) {
					Transaction t = (Transaction) element;
					Account a = t.getSource();
					return a.getFirstName() + " " + a.getLastName();
				}
				return "";
			}
		});

		// Zweite Spalte
		col = createTableViewerColumnTransaction(columnTitles[1], bounds[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Transaction) {
					Transaction t = (Transaction) element;
					Account a = t.getTarget();
					return a.getFirstName() + " " + a.getLastName();
				}
				return "";
			}
		});

		// Dritte Spalte
		col = createTableViewerColumnTransaction(columnTitles[2], bounds[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Transaction) {
					Transaction t = (Transaction) element;
					return t.getUsage();
				}
				return "";
			}
		});

		// Vierte Spalte
		col = createTableViewerColumnTransaction(columnTitles[3], bounds[3], 3);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Transaction) {
					Transaction t = (Transaction) element;
					return String.valueOf(t.getAmount());
				}
				return "";
			}
		});

		// Fünfte Spalte
		col = createTableViewerColumnTransaction(columnTitles[4], bounds[4], 4);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Transaction) {
					Transaction t = (Transaction) element;
					return String.valueOf(t.getTimestamp());
				}
				return "";
			}
		});
	}

	private TableViewerColumn createTableViewerColumnAccount(String title, int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(accountTable, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(false);
		column.setMoveable(false);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if (element instanceof Account) {
					Account a = (Account) element;
					return a.getLastName() + " " + a.getFirstName();
				}
				return super.getText(element);
			}
		});
		return viewerColumn;
	}

	private TableViewerColumn createTableViewerColumnTransaction(String title, int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(transactionTable, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(false);
		column.setMoveable(false);
		return viewerColumn;
	}

	public Text getTxtLastName() {
		return txtLastName;
	}

	public void setTxtLastName(Text txtLastName) {
		this.txtLastName = txtLastName;
	}

	public Text getTxtFirstName() {
		return txtFirstName;
	}

	public void setTxtFirstName(Text txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public Text getTxtId() {
		return txtId;
	}

	public void setTxtId(Text txtId) {
		this.txtId = txtId;
	}

	public Text getTxtPostal() {
		return txtPostal;
	}

	public void setTxtPostal(Text txtPostal) {
		this.txtPostal = txtPostal;
	}

	public Text getTxtAddress() {
		return txtAddress;
	}

	public void setTxtAddress(Text txtAddress) {
		this.txtAddress = txtAddress;
	}

	public Button getBtnTransaction() {
		return btnTransaction;
	}

	public void setBtnTransaction(Button btnTransaction) {
		this.btnTransaction = btnTransaction;
	}

	public Button getBtnNew() {
		return btnNew;
	}

	public void setBtnNew(Button btnNew) {
		this.btnNew = btnNew;
	}

	public Button getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(Button btnEdit) {
		this.btnEdit = btnEdit;
	}

	public Button getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(Button btnDelete) {
		this.btnDelete = btnDelete;
	}

	public TableViewer getAccountTable() {
		return accountTable;
	}

	public void setAccountTable(TableViewer accountTable) {
		this.accountTable = accountTable;
	}

	public TableViewer getTransactionTable() {
		return transactionTable;
	}

	public void setTransactionTable(TableViewer transactionTable) {
		this.transactionTable = transactionTable;
	}

	public Text getTxtBirthday() {
		return txtBirthday;
	}

	public void setTxtBirthday(Text txtBirthday) {
		this.txtBirthday = txtBirthday;
	}

	public ComboViewer getComboLanguage() {
		return comboLanguage;
	}

}
