package com.jidesoft.action;

import com.jidesoft.plaf.CommandBarTitleBarUI;
import com.jidesoft.swing.Alignable;
import com.jidesoft.swing.DragableHandle;
import com.jidesoft.swing.JideSwingUtilities;
import com.jidesoft.swing.TopLevelMenuContainer;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JMenuBar;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.MenuBarUI;
import javax.swing.plaf.UIResource;

public class CommandBarTitleBar extends JMenuBar implements MenuElement, SwingConstants, Alignable, DragableHandle, TopLevelMenuContainer, UIResource{

	private String title;//a

	public CommandBarTitleBar(String title) {
		this.title = title;
		setFocusable(false);
		updateUI();
	}

	public MenuBarUI getUI() {
		return (CommandBarTitleBarUI) this.ui;
	}

	public void setUI(CommandBarTitleBarUI ui) {
		super.setUI(ui);
	}

	public void updateUI() {
		setUI((CommandBarTitleBarUI) UIManager.getUI(this));
	}

	public String getUIClassID() {
		return "CommandBarTitleBarUI";
	}

	public void processMouseEvent(MouseEvent event,MenuElement[] path,MenuSelectionManager manager) {
	}

	public void processKeyEvent(KeyEvent event,MenuElement[] path,MenuSelectionManager manager) {
		
	}

	public void menuSelectionChanged(boolean isIncluded) {
	}

	public MenuElement[] getSubElements() {
		int k = DefaultDockableBarManager.state;
		Vector localVector = new Vector();
		int i = getComponentCount();
		int j = 0;
		do {
			if (j >= i)
				break;
			Component localComponent = getComponent(j);
			if (k == 0) {
				if (k != 0)
					break;
				if ((localComponent instanceof UIResource))
					localVector.addElement(localComponent);
				j++;
			}
		} while (k == 0);
		MenuElement[] arrayOfMenuElement = (MenuElement[]) new UIResource[localVector.size()];
		j = 0;
		i = localVector.size();
		do {
			if (j >= i)
				break;
			if (k != 0)
				break;
			arrayOfMenuElement[j] = (MenuElement) ((UIResource) localVector.elementAt(j));
			j++;
		} while (k == 0);
		return arrayOfMenuElement;
	}

	public Component getComponent() {
		return this;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		String str = this.title;
		this.title = title;
		firePropertyChange("title", str, title);
	}

	@Override
	public boolean isMenuBar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportVerticalOrientation() {
		return true;
	}

	@Override
	public boolean supportHorizontalOrientation() {
		return true;
	}

	@Override
	public void setOrientation(int orientation) {
		JideSwingUtilities.setOrientationOf(this, orientation);
	}

	@Override
	public int getOrientation() {
		return JideSwingUtilities.getOrientationOf(this);
	}

}
