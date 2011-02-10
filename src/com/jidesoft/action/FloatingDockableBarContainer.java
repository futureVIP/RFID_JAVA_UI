package com.jidesoft.action;

import java.awt.Window;
import javax.swing.JRootPane;
import javax.swing.JWindow;

public class FloatingDockableBarContainer extends JWindow {
	private static final long serialVersionUID = 1L;

	public FloatingDockableBarContainer(Window owner) {
		super(owner);
	}

	protected JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane() {
			private boolean a = false;

			public void validate() {
				super.validate();
				if (DefaultDockableBarManager.state == 0) {
					if (!this.a) {
						this.a = true;
						FloatingDockableBarContainer.this.pack();
					}
				} else
					this.a = false;
			}
		};
		rootPane.setOpaque(true);
		return rootPane;
	}
}
