package de.sulzer.azubi.bank;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.sulzer.azubi.bank.gui.Controller;
import de.sulzer.azubi.bank.gui.DataSourceDialog;
import de.sulzer.azubi.bank.gui.Overview;
import de.sulzer.azubi.bank.gui.OverviewController;
import de.sulzer.azubi.bank.gui.bundle.I18NHelper;

public class Main {

	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText(I18NHelper.getMessage("main.title"));

//		DataSourceDialog dataSourceDialog = new DataSourceDialog(shell);
//		
//		Controller controller = new Controller(dataSourceDialog);
//		controller.setup();
		
		Overview overview = new Overview(shell);

		OverviewController overviewController = new OverviewController(overview);
		overviewController.setup();

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();

		}
		display.dispose();
	}

}
