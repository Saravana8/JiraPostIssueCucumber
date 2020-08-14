package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {

	public static String getData(String key) throws IOException {

		Properties prop = new Properties();

		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");

		prop.load(stream);

		String value = prop.getProperty(key);
		// String value = (String) prop.get(key);

		return value;

	}

}
