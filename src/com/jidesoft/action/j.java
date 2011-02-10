package com.jidesoft.action;

import java.util.ArrayList;

class j extends ArrayList {

	private DockableBarListList dockableBarListList;

	public j(DockableBarListList dockableBarListList) {
		this.dockableBarListList = dockableBarListList;
	}

	public boolean remove(Object paramObject) {
		int i = DefaultDockableBarManager.state;
		boolean bool = super.remove(paramObject);
		if (i == 0)
			if (bool) {
				if (i != 0);
				if (size() == 0)
					this.dockableBarListList.remove(this);
			}
		return bool;
	}
}