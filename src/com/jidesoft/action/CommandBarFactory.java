package com.jidesoft.action;

import com.jidesoft.docking.DefaultDockableHolder;
import com.jidesoft.docking.DockableFrame;
import com.jidesoft.docking.DockableHolder;
import com.jidesoft.docking.DockingManager;
import com.jidesoft.docking.DockingManager.TabbedPaneCustomizer;
import com.jidesoft.document.DocumentPane;
import com.jidesoft.plaf.LookAndFeelFactory;
import com.jidesoft.plaf.office2003.Office2003Painter;
import com.jidesoft.plaf.office2003.Office2003Theme;
import com.jidesoft.swing.JideButton;
import com.jidesoft.swing.JideMenu;
import com.jidesoft.swing.JideSplitButton;
import com.jidesoft.swing.JideSwingUtilities;
import com.jidesoft.swing.JideSwingUtilities.Handler;
import com.jidesoft.swing.JideTabbedPane;
import com.jidesoft.utils.SystemInfo;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.synth.SynthStyleFactory;

public class CommandBarFactory{
	static final String[] a = { "de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaMauveMetallicLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel", "de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel" };
	static final String[] b = { "org.jvnet.substance.skin.SubstanceNebulaBrickWallLookAndFeel", "org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel", "org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel", "org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel", "org.jvnet.substance.skin.SubstanceBusinessLookAndFeel", "org.jvnet.substance.skin.SubstanceMagmaLookAndFeel", "org.jvnet.substance.skin.SubstanceSaharaLookAndFeel", "org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel", "org.jvnet.substance.skin.SubstanceCremeCoffeeLookAndFeel", "org.jvnet.substance.skin.SubstanceNebulaLookAndFeel", "org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel", "org.jvnet.substance.skin.SubstanceRavenLookAndFeel", "org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel", "org.jvnet.substance.skin.SubstanceAutumnLookAndFeel", "org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel", "org.jvnet.substance.skin.SubstanceMistSilverLookAndFeel", "org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel", "org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel", "org.jvnet.substance.skin.SubstanceCremeLookAndFeel", "org.jvnet.substance.skin.SubstanceModerateLookAndFeel" };
	public static boolean flag;//c
	  
	public static CommandBar createMenuCommandBar(JMenuBar paramJMenuBar) {
		CommandMenuBar localCommandMenuBar = new CommandMenuBar("Menu Bar");
		localCommandMenuBar.getContext().setInitSide(1);
		localCommandMenuBar.setPaintBackground(false);
		localCommandMenuBar.setStretch(true);
		localCommandMenuBar.setFloatable(true);
		localCommandMenuBar.add(paramJMenuBar);
		return localCommandMenuBar;
	}
	
	protected static JideButton createButton(Icon paramIcon) {
		return createButton(null, paramIcon);
	}

	protected static JideButton createButton(String paramString) {
		return createButton(paramString, null);
	}

	protected static JideButton createButton(String paramString, Icon paramIcon) {
		JideButton localJideButton = new JideButton(paramString, paramIcon);
		localJideButton.setOpaque(false);
		localJideButton.setFocusable(false);
		return localJideButton;
	}
	
	protected static JideMenu createMenu(Icon paramIcon) {
		JideMenu localJideMenu = new JideMenu("");
		localJideMenu.setIcon(paramIcon);
		localJideMenu.setOpaque(false);
		return localJideMenu;
	}

	protected static JideMenu createMenu(String paramString, char paramChar) {
		JideMenu localJideMenu = new JideMenu(paramString);
		localJideMenu.setMnemonic(paramChar);
		localJideMenu.setOpaque(false);
		return localJideMenu;
	}

	protected static JideMenu createMenu(String paramString, char paramChar,
			Icon paramIcon) {
		JideMenu localJideMenu = new JideMenu(paramString);
		localJideMenu.setIcon(paramIcon);
		localJideMenu.setMnemonic(paramChar);
		localJideMenu.setOpaque(false);
		return localJideMenu;
	}
	
