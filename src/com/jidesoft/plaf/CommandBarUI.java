package com.jidesoft.plaf;

import java.awt.Component;
import javax.swing.plaf.MenuBarUI;

public abstract class CommandBarUI extends MenuBarUI {
	public abstract Component getGripper();

	public abstract Component getTitleBar();
}