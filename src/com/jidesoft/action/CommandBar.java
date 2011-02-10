package com.jidesoft.action;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.MenuBar;
import java.awt.MenuContainer;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleStateSet;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.MenuBarUI;
import javax.swing.plaf.UIResource;

import com.jidesoft.plaf.CommandBarUI;
import com.jidesoft.swing.Alignable;
import com.jidesoft.swing.JideButton;
import com.jidesoft.swing.TopLevelMenuContainer;
import com.jidesoft.utils.SecurityUtils;
import com.jidesoft.utils.SystemInfo;

public class CommandBar extends DockableBar implements SwingConstants, Accessible, TopLevelMenuContainer{

	private boolean borderPainted = true;//m
	private Insets margin = null;//n
	//private n o;//o
	private int preferredRowCount;//p
    private boolean menuBar;//q
	private ArrayList hiddenComponents = new ArrayList();//r
	private boolean paintBackground = true;//s
	static boolean flag = false;//t
	  
	public CommandBar() {
		this(0);
	}
	
	public CommandBar(int orientation) {
		this("untitled", "untitled", orientation);
	}

	public CommandBar(String key) {
		this(key, key, 0);
	}
	
	public CommandBar(String key, String title) {
		this(key, title, 0);
	}
	
	public CommandBar(String key, String title, int orientation) {
		super(key, title);
		checkOrientation(orientation);
		this._orientation = orientation;
		b_ localb_ = new b_(orientation);
		setLayout(localb_);
		addPropertyChangeListener(localb_);
//		this.o = a();
//		addMouseListener(this.o);
//		addMouseMotionListener(this.o);
		updateUI();
	}
	
	public void addSeparator() {
		CommandBarSeparator localCommandBarSeparator = new CommandBarSeparator();
		add(localCommandBarSeparator);
	}

	public void addSeparator(Dimension paramDimension) {
		CommandBarSeparator localCommandBarSeparator = new CommandBarSeparator();
		add(localCommandBarSeparator);
	}
	
//	private n a() {
//		n localn = new n(this);
//		return localn;
//	}
	
	public MenuBarUI getUI() {
		return (CommandBarUI) this.ui;
	}
	
	public void setUI(CommandBarUI paramCommandBarUI) {
		super.setUI(paramCommandBarUI);
	}
	
	public void updateUI() {
		int j = DefaultDockableBarManager.state;
		setUI(UIManager.getUI(this));
		invalidate();
		if (j == 0) {
			if (!isScreenMenuBar(this)) {
//				((CommandBarUI) getUI()).getGripper().addMouseListener(this.o);
//				((CommandBarUI) getUI()).getGripper().addMouseMotionListener(this.o);
//				((CommandBarUI) getUI()).getTitleBar().addMouseListener(this.o);
//				((CommandBarUI) getUI()).getTitleBar().addMouseMotionListener(this.o);
			}
		} else {
			Component[] arrayOfComponent = getHiddenComponents();
			int i = 0;
			do {
				if (i >= arrayOfComponent.length)
					break;
				if ((j != 0) || ((arrayOfComponent[i] instanceof JComponent))) {
					JComponent localJComponent = (JComponent) arrayOfComponent[i];
					localJComponent.updateUI();
				}
				i++;
			} while (j == 0);
		}
	}
	
	public String getUIClassID() {
		return "CommandBarUI";
	}

	public void setMargin(Insets insets) {
		Insets localInsets = this.margin;
		this.margin = insets;
		firePropertyChange("margin", localInsets, insets);
		revalidate();
		repaint();
	}

	public Insets getMargin() {
		if (DefaultDockableBarManager.state == 0)
			if (this.margin == null)
				return new Insets(0, 0, 0, 0);
		return this.margin;
	}

