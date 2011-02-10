package com.jidesoft.action;

import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.RootPaneContainer;

import com.jidesoft.docking.DefaultDockingManager;
import com.jidesoft.docking.DockableHolder;
import com.jidesoft.docking.DockingManager;
import com.jidesoft.swing.ContentContainer;
import com.jidesoft.swing.LayoutPersistence;

public class DockableBarDockableHolderPanel extends ContentContainer implements DockableHolder, DockableBarHolder{
	private static final long serialVersionUID = 1L;

	public DockableBarDockableHolderPanel(){
		
	}
	
	public DockableBarDockableHolderPanel(RootPaneContainer container){
		
	}
	
	@Override
	public DockableBarManager getDockableBarManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DockingManager getDockingManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected DefaultDockableBarManager	createDockableBarManager(RootPaneContainer rootContainer, Container container){
		return null;
	}
	
	protected DefaultDockingManager	createDockingManager(RootPaneContainer rootContainer, Container container) {
		return null;
	}
	
	protected void dispose() {

	}
	
	protected LayoutPersistence getLayoutPersistence() {
		return null;
	}
	
	public void setLayout(LayoutManager mgr){
		
	}
}
