package com.jidesoft.action;

public class CommandMenuBar extends CommandBar {

	private static final long serialVersionUID = 1L;

	public CommandMenuBar() {
		setMenuBar(true);
	}

	public CommandMenuBar(int orientation) {
		super(orientation);
		setMenuBar(true);
	}

	public CommandMenuBar(String key) {
		super(key);
		setMenuBar(true);
	}

	public CommandMenuBar(String key, String title) {
		super(key, title);
		setMenuBar(true);
	}

	public CommandMenuBar(String key, String title, int orientation) {
		super(key, title, orientation);
		setMenuBar(true);
	}

	public void setPaintBackground(boolean isOpaque) {
		// TODO Auto-generated method stub
	}
}