	public boolean isBorderPainted() {
		return this.borderPainted;
	}
	
	
	public void setBorderPainted(boolean paramBoolean){
	    if ((DefaultDockableBarManager.state != 0) || (this.borderPainted != paramBoolean))
	    {
	      boolean bool = this.borderPainted;
	      this.borderPainted = paramBoolean;
	      firePropertyChange("borderPainted", bool, paramBoolean);
	      revalidate();
	      repaint();
	    }
	  }

	protected void paintBorder(Graphics paramGraphics) {
		if ((DefaultDockableBarManager.state != 0) || (isBorderPainted()))
			super.paintBorder(paramGraphics);
	}

	public JComponent add(Action action) {
		JComponent localJComponent = createActionComponent(action);
		add(localJComponent);
		return localJComponent;
	}

	protected JComponent createActionComponent(Action action) {
		return component(action);
	}

	private JComponent component(Action action) {
		int i = DefaultDockableBarManager.state;
		String str1 = (i != 0) || (action != null) ? (String) action.getValue("Name") : null;
		Icon localIcon = (i != 0) || (action != null) ? (Icon) action.getValue("SmallIcon") : null;
		boolean bool = (i != 0) || (action != null) ? action.isEnabled() : true;
		String shortDescription = (i != 0) || (action != null) ? (String) action.getValue("ShortDescription") : null;
		JideButton local0 = new JideButton(str1, localIcon) {
			protected PropertyChangeListener createActionPropertyChangeListener(Action paramAnonymousAction) {
				PropertyChangeListener localPropertyChangeListener = CommandBar.this.createActionChangeListener(this);
				if (DefaultDockableBarManager.state == 0)
					if (localPropertyChangeListener == null)
						localPropertyChangeListener = super.createActionPropertyChangeListener(paramAnonymousAction);
				return localPropertyChangeListener;
			}
		};
		if (i == 0) {
			if (localIcon != null)
				local0.putClientProperty("hideActionText", Boolean.TRUE);
				local0.setHorizontalTextPosition(0);
				local0.setVerticalTextPosition(3);
				local0.setEnabled(bool);
				local0.setToolTipText(shortDescription);
				local0.setAction(action);
		}
		return local0;
	}

	protected PropertyChangeListener createActionChangeListener(JComponent component) {
		return null;
	}

	protected void addImpl(Component comp, Object constraints,int index) {
		int k = DefaultDockableBarManager.state;
		if (k == 0) {
			if ((comp instanceof UIResource)) {
				super.addImpl(comp, constraints, index);
			}
		}
		if (index < 0) {
			super.addImpl(comp, constraints, index);
		} else {
			Component[] arrayOfComponent = getComponents();
			int i = 0;
			int j = 0;
			do {
				if (j >= arrayOfComponent.length)
					break;
				Component localComponent = arrayOfComponent[j];
					if (k != 0)
						break;
					if (!(localComponent instanceof UIResource))
						break;
					i++;
					j++;
			} while (k == 0);
			super.addImpl(comp, constraints, index + i);
		}
		if (k == 0) {
			 //if ((comp instanceof JButton))
			    //((JButton) comp).setDefaultCapable(false);
		} else
			comp.setFocusable(false);
	}

