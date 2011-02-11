package com.jidesoft.action;

import com.jidesoft.action.event.DockableBarEvent;
import com.jidesoft.action.event.DockableBarListener;
import com.jidesoft.swing.Alignable;
import com.jidesoft.swing.JideSwingUtilities;
import com.jidesoft.utils.Lm;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

public abstract class DockableBar extends JMenuBar implements Dockable, SwingConstants, Alignable{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DockableBarEvent.class.getName());//a
	public static final String KEY_PROPERTY = "key";
	public static final String TITLE_PROPERTY = "title";
	public static final String IS_FLOATABLE_PROPERTY = "floatable";
	public static final String IS_REARRANGABLE_PROPERTY = "rearrangable";
	public static final String IS_STRETCH_PROPERTY = "stretch";
	public static final String IS_HIDABLE_PROPERTY = "hidable";
	public static final String IS_HIDDEN_PROPERTY = "hidden";
	public static final String IS_HORI_DOCKED_PROPERTY = "hori_docked";
	public static final String IS_VERT_DOCKED_PROPERTY = "vert_docked";
	public static final String IS_FLOATING_PROPERTY = "floating";
	public static final String PROPERTY_INIT_SIDE = "initSide";
	public static final String PROPERTY_INIT_MODE = "initMode";
	public static final String PROPERTY_INIT_INDEX = "initIndex";
	public static final String PROPERTY_INIT_SUBINDEX = "initSubindex";
	public static final String PROPERTY_ALLOWED_DOCK_SIDES = "allowedDockSides";
	public static final String PROPERTY_UNDOCKED_BOUNDS = "undockedBounds";
	private String key;
	private String title;
	private DockableBarContext context;//c
	private DockableBarManager dockableBarManager;
	private boolean floatable = true; //e
	private boolean hidable = true;//f
	private boolean rearrangable = true;//g
    private boolean stretch = false; //h
	private int canSide = 15;
	protected int _orientation = 0;
	//static Class j;//j
	//static Class k;//k
	public static int l;//l
	
	public static final String PROPERTY_CHEVRON_ALWAYS_VISIBLE = "chevronAlwaysVisible";
	//private boolean m = true;//m
	private boolean isPaintBackground = true;
	public static final String PROPERTY_PAINT_BACKGROUND = "paintBackground";
	private boolean isMenuBar;
	public static final String PROPERTY_MENU_BAR = "menuBar";
	public static final String PROPERTY_AVAILABLE = "available";
	public static int o;//o
	
	public DockableBar() {
		this("", "");
	}

	public DockableBar(String key) {
		this(key, key);
	}
	
	public void setInitSubindex(int newValue) {
		int oldValue = getContext().getInitSubindex();
		if (!CommandBarFactory.flag) {
			if (oldValue != newValue)
				getContext().setInitSubindex(newValue);
		} else
			firePropertyChange("initSubindex", oldValue, newValue);
	}
	 
	public void setInitMode(int newValue) {
		int oldValue = getContext().getInitMode();
		if (!CommandBarFactory.flag) {
			if (oldValue != newValue)
				getContext().setInitMode(newValue);
		} else {
			firePropertyChange("initMode", oldValue, newValue);
		}
	}

	public void setInitIndex(int newValue) {
		int oldValue = getContext().getInitIndex();
		if (!CommandBarFactory.flag) {
			if (oldValue != newValue)
				getContext().setInitIndex(newValue);
		} else{
			firePropertyChange("initIndex", oldValue, newValue);
		}
	}
	  
	public DockableBar(String key, String title) {
		setTitle(title);
		this.key = key;
		this.context = new DockableBarContext();
	}

	public void setInitSide(int newValue) {
		int oldValue = getContext().getInitSide();
		if (!CommandBarFactory.flag) {
			if (oldValue != newValue)
				getContext().setInitSide(newValue);
		} else
			firePropertyChange("initSide", oldValue, newValue);
	}
	  
	public DockableBarContext getContext() {
		return this.context;
	}
	
	public boolean isMenuBar() {
		return this.isMenuBar;
	}
	
	public void setMenuBar(boolean newValue) {
		boolean oldValue = this.isMenuBar;
		if (!CommandBarFactory.flag) {
			if (isMenuBar != oldValue)
				this.isMenuBar = newValue;
		} else
			firePropertyChange("menuBar", oldValue, newValue);
	}

	public boolean isPaintBackground() {
		return this.isPaintBackground;
	}
	  
	public void setPaintBackground(boolean newValue) {
		boolean oldValue = this.isPaintBackground;
		if (!CommandBarFactory.flag) {
			if (newValue != oldValue)
				this.isPaintBackground = newValue;
		} else
			firePropertyChange("paintBackground", oldValue, newValue);
	}
	  
	public void setContext(DockableBarContext paramDockableBarContext) {
		int m = DefaultDockableBarManager.state;
		this.context = paramDockableBarContext;
		if (m == 0)
			if (this.context.isFloating()) {
				firePropertyChange("floating", false, true);
				if (m == 0)
					return;
			}
		if (m == 0)
			if (this.context.isHoriDocked()) {
				firePropertyChange("hori_docked", false, true);
				if (m == 0)
					return;
			}
		if (m == 0)
			if (this.context.isVertDocked())
				firePropertyChange("vert_docked", false, true);
		if ((m != 0) && ((m != 0) || (this.context.isHidden())))
			firePropertyChange("hidden", false, true);
	}

	public void setKey(String newValue) {
		String str = this.key;
		this.key = newValue;
		firePropertyChange("key", str, this.key);
	}

	public String getKey() {
		return this.key;
	}

	public void setTitle(String title) {
		String str = this.title;
		this.title = title;
		firePropertyChange("title", str, this.title);
	}

	public String getTitle() {
		return this.title;
	}

	public DockableBarManager getDockableBarManager() {
		return this.dockableBarManager;
	}

	public void setDockableBarManager(DockableBarManager dockableBarManager) {
		this.dockableBarManager = dockableBarManager;
	}

	public boolean isHidden() {
		return getContext().isHidden();
	}

	public void setHidden() throws PropertyVetoException {
		Boolean localBoolean = getContext().isHidden() ? Boolean.TRUE : Boolean.FALSE;
		fireVetoableChange("hidden", localBoolean, Boolean.TRUE);
		getContext().setCurrentMode(0);
		firePropertyChange("hidden", localBoolean, Boolean.TRUE);
		setVisible(false);
		fireDockableBarEvent(8002);
	}

	public boolean isFloating() {
		return getContext().isFloating();
	}

	public void setFloating() throws PropertyVetoException {
		fireVetoableChange("floating", Boolean.FALSE, Boolean.TRUE);
		boolean bool = getContext().isHidden();
		getContext().setCurrentMode(1);
		if (DefaultDockableBarManager.state == 0) {
			if (bool){
				fireDockableBarEvent(8001);
			}
			fireDockableBarEvent(8005);
			firePropertyChange("floating", Boolean.FALSE, Boolean.TRUE);
		}
	}

	public boolean isVertDocked() {
		return getContext().isVertDocked();
	}

	public void setVertDocked() throws PropertyVetoException {
		fireVetoableChange("vert_docked", Boolean.FALSE, Boolean.TRUE);
		boolean bool = getContext().isHidden();
		getContext().setCurrentMode(3);
		if (DefaultDockableBarManager.state == 0) {
			if (bool)
				fireDockableBarEvent(8001);
			fireDockableBarEvent(8004);
			firePropertyChange("vert_docked", Boolean.FALSE, Boolean.TRUE);
		}
	}

	public boolean isHoriDocked() {
		return getContext().isHoriDocked();
	}

	public void setHoriDocked() throws PropertyVetoException {
		fireVetoableChange("hori_docked", Boolean.FALSE, Boolean.TRUE);
		boolean bool = getContext().isHidden();
		getContext().setCurrentMode(2);
		if (DefaultDockableBarManager.state == 0) {
			if (bool){
				fireDockableBarEvent(8001);
			}
			fireDockableBarEvent(8003);
			firePropertyChange("hori_docked", Boolean.FALSE, Boolean.TRUE);
		}
	}

	  public void addDockableBarListener(DockableBarListener paramDockableBarListener){
	    this.listenerList.add(DockableBarListener.class, paramDockableBarListener);
	    enableEvents(0L);
	  }

	  public void removeDockableBarListener(DockableBarListener paramDockableBarListener){
	    this.listenerList.remove(DockableBarListener.class, paramDockableBarListener);
	  }

	  public DockableBarListener[] getDockableBarListeners(){
	    return (DockableBarListener[])this.listenerList.getListeners(DockableBarListener.class);
	  }

	  protected void fireDockableBarEvent(int id){
		  boolean bool = CommandBarFactory.flag;
		    if ((bool) || (logger.isLoggable(Level.FINE)))
		      switch (id){
		      case 4999:
		    	  logger.fine("DockableBar \"" + getKey() + "\" is added");
		          break;
		      case 5000:
		    	  logger.fine("DockableBar \"" + getKey() + "\" is removed");
		          break;
		      case 5003:
		    	  logger.fine("DockableBar \"" + getKey() + "\" is horizontally docked");
		          break;
		      case 5004:
		    	  logger.fine("DockableBar \"" + getKey() + "\" is vertically docked");
		          break;
		      case 5005:
		    	  logger.fine("DockableBar \"" + getKey() + "\" is floating");
		          break;
		      case 5001:
		    	  logger.fine("DockableBar \"" + getKey() + "\" is shown");
		          break;
		      case 5002:
		    	  logger.fine("DockableBar \"" + getKey() + "\" is hidden");
		        break;
		      }
		    
	    Object[] arrayOfObject = this.listenerList.getListenerList();
	    DockableBarEvent localDockableBarEvent = null;
	    int m = arrayOfObject.length - 2;
	    do{
	        if (m < 0)
	            break;
			if (arrayOfObject[m] == DockableBarListener.class) {
				if (!bool) {
					if (localDockableBarEvent == null) {
						localDockableBarEvent = new DockableBarEvent(this,id);
					}
				}
	        switch (localDockableBarEvent.getID()){
	        case 7999:
	          ((DockableBarListener)arrayOfObject[(m + 1)]).dockableBarAdded(localDockableBarEvent);
	            break;
	        case 8000:
	          ((DockableBarListener)arrayOfObject[(m + 1)]).dockableBarRemoved(localDockableBarEvent);
	            break;
	        case 8003:
	          ((DockableBarListener)arrayOfObject[(m + 1)]).dockableBarHoriDocked(localDockableBarEvent);
	            break;
	        case 8004:
	          ((DockableBarListener)arrayOfObject[(m + 1)]).dockableBarVertDocked(localDockableBarEvent);
	            break;
	        case 8005:
	          ((DockableBarListener)arrayOfObject[(m + 1)]).dockableBarFloating(localDockableBarEvent);
	            break;
	        case 8001:
	          ((DockableBarListener)arrayOfObject[(m + 1)]).dockableBarShown(localDockableBarEvent);
	            break;
	        case 8002:
	          ((DockableBarListener)arrayOfObject[(m + 1)]).dockableBarHidden(localDockableBarEvent);
	          break;
	        }
	      }
	      m -= 2;
	    }
	    while (!bool);
	  }

	public int getDockID() {
		return getContext().getDockID();
	}

	public void setDockID(int dockID) {
		getContext().setDockID(dockID);
	}

	public void resetDockID() {
		getContext().resetDockID();
		getContext().setInitPosition(false);
	}

	public boolean isFloatable() {
		return this.floatable;
	}

	public void setFloatable(boolean floatable) {
		if ((DefaultDockableBarManager.state != 0) || (this.floatable != floatable)) {
			boolean bool = this.floatable;
			this.floatable = floatable;
			firePropertyChange("floatable", bool, floatable);
			revalidate();
			repaint();
		}
	}

	public boolean isRearrangable() {
		return this.rearrangable;
	}

	public void setRearrangable(boolean rearrangable) {
		if ((DefaultDockableBarManager.state != 0) || (this.rearrangable != rearrangable)) {
			boolean bool = this.rearrangable;
			this.rearrangable = rearrangable;
			firePropertyChange("rearrangable", bool, rearrangable);
			revalidate();
			repaint();
		}
	}

	public boolean isHidable() {
		return this.hidable;
	}

	public void setHidable(boolean hidable) {
		if ((DefaultDockableBarManager.state != 0) || (this.hidable != hidable)) {
			boolean bool = this.hidable;
			this.hidable = hidable;
			firePropertyChange("hidable", bool, hidable);
			revalidate();
			repaint();
		}
	}

	public Rectangle getUndockedBounds() {
		return getContext().getUndockedBounds();
	}

	public void setUndockedBounds(Rectangle paramRectangle) {
		getContext().setUndockedBounds(paramRectangle);
	}

	public boolean isStretch() {
		return this.stretch;
	}

	public void setStretch(boolean stretch) {
		if ((DefaultDockableBarManager.state != 0) || (this.stretch != stretch)) {
			boolean bool = this.stretch;
			this.stretch = stretch;
			firePropertyChange("stretch", bool, stretch);
			revalidate();
			repaint();
		}
	}

	public int getOrientation() {
		return this._orientation;
	}

	public void setOrientation(int paramInt) {
		checkOrientation(paramInt);
		if ((DefaultDockableBarManager.state != 0)
				|| (this._orientation != paramInt)) {
			int m = this._orientation;
			this._orientation = paramInt;
			JideSwingUtilities.setOrientationOf(this, this._orientation);
			firePropertyChange("orientation", m, paramInt);
		}
	}

	public void setLayout(LayoutManager paramLayoutManager) {
		LayoutManager localLayoutManager = getLayout();
		if (DefaultDockableBarManager.state == 0) {
			if ((localLayoutManager instanceof PropertyChangeListener))
				removePropertyChangeListener((PropertyChangeListener) localLayoutManager);
			super.setLayout(paramLayoutManager);
		}
	}

	public boolean supportVerticalOrientation() {
		return true;
	}

	public boolean supportHorizontalOrientation() {
		return true;
	}

	protected void checkOrientation(int paramInt) {
		switch (paramInt) {
		case 0:
		case 1:
			if (DefaultDockableBarManager.state == 0)
				break;
		default:
			throw new IllegalArgumentException("orientation must be one of: VERTICAL, HORIZONTAL");
		}
	}

	public int getCanSide() {
		return this.canSide;
	}

	public void setCanSide(int canSide) {
		this.canSide = canSide;
	}

	protected void addImpl(Component comp, Object constraints,int index) {
		int n = DefaultDockableBarManager.state;
		if ((n != 0) || ((comp instanceof JComponent))) {
			int orientation = getOrientation();
			if (n != 0)
				return;
			if (JideSwingUtilities.getOrientationOf((JComponent) comp) != orientation)
				JideSwingUtilities.setOrientationOf((JComponent) comp, orientation);
		}
		System.out.println("comp: " + comp + " constraints: " + constraints + " index: " + index);
		super.addImpl(comp, constraints, index);
	}

//	static {
//		try {
//			System.out.println();
//			if (Lm.class.getDeclaredMethods().length != 26) {
//				System.err.println("The Lm class is invalid, exiting ...");
//				System.exit(-1);
//			}
//		} catch (Exception localException) {
//			System.exit(-1);
//		}
//		Lm.z();//loadRegister
//	}
}
