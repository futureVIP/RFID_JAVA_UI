package com.jidesoft.action.event;

import java.util.EventListener;

public abstract interface DockableBarListener extends EventListener {
	
	public abstract void dockableBarAdded(DockableBarEvent event);

	public abstract void dockableBarRemoved(DockableBarEvent event);

	public abstract void dockableBarShown(DockableBarEvent event);

	public abstract void dockableBarHidden(DockableBarEvent event);

	public abstract void dockableBarHoriDocked(DockableBarEvent event);

	public abstract void dockableBarVertDocked(DockableBarEvent event);

	public abstract void dockableBarFloating(DockableBarEvent event);
}