package com.jidesoft.action;

public interface Dockable {
	public abstract DockableBarManager getDockableBarManager();

	public abstract void setDockableBarManager(DockableBarManager paramDockableBarManager);

	public abstract int getDockID();

	public abstract void setDockID(int paramInt);

	public abstract void resetDockID();
}
