package com.jidesoft.action;

import java.awt.Component;
import java.awt.Point;
import java.beans.PropertyVetoException;

import javax.swing.JComponent;
import javax.swing.SwingConstants;

import com.jidesoft.swing.Alignable;
import com.jidesoft.swing.JideSwingUtilities;

public class DockableBarContainer extends JComponent implements SwingConstants{
	private static final long serialVersionUID = 1L;

	private int side;//a
	private DockableBarListList dockableBarList;//b
	public static final int OFFSET = 2;
	private DockableBarManager dockableBarManager;//c
	  
	public DockableBarContainer(DockableBarManager dockableBarManager) {
		this.dockableBarManager = dockableBarManager;
		this.dockableBarList = new DockableBarListList(this);
	}
	
	public DockableBarContainer(DockableBarManager dockableBarManager, int side){
	    this(dockableBarManager);
	    setSide(side);
	}

	public void setSide(int side){
	    int i = DefaultDockableBarManager.state;
	    this.side = side;
	    //setLayout(new c(this, this.a));
	    if (i == 0)
	      if (this.side != 3)
	      {
	        if (i != 0);
	        if (this.side != 7);
	      }
	    JideSwingUtilities.setOrientationOf(this, 1);
	    if (i != 0){
	      if (i == 0)
	        if (this.side != 1)
	          if ((i == 0) && (this.side != 5))
	            return;
	      JideSwingUtilities.setOrientationOf(this, 0);
	    }
	  }

	public int getSide() {
		return this.side;
	}

	  public void setDockableBarList(DockableBarListList list){
	    int k = DefaultDockableBarManager.state;
	    removeAll();
	    this.dockableBarList = list;
	    int i = 0;
	    do {
	      if (i >= list.size())
	        break;
	      j localj = (j)list.get(i);
	      if (k != 0)
	        return;
	      int j = 0;
			do {
				if (j >= localj.size())
					break;
				DockableBarList locald = (DockableBarList) localj.get(j);
				add(locald.getComponent());
				j++;
				if (k != 0)
					break;
			} while (k == 0);
	      i++;
	    }
	    while (k == 0);
	    invalidate();
	  }

	public DockableBarListList getDockableBarList() {
		return this.dockableBarList;
	}

	public int getRowCount() {
		return getDockableBarList().size();
	}

	public int getRowHeight(int paramInt) {
		//return ((c) getLayout()).getRowHeightAt(paramInt);
		return 0;
	}

	public int getRowAndGapIndexAt(Point paramPoint) {
		int m = DefaultDockableBarManager.state;
		if (m == 0)
			;
		int i = getOrientation() == 0 ? paramPoint.y : paramPoint.x;
		if (m == 0)
			if (i < 0)
				return 0;
		if (m == 0)
			;
		if (i >= (getOrientation() == 0 ? getHeight() : getWidth()))
			return getRowCount() * 2;
		int j = 0;
		int k = 0;
		do {
			if (k >= getRowCount())
				break;
			if (m != 0)
				break;
			if (m == 0) {
				if (i >= j + 2) {
					if (m == 0)
						;
					if (m != 0)
						break;
					if (i < j + getRowHeight(k)
							- (k != getRowCount() - 1 ? 2 : 0))
						return k * 2 + 1;
				}
				j += getRowHeight(k);
				if (m != 0)
					continue;
			}
			if (k != getRowCount() - 1) {
				if (((m != 0) || (i >= j - 2)) && ((m != 0) || (i < j + 1 + 2)))
					return k * 2 + 2;
				j++;
			}
			k++;
		} while (m == 0);
		return -1;
	}

	  public int getOrientation(){
	    int i = DefaultDockableBarManager.state;
	    if (i == 0)
	      if (this.side != 1){
	        if (i != 0);
	        if (this.side != 5);
	      }
	    return 0;
	   // return 1;
	  }

	public boolean isHorizontal() {
		if (DefaultDockableBarManager.state == 0)
			;
		return getOrientation() == 0;
	}

	public boolean isOpaque() {
		return false;
	}

	protected void addImpl(Component paramComponent, Object paramObject,int paramInt) {
		super.addImpl(paramComponent, paramObject, paramInt);
		if ((DefaultDockableBarManager.state != 0) || ((paramComponent instanceof Alignable)))
			((Alignable) paramComponent).setOrientation(getOrientation());
	}

	public void addDockableBar(DockableBar paramDockableBar, int paramInt1,	boolean paramBoolean, int paramInt2) {
		try {
			if (isHorizontal()) {
				paramDockableBar.setHoriDocked();
				if (DefaultDockableBarManager.state == 0)
					;
			} else {
				paramDockableBar.setVertDocked();
			}
		} catch (PropertyVetoException localPropertyVetoException) {
		}
		add(paramDockableBar);
		this.dockableBarList.changeComponentRow(paramDockableBar, paramInt1, paramBoolean,paramInt2);
		revalidate();
	}

	public int getCurrentRowOf(DockableBar paramDockableBar) {
		DockableBarList locald = getDockableBarList().getDockableBarItemOf(paramDockableBar);
		return locald.getRow();
	}

	public DockableBarManager getDockableBarManager() {
		return this.dockableBarManager;
	}
	
	interface DockableBarShrinkOrderProvider{
		int[] getShrinkOrder(int rowIndex);
	}
}