	public static CommandBar createLookAndFeelCommandBar(final Container paramContainer) {
		boolean bool = flag;
	    CommandBar localCommandBar = new CommandBar("LookAndFeel");
	    localCommandBar.setInitSide(1);
	    localCommandBar.setInitMode(2);
	    localCommandBar.setInitIndex(2);
	    JButton localJButton = (JButton)localCommandBar.add(createButton("Vsnet"));
	    localJButton.setMnemonic('V');
	    localJButton.setToolTipText("Windows LookAndFeel (Vsnet Style)");
	    localJButton.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = 3201541150821346747L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        System.setProperty("shadingtheme", "false");
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException localClassNotFoundException) {
				} catch (InstantiationException localInstantiationException) {
				} catch (IllegalAccessException localIllegalAccessException) {
				} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
				}
	        LookAndFeelFactory.installJideExtension(1);
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabShape", Integer.valueOf(2));
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabColorTheme", Integer.valueOf(3));
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJButton.setEnabled(SystemInfo.isWindows());
	    localJButton = (JButton)localCommandBar.add(createButton("Vsnet/Gradient"));
	    localJButton.setMnemonic('S');
	    localJButton.setToolTipText("Windows LookAndFeel (Vsnet Style with Gradient)");
	    localJButton.addActionListener(new AbstractAction()
	    {
	      private static final long serialVersionUID = 8646024555450082333L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        System.setProperty("shadingtheme", "true");
	        try{
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException localClassNotFoundException) {
				} catch (InstantiationException localInstantiationException) {
				} catch (IllegalAccessException localIllegalAccessException) {
				} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
				}
	        LookAndFeelFactory.installJideExtension(1);
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabShape", Integer.valueOf(1));
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabColorTheme", Integer.valueOf(4));
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJButton.setEnabled(SystemInfo.isWindows());
	    localJButton = (JButton)localCommandBar.add(createButton("Office2003"));
	    localJButton.setMnemonic('O');
	    localJButton.setToolTipText("Windows LookAndFeel (Office 2003 Style)");
	    localJButton.addActionListener(new AbstractAction()
	    {
	      private static final long serialVersionUID = -1327530702444587931L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	      {
	        System.setProperty("shadingtheme", "false");
	        try
	        {
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        }
	        catch (ClassNotFoundException localClassNotFoundException)
	        {
	        }
	        catch (InstantiationException localInstantiationException)
	        {
	        }
	        catch (IllegalAccessException localIllegalAccessException)
	        {
	        }
	        catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException)
	        {
	        }
	        LookAndFeelFactory.installJideExtension(3);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJButton.setEnabled(SystemInfo.isWindows());
	    JideSplitButton localJideSplitButton = (JideSplitButton)localCommandBar.add(createSplitButton("Office2003 Themes"));
	    localJideSplitButton.setMnemonic('T');
	    localJideSplitButton.setToolTipText("Switch Themes (Office 2003 Style only)");
	    localJideSplitButton.addActionListener(new AbstractAction()
	    {
	      private static final long serialVersionUID = -8255668487163004250L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	      {
	        boolean bool = CommandBarFactory.flag;
	        String str1 = ((Office2003Painter)Office2003Painter.getInstance()).getColorName();
	        if ((bool) || ((str1 == null) || ((bool) || (str1.trim().length() == 0))))
	          str1 = "Default";
	        Collection localCollection = ((Office2003Painter)Office2003Painter.getInstance()).getAvailableThemes();
	        String str2 = null;
	        Iterator localIterator = localCollection.iterator();
	        do
	        {
	          if (!localIterator.hasNext())
	            break;
	          Office2003Theme localOffice2003Theme1 = (Office2003Theme)localIterator.next();
	          if (!bool)
	            if (str2 == null)
	              str2 = localOffice2003Theme1.getThemeName();
	          if ((bool) || (localOffice2003Theme1.getThemeName().equals(str1)))
	            if ((bool) || (localIterator.hasNext()))
	            {
	              Office2003Theme localOffice2003Theme2 = (Office2003Theme)localIterator.next();
	              ((Office2003Painter)Office2003Painter.getInstance()).setColorName(localOffice2003Theme2.getThemeName());
	              CommandBarFactory.updateComponentTreeUI(paramContainer);
	              if (!bool);
	            }
	            else
	            {
	              ((Office2003Painter)Office2003Painter.getInstance()).setColorName(str2);
	              CommandBarFactory.updateComponentTreeUI(paramContainer);
	            }
	        }
	        while (!bool);
	      }
	    });
	    Collection localCollection = ((Office2003Painter)Office2003Painter.getInstance()).getAvailableThemes();
	    Object localObject1 = localCollection.iterator();
	    Object localObject2;
	    while (((Iterator)localObject1).hasNext()){
	      localObject2 = (Office2003Theme)((Iterator)localObject1).next();
	      JMenuItem localJMenuItem = new JMenuItem(((Office2003Theme)localObject2).getThemeName());
	      localJMenuItem.addActionListener(new AbstractAction(((Office2003Theme)localObject2).getThemeName())
	      {
	        private static final long serialVersionUID = -3081613616829830963L;

	        public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	        {
	          ((Office2003Painter)Office2003Painter.getInstance()).setColorName((String)getValue("Name"));
	          CommandBarFactory.updateComponentTreeUI(paramContainer);
	        }
	      });
	      localJideSplitButton.add(localJMenuItem);
	      if (bool)
	        break;
	      if (bool){
//	        int k = DockableBar.o;
//	        k++;
//	        DockableBar.o = k;
	      }
	    }
	    localJideSplitButton.setEnabled(SystemInfo.isWindows());
	    localJButton = (JButton)localCommandBar.add(createButton("Office2007"));
	    localJButton.setMnemonic('F');
	    localJButton.setToolTipText("Windows LookAndFeel (Office 2007 Style, Windows Vista Only)");
	    localJButton.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = 2947691667876664962L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	      {
	        System.setProperty("shadingtheme", "false");
	        try
	        {
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        }
	        catch (ClassNotFoundException localClassNotFoundException)
	        {
	        }
	        catch (InstantiationException localInstantiationException)
	        {
	        }
	        catch (IllegalAccessException localIllegalAccessException)
	        {
	        }
	        catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException)
	        {
	        }
	        LookAndFeelFactory.installJideExtension(7);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJButton.setEnabled(SystemInfo.isWindowsVistaAbove());
	    localCommandBar.addSeparator();
	    localJButton = (JButton)localCommandBar.add(createButton("Eclipse"));
	    localJButton.setMnemonic('E');
	    localJButton.setToolTipText("Windows LookAndFeel (Eclipse Style)");
	    localJButton.addActionListener(new AbstractAction()
	    {
	      private static final long serialVersionUID = -2312049199057067200L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	      {
	        System.setProperty("shadingtheme", "false");
	        try
	        {
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        }
	        catch (ClassNotFoundException localClassNotFoundException)
	        {
	        }
	        catch (InstantiationException localInstantiationException)
	        {
	        }
	        catch (IllegalAccessException localIllegalAccessException)
	        {
	        }
	        catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException)
	        {
	        }
	        LookAndFeelFactory.installJideExtension(2);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJButton.setEnabled(SystemInfo.isWindows());
	    localJButton = (JButton)localCommandBar.add(createButton("Eclipse3x"));
	    localJButton.setMnemonic('C');
	    localJButton.setToolTipText("Windows LookAndFeel (Eclipse3x Style)");
	    localJButton.addActionListener(new AbstractAction()
	    {
	      private static final long serialVersionUID = 1934151950524403252L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	      {
	        System.setProperty("shadingtheme", "false");
	        try
	        {
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        }
	        catch (ClassNotFoundException localClassNotFoundException)
	        {
	        }
	        catch (InstantiationException localInstantiationException)
	        {
	        }
	        catch (IllegalAccessException localIllegalAccessException)
	        {
	        }
	        catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException)
	        {
	        }
	        LookAndFeelFactory.installJideExtension(5);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJButton.setEnabled(SystemInfo.isWindows());
	    localCommandBar.addSeparator();
	    localJButton = (JButton)localCommandBar.add(createButton("Xerto"));
	    localJButton.setMnemonic('X');
	    localJButton.setToolTipText("Windows/Metal LookAndFeel (Xerto Style)");
	    localJButton.addActionListener(new AbstractAction()
	    {
	      private static final long serialVersionUID = 8377070200610409569L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	      {
	        try
	        {
	          if (!SystemInfo.isWindows())
	          {
	            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	            if (!CommandBarFactory.flag);
	          }
	          else
	          {
	            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	          }
	        }
	        catch (ClassNotFoundException localClassNotFoundException)
	        {
	        }
	        catch (InstantiationException localInstantiationException)
	        {
	        }
	        catch (IllegalAccessException localIllegalAccessException)
	        {
	        }
	        catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException)
	        {
	        }
	        LookAndFeelFactory.installJideExtension(4);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localCommandBar.addSeparator();
	    localJButton = (JButton)localCommandBar.add(createButton("Metal"));
	    localJButton.setMnemonic('M');
	    localJButton.setToolTipText("Metal LookAndFeel (Vsnet Style)");
	    localJButton.addActionListener(new AbstractAction()
	    {
	      private static final long serialVersionUID = 135917786379131644L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	      {
	        try
	        {
	          UIManager.setLookAndFeel(MetalLookAndFeel.class.getName());
	        }
	        catch (ClassNotFoundException localClassNotFoundException)
	        {
	        }
	        catch (InstantiationException localInstantiationException)
	        {
	        }
	        catch (IllegalAccessException localIllegalAccessException)
	        {
	        }
	        catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException)
	        {
	        }
	        LookAndFeelFactory.installJideExtension(1);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	   localCommandBar.addSeparator();
	    if (!bool){
	      localJButton = (JButton)localCommandBar.add(createButton("Aqua"));
	      localJButton.setMnemonic('A');
	      localJButton.setToolTipText("Aqua LookAndFeel (Mac OS X Only)");
	      localJButton.addActionListener(new AbstractAction(){
	        private static final long serialVersionUID = -3414435917876447440L;

	        public void actionPerformed(ActionEvent paramAnonymousActionEvent){
					try {
						UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
					} catch (ClassNotFoundException localClassNotFoundException) {
					} catch (InstantiationException localInstantiationException) {
					} catch (IllegalAccessException localIllegalAccessException) {
					} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
					}
	          LookAndFeelFactory.installJideExtension(1);
	          CommandBarFactory.updateComponentTreeUI(paramContainer);
	        }
	      });
	      localJButton.setEnabled(SystemInfo.isMacOSX());
	      if ((!LookAndFeelFactory.isPlastic3DLnfInstalled()) && ((bool) || (!LookAndFeelFactory.isPlastic3D13LnfInstalled())) && ((bool) || (!LookAndFeelFactory.isPlasticXPLnfInstalled())) && ((bool) || (!LookAndFeelFactory.isAlloyLnfInstalled())) && ((bool) || (!LookAndFeelFactory.isA03LnfInstalled())))
	      {
	        if (bool);
	        if (!LookAndFeelFactory.isSyntheticaLnfInstalled());
	      }
	    }
	    localCommandBar.addSeparator();
	    if (!bool)
	      if (LookAndFeelFactory.isPlastic3DLnfInstalled())
	      {
	        localJButton = (JButton)localCommandBar.add(createButton("Plastic3D"));
	        localJButton.setMnemonic('P');
	        localJButton.setToolTipText("Plastic3D LookAndFeel (Pre 1.3) (Vsnet Style)");
	        localJButton.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = 8436821172703192556L;

					public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
						System.setProperty("shadingtheme", "true");
						try {
							UIManager.setLookAndFeel("com.jgoodies.plaf.plastic.Plastic3DLookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
						LookAndFeelFactory.installJideExtension(1);
						CommandBarFactory.updateComponentTreeUI(paramContainer);
					}
	        });
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isPlastic3D13LnfInstalled()){
	        localJButton = (JButton)localCommandBar.add(createButton("Plastic3D"));
	        localJButton.setMnemonic('L');
	        localJButton.setToolTipText("Plastic3D LookAndFeel (Vsnet Style)");
	        localJButton.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = -8944151945641690341L;

	          public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	            System.setProperty("shadingtheme", "true");
	            try{
	              UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
	            LookAndFeelFactory.installJideExtension(1);
	            CommandBarFactory.updateComponentTreeUI(paramContainer);
	          }
	        });
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isPlasticXPLnfInstalled()){
	        localJButton = (JButton)localCommandBar.add(createButton("PlasticXP"));
	        localJButton.setMnemonic('S');
	        localJButton.setToolTipText("PlasticXP LookAndFeel (Vsnet Style)");
	        localJButton.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = -5532844695635634405L;

	          public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	            System.setProperty("shadingtheme", "true");
						try {
							UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
	            LookAndFeelFactory.installJideExtension(1);
	            CommandBarFactory.updateComponentTreeUI(paramContainer);
	          }
	        });
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isAlloyLnfInstalled()){
	        localJButton = (JButton)localCommandBar.add(createButton("Alloy"));
	        localJButton.setMnemonic('Y');
	        localJButton.setToolTipText("Alloy LookAndFeel (Vsnet Style)");
	        localJButton.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = 5740971958571563440L;

	          public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	            System.setProperty("shadingtheme", "true");
						try {
							UIManager.setLookAndFeel("com.incors.plaf.alloy.AlloyLookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
	            }
	            LookAndFeelFactory.installJideExtension(1);
	            CommandBarFactory.updateComponentTreeUI(paramContainer);
	          }
	        });
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isA03LnfInstalled()){
	        localJButton = (JButton)localCommandBar.add(createButton("A03"));
	        localJButton.setMnemonic('0');
	        localJButton.setToolTipText("A03 LookAndFeel (Xerto Style)");
	        localJButton.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = 4255442222043846798L;

	          public void actionPerformed(ActionEvent paramAnonymousActionEvent){
						try {
							UIManager.setLookAndFeel("a03.swing.plaf.A03LookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
	            LookAndFeelFactory.installJideExtension(4);
	            CommandBarFactory.updateComponentTreeUI(paramContainer);
	          }
	        });
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isSyntheticaLnfInstalled()){
	        localJideSplitButton = (JideSplitButton)localCommandBar.add(createSplitButton("Synthetica"));
	        localJideSplitButton.setToolTipText("Synthetica LookAndFeel");
	        localJideSplitButton.setAlwaysDropdown(true);
	        //localObject1 = a("Synthetica", paramContainer, a);
	        localObject2 = ((JMenu)localObject1).getPopupMenu().getComponents();
	        Object localObject3 = localObject2;
	        //int i = localObject3.length;
	        int j = 0;
	        do
	        {
	          //if (j >= i)
	            //break;
	          //Component localComponent = localObject3[j];
	         // localJideSplitButton.add(localComponent);
	         // j++;
	          //if (bool)
	            //break ;
	        }
	        while (!bool);
	      }
	    if (((!bool) && (LookAndFeelFactory.isPlastic3DLnfInstalled())) || ((!bool) && (LookAndFeelFactory.isPlastic3D13LnfInstalled())) || ((!bool) && (LookAndFeelFactory.isPlasticXPLnfInstalled())) || ((!bool) && (LookAndFeelFactory.isAlloyLnfInstalled())) || ((bool) || ((LookAndFeelFactory.isA03LnfInstalled()) || (LookAndFeelFactory.isSyntheticaLnfInstalled()))))
	      localCommandBar.addSeparator();
	    localJButton = (JButton)localCommandBar.add(createButton("Default"));
	    localJButton.setMnemonic('D');
	    localJButton.setToolTipText("Restore to default L&F with JIDE extension");
	    localJButton.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = -8161576554724617386L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        LookAndFeelFactory.installDefaultLookAndFeelAndExtension();
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    return localCommandBar;
	}
	
	protected static JideSplitButton createSplitButton(Icon paramIcon) {
		return createSplitButton(null, paramIcon);
	}
	
	protected static JideSplitButton createSplitButton(String paramString) {
		return createSplitButton(paramString, null);
	}

	protected static JideSplitButton createSplitButton(String paramString,Icon paramIcon) {
		JideSplitButton localJideSplitButton = new JideSplitButton(paramString);
		localJideSplitButton.setIcon(paramIcon);
		localJideSplitButton.setOpaque(true);
		localJideSplitButton.setFocusable(false);
		return localJideSplitButton;
	}
	  
	public static void addDemoMenus(JComponent paramJComponent,String[] paramArrayOfString) {
		boolean bool = flag;
		String[] arrayOfString = paramArrayOfString;
		int i = arrayOfString.length;
		int j = 0;
		do {
			if (j >= i)
				break;
			String str = arrayOfString[j];
			JideMenu localJideMenu = new JideMenu(str);
			localJideMenu.setMnemonic(str.charAt(0));
			JMenuItem localJMenuItem = new JMenuItem("<< Empty >>");
			localJideMenu.add(localJMenuItem);
			paramJComponent.add(localJideMenu);
			j++;
		} while (!bool);
	}

	public static JMenu createLookAndFeelMenu(final Container paramContainer) {
		boolean bool = flag;
	    ResourceBundle localResourceBundle = Actions.getResourceBundle(Locale.getDefault());
	    JideMenu localJideMenu1 = new JideMenu(localResourceBundle.getString("Menu.lookAndFeel"));
	    localJideMenu1.setMnemonic(localResourceBundle.getString("Menu.lookAndFeel.mnemonic").charAt(0));
	    JMenuItem localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.windowsVsnet"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.windowsVsnet.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = 7329857403026223556L;
	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        System.setProperty("shadingtheme", "false");
	        try{
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        }catch (ClassNotFoundException localClassNotFoundException){
	        }catch (InstantiationException localInstantiationException){
	        }catch (IllegalAccessException localIllegalAccessException){
	        }catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException){
	        }
	        LookAndFeelFactory.installJideExtension(1);
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabShape", Integer.valueOf(2));
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabColorTheme", Integer.valueOf(3));
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJideMenu1.add(localJMenuItem);
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.windowsVsnetGradient"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.windowsVsnetGradient.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = 1317964936229802115L;
	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        System.setProperty("shadingtheme", "true");
	        try{
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        }catch (ClassNotFoundException localClassNotFoundException){
	        }catch (InstantiationException localInstantiationException){
	        }catch (IllegalAccessException localIllegalAccessException){
	        }catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException){
	        }
	        LookAndFeelFactory.installJideExtension(1);
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabShape", Integer.valueOf(1));
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabColorTheme", Integer.valueOf(4));
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    
	    localJideMenu1.add(localJMenuItem);
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.windowsVsnetClassic"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.windowsVsnetClassic.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = -7357162252817623330L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        System.setProperty("shadingtheme", "false");
	        try{
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
	        }catch (ClassNotFoundException localClassNotFoundException){
	        }catch (InstantiationException localInstantiationException){
			} catch (IllegalAccessException localIllegalAccessException) {
			} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
			}
	        LookAndFeelFactory.installJideExtension(1);
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabShape", Integer.valueOf(1));
	        UIManager.getLookAndFeelDefaults().put("JideTabbedPane.defaultTabColorTheme", Integer.valueOf(1));
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    
	    localJideMenu1.add(localJMenuItem);
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.windowsOffice2003"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.windowsOffice2003.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = -7357162252817623330L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        System.setProperty("shadingtheme", "false");
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException localClassNotFoundException) {
				} catch (InstantiationException localInstantiationException) {
				} catch (IllegalAccessException localIllegalAccessException) {
				} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
				}
	        LookAndFeelFactory.installJideExtension(3);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    
	    localJMenuItem.setEnabled(SystemInfo.isWindows());
	    localJideMenu1.add(localJMenuItem);
	    JideMenu localJideMenu2 = new JideMenu(localResourceBundle.getString("Menu.office2003Themes"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.office2003Themes.mnemonic").charAt(0));
	    Collection localCollection = ((Office2003Painter)Office2003Painter.getInstance()).getAvailableThemes();
	    Iterator localIterator = localCollection.iterator();
	    
	    do{
	      if (!localIterator.hasNext())
	        break;
	      Office2003Theme localOffice2003Theme = (Office2003Theme)localIterator.next();
	      localJMenuItem = new JMenuItem(localOffice2003Theme.getThemeName());
	      localJMenuItem.addActionListener(new AbstractAction(localOffice2003Theme.getThemeName()){
	        private static final long serialVersionUID = -5040987591603805273L;

	        public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	          ((Office2003Painter)Office2003Painter.getInstance()).setColorName((String)getValue("Name"));
	          CommandBarFactory.updateComponentTreeUI(paramContainer);
	        }
	      });
	      localJideMenu2.add(localJMenuItem);
	      if (bool)
	        break;
	    }
	    while (!bool);
	    
	    localJideMenu2.setEnabled(SystemInfo.isWindows());
	    localJideMenu1.add(localJideMenu2);
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.windowsOffice2007"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.windowsOffice2007.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction()
	    {
	      private static final long serialVersionUID = 9196873570605698569L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        System.setProperty("shadingtheme", "false");
	        try{
	          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        }catch (ClassNotFoundException localClassNotFoundException){
	        }catch (InstantiationException localInstantiationException){
			} catch (IllegalAccessException localIllegalAccessException) {
			} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
			}
	        LookAndFeelFactory.installJideExtension(7);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    
	    localJMenuItem.setEnabled(SystemInfo.isWindowsVistaAbove());
	    localJideMenu1.add(localJMenuItem);
	    localJideMenu1.addSeparator();
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.windowsEclipse"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.windowsEclipse.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = -439933116198670257L;
			public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
				System.setProperty("shadingtheme", "false");
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException localClassNotFoundException) {
				} catch (InstantiationException localInstantiationException) {
				} catch (IllegalAccessException localIllegalAccessException) {
				} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
				}
				LookAndFeelFactory.installJideExtension(2);
				CommandBarFactory.updateComponentTreeUI(paramContainer);
			}
	    });
	    
	    localJideMenu1.add(localJMenuItem);
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.windowsEclipse3x"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.windowsEclipse3x.mnemonic").charAt(0));
		localJMenuItem.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 5752902379748846824L;

			public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
				System.setProperty("shadingtheme", "false");
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException localClassNotFoundException) {
				} catch (InstantiationException localInstantiationException) {
				} catch (IllegalAccessException localIllegalAccessException) {
				} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
				}
				LookAndFeelFactory.installJideExtension(5);
				CommandBarFactory.updateComponentTreeUI(paramContainer);
			}
		});
	    localJideMenu1.add(localJMenuItem);
	    localJideMenu1.addSeparator();
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.xerto"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.xerto.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = 8106961103954712663L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
				try {
					if (!SystemInfo.isWindows()) {
						UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
						if (!CommandBarFactory.flag);
					} else {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					}
				} catch (ClassNotFoundException localClassNotFoundException) {
				} catch (InstantiationException localInstantiationException) {
				} catch (IllegalAccessException localIllegalAccessException) {
				} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
				}
				LookAndFeelFactory.installJideExtension(4);
				CommandBarFactory.updateComponentTreeUI(paramContainer);
			}
	    });
	    
	    localJideMenu1.add(localJMenuItem);
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.metalVsnet"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.metalVsnet.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = -8280662735260996990L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent){
	        System.setProperty("shadingtheme", "false");
	        try{
	          UIManager.setLookAndFeel(MetalLookAndFeel.class.getName());
				} catch (ClassNotFoundException localClassNotFoundException) {
				} catch (InstantiationException localInstantiationException) {
				} catch (IllegalAccessException localIllegalAccessException) {
				} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
				}
	        LookAndFeelFactory.installJideExtension(1);
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJideMenu1.add(localJMenuItem);
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.aqua"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.aqua.mnemonic").charAt(0));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = -2607089212872234201L;

			public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
				System.setProperty("shadingtheme", "false");
				try {
					UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
				} catch (ClassNotFoundException localClassNotFoundException) {
				} catch (InstantiationException localInstantiationException) {
				} catch (IllegalAccessException localIllegalAccessException) {
				} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
				}
				LookAndFeelFactory.installJideExtension(1);
				CommandBarFactory.updateComponentTreeUI(paramContainer);
			}
	    });
	    
	    localJMenuItem.setEnabled(SystemInfo.isMacOSX());
	    if (!bool){
	      localJideMenu1.add(localJMenuItem);
	      if ((!LookAndFeelFactory.isPlastic3DLnfInstalled()) && ((bool) || (!LookAndFeelFactory.isPlasticXPLnfInstalled())) && ((bool) || (!LookAndFeelFactory.isAlloyLnfInstalled())) && ((bool) || (!LookAndFeelFactory.isA03LnfInstalled()))){
	        if (bool);
	        if (!LookAndFeelFactory.isSyntheticaLnfInstalled());
	      }
	    }
	    localJideMenu1.addSeparator();
	    if (!bool)
	      if (LookAndFeelFactory.isPlastic3DLnfInstalled()){
	        localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.plastic3DVsnet"));
	        localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.plastic3DVsnet.mnemonic").charAt(0));
	        localJMenuItem.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = -9166134683152348076L;
					public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
						System.setProperty("shadingtheme", "true");
						try {
							UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
						LookAndFeelFactory.installJideExtension(1);
						CommandBarFactory.updateComponentTreeUI(paramContainer);
					}
	        });
	        localJideMenu1.add(localJMenuItem);
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isPlasticXPLnfInstalled()){
	        localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.plasticXPVsnet"));
	        localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.plasticXPVsnet.mnemonic").charAt(0));
	        localJMenuItem.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = 7907842697885724816L;

					public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
						System.setProperty("shadingtheme", "true");
						try {
							UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
						LookAndFeelFactory.installJideExtension(1);
						CommandBarFactory.updateComponentTreeUI(paramContainer);
					}
				});
	        localJideMenu1.add(localJMenuItem);
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isBizlafLnfInstalled()) {
	        localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.bizlaf"));
	        localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.bizlaf.mnemonic").charAt(0));
	        localJMenuItem.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = 6326560496018798344L;

	          public void actionPerformed(ActionEvent paramAnonymousActionEvent){
						System.setProperty("shadingtheme", "true");
						try {
							UIManager.setLookAndFeel("de.centigrade.bizlaf.BizLookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
						LookAndFeelFactory.installJideExtension();
						CommandBarFactory.updateComponentTreeUI(paramContainer);
	          }
	        });
	        localJideMenu1.add(localJMenuItem);
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isAlloyLnfInstalled()) {
	        localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.alloyVsnet"));
	        localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.alloyVsnet.mnemonic").charAt(0));
				localJMenuItem.addActionListener(new AbstractAction() {
					private static final long serialVersionUID = -2585526602120461611L;

					public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
						System.setProperty("shadingtheme", "true");
						try {
							UIManager.setLookAndFeel("com.incors.plaf.alloy.AlloyLookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
						LookAndFeelFactory.installJideExtension(1);
						CommandBarFactory.updateComponentTreeUI(paramContainer);
					}
				});
				localJideMenu1.add(localJMenuItem);
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isA03LnfInstalled())
	      {
	        localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.a03Xerto"));
	        localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.a03Xerto.mnemonic").charAt(0));
	        localJMenuItem.addActionListener(new AbstractAction(){
	          private static final long serialVersionUID = 6326560496018798344L;

					public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
						System.setProperty("shadingtheme", "true");
						try {
							UIManager.setLookAndFeel("a03.swing.plaf.A03LookAndFeel");
						} catch (ClassNotFoundException localClassNotFoundException) {
						} catch (InstantiationException localInstantiationException) {
						} catch (IllegalAccessException localIllegalAccessException) {
						} catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
						}
						LookAndFeelFactory.installJideExtension(4);
						CommandBarFactory.updateComponentTreeUI(paramContainer);
	          }
	        });
	        localJideMenu1.add(localJMenuItem);
	      }
	    if (!bool)
	      if (LookAndFeelFactory.isSyntheticaLnfInstalled())
	        //localJideMenu1.add(a(localResourceBundle.getString("Menu.synthetica"), paramContainer, a));
	    if (((!bool) && (LookAndFeelFactory.isPlastic3DLnfInstalled())) || ((!bool) && (LookAndFeelFactory.isPlasticXPLnfInstalled())) || ((!bool) && (LookAndFeelFactory.isAlloyLnfInstalled())) || ((bool) || ((LookAndFeelFactory.isA03LnfInstalled()) || (LookAndFeelFactory.isSyntheticaLnfInstalled()))))
	      localJideMenu1.addSeparator();
	    localJMenuItem = new JMenuItem(localResourceBundle.getString("Menu.systemDefault"));
	    localJMenuItem.setMnemonic(localResourceBundle.getString("Menu.systemDefault.mnemonic").charAt(0));
	    localJMenuItem.setToolTipText(localResourceBundle.getString("Menu.systemDefault.toolTip"));
	    localJMenuItem.addActionListener(new AbstractAction(){
	      private static final long serialVersionUID = 7329857403026223556L;

	      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
	      {
	        LookAndFeelFactory.installDefaultLookAndFeelAndExtension();
	        CommandBarFactory.updateComponentTreeUI(paramContainer);
	      }
	    });
	    localJideMenu1.add(localJMenuItem);
