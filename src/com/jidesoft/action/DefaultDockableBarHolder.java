package com.jidesoft.action;

import com.jidesoft.swing.ContentContainer;
import com.jidesoft.swing.LayoutPersistence;
import com.jidesoft.utils.PersistenceUtilsCallback.Load;
import com.jidesoft.utils.PersistenceUtilsCallback.Save;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DefaultDockableBarHolder extends JFrame implements	DockableBarHolder { 
	private static final long serialVersionUID = 1L;
	
	private DockableBarManager dockableBarManager;

	
	public DefaultDockableBarHolder() throws HeadlessException {
		try {
			initFrame(getContentPane());
		} finally {
			setContentPaneCheckingEnabled(true);
		}
	}
	
	public DefaultDockableBarHolder(GraphicsConfiguration gc) {
		super(gc);
		try {
			initFrame(getContentPane());
		} finally {
			setContentPaneCheckingEnabled(true);
		}
	}
	
	public DefaultDockableBarHolder(String title) throws HeadlessException {
		super(title);
		try {
			initFrame(getContentPane());
		} finally {
			setContentPaneCheckingEnabled(true);
		}
	}

	public DefaultDockableBarHolder(String title,GraphicsConfiguration gc) {
		super(title, gc);
		try {
			initFrame(getContentPane());
		} finally {
			setContentPaneCheckingEnabled(true);
		}
	}
	
	protected DockableBarManager createDockableBarManager(Container paramContainer) {
		//程序进入的关键 2018-12-09
		return new DefaultDockableBarManager(this, paramContainer);
	}

	protected void initFrame(Container container) {
		ContentContainer contentContainer = createContentContainer();
		container.setLayout(new BorderLayout());
		container.add(contentContainer, "Center");
		contentContainer.setLayout(new BorderLayout());
		this.dockableBarManager = createDockableBarManager(contentContainer);
	}
	
	protected ContentContainer createContentContainer() {
		return new ContentContainer();
	}

	@Override
	public DockableBarManager getDockableBarManager() {
		return this.dockableBarManager;
	}

	public LayoutPersistence getLayoutPersistence() {
		return this.dockableBarManager;
	}
	
	public JMenuBar getJMenuBar() {
		if (getDockableBarManager() != null) {
			Collection col = getDockableBarManager().getAllDockableBars();
			for (Iterator iterator = col.iterator(); iterator.hasNext();) {
				DockableBar bar = (DockableBar) iterator.next();
				if (bar instanceof CommandBar && ((CommandBar) bar).isMenuBar()) {
					return bar;
				}
			}
		}
		return super.getJMenuBar();
	}
	
	protected boolean isContentPaneCheckingEnabled() {
		return isRootPaneCheckingEnabled();
	}

	protected void setContentPaneCheckingEnabled(boolean contentPaneCheckingEnabled) {
		setRootPaneCheckingEnabled(contentPaneCheckingEnabled);
	}
}
