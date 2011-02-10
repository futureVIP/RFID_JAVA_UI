package com.jidesoft.action;

import java.awt.Component;

class DockableBarList {
	private Component component;
	private int start = 0;//b
	private transient int row;//c
	private transient boolean onlyOne;//d
	private transient boolean dragging = false;//e
	private transient boolean resizing = false;//f

	public DockableBarList(Component component) {
		this(component, 0);
	}

	public DockableBarList(Component component, int start) {
		this.component = component;
		this.start = start;
	}

	public Component getComponent() {
		return this.component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public int getStart() {
		return this.start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean isOnlyOne() {
		return this.onlyOne;
	}

	public void setOnlyOne(boolean onlyOne) {
		this.onlyOne = onlyOne;
	}

	public boolean isDragging() {
		return this.dragging;
	}

	public void setDragging(boolean dragging) {
		this.dragging = dragging;
	}

	public boolean isResizing() {
		return this.resizing;
	}

	public void setResizing(boolean resizing) {
		this.resizing = resizing;
	}
}