package com.homesoft.guitar.util;

import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class CommandArguements {

	public static Properties getProperties(String[] args) throws InvalidPropertiesFormatException {
		Properties properties = new Properties();
		for (int index = 0; index < args.length; index++) {
			String key = null;
			String value = null;
			String arguement = args[index];
			if (arguement != null && arguement.trim().length() != 0) {
				if (arguement.indexOf("--") != -1) {
					String actualArguement = arguement.split("--")[1];
					if (actualArguement.indexOf("=") != -1) {
						key=actualArguement.split("=")[0];
						value=actualArguement.split("=")[1];
					} else {
						key=actualArguement;
					}
					if (key != null) {
						properties.put(key, value);
					}
				} else {
					throw new InvalidPropertiesFormatException("Invalid argument. "
							+ "\nAn arguement must start with --"
							+ "\nIf you arguement name is arg then"
							+ "\nFor no-value arguements, --arg"
							+ "\nFor valued arguements, --arg=val");
				}
			}
		}
		return properties;
	}

}
