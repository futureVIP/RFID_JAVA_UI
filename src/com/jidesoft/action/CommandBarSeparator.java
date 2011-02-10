package com.jidesoft.action;

import com.jidesoft.plaf.CommandBarSeparatorUI;
import com.jidesoft.swing.Alignable;
import com.jidesoft.swing.JideSwingUtilities;
import javax.accessibility.Accessible;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.SeparatorUI;

public class CommandBarSeparator extends JSeparator implements SwingConstants,Alignable, Accessible {
	public CommandBarSeparator() {
		this(0);
	}

	public CommandBarSeparator(int paramInt) {
		setOrientation(paramInt);
		setFocusable(false);
		updateUI();
	}

	public SeparatorUI getUI() {
		return (CommandBarSeparatorUI) this.ui;
	}

	public void updateUI() {
		setUI((CommandBarSeparatorUI) UIManager.getUI(this));
	}

	public String getUIClassID() {
		return "CommandBarSeparatorUI";
	}

	public void setOrientation(int paramInt) {
		super.setOrientation(paramInt);
		JideSwingUtilities.setOrientationOf(this, paramInt);
	}

	public int getOrientation() {
		return JideSwingUtilities.getOrientationOf(this);
	}

	public boolean supportVerticalOrientation() {
		return true;
	}

	public boolean supportHorizontalOrientation() {
		return true;
	}
}