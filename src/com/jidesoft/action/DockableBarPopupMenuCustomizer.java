package com.jidesoft.action;

import java.awt.Component;
import javax.swing.JPopupMenu;

public abstract interface DockableBarPopupMenuCustomizer {
	public abstract void customizePopupMenu(JPopupMenu menu, DockableBarManager dockableBarManager, Component component);
}
