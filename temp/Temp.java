package demo;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import com.jidesoft.action.CommandBarFactory;
import com.jidesoft.utils.SystemInfo;

public class Temp {

	public void eventDispatched(AWTEvent paramAWTEvent) {
		boolean bool = CommandBarFactory.flag;
		if ((bool) || ((paramAWTEvent instanceof MouseEvent))) {
			MouseEvent localMouseEvent;
			if (!bool)
				if (paramAWTEvent.getID() == 506) {
					localMouseEvent = (MouseEvent) paramAWTEvent;
					if (g()) {
						Point localPoint = localMouseEvent.getPoint();
						Object localObject = localMouseEvent.getSource();
						if (!bool) {
							if ((localObject instanceof Component)) {
								l.convertPointToScreen(localPoint,
										(Component) localObject, this.o);
								dragDockableBar(null, localPoint.x,
										localPoint.y,
										localMouseEvent.getModifiersEx());
							}
						} else
							localMouseEvent.consume();
					}
					if (!bool)
						return;
				}
			if (!bool)
				if (paramAWTEvent.getID() == 502) {
					localMouseEvent = (MouseEvent) paramAWTEvent;
					if (!bool)
						if (g()) {
							endDraggingDockableBar();
							localMouseEvent.consume();
						}
					if (SystemInfo.isWindows()) {
						if (bool)
						if (this.N != null) {
							if (bool)
							if (this.N.isVisible()) {
								if (bool)
								if (!this.N.isAncestorOf((Component) localMouseEvent
												.getSource())) {
									this.N.setVisible(false);
									this.N = null;
								}
							}
						}
					}
					a(localMouseEvent);
				}
			if ((bool) && (paramAWTEvent.getID() == 501))
				a((MouseEvent) paramAWTEvent);
		}
	}

	public void eventDispatched2(AWTEvent paramAWTEvent) {
		boolean bool = CommandBarFactory.flag;
		if ((bool) || ((paramAWTEvent instanceof MouseEvent))) {
			MouseEvent localMouseEvent;
			if (!bool)
				if (paramAWTEvent.getID() == 506) {
					localMouseEvent = (MouseEvent) paramAWTEvent;
					if (g()) {
						Point localPoint = localMouseEvent.getPoint();
						Object localObject = localMouseEvent.getSource();
						if (!bool) {
							if ((localObject instanceof Component)) {
								i.convertPointToScreen(localPoint,
										(Component) localObject, this.G);
								dragDockableBar(null, localPoint.x,
										localPoint.y,
										localMouseEvent.getModifiersEx());
							}
						} else
							localMouseEvent.consume();
					}
					if (!bool)
						return;
				}
			if (!bool)
				if (paramAWTEvent.getID() == 502) {
					localMouseEvent = (MouseEvent) paramAWTEvent;
					if (!bool)
						if (g()) {
							endDraggingDockableBar();
							localMouseEvent.consume();
						}
					if (SystemInfo.isWindows()) {
						if (bool)
							break label216;
						if (this.fb != null) {
							if (bool)
								break label216;
							if (this.fb.isVisible()) {
								if (bool)
									break label216;
								if (!this.fb
										.isAncestorOf((Component) localMouseEvent
												.getSource())) {
									this.fb.setVisible(false);
									this.fb = null;
								}
							}
						}
					}
					label216: a(localMouseEvent);
				}
			if ((bool) && (paramAWTEvent.getID() == 501))
				a((MouseEvent) paramAWTEvent);
		}
	}

	public void eventDispatched3(AWTEvent paramAWTEvent) {
		boolean bool = CommandBarFactory.flag;
		if ((bool) || ((paramAWTEvent instanceof MouseEvent))) {
			MouseEvent localMouseEvent;
			if (!bool)
				if (paramAWTEvent.getID() == 506) {
					localMouseEvent = (MouseEvent) paramAWTEvent;
					if (g()) {
						Point localPoint = localMouseEvent.getPoint();
						Object localObject = localMouseEvent.getSource();
						if (!bool) {
							if ((localObject instanceof Component)) {
								l.convertPointToScreen(localPoint,
										(Component) localObject, this.o);
								dragDockableBar(null, localPoint.x,
										localPoint.y,
										localMouseEvent.getModifiersEx());
							}
						} else
							localMouseEvent.consume();
					}
					if (!bool)
						return;
				}
			if (!bool)
				if (paramAWTEvent.getID() == 502) {
					localMouseEvent = (MouseEvent) paramAWTEvent;
					if (!bool)
						if (g()) {
							endDraggingDockableBar();
							localMouseEvent.consume();
						}
					if (SystemInfo.isWindows()) {
						if (bool)
							break label216;
						if (this.N != null) {
							if (bool)
								break label216;
							if (this.N.isVisible()) {
								if (bool)
									break label216;
								if (!this.N
										.isAncestorOf((Component) localMouseEvent
												.getSource())) {
									this.N.setVisible(false);
									this.N = null;
								}
							}
						}
					}
					label216: a(localMouseEvent);
				}
			if ((bool) && (paramAWTEvent.getID() == 501))
				a((MouseEvent) paramAWTEvent);
		}
	}
	
	private void a(MouseEvent paramMouseEvent) {

	}
	
	public void eventDispatched4(AWTEvent event) {
		boolean bool = CommandBarFactory.flag;
		if ((bool) || ((event instanceof MouseEvent))) {
			MouseEvent localMouseEvent;
			if(bool && (event.getID() == 501)){
				a((MouseEvent) event);
				return;
			}
			switch(event.getID()){
			case 506:
				localMouseEvent = (MouseEvent) event;
				
				break;
			}
		}
	}
}
