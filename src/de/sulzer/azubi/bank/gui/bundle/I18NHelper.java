package de.sulzer.azubi.bank.gui.bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class I18NHelper {

	private static final String LANGUAGEKEY = "Language";
	private static final String BASE_NAME = "de.sulzer.azubi.bank.gui.bundle.messages";
	private static Language locale;
	
	static {
		Properties pp = new Properties();
		try {
			loadInProperties(pp, getFile());
			String property = pp.getProperty(LANGUAGEKEY, Language.GERMAN.name());
			locale = Language.valueOf(property);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * getMessage(key);
	 * 
	 * @param key
	 * @param locale
	 * @param params
	 * @return
	 */

	public static String getMessage(String key, Object... params) {
		ResourceBundle bundle = getBundle(locale.getLocale());
		String result = key;
		if (bundle.containsKey(key)) {
			result = bundle.getString(key);
		}
		if (params != null && params.length != 0) {
			final MessageFormat mf = new MessageFormat(result, locale.getLocale());
			result = mf.format(params);
		}
		return result;
	}

	public static void updateLocale(Language newLocale) {
		locale = newLocale;

		Properties pp = new Properties();

		File file = getFile();
		try {
			loadInProperties(pp, file);

			pp.setProperty(LANGUAGEKEY, newLocale.name());
			
			FileOutputStream outputFile = new FileOutputStream(file);
			pp.store(outputFile, null);
			outputFile.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void loadInProperties(Properties pp, File file) throws FileNotFoundException, IOException {
		FileInputStream inputFile = new FileInputStream(file);
		pp.load(inputFile);
		inputFile.close();
	}

	private static File getFile() {
		File directory = new File(System.getenv("USERPROFILE") + File.separator + "Bank");
		if (!directory.exists()) {
			directory.mkdir();
		}

		File file = new File(directory, "settings.properties");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return file;
	}

	public static ResourceBundle getBundle(Locale locale) {
		return ResourceBundle.getBundle(BASE_NAME, locale);
	}

	public static Language getLocale() {
		return locale;
	}

}
