package com.jidesoft.action;

import java.applet.Applet;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.IllegalComponentStateException;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JApplet;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import com.jidesoft.swing.AbstractLayoutPersistence;
import com.jidesoft.swing.JidePopupMenu;
import com.jidesoft.swing.JideSwingUtilities;
import com.jidesoft.swing.JideTabbedPane;
import com.jidesoft.utils.PortingUtils;

public class DefaultDockableBarManager  extends AbstractLayoutPersistence implements DockableBarManager, AWTEventListener, SwingConstants{
	private final Map mapDockableBar = new HashMap();
	private final List b = new ArrayList();
	private final Map map = new HashMap();
	private Container contentContaner;
	private RootPaneContainer rootPaneContainer;
	private MainContainer mainContainer;
	private TempArrayList tempArrayList;
	private Duplicate duplicate;
	private DockableBarContainer i;
	private DockableBarContainer j;
	private DockableBarContainer k;
	private DockableBarContainer l;
	private boolean single;
	private double relativeX;
	private double relativeY;
	private boolean p = false;
	private JComponent component = null;
	private boolean r = false;
	private DockableBarContainer dockableBarContainer = null;
	private boolean rearrangable = true;
	private boolean floatable = true;
	private boolean hidable = true;
	private DockableBarPopupMenuCustomizer dockableBarPopupMenuCustomizer;
	private boolean realized = false;
	private Rectangle rectangle = new Rectangle();
	//private int z;
	private boolean hideFloatingDockableBarsWhenDeactivate = true;
	private boolean show = true;
	private int initState;
	private Rectangle initBounds = new Rectangle();
	public ComponentAdapter _componentListener;
	private WindowListener windowListener;
	private Window window;
	private boolean G = false;
	private KeyEventDispatcher keyEventDispatcher;
	private boolean showInitial = true;
	FloatingDockableBarContainer floatingDockableBarContainer;
	private JidePopupMenu jidePopupMenu;
	private PropertyChangeListener propertyChangeListener;
	int M;
	int N;
	static Class _class;
	public static int state;//P
	
	
	@Override
	public void beginLoadLayoutData() {
		setRealized(false);
	}

	public void setRealized(boolean realized) {
		this.realized = realized;
	}

	@Override
	public boolean isLoadDataSuccessful() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadInitialLayout(Document layoutDocument) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loadLayoutFrom(final InputStream in) {
//		int i1 = P;
//	    boolean bool = this.G;
//	    this.G = true;
//	    try
//	    {
//	      if (i1 == 0)
//	        if (SwingUtilities.isEventDispatchThread())
//	        {
//	          a(in);
//	          if (i1 == 0);
//	        }
//	      try
//	      {
//	        SwingUtilities.invokeAndWait(new Runnable() {
//	          private final InputStream a;
//
//	          public void run()
//	          {
//	            DefaultDockableBarManager.a(DefaultDockableBarManager.this, in);
//	          }
//	        });
//	      }
//	      catch (InterruptedException localInterruptedException)
//	      {
//	        a(in);
//	      }
//	      catch (InvocationTargetException localInvocationTargetException)
//	      {
//	        a(in);
//	      }
//	      this._useFrameBounds = true;
//	      this._useFrameState = true;
//	    }
//	    finally
//	    {
//	      this.G = bool;
//	    }
		return false;
	}

	//@Override
	public boolean loadLayoutFrom(Document document) {
		return false;
	}

