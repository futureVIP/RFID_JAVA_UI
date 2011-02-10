package com.jidesoft.action;

import java.util.ArrayList;

public class Duplicate extends ArrayList {

	public boolean add(Object paramObject) {
		if (DefaultDockableBarManager.state == 0)
			if (contains(paramObject))
				throw new IllegalStateException("duplicate entry of: " + paramObject);
		return super.add(paramObject);
	}
}
