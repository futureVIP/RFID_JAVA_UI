package com.jidesoft.action;

import java.util.Locale;
import java.util.ResourceBundle;

public class Actions {
	static final ResourceBundle a = ResourceBundle.getBundle("com.jidesoft.action.action");

	public static ResourceBundle getResourceBundle(Locale paramLocale) {
		return ResourceBundle.getBundle("com.jidesoft.action.action",paramLocale);
	}
}