	@Override
	public void resetToDefault() {
		if (SwingUtilities.isEventDispatchThread()){
	      e();
		} else {
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						DefaultDockableBarManager.e(DefaultDockableBarManager.this);
					}
				});
			} catch (InterruptedException localInterruptedException) {
				e();
			} catch (InvocationTargetException localInvocationTargetException) {
				e();
			}
	    }
	}

	@Override
	public void saveLayoutTo(OutputStream out) throws IOException {
		int i1 = state;
		if (i1 == 0) {
			if (this.G)
				return;
			h();
		}
	    l();
	    DataOutputStream localDataOutputStream = new DataOutputStream(out);
	    //i.b(localDataOutputStream, this._version);
	    if (i1 == 0)
	    {
	      //i.a(localDataOutputStream, this.D);
	      if ((i() instanceof Frame))
	      {
	        //i.a(localDataOutputStream, PortingUtils.getFrameState((Frame)i()));
	        //if (i1 == 0)
	          //break label86;
	      }
	    }
	    //i.a(localDataOutputStream, 0);
	   // label86: i.a(localDataOutputStream, this.c);
//	    i.a(localDataOutputStream, getDockableBarContainer(3));
//	    i.a(localDataOutputStream, getDockableBarContainer(5));
//	    i.a(localDataOutputStream, getDockableBarContainer(7));
//	    i.a(localDataOutputStream, getDockableBarContainer(1));
//	    i.a(localDataOutputStream, this.g);
	}

	//@Override
	public void saveLayoutTo(Document document) throws ParserConfigurationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDispatched(AWTEvent event) {
		int i1 = state;
	    if ((i1 != 0) || ((event instanceof MouseEvent))){
	      MouseEvent localMouseEvent;
	      Object localObject;
	      if (i1 == 0)
	        if (event.getID() == 506){
	          localMouseEvent = (MouseEvent)event;
	          if (f()){
	            localObject = localMouseEvent.getPoint();
	            //n.convertPointToScreen((Point)localObject, (Component)localMouseEvent.getSource(), this.m);
	            dragDockableBar(null, ((Point)localObject).x, ((Point)localObject).y, localMouseEvent.getModifiersEx());
	          }
	          if (i1 == 0)
	            return;
	        }
	      if (i1 == 0){
	        if (event.getID() == 502) {
	          if ((i1 == 0) && (!f())){
	            return;
	          }
	          endDraggingDockableBar();
	        }
	      }
	      if ((i1 != 0) && (event.getID() == 500)){
	        if (((i1 != 0) || (this.jidePopupMenu != null)) && ((i1 != 0) || (this.jidePopupMenu.isVisible()))){
	          this.jidePopupMenu.setVisible(false);
	          this.jidePopupMenu = null;
	        }
	        localMouseEvent = (MouseEvent)event;
	        if (SwingUtilities.isRightMouseButton(localMouseEvent)){
	          localObject = null;
	          localObject = SwingUtilities.getDeepestComponentAt((Component)event.getSource(), localMouseEvent.getX(), localMouseEvent.getY());
	          if ((i1 != 0) || (localObject != null)){
//	            localObject = e.getDockableBarOrContainer((Component)localObject);
//	            if (i1 == 0)
//	              if ((localObject instanceof DockableBar))
//	              {
//	                if (((DockableBar)localObject).getDockableBarManager() != this)
//	                  return;
//	                showContextMenu(localMouseEvent, (Component)localObject);
//	              }
//	            if ((i1 != 0) && ((i1 != 0) || ((localObject instanceof o))))
//	              if (((o)localObject).getDockableBarManager() == this)
//	                showContextMenu(localMouseEvent, (Component)localObject);
	          }
	        }
	      }
	    }
	}

	@Override
	public void addDockableBar(DockableBar dockableBar) {
		if (SwingUtilities.isEventDispatchThread()) {
			a(dockableBar);
		} else {
//			try {
//				SwingUtilities.invokeAndWait(new Runnable() {
//					private final DockableBar a;
//					public void run() {
						//DefaultDockableBarManager.a(DefaultDockableBarManager.this,dockableBarManager);
//					}
//				});
//			} catch (InterruptedException localInterruptedException) {
//				a(dockableBarManager);
//			} catch (InvocationTargetException localInvocationTargetException) {
//				a(dockableBarManager);
//			}
		}
	}

	@Override
	public void removeDockableBar(String key) {
		final DockableBar localDockableBar = getDockableBar(key);
	    if (localDockableBar == null)
	      return;
	    if (SwingUtilities.isEventDispatchThread()){
	      b(localDockableBar);
		} else {
//			try {
//			    SwingUtilities.invokeAndWait(new Runnable() {
//	            private final DockableBar a;
//	            public void run(){
//	            DefaultDockableBarManager.b(DefaultDockableBarManager.this, localDockableBar);
//	          }
//	        });
//			} catch (InterruptedException localInterruptedException) {
//				
//			} catch (InvocationTargetException localInvocationTargetException) {
//				
//			}
	    }
	}

	@Override
	public void removeAllDockableBars() {
		List localList = getAllDockableBarNames();
	    int i1 = 0;
	    do{
	      if (i1 >= localList.size())
	        break;
	      String str = (String)localList.get(i1);
	      removeDockableBar(str);
	      i1++;
	    }
	    while (state == 0);
	}

	@Override
	public DockableBar getDockableBar(String key) {
		return (DockableBar)this.mapDockableBar.get(key);
	}

	@Override
	public void showDockableBar(String key) {
		final DockableBar localDockableBar = getDockableBar(key);
	    if (localDockableBar == null)
	      return;
	    if (SwingUtilities.isEventDispatchThread()){
	      c(localDockableBar);
	    }else{
//	      try {
//	        SwingUtilities.invokeAndWait(new Runnable(){
//	          private final DockableBar a;
//
//	          public void run() {
//	            DefaultDockableBarManager.c(DefaultDockableBarManager.this, localDockableBar);
//	          }
//	        });
//			} catch (InterruptedException localInterruptedException) {
//				
//			} catch (InvocationTargetException localInvocationTargetException) {
//				
//			}
	    }
	}

	@Override
	public void hideDockableBar(String key) {
		int i1 = state;
	    final DockableBar localDockableBar = getDockableBar(key);
	    if (i1 == 0)
	      if (localDockableBar == null)
	        return;
	    if ((i1 != 0) || (localDockableBar.isHidable())){
	      if (isHidable());
		} else {
	      return;
	    }
	    if (SwingUtilities.isEventDispatchThread()){
	      d(localDockableBar);
	    } else {
//			try {
//				SwingUtilities.invokeAndWait(new Runnable() {
//				private final DockableBar a;
//				public void run(){
//					DefaultDockableBarManager.d(DefaultDockableBarManager.this, localDockableBar);
//	          }
//	        });
//			} catch (InterruptedException localInterruptedException) {
//			} catch (InvocationTargetException localInvocationTargetException) {
//			}
	    }
	}

	@Override
	public void beginDraggingDockableBar(JComponent f, int mouseX, int mouseY,double relativeX, double relativeY, boolean single) {
		int i1 = state;
	    if (i1 == 0)
	      if (!isRearrangable())
	        return;
	    if (i1 == 0){
	      if ((f instanceof DockableBar)){
	        if (i1 != 0);
	        if (!((DockableBar)f).isRearrangable())
	          return;
	      }
	      this.relativeX = relativeX;
	      this.relativeY = relativeY;
	      this.single = single;
	    }
	    if ((f.getTopLevelAncestor() instanceof FloatingDockableBarContainer))
	      this.floatingDockableBarContainer = ((FloatingDockableBarContainer)f.getTopLevelAncestor());
	    if (i1 == 0){
	      if (this.rootPaneContainer != null){
	        this.rootPaneContainer.getGlassPane().setVisible(true);
	        this.rootPaneContainer.getGlassPane().setCursor(Cursor.getPredefinedCursor(13));
	      }
	      this.p = true;
	      this.component = f;
	    }
	    a();
	}

	@Override
	public void dragDockableBar(JComponent f, int newX, int newY,int mouseModifiers) {
		int i7 = state;
	    if (!f())
	      return;
	    if ((i7 != 0) || (f == null))
	      f = this.component;
	    Container localContainer1 = null;
	    DockableBarContainer localo = null;
	    Point localPoint1 = new Point(newX, newY);
	    if (i7 == 0)
	      if (this.r){
	        if (i7 != 0);
	        if (this.dockableBarContainer != null)
	        {
	          localo = this.dockableBarContainer;
	        }
	      }
	    localContainer1 = getContainer();
	    Point localPoint2;
	     int i5;
	     int i2;
	    if (localContainer1 != null){
	      localPoint2 = new Point(localPoint1);
	     // n.convertPointFromScreen(localPoint2, localContainer1, this.m);
	      //localo = (DockableBarContainer)e.findNearbyDockableBarContainerAt(this, localContainer1, localPoint2, 22);
	      if (i7 == 0)
	        if (localo != null)
	        {
	          if (i7 != 0)
	            ;
	          //if (localo.getDockableBarManager() != this)
	            localo = null;
	        }
	      if (i7 == 0)
	        if (localo == null)
	        {
	          Container localContainer2 = getContainer();
	          if (localContainer2 != null)
	          {
	            Point localPoint4 = new Point(localPoint1);
	           // n.convertPointFromScreen(localPoint4, localContainer2, this.m);
	            //i5 = e.sideOfComponent(localContainer2, localPoint2.x, localPoint2.y);
//	            if (i7 == 0);
//	            switch (i5)
//	            {
//	            case 7:
//	              localo = this.j;
//	              if (i7 == 0)
//	                break;
//	            case 1:
//	              localo = this.k;
//	              if (i7 == 0)
//	                break;
//	            case 5:
//	              localo = this.l;
//	              if (i7 == 0)
//	                break;
//	            case 3:
//	              localo = this.i;
//	            case 2:
//	            case 4:
//	            case 6:
//	            }
	            if (i7 != 0);
	            if (localo != null)
	            {
	              if (i7 != 0);
	              if (!localo.isShowing())
	                localo = null;
	            }
	          }
	        }
	      if (i7 == 0)
	        if (localo != null)
	        {
	          if (i7 != 0);
	          //i2 = localo.getSide();
//	          if ((((DockableBar)f).getCanSide() & e.convertSideToDockSide(i2)) == 0)
//	            localo = null;
	        }
	      if (((i7 != 0) || (localo == null)) && ((i7 != 0) || ((!((DockableBar)f).isFloatable()) && ((i7 != 0) || (!((DockableBar)f).isFloating())))))
	        localo = (DockableBarContainer)f.getParent();
	    }
	    if (i7 == 0)
	      if ((this.floatingDockableBarContainer == null) && (localo != null))
	      {
	        localPoint2 = new Point(localPoint1);
	        //n.convertPointFromScreen(localPoint2, localo, this.m);
	        i2 = localPoint2.x - (int)(f.getWidth() * this.relativeX);
	        int i3 = localPoint2.y - (int)(f.getHeight() * this.relativeY);
	        i5 = -1;
	        if (i7 == 0)
	          if (!localo.equals(f.getParent()))
	          {
	            Container localContainer3 = f.getParent();
	            localContainer3.remove(f);
	            if (i7 == 0)
	              if ((f instanceof DockableBar))
	              {
	                //((DockableBar)f).setOrientation(localo.getOrientation());
	                try
	                {
	                  if (i7 == 0)
	                    //if (localo.getOrientation() == 0)
	                   // {
	                      ((DockableBar)f).setHoriDocked();
	                      if (i7 == 0);
	                   // }
	                  ((DockableBar)f).setVertDocked();
	                }catch (PropertyVetoException localPropertyVetoException2){
	                	
	                }
	              }
	            localo.add(f);
	            if (i7 == 0);
	          }
	       // i5 = localo.getCurrentRowOf((DockableBar)f);
	        //int i6 = localo.getRowAndGapIndexAt(localPoint2);
	        if (i7 == 0)
	          if (((DockableBar)f).isStretch())
	          {
	            if (i7 != 0);
	           // if (i6 > 0)
	            //{
	              if (i7 != 0);
	               
	             // if (i6 / 2 > i5)
	             // {
	                if (i7 != 0);
	              //  if (i6 <= i5 * 2 + 2)
	                //  i6 = i5 * 2;
	             // }
	            //}
	          }
	       // if (((i7 != 0) || (i5 != -1)) && ((i7 != 0) || (i6 % 2 != 0)) && (i6 / 2 == i5))
	       // {
	          if (i7 == 0);
	         //localo.getDockableBarList().changeComponentStart(paramJComponent, localo.getOrientation() == 0 ? i2 : i3);
	        //}
	        else
	        {
	          if (i7 == 0);
	          //localo.getDockableBarList().changeComponentRow(paramJComponent, i6 / 2, i6 % 2 == 0, localo.getOrientation() == 0 ? i2 : i3);
	        }
	        if (i7 == 0)
	          return;
	      }
	    int i1;
	    Rectangle localRectangle1;
	    if (i7 == 0)
	      if ((this.floatingDockableBarContainer == null) && ((i7 != 0) || (localo == null)))
	      {
	        if ((i7 == 0) && (!(f instanceof DockableBar)))
	          return;
	        i1 = newX;
	        i2 = newY;
	        localRectangle1 = ((DockableBar)f).getUndockedBounds();
	        if (i7 == 0)
	        {
	          if (localRectangle1 != null)
	            floatDockableBar((DockableBar)f, new Rectangle(i1, i2, localRectangle1.width, localRectangle1.height));
	        }
	        else
	          if (i7 == 0);
	        floatDockableBar((DockableBar)f, new Rectangle(i1, i2, 0, 0));
	        if (i7 == 0)
	          return;
	      }
	    if (i7 == 0)
	      if ((this.floatingDockableBarContainer != null) && (localo == null))
	      {
	        i1 = newX - (int)(this.floatingDockableBarContainer.getWidth() * this.relativeX);
	        i2 = newY - (int)(this.floatingDockableBarContainer.getHeight() * this.relativeY);
	        localRectangle1 = new Rectangle(i1, i2, this.floatingDockableBarContainer.getWidth(), this.floatingDockableBarContainer.getHeight());
	        Rectangle localRectangle2 = PortingUtils.getScreenBounds(this.floatingDockableBarContainer);
	        if (i7 == 0)
	          if (localRectangle1.y + localRectangle1.height > localRectangle2.y + localRectangle2.height)
	            localRectangle1.y = (localRectangle2.y + localRectangle2.height - localRectangle1.height);
	        if ((i7 != 0) || (localRectangle1.y < localRectangle2.y))
	          localRectangle1.y = localRectangle2.y;
	        this.floatingDockableBarContainer.setLocation(localRectangle1.x, localRectangle1.y);
	      }
	    if ((i7 != 0) && (this.floatingDockableBarContainer != null))
	      if (i7 == 0)
	      {
	        if (localo != null)
	        {
	          this.floatingDockableBarContainer.setVisible(false);
	          //this.g.remove(this.floatingDockableBarContainer);
	          this.floatingDockableBarContainer.dispose();
	          this.floatingDockableBarContainer = null;
	        }
	      }
	      else
	      {
	        if ((i7 != 0) || ((f instanceof DockableBar)));
	          try
	          {
	            if (i7 == 0)
	              //if (localo.getOrientation() == 0)
	             // {
	                ((DockableBar)f).setHoriDocked();
	                if (i7 == 0);
	             // }
	            ((DockableBar)f).setVertDocked();
	          }
	          catch (PropertyVetoException localPropertyVetoException1)
	          {
	          }
	        Point localPoint3 = new Point(localPoint1);
	       // n.convertPointFromScreen(localPoint3, localo, this.m);
	        //i2 = localo.getRowAndGapIndexAt(localPoint3);
	        if (i7 == 0)
	        {
	          if ((f instanceof DockableBar))
	           // ((DockableBar)f).setOrientation(localo.getOrientation());
	          localo.add(f);
	        }
	        if (i7 == 0);
	        //int i4 = localo.getOrientation() == 0 ? localPoint3.x - (int)(f.getWidth() * this.n) : localPoint3.y - (int)(f.getHeight() * this.o);
	        if (i7 == 0);
	        //localo.getDockableBarList().changeComponentRow(f, i2 / 2, i2 % 2 == 0, i4);
	      }
	}

	@Override
	public void pauseDragDockableBar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDraggingDockableBar() {
		g();
	}

	@Override
	public void beginResizingDockableBar(JComponent f, int direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resizingDockableBar(JComponent f, int newX, int newY,int newWidth, int newHeight, int deltaX, int deltaY) {
		int i1 = state;
	    if (i1 == 0)
	      if ((f instanceof CommandBar)){
	        //((CommandBar)f).a(newX, newY, newWidth, newHeight, deltaX, this.M, deltaY, this.N);
	    //Container localContainer = f.getTopLevelAncestor();
	    //if ((i1 != 0) || ((localContainer instanceof Window)))
	    //{
	      //Window localWindow = (Window)localContainer;
	     // Rectangle localRectangle = localWindow.getBounds();
	    //  if (i1 == 0)
	    //  {
	       // if ((localRectangle.width != f.getWidth()) || (localRectangle.height != f.getHeight()))
	       // {
	        //  this.M = deltaX;
	         // this.N = deltaY;
	         // ((DockableBar)f).setUndockedBounds(new Rectangle(localRectangle.x + newX, localRectangle.y + newY, f.getWidth(), f.getHeight()));
	         // localWindow.setBounds(((DockableBar)f).getUndockedBounds());
	       // }
	     // }
	      //else
	       // localWindow.validate();
	    }
	}

	@Override
	public void endResizingDockableBar(JComponent f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RootPaneContainer getRootPaneContainer() {
		return this.rootPaneContainer;
	}

	@Override
	public MainContainer getMainContainer() {
		 return this.mainContainer;
	}

	@Override
	public void toggleState(DockableBar bar) {
		int i1 = state;
	    if (((i1 != 0) || (bar.isRearrangable())) && ((i1 != 0) || (bar.isFloatable())) && ((i1 != 0) || (isRearrangable()))){
			if (isFloatable())
				;
		} else {
			return;
		}
	    if (i1 == 0)
	      if (bar.isFloating()){
//	        localg = g.createPreviousState(bar);
//	        g.disposePreviousState(bar.getContext().getFloatPreviousState());
//	        bar.getContext().setFloatPreviousState(localg);
//	        h(bar);
	        if (i1 == 0)
	          return;
	      }
//	    g localg = g.createPreviousState(bar);
//	    g.disposePreviousState(bar.getContext().getDockPreviousState());
//	    bar.getContext().setDockPreviousState(localg);
	    i(bar);
	}

	@Override
	public boolean isRearrangable() {
		 return this.rearrangable;
	}

	@Override
	public void setRearrangable(boolean rearrangable) {
		int i2 = state;
	    if (i2 == 0)
	      if (this.rearrangable == rearrangable)
	        return;
	    boolean bool = this.rearrangable;
	    this.rearrangable = rearrangable;
	    List localList = getAllDockableBarNames();
	    int i1 = 0;
	    do
	    {
	      if (i1 >= localList.size())
	        break;
	      String str = (String)localList.get(i1);
	      DockableBar localDockableBar = getDockableBar(str);
	      if (i2 == 0)
	      {
	        if (localDockableBar != null)
	          localDockableBar.firePropertyChange("rearrangable", bool, this.rearrangable);
	        i1++;
	      }
	    }
	    while (i2 == 0);
	}

	@Override
	public boolean isFloatable() {
		return this.floatable;
	}

	@Override
	public void setFloatable(boolean floatable) {
		int i2 = state;
	    if (i2 == 0)
	      if (this.floatable == floatable)
	        return;
	    boolean bool = this.floatable;
	    this.floatable = floatable;
	    List localList = getAllDockableBarNames();
	    int i1 = 0;
	    do{
	      if (i1 >= localList.size())
	        break;
	      String str = (String)localList.get(i1);
	      DockableBar localDockableBar = getDockableBar(str);
	      if (i2 == 0)
	      {
	        if (localDockableBar != null)
	          localDockableBar.firePropertyChange("floatable", bool, this.floatable);
	        i1++;
	      }
	    }
	    while (i2 == 0);
	}

	@Override
	public boolean isHidable() {
		return this.hidable;
	}

	@Override
	public void setHidable(boolean hidable) {
		int i2 = state;
	    if (i2 == 0)
	      if (this.hidable == hidable)
	        return;
	    boolean bool = this.hidable;
	    this.hidable = hidable;
	    List localList = getAllDockableBarNames();
	    int i1 = 0;
	    do {
	      if (i1 >= localList.size())
	        break;
	      String str = (String)localList.get(i1);
	      DockableBar localDockableBar = getDockableBar(str);
	      if (i2 == 0){
	        if (localDockableBar != null)
	          localDockableBar.firePropertyChange("hidable", bool, this.hidable);
	        i1++;
	      }
	    }
	    while (i2 == 0);
	}

	@Override
	public void updateComponentTreeUI() {
		int i3 = state;
	    SwingUtilities.updateComponentTreeUI(i());
	    if (i3 == 0)
	      if (this.tempArrayList != null){
	        int i1 = 0;
	        do{
	          if (i1 >= this.tempArrayList.size())
	            break;
	          if (i3 != 0);
	          FloatingDockableBarContainer localq = (FloatingDockableBarContainer)this.tempArrayList.get(i1);
	          SwingUtilities.updateComponentTreeUI(localq);
	          i1++;
	        }
	        while (i3 == 0);
	      }
	    List localList = getAllDockableBarNames();
	    int i2 = 0;
	    do
	    {
	      if (i2 >= localList.size())
	        break;
	      String str = (String)localList.get(i2);
	      DockableBar localDockableBar = getDockableBar(str);
	      if (i3 == 0){
	        if (i3 != 0);
	        if ((localDockableBar != null) && ((i3 != 0) || (localDockableBar.isHidden())))
	          SwingUtilities.updateComponentTreeUI(localDockableBar);
	        i2++;
	      }
	    }
	    while (i3 == 0);
	    getContainer().invalidate();
	    getContainer().doLayout();
	}

	@Override
	public Collection getAllDockableBars() {
		return this.mapDockableBar.values();
	}

	@Override
	public List getAllDockableBarNames() {
		return new ArrayList(this.b);
	}

	@Override
	public DockableBarPopupMenuCustomizer getDockableBarPopupMenuCustomizer() {
		return this.dockableBarPopupMenuCustomizer;
	}

	@Override
	public void setDockableBarPopupMenuCustomizer(DockableBarPopupMenuCustomizer dockableBarPopupMenuCustomizer) {
		 this.dockableBarPopupMenuCustomizer = dockableBarPopupMenuCustomizer;
	}

	@Override
	public void showContextMenu(MouseEvent e, Component component) {
		 int i2 = state;
		    List localList = getAllDockableBarNames();
		    this.jidePopupMenu = new JidePopupMenu();
		    int i1 = 0;
		    Object localObject;
		    do {
		      if (i1 >= localList.size())
		        break;
		      localObject = (String)localList.get(i1);
		      DockableBar localDockableBar = getDockableBar((String)localObject);
		      if (i2 != 0);
		      if (i2 == 0){
		        if (localDockableBar != null){
		          JCheckBoxMenuItem localJCheckBoxMenuItem2 = (JCheckBoxMenuItem)this.jidePopupMenu.add(new JCheckBoxMenuItem(localDockableBar.getTitle()));
		          if ((i2 != 0) || ((localDockableBar.isHidable()) && (isHidable()))){
//		            localJCheckBoxMenuItem2.addActionListener(new AbstractAction()
//		            {
//		              private final String a;
//
//		              public void actionPerformed(ActionEvent paramAnonymousActionEvent)
//		              {
//		                int i = DefaultDockableBarManager.P;
//		                DockableBar localDockableBar = DefaultDockableBarManager.this.getDockableBar(this.a);
//		                if ((i != 0) || (localDockableBar != null))
//		                  if (localDockableBar.isHidden())
//		                  {
//		                    DefaultDockableBarManager.this.showDockableBar(this.a);
//		                  }
//		                  else
//		                  {
//		                    DefaultDockableBarManager.this.hideDockableBar(this.a);
//		                  }
//		              }
//		            });
		            if (i2 == 0);
					} else {
						localJCheckBoxMenuItem2.setEnabled(false);
					}
		          localJCheckBoxMenuItem2.setSelected(!localDockableBar.isHidden());
		        }
		        i1++;
		      }
		    }
		    while (i2 == 0);
		    this.jidePopupMenu.addSeparator();
		   // JCheckBoxMenuItem localJCheckBoxMenuItem1 = (JCheckBoxMenuItem)this.K.add(new JCheckBoxMenuItem(h.a.getString("DockableBar.rearrangable")));
//		    localJCheckBoxMenuItem1.addActionListener(new AbstractAction()
//		    {
//		      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
//		      {
//		        if (DefaultDockableBarManager.P == 0);
//		        DefaultDockableBarManager.this.setRearrangable(!DefaultDockableBarManager.this.isRearrangable());
//		      }
//		    });
//		    localJCheckBoxMenuItem1.setSelected(isRearrangable());
		    //localJCheckBoxMenuItem1 = (JCheckBoxMenuItem)this.K.add(new JCheckBoxMenuItem(h.a.getString("DockableBar.hidable")));
//		    localJCheckBoxMenuItem1.addActionListener(new AbstractAction()
//		    {
//		      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
//		      {
//		        if (DefaultDockableBarManager.P == 0);
//		        DefaultDockableBarManager.this.setHidable(!DefaultDockableBarManager.this.isHidable());
//		      }
//		    });
//		    localJCheckBoxMenuItem1.setSelected(isHidable());
		   // localJCheckBoxMenuItem1 = (JCheckBoxMenuItem)this.K.add(new JCheckBoxMenuItem(h.a.getString("DockableBar.floatable")));
//		    localJCheckBoxMenuItem1.addActionListener(new AbstractAction()
		  //  {
//		      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
//		      {
//		        if (DefaultDockableBarManager.P == 0);
//		        DefaultDockableBarManager.this.setFloatable(!DefaultDockableBarManager.this.isFloatable());
//		      }
//		    });
//		    localJCheckBoxMenuItem1.setSelected(isFloatable());
//		    if (i2 == 0)
//		      if (getDockableBarPopupMenuCustomizer() != null)
//		        //getDockableBarPopupMenuCustomizer().customizePopupMenu(this.K, this, paramComponent);
//		    if ((i2 != 0) || (this.K.getComponentCount() > 0))
//		    {
		     // localObject = SwingUtilities.convertPoint((Component)paramMouseEvent.getSource(), paramMouseEvent.getPoint(), paramComponent);
		      //this.K.show(paramComponent, ((Point)localObject).x, ((Point)localObject).y);
//		    }
	}

	@Override
	public void floatDockableBar(final DockableBar dockableBar,final Rectangle bounds) {
		int i1 = state;
		if ((i1 != 0) || (dockableBar.isFloatable())) {
			if (i1 != 0);
			if (isFloatable());
		} else {
			return;
		}
	    dockableBar.resetDockID();
	    if (i1 == 0)
	      if (SwingUtilities.isEventDispatchThread()){
	        label42: a(dockableBar, bounds);
	        if (i1 == 0)
	          return;
	      }
		//try {
//			SwingUtilities.invokeAndWait(new Runnable() {
//	        private final DockableBar a;
//	        private final Rectangle b;
//
//	        public void run()
//	        {
//	          DefaultDockableBarManager.a(DefaultDockableBarManager.this, dockableBar, bounds);
//	        }
//	      });
		//} catch (InterruptedException localInterruptedException) {
		//} catch (InvocationTargetException localInvocationTargetException) {
	   // }
	}

	@Override
	public void dockDockableBar(final DockableBar dockableBar, final int side, final int row,final boolean createNewRow, final int start) {
		if (SwingUtilities.isEventDispatchThread()){
	      a(dockableBar, side, row, createNewRow, start);
	      if (state == 0);
	    }else {
//			try {
//				SwingUtilities.invokeAndWait(new Runnable() {
//					private final DockableBar a;
//					private final int b;
//					private final int c;
//					private final boolean d;
//					private final int e;
//
//					public void run() {
//						DefaultDockableBarManager.a(DefaultDockableBarManager.this, dockableBar, side, row, createNewRow, start);
//	                }
//				});
//			} catch (InterruptedException localInterruptedException) {
//
//			} catch (InvocationTargetException localInvocationTargetException) {
//	      }
	    }
	}

	@Override
	public DockableBarContainer getDockableBarContainer(int side) {
		switch (side) {
		case 7:
			return this.j;
		case 3:
			return this.i;
		case 1:
			return this.k;
		case 5:
			return this.l;
		case 2:
		case 4:
		case 6:
		}
		return null;
	}

	@Override
	public Rectangle getInitBounds() {
		int i1 = state;
		if (i1 == 0)
			if (this.rectangle.isEmpty()) {
				Dimension localDimension = PortingUtils.getScreenSize(i());
				if (i1 == 0) {
					if (localDimension.width <= 1024)
						this.rectangle.setBounds(0, 0, localDimension.width,
								localDimension.height);
				} else if (i1 == 0)
					;
				this.rectangle.setBounds(0, 0, 1024, 768);
			}
		return this.rectangle;
	}

	@Override
	public void setInitBounds(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	@Override
	public int getInitState() {
		int i1 = state;
	    Dimension localDimension = PortingUtils.getScreenSize(i());
	    Rectangle localRectangle = getInitBounds();
	    if (i1 == 0)
	      if (localRectangle.width <= localDimension.width)
	      {
	        if (i1 != 0);
	        if (localRectangle.height <= localDimension.height);
	      }
	    //return 6;
	    return this.initState;
	}

	@Override
	public void setInitState(int initState) {
		 this.initState = initState;
	}

	@Override
	public void dispose() {
		int i1 = state;
		removeAllDockableBars();
		d();
		this.keyEventDispatcher = null;
		this.map.clear();
		i().removeComponentListener(this._componentListener);
		this._componentListener = null;
		this.i = null;
		this.j = null;
		this.k = null;
		this.l = null;
		if (i1 == 0)
			if (this.tempArrayList != null) {
				 this.tempArrayList.clear();
				this.tempArrayList = null;
			}
		if (i1 == 0) {
			if (this.duplicate != null) {
			    this.duplicate.clear();
				this.duplicate = null;
			}
			this.contentContaner = null;
			this.dockableBarPopupMenuCustomizer = null;
			this.mainContainer = null;
		}
		this.rootPaneContainer = null;
	}

	@Override
	public DockableBarContext getDockableBarContextOf(String barName) {
		Object localObject = this.map.get(barName);
		if ((state != 0) || (localObject != null)){
			return (DockableBarContext) localObject;
		}
		return null;
	}

	@Override
	public void removeFromHiddenDockableBars(String name) {
		 //this.h.remove(name);
	}

	@Override
	public void setFloatingDockableBarsVisible(boolean show) {
		this.show = show;
	    a(show);
	}
	
	private boolean g() {
		return this.r;
	}
	  
	@Override
	public void switchRootPaneContainer(RootPaneContainer rootContainer) {
		boolean bool = CommandBarFactory.flag;
	    if (rootContainer == null)
	      return;
	    this.rootPaneContainer = rootContainer;
	    this._componentListener = new ComponentAdapter(){
	      public void componentMoved(ComponentEvent event){
	        a();
	        a(event);
	      }

	      public void componentHidden(ComponentEvent event)
	      {
	        a();
	      }

	      public void componentResized(ComponentEvent event)
	      {
	        a();
	        a(event);
	      }

	      private void a(){
	        if ((CommandBarFactory.flag) || (DefaultDockableBarManager.this.g()))
	          DefaultDockableBarManager.this.cancelDragging();
	      }

	      private void a(ComponentEvent paramAnonymousComponentEvent){
	        boolean bool = CommandBarFactory.flag;
	        if (!bool){
	          if (!DefaultDockableBarManager.this._useFrameBounds){
	            return;
	          }
	        }
	        Object localObject;
	        if (!bool)
	          if ((paramAnonymousComponentEvent.getComponent() instanceof Frame)) {
	            localObject = (Frame)paramAnonymousComponentEvent.getComponent();
	            if (!bool){
	              if (PortingUtils.getFrameState((Frame)localObject) != 6){
	                DefaultDockableBarManager.this.rectangle.x = ((Frame)localObject).getX();
	                DefaultDockableBarManager.this.rectangle.y = ((Frame)localObject).getY();
	                DefaultDockableBarManager.this.rectangle.width = ((Frame)localObject).getWidth();
	              }
	            }else
	              DefaultDockableBarManager.this.rectangle.height = ((Frame)localObject).getHeight();
	          }
	        if ((bool) && ((bool) || ((paramAnonymousComponentEvent.getComponent() instanceof Window))))
	        {
	          localObject = (Window)paramAnonymousComponentEvent.getComponent();
	          DefaultDockableBarManager.this.rectangle.x = ((Window)localObject).getX();
	          DefaultDockableBarManager.this.rectangle.y = ((Window)localObject).getY();
	          DefaultDockableBarManager.this.rectangle.width = ((Window)localObject).getWidth();
	          DefaultDockableBarManager.this.rectangle.height = ((Window)localObject).getHeight();
	        }
	      }
	    };
	    if (!bool)
	      //if (j() != null)
	      //  j().addComponentListener(this._componentListener);
	    this.windowListener = new WindowAdapter(){
	      public void windowActivated(WindowEvent paramAnonymousWindowEvent){
	        boolean bool = CommandBarFactory.flag;
	        if (!bool)
	          if (DefaultDockableBarManager.this.isHideFloatingDockableBarsWhenDeactivate())
	            DefaultDockableBarManager.this.a(true);
	        if ((bool) || (DefaultDockableBarManager.this.window != null))
	          DefaultDockableBarManager.this.window = null;
	      }

	      public void windowDeactivated(WindowEvent event){
	        boolean bool = CommandBarFactory.flag;
	        if ((bool) || ((!DefaultDockableBarManager.this.isOwnedWindow(event.getOppositeWindow())) && ((bool) || (!DefaultDockableBarManager.this.isOwnedFloatingDockableBar(event.getOppositeWindow())))))
	        {
	          if (!bool)
	            if (DefaultDockableBarManager.this.window == null){
	             // Component localComponent = DefaultDockableBarManager.this.j();
	              if (bool);
	             // if ((localComponent instanceof Window))
	                //DefaultDockableBarManager.this.window = ((Window)localComponent);
	            }
	          if ((bool) || (DefaultDockableBarManager.this.isHideFloatingDockableBarsWhenDeactivate()))
	            DefaultDockableBarManager.this.a(false);
	        }
	      }
	    };
	    if ((bool) || ((rootContainer instanceof Window))){
	      ((Window)rootContainer).addWindowListener(this.windowListener);
	    }
	}

	@Override
	public void setShowInitial(boolean value) {
		this.showInitial = value;
	}

	@Override
	public boolean isShowInitial() {
		return this.showInitial;
	}

	@Override
	public void showInitial() {
		 int i1 = state;
		    i().setVisible(true);
		    if ((i1 != 0) || (((i() instanceof Frame)) && ((i1 != 0) || (this._useFrameState))))
		      PortingUtils.setFrameState((Frame)i(), this.initState);
	}

	@Override
	public boolean isHideFloatingDockableBarsWhenDeactivate() {
		return this.hideFloatingDockableBarsWhenDeactivate;
	}

	@Override
	public void setHideFloatingDockableBarsWhenDeactivate(boolean hideFloatingDockableBarsWhenDeactivate) {
		this.hideFloatingDockableBarsWhenDeactivate = hideFloatingDockableBarsWhenDeactivate;
	}
	
	public DefaultDockableBarManager(RootPaneContainer rootContainer, Container contentContaner){
		//½øÈë
	    switchRootPaneContainer(rootContainer);
	    this.contentContaner = contentContaner;
	    this.mainContainer = new MainContainer();
	    getContainer().setBackground(UIManager.getColor("ContentContainer.background"));
	    getContainer().setLayout(new BorderLayout());
	    getContainer().add(this.mainContainer, "Center");
	    addAWTEventListener();
	    this.propertyChangeListener = new PropertyChangeListener(){
	      public void propertyChange(PropertyChangeEvent paramAnonymousPropertyChangeEvent){
	        if ("key".equals(paramAnonymousPropertyChangeEvent.getPropertyName()))
	          DefaultDockableBarManager.a(DefaultDockableBarManager.this, (String)paramAnonymousPropertyChangeEvent.getOldValue(), (String)paramAnonymousPropertyChangeEvent.getNewValue());
	      }
	    };
	    setRealized(false);
//	    if (DockableBar.l != 0){
//	      i1++;
//	      P = i1;
//	    }
	  }

	  private void a(boolean paramBoolean){
//	    int i1 = P;
//	    if (i1 == 0)
//	      if (this.g == null)
//	        return;
//	    if (i1 == 0)
//	      if (!isHideFloatingDockableBarsWhenDeactivate())
//	        return;
//	    Iterator localIterator = this.g.iterator();
//	    label98: 
//	    do
//	    {
//	      q localq;
//	      do
//	      {
//	        Object localObject;
//	        do
//	        {
//	          if (!localIterator.hasNext())
//	            break;
//	          localObject = localIterator.next();
//	        }
//	        while (!(localObject instanceof q));
//	        localq = (q)localObject;
//	        if (i1 != 0)
//	          break label98;
//	        if ((!this.B) || (!paramBoolean))
//	          break;
//	        hackSetFrameVisible(localq, paramBoolean);
//	      }
//	      while (i1 == 0);
//	      hackSetFrameVisible(localq, false);
//	    }
//	    while (i1 == 0);
	  }

	  protected void hackSetFrameVisible(FloatingDockableBarContainer paramq, boolean paramBoolean)
	  {
	    int i3 = state;
	    try
	    {
	      int i1 = paramq.getLocationOnScreen().x;
	      int i2 = paramq.getLocationOnScreen().y;
	      if (i3 == 0)
	        if (paramBoolean)
	        {
	          if (i3 != 0);
	          if (!hackIsFrameVisible(paramq))
	          {
	            paramq.setLocation(i1, i2 + 10000);
	            if (i3 == 0)
	              return;
	          }
	        }
	      if ((i3 != 0) || ((!paramBoolean) && (hackIsFrameVisible(paramq))))
	        paramq.setLocation(i1, i2 - 10000);
	    }
	    catch (IllegalComponentStateException localIllegalComponentStateException){
	    	
	    }
	  }

	  protected boolean hackIsFrameVisible(FloatingDockableBarContainer paramq){
	    int i1 = paramq.getLocationOnScreen().y;
	    if (state == 0);
	    return i1 >= -paramq.getHeight();
	  }

	  protected boolean isOwnedFloatingDockableBar(Window paramWindow)
	  {
	    int i1 = state;
	    //if (((i1 == 0) && (this.g == null)) || ((i1 != 0) || ((this.g.size() == 0) || (paramWindow == null))))
	      return false;
	    //return this.g.contains(paramWindow);
	  }

	  private static boolean a(Container paramContainer, Object paramObject){
	    int i1 = state;
	    Container localContainer = paramContainer;
	    do{
	      if (localContainer == null)
	        break;
	      if (i1 == 0)
	        if (localContainer == paramObject)
	          return true;
	      localContainer = localContainer.getParent();
	    }while (i1 == 0);
	    return false;
	  }

	  protected boolean isOwnedWindow(Window paramWindow){
	    int i1 = state;
	    if ((i1 != 0) || (paramWindow != null))
	    {
	      if (i1 != 0);
	      if (a(paramWindow, getRootPaneContainer()))
	        return true;
	    }
	    return false;
	  }

	  private void a(){
	    try{
	      this.keyEventDispatcher = new KeyEventDispatcher(){
	        public boolean dispatchKeyEvent(KeyEvent paramAnonymousKeyEvent){
	          DefaultDockableBarManager.a(DefaultDockableBarManager.this, paramAnonymousKeyEvent);
	          return false;
	        }
	      };
	      KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this.keyEventDispatcher);
	    }catch (SecurityException localSecurityException){
	      System.err.println(localSecurityException.getLocalizedMessage());
	    }
	  }

	  //b
	  private void addAWTEventListener(){
	    try{
	      Toolkit.getDefaultToolkit().addAWTEventListener(this, 48L);
	    }catch (SecurityException localSecurityException){
	      System.err.println(localSecurityException.getLocalizedMessage());
	    }
	  }

	  private void c(){
		try {
			KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(this.keyEventDispatcher);
		} catch (SecurityException localSecurityException) {
			System.err.println(localSecurityException.getLocalizedMessage());
		}
	  }

	  private void d(){
	    try{
	      Toolkit.getDefaultToolkit().removeAWTEventListener(this);
	    }catch (SecurityException localSecurityException) {
	      System.err.println(localSecurityException.getLocalizedMessage());
	    }
	  }

	  private void a(AWTEvent paramAWTEvent){
	    int i1 = state;
	    if ((i1 != 0) || ((paramAWTEvent instanceof KeyEvent))){
	      if (i1 == 0)
	        if (paramAWTEvent.getID() == 401){
	          if (i1 != 0);
	          if (((KeyEvent)paramAWTEvent).getKeyCode() == 27){
	            if ((i1 == 0) && (!f()))
	              return;
	            cancelDragging();
	            if (i1 == 0)
	              return;
	          }
	        }
	      if (i1 == 0)
	        if (paramAWTEvent.getID() == 401){
	          if (i1 != 0);
	          if (((KeyEvent)paramAWTEvent).getKeyCode() == 17){
	            b(false);
	            if (i1 == 0)
	              return;
	          }
	        }
	      if ((i1 != 0) || ((paramAWTEvent.getID() == 402) && (((KeyEvent)paramAWTEvent).getKeyCode() == 17)))
	        b(true);
	    }
	  }

	  private void e(){
	    int i3 = state;
	    j();
	    this.initBounds = getInitBounds();
	    this.initState = getInitState();
	    this.duplicate = new Duplicate();
	    //this.g = new l();
	    //this.i = createDockableBarContainer();
	    //this.i.setSide(3);
	    //this.j = createDockableBarContainer();
	    //this.j.setSide(7);
	    //this.k = createDockableBarContainer();
	    //this.k.setSide(1);
	    //this.l = createDockableBarContainer();
	    //this.l.setSide(5);
	    getContainer().add(this.i, "East");
	    getContainer().add(this.j, "West");
	    getContainer().add(this.l, "South");
	    getContainer().add(this.k, "North");
	    ArrayList localArrayList1 = new ArrayList();
	    ArrayList localArrayList2 = new ArrayList();
	    ArrayList localArrayList3 = new ArrayList();
	    ArrayList localArrayList4 = new ArrayList();
	    ArrayList localArrayList5 = new ArrayList();
	    int i1 = 0;
	    do
	    {
	      if (i1 >= this.b.size())
	        break;
	      if (i3 != 0)
	        break;
	      Object localObject = getDockableBar((String)this.b.get(i1));
	      ((DockableBar)localObject).getContext().setInitPosition(true);
	      ((DockableBar)localObject).getContext().setCurrentMode(((DockableBar)localObject).getContext().getInitMode());
	      if (i3 == 0)
	        if (((DockableBar)localObject).isHidden())
	          //this.h.add(((DockableBar)localObject).getKey());
	      if (i3 == 0)
	        if (!((DockableBar)localObject).isVertDocked())
	        {
	          if (i3 != 0);
	          if (!((DockableBar)localObject).isHoriDocked())
	            break;
	        }
	      int i2 = ((DockableBar)localObject).getContext().getInitSide();
	      ((DockableBar)localObject).getContext().setCurrentDockSide(i2);
	      if (i3 == 0);
//	      switch (e.convertDockSideToSide(i2))
//	      {
//	      case 3:
//	        //localArrayList2.add(localObject);
//	        if (i3 == 0)
//	          break;
//	      case 7:
//	       // localArrayList1.add(localObject);
//	        if (i3 == 0)
//	          break;
//	      case 1:
//	        //localArrayList3.add(localObject);
//	        if (i3 == 0)
//	          break;
//	      case 5:
//	       // localArrayList4.add(localObject);
//	      case 2:
//	      case 4:
//	      case 6:
//	      }
	      if (i3 != 0)
//	        if ((i3 != 0) || (((DockableBar)localObject).isFloating()))
//	          localArrayList5.add(localObject);
	      i1++;
	    }
	    while (i3 == 0);
	    k localk1 = a(localArrayList2, this.i);
	    Object localObject = a(localArrayList1, this.j);
	    k localk2 = a(localArrayList3, this.k);
	    k localk3 = a(localArrayList4, this.l);
//	    this.i.setDockableBarList(localk1);
//	    this.j.setDockableBarList((k)localObject);
//	    this.k.setDockableBarList(localk2);
//	    this.l.setDockableBarList(localk3);
	    a(localArrayList5);
	    k();
	    setRealized(true);
	  }

	  private void a(List paramList)
	  {
	    int i2 = state;
	    if (i2 == 0)
	      if (paramList.size() == 0)
	        return;
	    int i1 = 0;
	    do
	    {
	      if (i1 >= paramList.size())
	        break;
	      DockableBar localDockableBar = (DockableBar)paramList.get(i1);
	      floatDockableBar(localDockableBar, localDockableBar.getUndockedBounds());
	      i1++;
	    }
	    while (i2 == 0);
	  }

	  private List b(List paramList){
	    int i2 = state;
	    ArrayList localArrayList = new ArrayList();
	    int i1 = 0;
	    do{
	      if (i1 >= paramList.size())
	        break;
	      DockableBar localDockableBar = (DockableBar)paramList.get(i1);
	      Integer localInteger = new Integer(localDockableBar.getContext().getInitIndex());
	      if (i2 == 0){
	        if (i2 != 0)
	          break;
	        if (localArrayList.indexOf(localInteger) == -1)
	          localArrayList.add(localInteger);
	        i1++;
	      }
	    }
	    while (i2 == 0);
	    Collections.sort(localArrayList);
	     return localArrayList;
	  }

	  private k a(List paramList, Container paramContainer){
	    int i3 = state;
	    //k localk = new k(paramContainer);
	    List localList = b(paramList);
	    int i1 = 0;
	     
	    do {
	      if (i1 >= localList.size())
	        break;
	      Integer localInteger = (Integer)localList.get(i1);
	     // j localj = new j(localk);
	      int i2 = 0;
	      do
	      {
	        if (i2 >= paramList.size())
	          break ;
	        DockableBar localDockableBar = (DockableBar)paramList.get(i2);
	        if (i3 == 0)
	        {
	          if (i3 != 0)
	            break;
	          if (localInteger.intValue() == localDockableBar.getContext().getInitIndex())
	            //localj.add(new d(localDockableBar, localDockableBar.getContext().getInitSideSubindex()));
	          i2++;
	        }
	      }
	      while (i3 == 0);
	     // localk.add(localj);
	      i1++;
	    }
	    while (i3 == 0);
	    //return localk;
	    return null;
	  }

	  private void a(DockableBar dockableBar){
	    int i1 = state;
	    if (i1 == 0) {
	      if (this.mapDockableBar.containsKey(dockableBar.getKey()))
	        throw new IllegalArgumentException("The DockableBar exists with name \"" + dockableBar.getKey() + "\". Please specify a new name for the frame.");
	      this.mapDockableBar.put(dockableBar.getKey(), dockableBar);
	    }
	    this.b.add(dockableBar.getKey());
	    dockableBar.addPropertyChangeListener("key", this.propertyChangeListener);
	    dockableBar.setDockableBarManager(this);
	    DockableBarContext localDockableBarContext = getDockableBarContextOf(dockableBar.getKey());
	    if (i1 == 0) {
	      if (localDockableBarContext == null) {
	        a(dockableBar.getKey(), dockableBar.getContext());
	        if (i1 == 0) {
	          if (isRealized())
	            if (i1 == 0) {
	              if (dockableBar.isHidden()){
	                //this.h.add(paramDockableBar.getKey());
	                if (i1 == 0);
					} else {
	                g(dockableBar);
	              }
	            }
	            else
	             // this.h.remove(paramDockableBar.getKey());
	            	dockableBar.getContext().setInitPosition(true);
	        }
	        if (i1 == 0);
	      }
	      else
	      {
	    	  dockableBar.setContext(localDockableBarContext);
	      }
	    }
	    else if ((i1 != 0) || (isRealized()))
	      if (i1 == 0)
	      {
	        if (!localDockableBarContext.isHidden())
	          g(dockableBar);
	      }
	      //else
	        //this.h.remove(dockableBar.getKey());
	  }


	  private void b(DockableBar paramDockableBar){
	    int i1 = state;
	    if ((i1 != 0) || (this.mapDockableBar.containsKey(paramDockableBar.getKey()))){
	      if (i1 == 0)
	      {
	        if (!paramDockableBar.isHidden())
	          e(paramDockableBar);
	        this.mapDockableBar.remove(paramDockableBar.getKey());
	        this.b.remove(paramDockableBar.getKey());
	        if (i1 != 0);
	      }else{
//	        if (this.h.contains(paramDockableBar.getKey()))
//	          this.h.remove(paramDockableBar.getKey());
	        paramDockableBar.removePropertyChangeListener(this.propertyChangeListener);
	      }
	      a(paramDockableBar.getKey());
	      paramDockableBar.fireDockableBarEvent(8000);
	      paramDockableBar.setDockableBarManager(null);
	    }
	  }

	  private void c(DockableBar paramDockableBar){
	    int i1 = state;
	    if (i1 == 0)
	      if (!this.mapDockableBar.containsKey(paramDockableBar.getKey()))
	        addDockableBar(paramDockableBar);
	    if ((i1 != 0) || (!paramDockableBar.isVisible()))
	      paramDockableBar.setVisible(true);
//	    if (((i1 == 0) && ((this.h != null) && ((i1 == 0) && (!this.h.contains(paramDockableBar.getKey()))))) || (i1 == 0))
//	      if ((!f(paramDockableBar)) && (paramDockableBar.isFloating()))
//	        floatDockableBar(paramDockableBar, new Rectangle(200, 200, 0, 0));
//	    if ((i1 != 0) || (this.h != null))
	      //this.h.remove(paramDockableBar.getKey());
	  }



	  private void d(DockableBar paramDockableBar){
	    int i1 = state;
		if (i1 == 0) {
			if (paramDockableBar.isHidden()){
				return;
			}
		}
	    else if (!this.mapDockableBar.containsKey(paramDockableBar.getKey())){
	      addDockableBar(paramDockableBar);
	    }
	    e(paramDockableBar);
	  }

	  private void e(DockableBar paramDockableBar){
	    int i1 = state;
	    if (i1 == 0){
	      if (paramDockableBar.isHidden())
	        return;
	      //e.a(paramDockableBar);
	    }
		try {
			if (i1 == 0) {
				if (paramDockableBar.getParent() != null) {
					if (i1 != 0)
						;
					// if ((paramDockableBar.getParent() instanceof o))
					// paramDockableBar.getParent().remove(paramDockableBar);
				}
				paramDockableBar.setHidden();
			} else {
				paramDockableBar.fireDockableBarEvent(8002);
			}
			// if ((i1 != 0) || (!this.h.contains(paramDockableBar.getKey())))
			// this.h.add(paramDockableBar.getKey());
		} catch (PropertyVetoException localPropertyVetoException) {

		}
	    n();
	  }

	  private void a(DockableBar paramDockableBar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3){
	    int i1 = state;
	    if (i1 == 0)
	      if (paramInt1 != 1){
				if (paramInt1 != 5) {
					if (paramInt1 != 3) {
						if (paramInt1 != 7){
							throw new IllegalArgumentException("Invalid argument side. side must be one of following value, DockContext.DOCK_SIDE_WEST, DockContext.DOCK_SIDE_EAST, DockContext.DOCK_SIDE_NORTH, DockContext.DOCK_SIDE_SOUTH or DockContext.DOCK_SIDE_CENTER.");
						}
					}
				}
	      }
	    if (paramInt3 < 0)
	    throw new IllegalArgumentException("Argument start must be a positive integer.");
	    DockableBarContainer localo = getDockableBarContainer(paramInt1);
	    localo.addDockableBar(paramDockableBar, paramInt2, paramBoolean, paramInt3);
	    paramDockableBar.invalidate();
	    paramDockableBar.repaint();
	  }

	  private void a(DockableBar paramDockableBar, Rectangle paramRectangle){
	    int i1 = state;
	    if (!paramDockableBar.isFloatable())
	      return;
	    if ((i1 != 0) || (paramRectangle == null))
	      paramRectangle = new Rectangle(200, 200, 0, 0);
	    FloatingDockableBarContainer localq = createFloatingDockableBarContainer();
	    if (i1 == 0){
	      if (localq != null)
	        paramDockableBar.setOrientation(0);
	    } else {
			try {
				paramDockableBar.setFloating();
			} catch (PropertyVetoException localPropertyVetoException) {
			}
			Container localContainer = paramDockableBar.getParent();
			if (i1 == 0) {
				if (localContainer != null)
					localContainer.remove(paramDockableBar);
			} else {
				localq.getContentPane().add(paramDockableBar, "Center");
				if (paramRectangle.isEmpty()) {
					localq.setSize(paramDockableBar.getPreferredSize());
				}
			}
	      localq.setSize(paramRectangle.getSize());
	      localq.pack();
	      paramRectangle.x -= (int)(localq.getWidth() * this.relativeX);
	      paramRectangle.y -= (int)(localq.getHeight() * this.relativeY);
	      Rectangle localRectangle = PortingUtils.getScreenBounds(localq);
	      if (i1 == 0){
	        if (paramRectangle.y + paramRectangle.height > localRectangle.y + localRectangle.height)
	          paramRectangle.y = (localRectangle.y + localRectangle.height - paramRectangle.height);
	      }else {
	        if (paramRectangle.y < localRectangle.y)
	          paramRectangle.y = localRectangle.y;
	        localq.setLocation(paramRectangle.x, paramRectangle.y);
	        localq.setVisible(true);
	        this.floatingDockableBarContainer = localq;
	      }
	     // this.g.add(localq);
	    }
	  }


	  private boolean f(){
	    return this.p;
	  }

	  public void cancelDragging(){
	    int i1 = state;
	    c();
	    if (i1 == 0)
	      if (SwingUtilities.isEventDispatchThread()){
	        g();
	        if (i1 == 0)
	          return;
	      }
	    try{
	      SwingUtilities.invokeAndWait(new Runnable(){
	        public void run()
	        {
	          DefaultDockableBarManager.f(DefaultDockableBarManager.this);
	        }
	      });
		} catch (InterruptedException localInterruptedException) {
		} catch (InvocationTargetException localInvocationTargetException) {
		}
	  }

//	  private void g(){
//	    this.relativeX = 0.0D;
//	    this.relativeY = 0.0D;
//	    this.single = false;
//	    if (P == 0)
//	    {
//	      if (this.rootPaneContainer != null)
//	      {
//	        this.rootPaneContainer.getGlassPane().setVisible(false);
//	        this.rootPaneContainer.getGlassPane().setCursor(Cursor.getDefaultCursor());
//	      }
//	      this.floatingDockableBarContainer = null;
//	      this.p = false;
//	      this.r = false;
//	      this.dockableBarContainer = null;
//	      this.component = null;
//	    }
//	    c();
//	  }

	private void b(boolean paramBoolean) {
	}

	private void h() {
		int i2 = state;
		if (this.tempArrayList != null) {
			int i1 = 0;
			do {
				// if (i1 >= this.g.size())
				// break;
				// FloatingDockableBarContainer localq =
				// (FloatingDockableBarContainer)this.g.get(i1);
				if (i2 == 0) {
					// if (!localq.isVisible())
					// {
					// this.g.remove(localq);
					i1--;
					// }
					i1++;
				}
			} while (i2 == 0);
		}
	}

	private boolean f(DockableBar paramDockableBar) {
		// g localg = paramDockableBar.getContext().getHiddenPreviousState();
		if (state == 0) {
			// if (localg != null)
			// a(paramDockableBar, localg);
		} else
			return true;
		return false;
	}

	private boolean g(DockableBar paramDockableBar) {
		int i1 = state;
		// g localg = paramDockableBar.getContext().getClosePreviousState();
		if (i1 == 0) {
			// if (localg != null)
			// a(paramDockableBar, localg);
		} else
			return true;
		if (paramDockableBar.getContext().getInitMode() == 1) {
			floatDockableBar(paramDockableBar, new Rectangle(200, 200, 0, 0));
			if (i1 == 0)
				;
		} else {
			// dockDockableBar(paramDockableBar,
			// e.convertDockSideToSide(paramDockableBar.getContext().getInitSide()),
			// 2147483647, true, 0);
		}
		return true;
	}

	private boolean h(DockableBar paramDockableBar) {
		//g localg = paramDockableBar.getContext().getDockPreviousState();
		//if (P == 0) {
			//if (localg != null) {
				//a(paramDockableBar, localg);
				//return true;
			//}
			//dockDockableBar(paramDockableBar, 1, 2147483647, true, 0);
	//	}
		return true;
	}

	private boolean i(DockableBar paramDockableBar) {
		// g localg = paramDockableBar.getContext().getFloatPreviousState();
		if (state == 0) {
			// if (localg != null)
			// {
			// a(paramDockableBar, localg);
			// return true;
			// }
			floatDockableBar(paramDockableBar, new Rectangle(200, 200, 0, 0));
		}
		return true;
	}

	private void a(DockableBar paramDockableBar, PreviousState paramg) {
		int i1 = state;
		if (i1 == 0);
//			if (paramg.a == 1) {
//				floatDockableBar(paramDockableBar, paramg.c);
//				if (i1 == 0)
//					return;
//			}
//		if ((i1 != 0) || ((paramg.a == 2) || (paramg.a == 3)))
//			dockDockableBar(paramDockableBar, paramg.d, paramg.g, paramg.e,paramg.f);
	}


	  private Component i(){
	    return (Component)this.rootPaneContainer;
	  }

	  private void j(){
	    int i2 = state;
	    Collection localCollection = this.mapDockableBar.values();
	    Iterator localIterator = localCollection.iterator();
	    Object localObject = null;
	    do {
	      if (!localIterator.hasNext())
	        break;
	      localObject = (DockableBar)localIterator.next();
	      if (i2 != 0)
	        break;
	      if ((i2 != 0) || (((DockableBar)localObject).getParent() != null))
	        ((DockableBar)localObject).getParent().remove((Component)localObject);
	    }
	    while (i2 == 0);
	    if (i2 == 0)
	      if (getContainer() != null) {
	         if (i2 == 0)
	          if (this.i != null)
	        	  getContainer().remove(this.i);
	        if (i2 == 0)
	          if (this.j != null)
	        	  getContainer().remove(this.j);
	        if (i2 == 0)
	        {
	          if (this.k != null)
	        	  getContainer().remove(this.k);
	          if (i2 != 0);
	        }
	        if (this.l != null)
	        	getContainer().remove(this.l);
	      }
	     if (i2 == 0)
	      if (this.tempArrayList != null){
	        int i1 = 0;
	        do
	        {
	          if (i1 >= this.tempArrayList.size())
	            break;
	          localObject = (FloatingDockableBarContainer)this.tempArrayList.get(i1);
	          ((FloatingDockableBarContainer)localObject).removeAll();
	          ((FloatingDockableBarContainer)localObject).setVisible(false);
	          ((FloatingDockableBarContainer)localObject).dispose();
	          i1++;
	          if (i2 != 0)
	            break;
	        }
	        while (i2 == 0);
	        	this.tempArrayList.clear();
	      }
	    if ((i2 != 0) || (this.duplicate != null));
	      this.duplicate.clear();
	    // f.getInstance().releaseAll();
	  }

	  private void a(InputStream paramInputStream){
	    int i3 = state;
	    try{
	      j();
	      DataInputStream localDataInputStream = new DataInputStream(paramInputStream);
	     // int i1 = i.e(localDataInputStream);
	      if (i3 == 0){
	       // if (i1 != this._version)
	          //throw new IOException("Layout data version number changed. Ignore previous layout data");
	        //this.D = i.d(localDataInputStream);
	        //this.C = i.b(localDataInputStream);
	        //i.a(localDataInputStream, this.c);
	        //this.h = new m();
	      }
	      Set localSet = this.map.keySet();
	      Iterator localIterator = localSet.iterator();
	      Object localObject = null;
	      do{
	        if (!localIterator.hasNext())
	          break;
	        localObject = (String)localIterator.next();
	        DockableBar localDockableBar = getDockableBar((String)localObject);
	        if (i3 == 0){
	          if (i3 != 0)
	            break;
	          if (localDockableBar != null)
	            localDockableBar.setContext((DockableBarContext)this.map.get(localObject));
	          //this.h.add(localObject);
	        }
	      }
	      while (i3 == 0);
	      //this.i = ((DockableBarContainer)i.a(this, localDataInputStream));
	      //this.l = ((DockableBarContainer)i.a(this, localDataInputStream));
	     // this.j = ((DockableBarContainer)i.a(this, localDataInputStream));
	      //this.k = ((DockableBarContainer)i.a(this, localDataInputStream));
	      if (((i3 != 0) || (this.i != null)) && ((i3 != 0) || (this.j != null)) && ((i3 != 0) || (this.k != null))){
	        if (i3 != 0)
	        if (this.l != null);
			} else {
	        throw new IOException("Layout Data is corrupted. Layout will be reset.");
	      }
	      getContainer().add(this.i, "East");
	      getContainer().add(this.l, "South");
	      getContainer().add(this.j, "West");
	      getContainer().add(this.k, "North");
	     // this.g = i.e(this, localDataInputStream);
	      int i2 = 0;
	      do {
	        //if (i2 >= this.g.size())
	         // break;
	        //localObject = (FloatingDockableBarContainer)this.g.get(i2);
	        ((FloatingDockableBarContainer)localObject).setVisible(true);
	        i2++;
	        if (i3 != 0)
	          return;
	      }while (i3 == 0);
	      k();
	      setRealized(true);
	    }catch (IOException localIOException) {
	      System.err.println("====>" + localIOException.getLocalizedMessage());
	      resetToDefault();
	    }
	  }

	  private void k(){
	    int i1 = state;
	    if (i1 == 0)
	      if (this._useFrameBounds)
	      {
	        Dimension localDimension = PortingUtils.getScreenSize(i());
	        if (i1 == 0)
	        {
	          if (this.initBounds.x > localDimension.width)
	            this.initBounds.x = 0;
	          if (i1 != 0);
	        }
	        else if (this.initBounds.y > localDimension.height)
	        {
	          this.initBounds.y = 0;
	        }
	        i().setBounds(this.initBounds);
	      }
	    if ((i1 != 0) || (isShowInitial()))
	      showInitial();
	  }

	  private void l(){
	    int i1 = 0;
	    do{
	      if (i1 >= this.b.size())
	        break;
	      String str = (String)this.b.get(i1);
	      DockableBar localDockableBar = getDockableBar(str);
	      //localDockableBar.getContext().setClosePreviousState(g.createPreviousState(localDockableBar));
	      i1++;
	    }
	    while (state == 0);
	  }

	  private Container getContainer(){
	    return this.contentContaner;
	  }

	  private void n(){
		getContainer().validate();
	    getMainContainer().validate();
	    getContainer().repaint();
	    setRealized(true);
	  }


	  private void a(String paramString, DockableBarContext paramDockableBarContext){
	    this.map.put(paramString, paramDockableBarContext);
	  }

	  private void a(String paramString){
	    this.map.remove(paramString);
	  }

	  protected void finalize()
	    throws Throwable{
	    super.finalize();
	  }

	  public DockableBarContainer createDockableBarContainer(){
		  DockableBarContainer localo = new DockableBarContainer(this);
	    return localo;
	  }

	  protected FloatingDockableBarContainer createFloatingDockableBarContainer(){
	    int i1 = state;
	    FloatingDockableBarContainer localq = null;
	    if (i1 == 0)
	      if ((this.rootPaneContainer instanceof Window))
	      {
	        localq = new FloatingDockableBarContainer((Window)this.rootPaneContainer);
	      }
	    if (i1 == 0)
	      if ((this.rootPaneContainer instanceof Applet))
	      {
	        Frame localFrame = JideSwingUtilities.getFrame((Applet)this.rootPaneContainer);
	        localq = new FloatingDockableBarContainer(localFrame);
	      }
	    if ((this.rootPaneContainer instanceof Frame))
	      localq = new FloatingDockableBarContainer((Window)this.rootPaneContainer);
	    else
	      throw new UnsupportedOperationException("JIDE Action Framework doesn't support floating command bar if rootPaneContainer is " + this.rootPaneContainer.getClass().getName());
	    return localq;
	  }

	  private void a(String paramString1, String paramString2){
	    int i1 = state;
	    Object localObject;
	    if (i1 == 0){
	      if (this.map != null){
	        if (i1 != 0);
	        if (this.map.containsKey(paramString1)){
	          localObject = this.map.get(paramString1);
	          this.map.remove(paramString1);
	          this.map.put(paramString2, localObject);
	        }
	      }
	      if (i1 != 0);
	    }
	    if (this.mapDockableBar != null){
	     if (i1 != 0);
	      if (this.mapDockableBar.containsKey(paramString1)){
	        localObject = this.mapDockableBar.get(paramString1);
	        this.mapDockableBar.remove(paramString1);
	        this.mapDockableBar.put(paramString2, localObject);
	      }
	    }
	    if (i1 == 0)
	      if (this.b != null){
	        if (i1 != 0);
	        if (this.b.contains(paramString1))
	          this.b.set(this.b.indexOf(paramString1), paramString2);
	      }
	    //if (((i1 != 0) || (this.h != null)) && ((i1 != 0) || (this.h.contains(paramString1))))
	      //this.h.set(this.h.indexOf(paramString1), paramString2);
	  }

	public boolean isRealized() {
		return this.realized;
	}


	static Class b(String paramString) throws Throwable {
		try {
			return Class.forName(paramString);
		} catch (ClassNotFoundException localClassNotFoundException) {
			throw new NoClassDefFoundError().initCause(localClassNotFoundException);
		}
	}

	 static void a(DefaultDockableBarManager paramDefaultDockableBarManager, String paramString1, String paramString2){
	    paramDefaultDockableBarManager.a(paramString1, paramString2);
	 }

	  static boolean a(DefaultDockableBarManager paramDefaultDockableBarManager){
	    return paramDefaultDockableBarManager.f();
	  }

	  static Rectangle b(DefaultDockableBarManager paramDefaultDockableBarManager) {
	    return paramDefaultDockableBarManager.initBounds;
	  }

	  static void a(DefaultDockableBarManager paramDefaultDockableBarManager, boolean paramBoolean){
	    paramDefaultDockableBarManager.a(paramBoolean);
	  }

	  static Window c(DefaultDockableBarManager paramDefaultDockableBarManager){
	    return paramDefaultDockableBarManager.window;
	  }

	  static Window a(DefaultDockableBarManager paramDefaultDockableBarManager, Window window){
	    return paramDefaultDockableBarManager.window = window;
	  }

	  static Component d(DefaultDockableBarManager paramDefaultDockableBarManager){
	    return paramDefaultDockableBarManager.i();
	  }

	  static void a(DefaultDockableBarManager paramDefaultDockableBarManager, AWTEvent paramAWTEvent){
	    paramDefaultDockableBarManager.a(paramAWTEvent);
	  }

	  static void e(DefaultDockableBarManager paramDefaultDockableBarManager){
	    paramDefaultDockableBarManager.e();
	  }

	  static void a(DefaultDockableBarManager paramDefaultDockableBarManager, DockableBar paramDockableBar){
	    paramDefaultDockableBarManager.a(paramDockableBar);
	  }

	  static void b(DefaultDockableBarManager paramDefaultDockableBarManager, DockableBar paramDockableBar){
	    paramDefaultDockableBarManager.b(paramDockableBar);
	  }

	  static void c(DefaultDockableBarManager paramDefaultDockableBarManager, DockableBar paramDockableBar){
	    paramDefaultDockableBarManager.c(paramDockableBar);
	  }

	  static void d(DefaultDockableBarManager paramDefaultDockableBarManager, DockableBar paramDockableBar){
	    paramDefaultDockableBarManager.d(paramDockableBar);
	  }

	  static void a(DefaultDockableBarManager paramDefaultDockableBarManager, DockableBar paramDockableBar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
	  {
	    paramDefaultDockableBarManager.a(paramDockableBar, paramInt1, paramInt2, paramBoolean, paramInt3);
	  }

	  static void a(DefaultDockableBarManager paramDefaultDockableBarManager, DockableBar paramDockableBar, Rectangle paramRectangle)
	  {
	    paramDefaultDockableBarManager.a(paramDockableBar, paramRectangle);
	  }

	  static void f(DefaultDockableBarManager paramDefaultDockableBarManager){
	    paramDefaultDockableBarManager.g();
	  }

	  static void a(DefaultDockableBarManager paramDefaultDockableBarManager, InputStream paramInputStream){
	    paramDefaultDockableBarManager.a(paramInputStream);
	  }

	  static {
//	    if (!Lm.isActionProductPurchased())
//	      Lm.showInvalidProductMessage((O == null ? (DefaultDockableBarManager.O = b("com.jidesoft.action.DefaultDockableBarManager")) : O).getName(), 16);
	  }

	public static abstract interface TabbedPaneCustomizer {
		public abstract void customize(JideTabbedPane jideTabbedPane);
	}
}

