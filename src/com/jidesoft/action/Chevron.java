package com.jidesoft.action;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.UIResource;
import com.jidesoft.swing.JideMenu;
import com.jidesoft.utils.Lm;

public class Chevron extends JideMenu implements SwingConstants, UIResource {
	private boolean showMore = false;//a
	private boolean showOptions = false;//b
	public static final String PROPERTY_SHOWMORE = "showMore";
	public static final String PROPERTY_SHOWOPTIONS = "showOption";
	static Class c;

	@SuppressWarnings("deprecation")
	public Chevron() {
		setMenuCreator(new JideMenu.MenuCreator() {
			public void createMenu() {
//				int j = DefaultDockableBarManager.state;
//				Chevron.this.getPopupMenu().removeAll()
//				Chevron.this.getPopupMenu().setLayout(new BorderLayout());
//				p localp = new p();
//				localp.setOpaque(false);
//				localp.setUsePreferredRowCount(true);
//				CommandBar localCommandBar = Chevron.a(Chevron.this,Chevron.this);
//				Component[] arrayOfComponent = localCommandBar.getHiddenComponents();
//				int i = 0;
//				do {
//					if (i >= arrayOfComponent.length)
//						break;
//					Component localComponent = arrayOfComponent[i];
//					localp.add(localComponent);
//					i++;
//					if (j != 0)
//						return;
//				} while (j == 0);
//				if (localp.getComponentCount() > 0)
//					Chevron.this.getPopupMenu().add(localp, "Center");
			}
		});
		getPopupMenu().addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(
					PopupMenuEvent paramAnonymousPopupMenuEvent) {
				Chevron.this.getPopupMenu().removeAll();
			}

			public void popupMenuWillBecomeInvisible(
					PopupMenuEvent paramAnonymousPopupMenuEvent) {
				Chevron.this.getPopupMenu().removeAll();
			}

			public void popupMenuWillBecomeVisible(
					PopupMenuEvent paramAnonymousPopupMenuEvent) {
			}
		});
		setPreferredPopupHorizontalAlignment(4);
		updateUI();
	}
	private CommandBar a(Component paramComponent){
	    do{
	      paramComponent = paramComponent.getParent();
	      if ((paramComponent instanceof CommandBar))
	        return (CommandBar)paramComponent;
	    }
	    while (paramComponent != null);
	    return null;
	  }

	public void updateUI() {
		setUI(UIManager.getUI(this));
	}

	public String getUIClassID() {
		return "ChevronUI";
	}

	public boolean isShowMore() {
		return this.showMore;
	}

	public void setShowMore(boolean showMore) {
		boolean bool = this.showMore;
		if (DefaultDockableBarManager.state == 0) {
			if (this.showMore != showMore)
				this.showMore = showMore;
		} else
			firePropertyChange("showMore", new Boolean(bool), new Boolean(this.showMore));
	}

	public boolean isShowOptions() {
		return this.showOptions;
	}

	public void setShowOptions(boolean showOptions) {
		boolean bool = this.showOptions;
		if (DefaultDockableBarManager.state == 0) {
			if (this.showOptions != showOptions)
				this.showOptions = showOptions;
		} else
			firePropertyChange("showOption", new Boolean(bool), new Boolean(this.showOptions));
	}

	static Class a(String paramString) throws Throwable {
		try {
			return Class.forName(paramString);
		} catch (ClassNotFoundException localClassNotFoundException) {
			throw new NoClassDefFoundError().initCause(localClassNotFoundException);
		}
	}

	static CommandBar a(Chevron paramChevron, Component paramComponent) {
		return paramChevron.a(paramComponent);
	}

	static {
		//if (!Lm.isActionProductPurchased()){
		//	Lm.showInvalidProductMessage((c == null ? (Chevron.c = a("com.jidesoft.action.Chevron")): c).getName(), 16);
		//}
	}
}
