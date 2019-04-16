package de.sulzer.azubi.bank.gui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.sulzer.azubi.bank.gui.bundle.I18NHelper;

public class DataSourceDialog extends Dialog {

	private ComboViewer comboDataSource;

	public DataSourceDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected void configureShell(Shell parentShell) {
		super.configureShell(parentShell);
		parentShell.setText(I18NHelper.getMessage("datasourcedialog.title"));
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText(I18NHelper.getMessage("datasourcedialog.lbl"));

		comboDataSource = new ComboViewer(container, SWT.NONE);
		Combo combo = comboDataSource.getCombo();
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 248;
		combo.setLayoutData(gd_combo);

		return container;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(300, 140);
	}

	@Override
	protected void okPressed() {
		if (isInputValid()) {
			super.okPressed();
			
		}
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (comboDataSource.getStructuredSelection().isEmpty()) {
			errorMessage += I18NHelper.getMessage("datasourcedialog.error.source");
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			MessageDialog.openConfirm(getShell(), I18NHelper.getMessage("datasourcedialog.error.title"), errorMessage);
			return false;
		}
	}

	public ComboViewer getComboDataSource() {
		return comboDataSource;
	}
}