	  public static final boolean isScreenMenuBar(JMenuBar jMenuBar){
	    int i = DefaultDockableBarManager.state;
	    if (i == 0)
	      if (flag){
	        if (i == 0)
	          if ((jMenuBar instanceof CommandMenuBar))
	            return true;
	        MenuBarUI localMenuBarUI = jMenuBar.getUI();
	        if (i != 0);
	        if ((localMenuBarUI instanceof CommandBarUI)){
	          Container localContainer = jMenuBar.getTopLevelAncestor();
	          //if (i != 0)
//	            break;
//	          if ((localContainer instanceof JFrame)){
//	            MenuBar localMenuBar = ((JFrame)localContainer).getMenuBar();
//	            boolean bool = ((JFrame)localContainer).getJMenuBar() == paramJMenuBar;
//	            if (i == 0)
//	              if (localMenuBar == null)
//	                return bool;
//	            if ((i != 0) || ((localMenuBar instanceof ScreenMenuBar)))
//	              if (i != 0);
//	            return bool;
	        //  }
	        }
	      }
	    return false;
	  }

	  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8){
	    int i = DefaultDockableBarManager.state;
	    if (i == 0)
	      if (isFloating()){
	        b_ localb_ = (b_)getLayout();
	        Rectangle localRectangle = null;
	        if (i == 0)
	          if (paramInt3 == -1)
	          {
	            if (i != 0);
	            if (paramInt7 != paramInt8){
	              if (paramInt2 == getY())
	              {
	                if (i == 0);
	                localRectangle = localb_.getActualSize(this, paramInt1, paramInt2, paramInt3, paramInt4, 1, true, paramInt7 > paramInt8);
	              }
	              if (i == 0);
	              localRectangle = localb_.getActualSize(this, paramInt1, paramInt2, paramInt3, paramInt4, 1, false, paramInt7 < paramInt8);
	            }
	          }
	        if (((i != 0) || (paramInt5 != paramInt6)) && ((i != 0) || (paramInt4 == -1)))
	          if (paramInt1 == getX())
	          {
	            if (i == 0);
	            localRectangle = localb_.getActualSize(this, paramInt1, paramInt2, paramInt3, paramInt4, 0, true, paramInt5 > paramInt6);
	          }
	          else
	          {
	            if (i == 0);
	            localRectangle = localb_.getActualSize(this, paramInt1, paramInt2, paramInt3, paramInt4, 0, false, paramInt5 < paramInt6);
	          }
	        if (i == 0){
	          if (localRectangle != null){
	            paramInt1 = localRectangle.x;
	            paramInt2 = localRectangle.y;
	            paramInt3 = localRectangle.width;
	          }
	        }
	        else
	          paramInt4 = localRectangle.height;
	      }
	    if (i == 0)
	      if (paramInt3 == -1)
	        paramInt3 = getWidth();
	    if ((i != 0) || (paramInt4 == -1))
	      paramInt4 = getHeight();
	    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
	  }

	public boolean isOpaque() {
		return false;
	}

	public int getPreferredRowCount() {
		return this.preferredRowCount;
	}

	public void setPreferredRowCount(int preferredRowCount) {
		if (DefaultDockableBarManager.state == 0)
			if (this.preferredRowCount != preferredRowCount)
				invalidate();
		this.preferredRowCount = preferredRowCount;
	}

	public Component[] getHiddenComponents() {
		if (DefaultDockableBarManager.state == 0)
			if (this.hiddenComponents == null)
				return new Component[0];
		return (Component[]) this.hiddenComponents.toArray(new Component[0]);
	}

	void a(Component paramComponent) {
		if (DefaultDockableBarManager.state == 0)
			if (!this.hiddenComponents.contains(paramComponent))
				this.hiddenComponents.add(paramComponent);
		if (paramComponent.getParent() == this)
			remove(paramComponent);
	}

	public void remove(Component comp) {
		int k = DefaultDockableBarManager.state;
		Component[] arrayOfComponent = getComponents();
		int i = 0;
		int j = 0;
		do {
			if (j >= arrayOfComponent.length)
				break;
			if (k != 0)
				break;
			if (arrayOfComponent[j] == comp) {
				i = 1;
				if (k == 0)
					break;
			}
			j++;
		} while (k == 0);
		if (k == 0)
			if (i != 0) {
				super.remove(comp);
				return;
			}
		if ((k != 0) || (this.hiddenComponents.contains(comp))) {
			this.hiddenComponents.remove(comp);
			return;
		}
	}

	public void removeAll() {
		this.hiddenComponents.clear();
		super.removeAll();
	}

	void b(Component paramComponent) {
		int i = DefaultDockableBarManager.state;
		if (i == 0)
			if (this.hiddenComponents.contains(paramComponent))
				this.hiddenComponents.remove(paramComponent);
		if ((i != 0) || (paramComponent.getParent() != this))
			add(paramComponent);
	}

	public void removeAllHiddenComponents() {
		Object[] arrayOfObject = this.hiddenComponents.toArray();
		int i = 0;
		do {
			if (i >= arrayOfObject.length)
				break;
			Component localComponent = (Component) arrayOfObject[i];
			b(localComponent);
			i++;
		} while (DefaultDockableBarManager.state == 0);
	}

	@Override
	public boolean isMenuBar() {
		return this.menuBar;
	}

	/** @deprecated */
	public void setMenuBar(boolean menuBar) {
		this.menuBar = menuBar;
	}

	public boolean isPaintBackground() {
		return this.menuBar;
	}

	public void setPaintBackground(boolean paintBackground) {
		this.paintBackground = paintBackground;
	}

	public int getMenuCount() {
		int k = DefaultDockableBarManager.state;
		Component[] arrayOfComponent = getComponents();
		int i = 0;
		int j = 0;
		do {
			if (j >= arrayOfComponent.length)
				break;
			Component localComponent = arrayOfComponent[j];
			if (k != 0)
				break;
			if ((!(localComponent instanceof UIResource)) || (k != 0))
				i++;
			j++;
		} while (k == 0);
		return i;
	}

	public JMenu getMenu(int index) {
		int k = DefaultDockableBarManager.state;
		Component[] arrayOfComponent = getComponents();
		int i = 0;
		int j = 0;
		do {
			if (j >= arrayOfComponent.length)
				break;
			Component localComponent = arrayOfComponent[j];
			if ((k != 0)
					|| ((!(localComponent instanceof UIResource)) || (k != 0))) {
				if (index == i)
					return super.getMenu(j);
				i++;
			}
			j++;
		} while (k == 0);
		return null;
	}

	  public AccessibleContext getAccessibleContext(){
	    if (DefaultDockableBarManager.state == 0)
	      if (this.accessibleContext == null)
	        this.accessibleContext = new AccessibleCommandBar();
	    return this.accessibleContext;
	  }

	  static{
	    if (SystemInfo.isMacOSX()){
	      String[] arrayOfString = { "" };
	      boolean bool = false;
	      try{
	        arrayOfString[0] = SecurityUtils.getProperty("apple.laf.useScreenMenuBar", "true");
	        if ((arrayOfString[0] != null) && (arrayOfString[0].equals("true"))){
	          bool = true;
	        }else{
	          arrayOfString[0] = SecurityUtils.getProperty("com.apple.macos.useScreenMenuBar", "true");
	          if ((arrayOfString[0] != null) && (arrayOfString[0].equals("true"))){
	            System.err.println("com.apple.macos.useScreenMenuBar has been deprecated. Please switch to apple.laf.useScreenMenuBar");
	            bool = true;
	          }
	        }
	      }catch (Throwable localThrowable) {
	        System.err.println("Problem in Menu Bar static initializer! :  " + localThrowable);
	        localThrowable.printStackTrace();
	      }
	      flag = bool;
	    }
	  }

	  protected class AccessibleCommandBar extends JComponent.AccessibleJComponent{
	    protected AccessibleCommandBar(){
	      super();
	    }

	    public AccessibleStateSet getAccessibleStateSet(){
	      AccessibleStateSet localAccessibleStateSet = super.getAccessibleStateSet();
	      return localAccessibleStateSet;
	    }

	    public AccessibleRole getAccessibleRole(){
	      if (CommandBar.this.isMenuBar())
	        return AccessibleRole.MENU_BAR;
	      return AccessibleRole.TOOL_BAR;
	    }
	  }

	  private class b_  implements LayoutManager2, Serializable, PropertyChangeListener, UIResource {
	    a a;
	    b_(int arg2) {
//	      if (j == 0){
//	        int i;
//	        if (i == 1)
//	          this.a = new a(CommandBar.this, 3);
//	      }else{
//	        if (j == 0)
//	          break;
//	      }
	      this.a = new a(CommandBar.this, 2);
	      CommandBar.this.addPropertyChangeListener(this);
	    }

	    public void addLayoutComponent(String paramString, Component component){
	      this.a.addLayoutComponent(paramString, component);
	      this.a.invalidateLayout(CommandBar.this);
	    }

	    public void addLayoutComponent(Component component, Object paramObject){
	      this.a.addLayoutComponent(component, paramObject);
	      this.a.invalidateLayout(CommandBar.this);
	    }

	    public void removeLayoutComponent(Component component){
	      this.a.removeLayoutComponent(component);
	      this.a.invalidateLayout(CommandBar.this);
	    }

	    public Dimension preferredLayoutSize(Container container){
	      return this.a.preferredLayoutSize(container);
	    }

	    public Dimension minimumLayoutSize(Container container){
	      return this.a.minimumLayoutSize(container);
	    }

	    public Dimension maximumLayoutSize(Container container){
	      if ((DefaultDockableBarManager.state != 0) || ((this.a instanceof UIResource)))
	        return this.a.maximumLayoutSize(container);
	      return new Dimension(32767, 32767);
	    }

	    public void layoutContainer(Container paramContainer){
	      this.a.layoutContainer(paramContainer);
	    }

	    public float getLayoutAlignmentX(Container paramContainer){
	      if ((DefaultDockableBarManager.state != 0) || ((this.a instanceof UIResource)))
	        return this.a.getLayoutAlignmentX(paramContainer);
	      return 0.5F;
	    }

	    public float getLayoutAlignmentY(Container paramContainer){
	      if ((DefaultDockableBarManager.state != 0) || ((this.a instanceof UIResource)))
	        return this.a.getLayoutAlignmentY(paramContainer);
	      return 0.5F;
	    }

	    public void invalidateLayout(Container paramContainer){
	      if ((DefaultDockableBarManager.state != 0) || ((this.a instanceof UIResource)))
	        this.a.invalidateLayout(paramContainer);
	    }

	    @Override
	    public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent) {
	      int j = DefaultDockableBarManager.state;
	      String str = paramPropertyChangeEvent.getPropertyName();
	      if (j == 0)
	        if (str.equals("floating")){
	          this.a.invalidateLayout(CommandBar.this);
	          if (j == 0)
	            return;
	        }
	      if (j == 0)
	        if (str.equals("hori_docked"))
	        {
	          this.a.invalidateLayout(CommandBar.this);
	          if (j == 0)
	            return;
	        }
	      if (j == 0)
	        if (str.equals("vert_docked"))
	        {
	          this.a.invalidateLayout(CommandBar.this);
	          if (j == 0)
	            return;
	        }
	      if ((j != 0) || (str.equals("orientation"))){
	        int i = ((Integer)paramPropertyChangeEvent.getNewValue()).intValue();
	        if (j == 0){
	          if (i == 1)
	            this.a = new a(CommandBar.this, 3);
	        }
	        else if (j == 0)
	          return;
	        this.a = new a(CommandBar.this, 2);
	      }
	    }

	    public Rectangle getActualSize(Container paramContainer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2){
	      return this.a.getActualSize(paramContainer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean1, paramBoolean2);
	    }
	  }

	public static class Expansion extends Box.Filler implements Alignable, ImageObserver, MenuContainer, Serializable, Accessible {
		
		private int orientation;

		public Expansion() {
			super(new Dimension(0, 0), new Dimension(32767, 32767), new Dimension(32767, 32767));
		}
		
		public boolean supportVerticalOrientation() {
			return true;
		}

		public boolean supportHorizontalOrientation() {
			return true;
		}

		public int getOrientation() {
			return this.orientation;
		}

		public void setOrientation(int orientation) {
			this.orientation = orientation;
		}
	}

	public void setChevronAlwaysVisible(boolean b) {
		
	}
}