//	    if (AbstractDemo.a != 0)
//	      b = !bool;
	    return localJideMenu1;
	}

	private static void updateComponentTreeUI(final Container paramContainer) {
		boolean bool = flag;
	    ArrayList localArrayList = new ArrayList();
	    List<String> localObject = new ArrayList<String>();
	    if (!bool)
	      if ((paramContainer instanceof DockableHolder)){
	        localObject = ((DockableHolder)paramContainer).getDockingManager().getAllFrameNames();
	        Iterator localIterator = ((List)localObject).iterator();
	        do {
	          if (!localIterator.hasNext())
	            break;
	          String str = (String)localIterator.next();
	         DockableFrame localDockableFrame = ((DockableHolder)paramContainer).getDockingManager().getFrame(str);
	          if (bool)
	            break ;
	          if ((bool) || (localDockableFrame.isFloated()))
	            localArrayList.add(str);
	        }
	        while (!bool);
	      }
	    if (!bool){
	      if ((paramContainer instanceof JFrame)){
	        if (!bool)
	          if ((paramContainer instanceof DefaultDockableHolder))
	            ((DefaultDockableHolder)paramContainer).setAutoDispose(false);
	        if (!bool)
	          if (!LookAndFeelFactory.isCurrentLnfDecorated())
	          {
	            ((JFrame)paramContainer).dispose();
	            ((JFrame)paramContainer).setUndecorated(true);
	            ((JFrame)paramContainer).getRootPane().setWindowDecorationStyle(1);
	            if (!bool);
	          }
	        if (!bool)
	          if (((JFrame)paramContainer).isUndecorated()){
	            if (bool);
	            if (LookAndFeelFactory.isCurrentLnfDecorated())
	            {
	              ((JFrame)paramContainer).dispose();
	              ((JFrame)paramContainer).setUndecorated(false);
	              ((JFrame)paramContainer).getRootPane().setWindowDecorationStyle(0);
	            }
	          }
	        if (bool);
	        if ((paramContainer instanceof DefaultDockableHolder))
	          ((DefaultDockableHolder)paramContainer).setAutoDispose(true);
	      }
	      JideSwingUtilities.setRecursively(paramContainer, new JideSwingUtilities.Handler(){
	        public boolean condition(Component paramAnonymousComponent){
	          boolean bool = CommandBarFactory.flag;
	          if (!bool)
	            if (!(paramAnonymousComponent instanceof DockableHolder))
	              if (bool);
	         return (paramAnonymousComponent instanceof DockableBarHolder);
	        }

	        public void action(Component paramAnonymousComponent){
	          boolean bool2 = CommandBarFactory.flag;
	          if (!bool2){
	            if ((paramAnonymousComponent instanceof DockableHolder))
	              ((DockableHolder)paramAnonymousComponent).getDockingManager().updateComponentTreeUI();
	            if (bool2);
	          }else{
	            if (!(paramAnonymousComponent instanceof DockableBarHolder))
	              return;
	            ((DockableBarHolder)paramAnonymousComponent).getDockableBarManager().updateComponentTreeUI();
	          }
	          List localList = ((DockableBarHolder)paramAnonymousComponent).getDockableBarManager().getAllDockableBarNames();
	          boolean bool1 = LookAndFeelFactory.isCurrentLnfDecorated();
	          Iterator localIterator = localList.iterator();
	          do {
	            if (!localIterator.hasNext())
	              break;
	            String str = (String)localIterator.next();
	            DockableBar localDockableBar = ((DockableBarHolder)paramAnonymousComponent).getDockableBarManager().getDockableBar(str);
	            if (!bool2) {
	              if (bool1)  {
	                if (!bool2)             {
	                  if (!localDockableBar.isMenuBar())
	                  {
	                    localDockableBar.setOpaque(false);
	                    localDockableBar.setStretch(false);
	                    localDockableBar.setPaintBackground(true);
	                    if (!bool2)
	                      continue;
	                  }
	                  localDockableBar.setOpaque(false);
	                  localDockableBar.setPaintBackground(false);
	                }
	                localDockableBar.setRearrangable(true);
	                if (!bool2)
	                  continue;
	              }
	              if (bool2);
	            }
	            else
	            {
	              if (!localDockableBar.isMenuBar())
	              {
	                localDockableBar.setOpaque(true);
	                localDockableBar.setStretch(true);
	                localDockableBar.setPaintBackground(true);
	                if (!bool2)
	                  continue;
	              }
	              localDockableBar.setOpaque(false);
	              localDockableBar.setPaintBackground(true);
	            }
	            localDockableBar.setRearrangable(localDockableBar.isRearrangable());
	          }
	          while (!bool2);
	        }

	        public void postAction(Component paramAnonymousComponent)
	        {
	        }
	      });
	      SwingUtilities.updateComponentTreeUI(paramContainer);
	    }
	    if ((bool) || ((paramContainer instanceof JFrame)))
	      paramContainer.setVisible(true);
	    // localObject = new Runnable(){
	    //  public void run(){
//	        boolean bool = CommandBarFactory.c;
//	        if (((bool) || (this.val$floatingFrames != null)) && ((bool) || ((this.val$floatingFrames.size() > 0) && ((bool) || ((paramContainer instanceof DockableHolder))))))
//	        {
//	          DockingManager localDockingManager = ((DockableHolder)paramContainer).getDockingManager();
//	          Iterator localIterator = this.val$floatingFrames.iterator();
//	          do
//	          {
//	            if (!localIterator.hasNext())
//	              break;
//	            String str = (String)localIterator.next();
//	            localDockingManager.showFrame(str);
//	          }
//	          while (!bool);
	     // 	}
	  //  };
	    SwingUtilities.invokeLater((Runnable)localObject);
	}
}
