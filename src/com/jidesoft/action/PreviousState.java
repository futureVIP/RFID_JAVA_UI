package com.jidesoft.action;

import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import java.util.ArrayList;

class PreviousState {
	int a;//a
	int b;//b
	Rectangle c;//c
	int side;//d
	boolean onlyOne;//e
	int start;//f
	int row;//g
	int h;//h
	ArrayList i;//i
	ArrayList j;//j

	public static PreviousState createPreviousState(DockableBar paramDockableBar) {
		PreviousState localg = new PreviousState();
		localg.a = paramDockableBar.getContext().getCurrentMode();
		localg.b = paramDockableBar.getDockID();
		Container localContainer = paramDockableBar.getParent();
		if (DefaultDockableBarManager.state == 0)
			if ((localContainer instanceof DockableBarContainer)) {
				//localObject = (DockableBarContainer) localContainer;
				//DockableBarList locald = ((DockableBarContainer) localObject).getDockableBarList().getDockableBarItemOf(paramDockableBar);
				//localg.start = locald.getStart();
				//localg.row = locald.getRow();
				//localg.onlyOne = locald.isOnlyOne();
			    //localg.side = ((DockableBarContainer) localObject).getSide();
			}
		Object localObject = a(paramDockableBar);
		if (localObject != null)
			localg.c = ((Container) localObject).getBounds();
		return localg;
	}

	public static void disposePreviousState(PreviousState paramg) {
		if (paramg == null){
			return;
		}
		paramg = null;
	}

	static Container a(Component paramComponent) {
		int k = DefaultDockableBarManager.state;
		if (k == 0) {
			if ((paramComponent instanceof MainContainer))
				return (MainContainer) paramComponent;
			if (k != 0)
				;
		} else if ((paramComponent instanceof FloatingDockableBarContainer)) {
			return (FloatingDockableBarContainer) paramComponent;
		}
		Container localContainer = paramComponent.getParent();
		if (localContainer == null)
			return null;
		if (k == 0)
			if ((localContainer instanceof MainContainer))
				return localContainer;
		do {
			if (k == 0) {
				if ((localContainer instanceof FloatingDockableBarContainer))
					return localContainer;
				localContainer = localContainer.getParent();
			}
			if (localContainer != null)
				break;
		} while (k != 0);
		return null;
	}

	static class a_ {
		int a;
		int b;
		int c;
		ArrayList d;
	}
}