package com.jidesoft.action;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

public class DockableBarListList extends ArrayList {
	private static final long serialVersionUID = 1L;
	private Container container;

	public DockableBarListList(Container container) {
		this.container = container;
	}

    protected DockableBarList getDockableBarItemOf(Component paramComponent){
	    int k = DefaultDockableBarManager.state;
	    int i = 0;
	    do {
	      if (i >= size())
	        break;
	      List localList = (List)get(i);
	      int j = 0;
	      do{
	        if (j >= localList.size())
	          break ;
	        DockableBarList locald = (DockableBarList)localList.get(j);
	        if (k == 0)
	        {
	          if (k != 0)
	        	  break;
	          if (locald.getComponent().equals(paramComponent)){
	            locald.setRow(i);
	            if (k == 0);
	            locald.setOnlyOne(localList.size() == 1);
	            return locald;
	          }
	          j++;
	        }
	      }
	      while (k == 0);
	      i++;
	    }
	    while (k == 0);
	    return null;
	  }

	  protected DockableBarList removeDockableBarItemOf(Component paramComponent){
	    int k = DefaultDockableBarManager.state;
	    int i = 0;
	    do{
	      if (i >= size())
	        break;
	      List localList = (List)get(i);
	      int j = 0;
	      do{
	        if (j >= localList.size())
	          break ;
	        DockableBarList locald = (DockableBarList)localList.get(j);
	        if (k == 0)
	        {
	          if (k != 0)
	            break;
	          if (locald.getComponent().equals(paramComponent))
	          {
	            localList.remove(locald);
	            return locald;
	          }
	          j++;
	        }
	      }while (k == 0);
	      i++;
	    }
	    while (k == 0);
	    return null;
	  }

	  public void setStartLocation(Component paramComponent, int paramInt){
		DockableBarList locald = getDockableBarItemOf(paramComponent);
	    if ((DefaultDockableBarManager.state != 0) || (locald != null)){
	      locald.setStart(paramInt);
	      a();
	    }
	  }

	  public void removeComponent(Component paramComponent){
		  DockableBarList locald = removeDockableBarItemOf(paramComponent);
	    if (DefaultDockableBarManager.state == 0)
	    {
	      if (locald == null)
	        return;
	      a();
	    }
	  }

	  public DockableBarList addComponent(Component paramComponent, int paramInt){
	    int i = a(size(), true);
	    List localList = (List)get(i);
	    DockableBarList locald = new DockableBarList(paramComponent, paramInt);
	    localList.add(locald);
	    locald.setRow(i);
	    return locald;
	  }

	  public DockableBarList insertComponent(Component paramComponent, int paramInt1, int paramInt2){
	    paramInt1 = a(paramInt1, true);
	    List localList = (List)get(paramInt1);
	    DockableBarList locald = new DockableBarList(paramComponent, paramInt2);
	    localList.add(locald);
	    locald.setRow(paramInt1);
	    return locald;
	  }

	  public void changeComponentRow(Component paramComponent, int paramInt1, boolean paramBoolean, int paramInt2){
	    int j = DefaultDockableBarManager.state;
	    DockableBarList locald = getDockableBarItemOf(paramComponent);
	    locald.setDragging(true);
	    if (j == 0){
	      locald.setResizing(false);
	      if (paramInt2 < 0)
	        paramInt2 = 0;
	    }
	    if (j == 0)
	      if (locald == null)
	        locald = insertComponent(paramComponent, paramInt1, paramInt2);
	    int i = locald.getRow();
	    if (j == 0){
	      if (!paramBoolean){
	        if (j == 0){
	          if (i != paramInt1)
	            if (j != 0);
	        } else {
	          if (((List)get(i)).size() != 1);
	          if (j != 0);
	          if (paramInt1 - i != 1);
	        }
	        locald.setStart(paramInt2);
	        a();
	        return;
	      }
	      ((List)get(i)).remove(locald);
	    }
	    if (j == 0)
	      if (!paramBoolean)
	      {
	        if (j != 0);
	        if ((locald.getComponent() instanceof DockableBar))
	        {
	          if (j != 0);
	          if (((DockableBar)locald.getComponent()).isStretch())
	            paramBoolean = true;
	        }
	      }
	    if (j == 0)
	    {
	      if (!paramBoolean)
	      {
	        if (j == 0)
	          if (paramInt1 >= size())
	            paramInt1 = size() - 1;
	        if ((j != 0) || (paramInt1 < 0))
	          paramInt1 = 0;
	        List localList = (List)get(paramInt1);
	        if (j != 0);
	        if (localList.size() > 0){
	          Component localComponent = ((DockableBarList)localList.get(0)).getComponent();
	          if (j != 0) ;
	          if ((localComponent instanceof DockableBar))
	          {
	            if (j != 0);
	            if (((DockableBar)localComponent).isStretch())
	              paramBoolean = true;
	          }
	        }
	      }
	      paramInt1 = a(paramInt1, paramBoolean);
	      locald.setStart(paramInt2);
	      if (j != 0)
	        return;
	    }
	    if (paramInt1 < size())
	      ((List)get(paramInt1)).add(locald);
	    a();
	  }

	  public void changeComponentStart(Component paramComponent, int paramInt)
	  {
		DockableBarList locald = getDockableBarItemOf(paramComponent);
	    locald.setDragging(true);
	    locald.setResizing(true);
	    if (DefaultDockableBarManager.state == 0){
	      if (paramInt < 0)
	        paramInt = 0;
	      locald.setStart(paramInt);
	      a();
	    }
	  }

	  private void a() {
	    ((JComponent)this.container).revalidate();
	  }

	  private int a(int paramInt, boolean paramBoolean){
	    int i = DefaultDockableBarManager.state;
	    j localj;
	    if (i == 0)
	      if (paramInt < 0)
	      {
	        paramInt = 0;
	        if (i != 0);
	        if (paramBoolean)
	        {
	          localj = b();
	          add(paramInt, localj);
	        }
	      }
	     if (i == 0)
	      if (paramInt >= size())
	      {
	        if (i == 0)
	          if (paramBoolean)
	          {
	            localj = b();
	            add(localj);
	          }
	        paramInt = size() - 1;
	        if (i == 0);
	      }
	    if (i == 0)
	      if (paramBoolean)
	      {
	        localj = b();
	        add(paramInt, localj);
	      }
	     return paramInt;
	  }

	private j b() {
		return new j(this);
	}
}