package com.jidesoft.plaf.basic;

import com.jidesoft.action.Chevron;
import com.jidesoft.action.CommandBar;
import com.jidesoft.action.CommandBarTitleBar;
import com.jidesoft.action.CommandMenuBar;
import com.jidesoft.action.DockableBar;
import com.jidesoft.plaf.CommandBarUI;
import com.jidesoft.plaf.UIDefaultsLookup;
import com.jidesoft.swing.Gripper;
import com.jidesoft.swing.JideSwingUtilities;
import com.jidesoft.utils.SystemInfo;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Constructor;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ButtonModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;
import javax.swing.JToolBar;
import javax.swing.LookAndFeel;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.SingleSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.MenuBarUI;

public class BasicCommandBarUI extends CommandBarUI implements SwingConstants {

	@Override
	public Component getGripper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTitleBar() {
		// TODO Auto-generated method stub
		return null;
	}

}
