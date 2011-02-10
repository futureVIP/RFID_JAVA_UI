package com.jidesoft.action;

import com.jidesoft.swing.LayoutPersistence;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.RootPaneContainer;

public interface DockableBarManager extends LayoutPersistence{
	
	  void addDockableBar(DockableBar dockableBarManager);

	  void removeDockableBar(String key);

	  void removeAllDockableBars();

	  DockableBar getDockableBar(String key);

	  void showDockableBar(String key);

	  void hideDockableBar(String key);

	  void beginDraggingDockableBar(JComponent f, int mouseX, int mouseY, double relativeX, double relativeY, boolean single);

	  void dragDockableBar(JComponent f, int newX, int newY, int mouseModifiers);

	  void pauseDragDockableBar();

	  void endDraggingDockableBar();

	  void beginResizingDockableBar(JComponent f, int direction);

	  void resizingDockableBar(JComponent f, int newX, int newY, int newWidth, int newHeight, int deltaX, int deltaY);

	  void endResizingDockableBar(JComponent f);

	  RootPaneContainer getRootPaneContainer();

	  MainContainer getMainContainer();

	  void toggleState(DockableBar bar);

	  boolean isRearrangable();

	  void setRearrangable(boolean rearrangable);

	  boolean isFloatable();

	  void setFloatable(boolean floatable);

	  boolean isHidable();

	  void setHidable(boolean hidable);

	  void updateComponentTreeUI();

	  Collection getAllDockableBars();

	  List getAllDockableBarNames();

	  DockableBarPopupMenuCustomizer getDockableBarPopupMenuCustomizer();

	  void setDockableBarPopupMenuCustomizer(DockableBarPopupMenuCustomizer customizer);

	  void showContextMenu(MouseEvent e, Component component);

	  void floatDockableBar(DockableBar dockableBar, Rectangle bounds);

	  void dockDockableBar(DockableBar dockableBar, int side, int row, boolean createNewRow, int start);

	  DockableBarContainer getDockableBarContainer(int side);

	  Rectangle getInitBounds();

	  void setInitBounds(Rectangle initBounds);

	  int getInitState();

	  void setInitState(int initState);

	  void setUseFrameState(boolean useFrameState);

	  void setUseFrameBounds(boolean useFrameBounds);

	  void dispose();

	  DockableBarContext getDockableBarContextOf(String barName);

	  void removeFromHiddenDockableBars(String name);

	  void setFloatingDockableBarsVisible(boolean show);

	  void switchRootPaneContainer(RootPaneContainer rootContainer);

	  void setShowInitial(boolean value);

	  boolean isShowInitial();

	  void showInitial();

	  boolean isHideFloatingDockableBarsWhenDeactivate();

	  void setHideFloatingDockableBarsWhenDeactivate(boolean hideFloatingDockableBarsWhenDeactivate);
}
