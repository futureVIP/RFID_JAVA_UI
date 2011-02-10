package com.jidesoft.action;

import java.awt.Rectangle;
import java.io.Serializable;

public class DockableBarContext implements Serializable {
	public static final int STATE_HIDDEN = 0;
	public static final int STATE_FLOATING = 1;
	public static final int STATE_HORI_DOCKED = 2;
	public static final int STATE_VERT_DOCKED = 3;
	public static final String[] STATE_NAMES = { "\"HIDE\"", "\"FLOAT\"","\"HORI_DOCKED\"", "\"VERT_DOCKED\"" };
	private int initMode = 2;//a
	private int hidden = -1;//b
	public static final int DOCK_SIDE_NORTH = 1;
	public static final int DOCK_SIDE_SOUTH = 2;
	public static final int DOCK_SIDE_EAST = 4;
	public static final int DOCK_SIDE_WEST = 8;
	public static final int DOCK_SIDE_HORIZONTAL = 3;
	public static final int DOCK_SIDE_VERTICAL = 12;
	public static final int DOCK_SIDE_ALL = 15;
	public static final String[] SIDE_NAMES = { "\"NORTH\"", "\"SOUTH\"","\"EAST\"", "\"WEST\"" };
	private int initSide = 1;//c
	private int initIndex;//d
	private int initSideSubindex;//e
	private boolean initPosition = true;//f
	private int currentDockSide = 1;//g
	private Rectangle h;//h
	private int dockedWidth;//i
	private int dockedHeight;//j
	private int dockID;//k
	private PreviousState hiddenPreviousState;//l
	private PreviousState closePreviousState;//m
	private PreviousState dockPreviousState;//n
	private PreviousState floatPreviousState;//o

	public int getInitMode() {
		return this.initMode;
	}

	public void setInitMode(int initMode) {
		int i1 = DefaultDockableBarManager.state;
		if (((i1 != 0) || (initMode != 1)) && ((i1 != 0) || (initMode != 0))
				&& ((i1 != 0) || ((initMode != 2) && (initMode != 3))))
			throw new IllegalArgumentException("initMode must be one of the following values - DockableBarContext.STATE_FLOATING, DockableBarContext.STATE_HIDDEN, DockableBarContext.STATE_HORI_DOCKED or DockableBarContext.STATE_VERT_DOCKED");
		this.initMode = initMode;
	}

	public int getCurrentMode() {
		if (DefaultDockableBarManager.state == 0)
			if (this.hidden == -1)
				return this.initMode;
		return this.hidden;
	}

	public void setCurrentMode(int hidden) {
		int i1 = DefaultDockableBarManager.state;
		if (((i1 != 0) || (hidden != 1)) && ((i1 != 0) || (hidden != 0))
				&& ((i1 != 0) || ((hidden != 2) && (hidden != 3))))
			throw new IllegalArgumentException(
					"currentMode must be one of the following values - DockableBarContext.STATE_FLOATING, DockableBarContext.STATE_HIDDEN, DockableBarContext.STATE_HORI_DOCKED or DockableBarContext.STATE_VERT_DOCKED");
		this.hidden = hidden;
	}

	public boolean isHidden() {
		if (DefaultDockableBarManager.state == 0)
			;
		return this.hidden == 0;
	}

	public boolean isHoriDocked() {
		if (DefaultDockableBarManager.state == 0)
			;
		return this.hidden == 2;
	}

	public boolean isVertDocked() {
		if (DefaultDockableBarManager.state == 0)
			;
		return this.hidden == 3;
	}

	public boolean isFloating() {
		if (DefaultDockableBarManager.state == 0)
			;
		return this.hidden == 1;
	}

	public int getInitSide() {
		return this.initSide;
	}

	public void setInitSide(int initSide) {
		int i1 = DefaultDockableBarManager.state;
		if (((i1 != 0) || (initSide != 1)) && ((i1 != 0) || (initSide != 2))&& ((i1 != 0) || ((initSide != 4) && (initSide != 8))))
			throw new IllegalArgumentException("initSide must be one of the following values - DockableBarContext.DOCK_SIDE_NORTH, DockableBarContext.DOCK_SIDE_SOUTH, DockableBarContext.DOCK_SIDE_EAST or DockableBarContext.DOCK_SIDE_WEST");
		this.initSide = initSide;
	}

	public boolean isInitPosition() {
		return this.initPosition;
	}

	public void setInitPosition(boolean initPosition) {
		this.initPosition = initPosition;
	}

	public int getInitIndex() {
		return this.initIndex;
	}

	public void setInitIndex(int initIndex) {
		this.initIndex = initIndex;
	}

	public int getInitSideSubindex() {
		return this.initSideSubindex;
	}

	public void setInitSideSubindex(int initSideSubindex) {
		this.initSideSubindex = initSideSubindex;
	}

	public int getCurrentDockSide() {
		return this.currentDockSide;
	}

	public void setCurrentDockSide(int currentDockSide) {
		int i1 = DefaultDockableBarManager.state;
		if (((i1 != 0) || (currentDockSide != 1)) && ((i1 != 0) || (currentDockSide != 2))
				&& ((i1 != 0) || ((currentDockSide != 4) && (currentDockSide != 8))))
			throw new IllegalArgumentException(
					"currentDockSide must be one of the following values - DockableBarContext.DOCK_SIDE_NORTH, DockableBarContext.DOCK_SIDE_SOUTH, DockableBarContext.DOCK_SIDE_EAST or DockableBarContext.DOCK_SIDE_WEST");
		this.currentDockSide = currentDockSide;
	}

	public Rectangle getUndockedBounds() {
		return this.h;
	}

	public void setUndockedBounds(Rectangle paramRectangle) {
		this.h = paramRectangle;
	}

	public int getDockedWidth() {
		return this.dockedWidth;
	}

	public void setDockedWidth(int dockedWidth) {
		this.dockedWidth = dockedWidth;
	}

	public int getDockedHeight() {
		return this.dockedHeight;
	}

	public void setDockedHeight(int dockedHeight) {
		this.dockedHeight = dockedHeight;
	}

	public PreviousState getHiddenPreviousState() {
		return this.hiddenPreviousState;
	}

	public void setHiddenPreviousState(PreviousState hiddenPreviousState) {
		this.hiddenPreviousState = hiddenPreviousState;
	}

	public PreviousState getClosePreviousState() {
		return this.closePreviousState;
	}

	public void setClosePreviousState(PreviousState closePreviousState) {
		this.closePreviousState = closePreviousState;
	}

	public PreviousState getDockPreviousState() {
		return this.dockPreviousState;
	}

	public void setDockPreviousState(PreviousState dockPreviousState) {
		this.dockPreviousState = dockPreviousState;
	}

	public PreviousState getFloatPreviousState() {
		return this.floatPreviousState;
	}

	public void setFloatPreviousState(PreviousState floatPreviousState) {
		this.floatPreviousState = floatPreviousState;
	}

	public static String getDockSideName(int paramInt) {
		return SIDE_NAMES[((int) (java.lang.Math.log(paramInt) / java.lang.Math.log(2.0D)))];
	}

	public int getDockID() {
		return this.dockID;
	}

	public void setDockID(int dockID) {
		this.dockID = dockID;
	}

	public void resetDockID() {
		
	}

	public int getInitSubindex() {
		return this.initSideSubindex;
	}
	
	public void setInitSubindex(int initSideSubindex) {
		this.initSideSubindex = initSideSubindex;
	}

}