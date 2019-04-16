package de.sulzer.azubi.bank.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import de.sulzer.azubi.bank.business.impl.Source;

public class Controller {
	
	private static final String SOURCEKEY = "Bank";
	private DataSourceDialog dataSourceDialog;
	
	public Controller(DataSourceDialog dataSourceDialog) {
		this.dataSourceDialog = dataSourceDialog;
	}
	
	public void setup() {
		dataSourceDialog.getComboDataSource().setInput(Source.values());
		dataSourceDialog.getComboDataSource().setLabelProvider(new SourceProvider());
		
		provideListener();
	}
	
	private void provideListener() {
		dataSourceDialog.getComboDataSource().addSelectionChangedListener(event -> {
			
			Properties pp = new Properties();
			
			File file = getFile();
			try {
				loadInProperties(pp, file);
				
				pp.setProperty(SOURCEKEY, Source.Raiffeisenbank.name());
				
				FileOutputStream outputFile = new FileOutputStream(file);
				pp.store(outputFile, null);
				outputFile.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	private static void loadInProperties(Properties pp,File file) throws FileNotFoundException, IOException{
		FileInputStream inputFile = new FileInputStream(file);
		pp.load(inputFile);
		inputFile.close();
	}
	
	private static File getFile() {
		File directory = new File(System.getenv("USERPROFILE") + File.separator + "Bank");
		if(!directory.exists()) {
			directory.mkdir();
		}
		
		File file = new File(directory, "datasource.properties");
		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
