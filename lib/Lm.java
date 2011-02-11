package com.jidesoft.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.Beans;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import com.jidesoft.converter.CalendarConverter;
import com.jidesoft.icons.JideIconsFactory;
import com.jidesoft.plaf.UIDefaultsLookup;
import com.jidesoft.swing.JideSwingUtilities;
import com.jidesoft.swing.PopupWindow;

/**
 * License manager.
 * <p/>
 * The only public method that user needs to use is
 * {@link #verifyLicense(String, String, String)}.
 */
@SuppressWarnings("unused")
public final class Lm {

	private static Logger logger = Logger.getLogger(Lm.class.getName());//a
	
	/**
	 * @deprecated no longer used
	 */
	public static final boolean DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean DOC_DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean CM_DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean RA_DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean ID_DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean PG_DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean CB_DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean HG_DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean AF_DEBUG = false;

	/**
	 * @deprecated no longer used
	 */
	public static final boolean BP_DEBUG = false;

	public static final boolean DOCK_DEBUG = false;

	public static final boolean DOCK_ID_DEBUG = false;

	public static final boolean ACTION_DEBUG = false;

	public static final boolean COMPONENT_DEBUG = false;

	public static final boolean PROPERTY_TABLE_DEBUG = false;

	public static final boolean COMBOBOX_DEBUG = false;

	public static final boolean BEAN_INTROSPECTOR_DEBUG = false;

	public static final boolean DEMO = true;
	
	private static boolean showAboutMessageBox = false;
	private static int c = 0;
	private static JFrame parent;//d
	private static final Calendar e = Calendar.getInstance();
	private static int f = 0;
	private static boolean g = false;
	private static int h = 0;
	private static String i = null;
	private static String j = null;
	private static final String[] productType = { "Docking", "Component", "Grid","Dialog", "Action", "Shortcut", "Pivot", "CodeEditor","FeedReader", "Dashboard", "Data", "Charts", "Gantt", "Diff","TreeMap", "JDAF" };
	private static final BigInteger l = new BigInteger("19", 10);
	private static final BigInteger m = new BigInteger("305508269643653255827856366547026610628423058227532461973", 10);
	public static boolean n;

	public Lm() {
		
	}

	/**
	 * Gets the product version. We used the same version number for all JIDE
	 * products. So you will get a version string that applies to all JIDE
	 * products. It's in the format of x.x.x.xx. or x.x.x. Those numbers are
	 * milestone version, major version, minor version and patch version
	 * respectively.
	 * 
	 * @return the product version.
	 */
	public static String getProductVersion() {
		return "3.7.5";
	}

	public static boolean showDemoMessageBoxDocking() {
		boolean bool = n;
		c += 1;
		if (!bool){
			if (c != 0) {
				if (c % 20 == 0) {
					showAboutMessageBox = false;
					loadRegister();
				}
			}
		}
		return false;
	}

	public static void showAboutMessageBox() {
		showAboutMessageBox = false;
		loadRegister();
	}

	protected static String getProductName(int[] products) {//a
		StringBuffer localStringBuffer = new StringBuffer();
		for (int i = 0; i < products.length; i++) {
			int temp = products[i];
			if (temp == 1)
				localStringBuffer.append(productType[i]);
		}
		return localStringBuffer.toString();
	}

	public static void showInvalidProductMessage(String className,int productName) {
		boolean bool = n;
	    if (!bool)
	      if (h == 0) {
	        if ((!bool) && (g))
	          return;
	        if (!bool)
	          if ("true".equals(SecurityUtils.getProperty("jide.verifyLicense", "false"))){
	            System.err.println(new StringBuilder().append("Verifying ").append(className).toString());
	            Thread.dumpStack();
	          }
	        if ((bool) || ((!Beans.isDesignTime()) && (Beans.isGuiAvailable()))){
	        initalFrame("<html><font size=3><b>Unauthorized usage of JIDE products</b></font><br><br><hr size='1'><br>You get this message box is because you didn't input a correct license key.<br>If you see this message box in one of our demo examples, just ignore it. If you wish to use JIDE products in <br>your application, please contact sales@jidesoft.com.</html>", "JIDE Software, Inc.", -1, "Click to Continue");
	          if (!bool);
				} else {
	          System.out.println("Unauthorized usage of JIDE products\nYou get this message is because you didn't input a correct license key.\nIf you see this message box in one of our demo examples, just ignore it.\nIf you wish to use JIDE products in your application, please contact sales@jidesoft.com.");
	        }
	        g = true;
	        if (!bool)
	          return;
	      }
	    if ((bool) || ((f & productName) == 0)){
	      if (!bool)
	        if ("true".equals(SecurityUtils.getProperty("jide.verifyLicense", "false")))
	        {
	          System.err.println(new StringBuilder().append("Verifying ").append(className).append(" for ").append(productName).toString());
	          Thread.dumpStack();
	        }
	      String str1 = productType(productName);
	      String str2 = productType(h);
	      if ((bool) || ((!Beans.isDesignTime()) && (Beans.isGuiAvailable()))) {
	    	  initalFrame(new StringBuilder().append("<html><font size=3><b>Unauthorized usage of JIDE products</b></font><br><br><hr size='1'><br>You get this message box is because the license key(s) are for ").append(str2).append(" only.<br>").append("The class ").append(className).append(" you tried to use is part of ").append(str1).append(".<br>If you wish to use ").append(str1).append(" in your application, please contact sales@jidesoft.com.</html>").toString(), "JIDE Software, Inc.", -1, "Click to Continue");
	        if (!bool);
			} else {
				System.out.println(new StringBuilder().append("Unauthorized usage of JIDE products\nYou get this message is because the license key(s) are for ").append(str2).append(" only.\n").append("The class ").append(className).append(" you tried to use is part of ").append(str1).append(".\nIf you wish to use ").append(str1).append(" in your application, please contact sales@jidesoft.com.").toString());
	      }
	      f |= productName;
	    }
	}
	 private static String productType(int id){
		 boolean bool = n;
		    StringBuffer localStringBuffer = new StringBuffer();
		    if (!bool)
		      if (id == 0)
		        return "";
		    if (!bool)
		      if ((id & 0x1) != 0)
		        localStringBuffer.append("JIDE Docking Framework, ");
		    if (!bool)
		      if ((id & 0x2) != 0)
		        localStringBuffer.append("JIDE Components, ");
		    if (!bool)
		      if ((id & 0x4) != 0)
		        localStringBuffer.append("JIDE Grids, ");
		    if (!bool)
		      if ((id & 0x8) != 0)
		        localStringBuffer.append("JIDE Dialogs, ");
		    if (!bool)
		      if ((id & 0x10) != 0)
		        localStringBuffer.append("JIDE Action Framework, ");
		    if (!bool)
		      if ((id & 0x40) != 0)
		        localStringBuffer.append("JIDE Shortcut Editor, ");
		    if (!bool)
		      if ((id & 0x20) != 0)
		        localStringBuffer.append("JIDE Pivot Grid, ");
		    if (!bool)
		      if ((id & 0x80) != 0)
		        localStringBuffer.append("JIDE Code Editor, ");
		    if (!bool)
		      if ((id & 0x100) != 0)
		        localStringBuffer.append("JIDE Feed Reader, ");
		    if (!bool)
		      if ((id & 0x400) != 0)
		        localStringBuffer.append("JIDE Dashboard, ");
		    if (!bool)
		      if ((id & 0x800) != 0)
		        localStringBuffer.append("JIDE Data Grids, ");
		    if (!bool)
		      if ((id & 0x1000) != 0)
		        localStringBuffer.append("JIDE Charts, ");
		    if (!bool)
		      if ((id & 0x2000) != 0)
		        localStringBuffer.append("JIDE Gantt Chart, ");
		    if (!bool)
		      if ((id & 0x4000) != 0)
		        localStringBuffer.append("JIDE Diff, ");
		    if (!bool)
		      if ((id & 0x8000) != 0)
		        localStringBuffer.append("JIDE TreeMap, ");
		    if ((id & 0x200) != 0)
		      localStringBuffer.append("JIDE Desktop Application Framework, ");
		    String str = new String(localStringBuffer);
		    return str.substring(0, str.length() - 2);
	 }

	  private static void productType(){
	    if (h == 0)
	    verifyLicense();
	    Calendar localCalendar = Calendar.getInstance();
	    String product = "JIDE Docking Framework, JIDE Action Framework, JIDE Components, JIDE Grids, JIDE Dialogs, JIDE Pivot Grid, JIDE Shortcut Editor, JIDE Code Editor, JIDE Feed Reader, JIDE Dashboard, JIDE Data Grids, JIDE Charts, JIDE Gantt Chart, and JIDE Diff";
	    int i1 = product.indexOf(",", product.length() / 2);
	    product = new StringBuilder().append(product.substring(0, i1 + 1)).append("<BR>").append(product.substring(i1 + 1)).append("<BR>").append(getProductVersion()).toString();
	    if ((h == 0) && (localCalendar.after(e))){
	      initalFrame(new StringBuilder().append("<html><font size=3><b>Demo for ").append(product).append("</b></font><br><br>").append("Copyright (c) 2002-").append(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime())).append(" JIDE Software, Inc, all rights reserved.<br><br><hr size='1'><br>").append("<font color='red'><b>This demo version has expired on ").append(DateFormat.getDateInstance(1).format(e.getTime())).append(".</b></font>").append("<br>If you want to continue evaluating, please download it again from http://www.jidesoft.com.").append("<br><br><b>").append("Please Note: This release package is for evaluation purpose only. Distribution of it is strictly prohibited. If you wish to use any JIDE products in your application, please contact sales@jidesoft.com.</html>").toString(), "JIDE Software, Inc.", -1, "Click to Exit");
	      System.exit(0);
	    }else if (!showAboutMessageBox){
	      if ((!Beans.isDesignTime()) && (Beans.isGuiAvailable()))
	    	initalFrame(new StringBuilder().append("<html><font size=3><b>Demo for ").append(product).append("</b></font><br><br>").append("Copyright (c) 2002-").append(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime())).append(" JIDE Software, Inc, all rights reserved.<br><br><hr size='1'><br>").append("This is an evaluation version of JIDE products ").append(h == 0 ? new StringBuilder().append(". It will expire on ").append(DateFormat.getDateInstance(1).format(e.getTime())).toString() : new StringBuilder().append("that is temporarily licensed to <b>").append(i).append("</b> for ").append(j).toString()).append(".<br><br><b>").append("Please Note: This release package is for evaluation purpose only. Distribution of it is strictly prohibited.<br> ").append("If you wish to use any JIDE products in your application, please contact sales@jidesoft.com. If you already purchased, please download the formal release package to get rid of this message box.</html>").toString(), "JIDE Software, Inc.", -1, "Continue to Evaluate");
	      else
	        System.out.println(new StringBuilder().append("Demo for JIDE Docking Framework, JIDE Action Framework, JIDE Components, JIDE Grids, JIDE Dialogs, JIDE Pivot Grid, JIDE Shortcut Editor, JIDE Code Editor, JIDE Feed Reader, JIDE Dashboard, JIDE Data Grids, JIDE Charts, JIDE Gantt Chart, and JIDE Diff\n\nCopyright (c) 2002-").append(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime())).append(" JIDE Software, Inc, all rights reserved.\n\n---------\n").append("This is an evaluation version of JIDE products ").append(h == 0 ? new StringBuilder().append(". It will expire on ").append(DateFormat.getDateInstance(1).format(e.getTime())).toString() : new StringBuilder().append("that is temporarily licensed to <b>").append(i).append(" for ").append(j).toString()).append(".\n\nPlease Note: This release package is for evaluation purpose only. Distribution of it is strictly prohibited.\n ").append("If you wish to use any JIDE products in your application, please contact sales@jidesoft.com. If you already purchased, please download the formal release package to get rid of this message box.").toString());
	      showAboutMessageBox = true;
	    }
	  }

	public static void loadRegister() {
		productType();
	}
	
	 private static String a(String paramString1, String paramString2, int paramInt1, int paramInt2){
	    StringBuffer sb = new StringBuffer();
	    sb.append(paramString1);
	    sb.append(":");
	    sb.append(paramString2);
	    sb.append(":");
	    sb.append(paramInt1);
	    if (paramInt2 != 0){
	    	sb.append(":");
	    	sb.append(paramInt2);
	    }
	    return new String(sb);
	  }

	  private static String getProductName(String companyName, String projectName, String licenseKey){
	    StringBuffer sb = new StringBuffer();
	    sb.append(companyName);
	    sb.append(":");
	    sb.append(projectName);
	    sb.append(":");
	    sb.append(licenseKey);
	    return new String(sb);
	  }

	  private static int getProductName(String paramString){
	    int i1 = 0;
	    if (paramString.indexOf("Docking") != -1)
	      i1 |= 1;
	    if (paramString.indexOf("Component") != -1)
	      i1 |= 2;
	    if (paramString.indexOf("Grid") != -1)
	      i1 |= 4;
	    if (paramString.indexOf("Dialog") != -1)
	      i1 |= 8;
	    if (paramString.indexOf("Action") != -1)
	      i1 |= 16;
	    if (paramString.indexOf("Shortcut") != -1)
	      i1 |= 64;
	    if (paramString.indexOf("Pivot") != -1)
	      i1 |= 32;
	    if (paramString.indexOf("CodeEditor") != -1)
	      i1 |= 128;
	    if (paramString.indexOf("FeedReader") != -1)
	      i1 |= 256;
	    if (paramString.indexOf("Dashboard") != -1)
	      i1 |= 1024;
	    if (paramString.indexOf("Data") != -1)
	      i1 |= 2048;
	    if (paramString.indexOf("Charts") != -1)
	      i1 |= 4096;
	    if (paramString.indexOf("Gantt") != -1)
	      i1 |= 8192;
	    if (paramString.indexOf("Diff") != -1)
	      i1 |= 16384;
	    if (paramString.indexOf("TreeMap") != -1)
	      i1 |= 32768;
	    if (paramString.indexOf("JDAF") != -1)
	      i1 |= 512;
	    return i1;
	  }

	static boolean verifyLicense(int paramInt) {
		boolean bool = n;
		if (!bool)
			if (h == 0) {
				if ((bool) || (logger.isLoggable(Level.FINE))){
					logger.fine("No license key is input, try to get it from resource file or system property");
				}
				verifyLicense();
			}
		if ((bool) || ((h & paramInt) != 0))
		return !"Evaluation Purpose Only".equals(j);
		
		return bool;
	}

	/**
	 * Verifies the license key.
	 * <p/>
	 * In order to use our product without the license key warning dialog, you
	 * need to get a license key from us. The license key will only enable you
	 * to use the products you purchased.
	 * <p/>
	 * To get the license key, please send email to support@jidesoft.com. We
	 * need following two things from you in order to generate a license key. So
	 * please make sure you have the two things in the email when asking for the
	 * license key.
	 * <p/>
	 * <br>
	 * 1. Company name. If you purchase this product as person, your name is
	 * also fine. <br>
	 * 2. The project/product name where JIDE products are used. We need this in
	 * order to differentiate in case there are two projects in the same company
	 * using JIDE.
	 * <p/>
	 * Once you get the license key from us, just add this line to the beginning
	 * of your application's main method.
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 *      com.jidesoft.utils.Lm.verifyLicense("COMPANY NAME", "PROJECT NAME", "LICENSE KEY");
	 *  </code>
	 * </pre>
	 * <p/>
	 * It will work in most cases. Sometimes you might use one of our components
	 * as static field which will get initialized before the main method. In
	 * this case, you can add a static block before that field.
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 *  static {
	 *      com.jidesoft.utils.Lm.verifyLicense("COMPANY NAME", "PROJECT NAME", "LICENSE KEY");
	 *  }
	 *  </code>
	 * </pre>
	 * 
	 * @param companyName
	 *            your company name. If you purchased this product for personal
	 *            usage, you can use your name as well.
	 * @param projectName
	 *            your project name. It is the project or product where you will
	 *            use JIDE products.
	 * @param licenseKey
	 *            the license key we sent to you by email.
	 */
	public static void verifyLicense(String companyName, String projectName,String licenseKey) {
		if ((n) || (logger.isLoggable(Level.FINE)))
		      logger.fine(new StringBuilder().append("Verify license key: ").append(companyName).append(" + ").append(projectName).append(" + ").append(licenseKey).toString());
		verifyProductInfo(companyName, projectName, licenseKey);
	}
	
	private static void verifyLicense(){
	    ResourceBundle resourceBundle = null;
	    try{
	    	resourceBundle = ResourceBundle.getBundle("com.jidesoft.utils.utils");
		} catch (Exception exception1) {
		}
	    if (resourceBundle == null)
		  try {
	        ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
	        if (localClassLoader != null)
	        	resourceBundle = ResourceBundle.getBundle("com.jidesoft.utils.utils", Locale.getDefault(), localClassLoader);
			} catch (Exception exception2) {
	      }else if (logger.isLoggable(Level.FINE))
	    	logger.fine("Retrieved license key from the resource file");
	    try {
	      String companyName = resourceBundle != null ? resourceBundle.getString("verifyLicense.companyName") : SecurityUtils.getProperty("verifyLicense.companyName", null);
	      if ((companyName == null) || (companyName.trim().length() == 0)) {
	        if (logger.isLoggable(Level.FINE))
	        	logger.fine("Company name is empty");
	        return;
	      }
	      String projectName = resourceBundle != null ? resourceBundle.getString("verifyLicense.projectName") : SecurityUtils.getProperty("verifyLicense.projectName", null);
	      if ((projectName == null) || (projectName.trim().length() == 0)){
	        if (logger.isLoggable(Level.FINE))
	        	logger.fine("Product name is empty");
	        return;
	      }
	      String licenseKey = resourceBundle != null ? resourceBundle.getString("verifyLicense.licenseKey") : SecurityUtils.getProperty("verifyLicense.licenseKey", null);
			if ((licenseKey == null) || (licenseKey.trim().length() == 0)) {
				if (logger.isLoggable(Level.FINE))
					logger.fine("License key is empty");
				return;
			}
			verifyProductInfo(companyName, projectName, licenseKey);
		} catch (Exception exception3) {
		}
	  }
	
	private static void verifyProductInfo(String companyName, String projectName, String licenseKey){
	    if (logger.isLoggable(Level.FINE))
	    	logger.fine("Verifying ...");
	    if ((companyName == null) || (companyName.trim().length() == 0) || (projectName == null) || (projectName.trim().length() == 0) || (licenseKey == null) || (licenseKey.trim().length() == 0)) {
	      if (logger.isLoggable(Level.FINE))
	    	  logger.fine("Verify failed as one of the names are null");
	      return;
	    }
	    companyName = companyName.trim();
	    projectName = projectName.trim();
	    if (projectName.startsWith("Trial")){
	    	Object localObject1 = projectName.substring("Trial".length()).trim();
	      if (((String)localObject1).length() > 0){
	    	  Object localObject2 = new CalendarConverter().fromString((String)localObject1, null);
	        if (((localObject2 instanceof Calendar)) && (Calendar.getInstance().after((Calendar)localObject2))){
	          initalFrame(new StringBuilder().append("<html><font size=3><b>Trial Version for JIDE Products</b></font><br><br>Copyright (c) 2002-").append(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime())).append(" JIDE Software, Inc, all rights reserved.<br><br><hr size='1'><br>").append("<font color='red'><b>This trial version has expired on ").append(DateFormat.getDateInstance(1).format(((Calendar)localObject2).getTime())).append(".</b></font>").append("<br>If you want to continue evaluating, please email sales@jidesoft.com to extend your trial license.").append("<br><br><b>Please Note: This release package is for trial purpose only. Distribution of it is strictly prohibited.<br> ").append("If you wish to use any JIDE products in your application, please contact sales@jidesoft.com.</html>").toString(), "JIDE Software, Inc.", -1, "Click to Exit");
	          System.exit(0);
	        }
	      }
	    }
	    Object localObject1 = new int[productType.length];
	    Arrays.fill((int[])localObject1, 0);
	    Object localObject2 = b(licenseKey);
	    BigInteger localBigInteger = ((BigInteger)localObject2).modPow(l, m);
	    if (b(companyName, projectName, (int[])localObject1, localBigInteger))
	      return;
	    if (a(companyName, projectName, (int[])localObject1, localBigInteger))
	      return;
	    for (int i = 15; i >= 0; i--)
	      for (int j = 7; j >= 0; j--){
	        int i3 = c(a(companyName, projectName, i, j * 16));
	        if (localBigInteger.equals(new BigInteger(new StringBuilder().append("").append(i3).toString())))
	        {
	          h |= i + j * 16;
	          if (logger.isLoggable(Level.FINE))
	        	  logger.fine(new StringBuilder().append("Verified (old way): ").append(h).toString());
	          return;
	        }
	      }
	    if (logger.isLoggable(Level.FINE))
	    	logger.fine("Verify failed");
	  }
	
	private static boolean a(String paramString1, String paramString2, int[] paramArrayOfInt, BigInteger paramBigInteger){
		paramArrayOfInt[0] = 1;
		while (paramArrayOfInt[0] >= 0) {
			paramArrayOfInt[1] = 1;
			while (paramArrayOfInt[1] >= 0) {
				paramArrayOfInt[2] = 1;
				while (paramArrayOfInt[2] >= 0) {
					paramArrayOfInt[3] = 1;
					while (paramArrayOfInt[3] >= 0) {
						paramArrayOfInt[4] = 1;
						while (paramArrayOfInt[4] >= 0) {
							paramArrayOfInt[5] = 1;
							while (paramArrayOfInt[5] >= 0) {
								paramArrayOfInt[6] = 1;
								while (paramArrayOfInt[6] >= 0) {
									paramArrayOfInt[7] = 1;
									while (paramArrayOfInt[7] >= 0) {
										paramArrayOfInt[8] = 1;
										while (paramArrayOfInt[8] >= 0) {
											paramArrayOfInt[9] = 1;
											while (paramArrayOfInt[9] >= 0) {
												paramArrayOfInt[10] = 1;
												while (paramArrayOfInt[10] >= 0) {
													paramArrayOfInt[11] = 1;
													while (paramArrayOfInt[11] >= 0) {
														paramArrayOfInt[12] = 1;
														while (paramArrayOfInt[12] >= 0) {
															paramArrayOfInt[13] = 1;
															while (paramArrayOfInt[13] >= 0) {
																paramArrayOfInt[14] = 1;
																while (paramArrayOfInt[14] >= 0) {
																	paramArrayOfInt[15] = 1;
																	while (paramArrayOfInt[15] >= 0) {
																		if (c(paramString1,paramString2,paramArrayOfInt,paramBigInteger))
																			return true;
																		paramArrayOfInt[15] -= 1;
																	}
																	paramArrayOfInt[14] -= 1;
																}
																paramArrayOfInt[13] -= 1;
															}
															paramArrayOfInt[12] -= 1;
														}
														paramArrayOfInt[11] -= 1;
													}
													paramArrayOfInt[10] -= 1;
												}
												paramArrayOfInt[9] -= 1;
											}
											paramArrayOfInt[8] -= 1;
										}
										paramArrayOfInt[7] -= 1;
									}
									paramArrayOfInt[6] -= 1;
								}
								paramArrayOfInt[5] -= 1;
							}
							paramArrayOfInt[4] -= 1;
						}
						paramArrayOfInt[3] -= 1;
					}
					paramArrayOfInt[2] -= 1;
				}
				paramArrayOfInt[1] -= 1;
			}
			paramArrayOfInt[0] -= 1;
		}
		return false;
	}

	private static boolean b(String paramString1, String paramString2, int[] paramArrayOfInt, BigInteger paramBigInteger){
	    Arrays.fill(paramArrayOfInt, 1);
	    if (c(paramString1, paramString2, paramArrayOfInt, paramBigInteger))
	      return true;
	    Arrays.fill(paramArrayOfInt, 0);
	    paramArrayOfInt[0] = 1;
	    paramArrayOfInt[1] = 1;
	    if (c(paramString1, paramString2, paramArrayOfInt, paramBigInteger))
	      return true;
	    paramArrayOfInt[2] = 1;
	    paramArrayOfInt[3] = 1;
	    paramArrayOfInt[4] = 1;
	    if (c(paramString1, paramString2, paramArrayOfInt, paramBigInteger))
	      return true;
	    for (int i1 = 0; i1 < paramArrayOfInt.length; i1++){
	      Arrays.fill(paramArrayOfInt, 0);
	      paramArrayOfInt[i1] = 1;
	      if (c(paramString1, paramString2, paramArrayOfInt, paramBigInteger))
	        return true;
	    }
	    Arrays.fill(paramArrayOfInt, 0);
	    paramArrayOfInt[2] = 1;
	    paramArrayOfInt[6] = 1;
	    return c(paramString1, paramString2, paramArrayOfInt, paramBigInteger);
	  }

	  private static boolean c(String paramString1, String paramString2, int[] paramArrayOfInt, BigInteger paramBigInteger){
	    String str = getProductName(paramArrayOfInt);
	    int i1 = d(getProductName(paramString1, paramString2, str));
	    if (paramBigInteger.equals(new BigInteger(new StringBuilder().append("").append(i1).toString()))){
	      h |= getProductName(str);
	      i = paramString1;
	      j = paramString2;
	      if (logger.isLoggable(Level.FINE))
	    	  logger.fine(new StringBuilder().append("Verified: ").append(h).toString());
	      return true;
	    }
	    return false;
	  }
	  
	/**
	 * Clears the license information.
	 */
	public static void clearLicense() {
		if (!n){
			if (logger.isLoggable(Level.FINE)){
				logger.fine("License key is cleared");
			}
		}
		h = 0;
	}
	
	private static BigInteger b(String paramString) {
		BigInteger localBigInteger = BigInteger.ZERO;
		for (int i = paramString.length() - 1; i >= 0; i--) {
			int i2 = paramString.charAt(i);
			int i3;
			if ((48 <= i2) && (i2 <= 57)) {
				i3 = i2 - 48;
			} else if ((65 <= i2) && (i2 <= 90)) {
				i3 = i2 - 65 + 10;
			} else if ((97 <= i2) && (i2 <= 122)) {
				i3 = i2 - 97 + 36;
			} else if (i2 == 46) {
				i3 = 62;
			} else if (i2 == 58) {
				i3 = 63;
			} else {
				System.err.println(new StringBuilder().append("incorrect char:").append(i2).toString());
				continue;
			}
			localBigInteger = localBigInteger.shiftLeft(6);
			localBigInteger = localBigInteger.add(BigInteger.valueOf(i3));
		}
		return localBigInteger;
	}
	
	private static int c(String paramString) {
		int i1 = 1976;
		for (int i2 = 0; i2 < paramString.length(); i2++) {
			i1 += paramString.charAt(i2);
			i1 += 666;
			i1 ^= 30869;
		}
		return i1;
	}

	private static int d(String paramString) {
		int i1 = 1979;
		for (int i2 = 0; i2 < paramString.length(); i2++) {
			i1 += paramString.charAt(i2);
			i1 += 88888;
			i1 ^= 3232379;
		}
		return i1;
	}

	/**
	 * Sets a parent frame for any message boxes from this class. You don't need
	 * to call it in your application.
	 * 
	 * @param parent
	 *            the parent
	 */
	public static void setParent(JFrame parents) {
	     parent = parents;
	}
	
	private static void initalFrame(Object paramObject, String paramString, int paramInt) {
		initalFrame(paramObject, paramString, paramInt, null);
	}
	
	private static void initalFrame(Object paramObject, String paramString1, int paramInt, String paramString2){
	    Object localObject;
	    if (parent == null){
	      localObject = new JFrame("JIDE Software, Inc.");
	      ((JFrame)localObject).setIconImage(JideIconsFactory.getImageIcon("jide/jide32.png").getImage());
	      ((JFrame)localObject).setLocation(0, 2147483647);
	      ((JFrame)localObject).pack();
	      ((JFrame)localObject).setVisible(true);
	      PortingUtils.notifyUser();
	      ((JFrame)localObject).toFront();
	      b_ localb_ = new b_((Frame)localObject, paramString1, paramObject.toString(), paramInt, paramString2);
	      localb_.display(false);
	      ((JFrame)localObject).setVisible(false);
	      ((JFrame)localObject).dispose();
	    }else{
	      localObject = new b_(parent, paramString1, paramObject.toString(), paramInt, paramString2);
	      ((b_)localObject).display(false);
	    }
	  }

	public static void showPopupMessageBox(String message) {
		 PopupWindow localPopupWindow = new PopupWindow(parent);
		 JLabel localJLabel = new JLabel();
		 localJLabel.setBackground(UIDefaultsLookup.getColor("ContentContainer.background"));
		 localJLabel.setForeground(Color.black);
		 localJLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		 localJLabel.setText(message);
		 localPopupWindow.add(localJLabel);
		 localPopupWindow.show(parent, 100, 200);
	}

	private static void inital(){
	    StringBuffer localStringBuffer = new StringBuffer();
	    localStringBuffer.append("This is a demo version for evaluation purpose only.<BR><BR>");
	    localStringBuffer.append("JIDE Version: ").append("3.7.5");
	    localStringBuffer.append("<BR>");
	    localStringBuffer.append("JDK Version: ").append(SystemInfo.getJavaVersion());
	    localStringBuffer.append("<BR>");
	    localStringBuffer.append("JDK Vendor: ").append(SystemInfo.getJavaVendor());
	    localStringBuffer.append("<BR>");
	    localStringBuffer.append("Java Class Version: ").append(SystemInfo.getJavaClassVerion());
	    localStringBuffer.append("<BR>");
	    localStringBuffer.append("Platform: ").append(SystemInfo.getOS());
	    localStringBuffer.append("<BR>");
	    localStringBuffer.append("Platform Version: ").append(SystemInfo.getOSVersion());
	    localStringBuffer.append("<BR>");
	    localStringBuffer.append("Platform Architecture: ").append(SystemInfo.getOSArchitecture());
	    localStringBuffer.append("<BR>");
	    String str = localStringBuffer.toString();
	    str = str.replaceAll("<BR>", "\n");
	    System.out.println(str);
	    initalFrame(new StringBuilder().append("<HTML>").append(localStringBuffer).append("</HTML>").toString(), "JIDE Products - System Information", -1);
	  }
	
	
	public static void main(String[] args) {
		inital();
	}

	public static void getUIError(String componentName) {
		initalFrame(new StringBuilder().append("<HTML><B>Missing value in LookAndFeel's UIDefaults</B>. <BR><BR><HR><BR>Component \"<B>").append(componentName).append("</B>\" requires its own ComponentUI and additional values in LookAndFeel's UIDefaults.<BR>Please make sure you call LookAndFeelFactory.installJideExtension() whenever you switch L&F.").append("<BR>For more details, please refer to Developer Guides or visit JIDE Developer's Forum (http://www.jidesoft.com/forum).\n").toString(), "LookAndFeel Error", -1, "  Exit  ");
	    System.exit(-1);
	}
	
	static {
		e.set(2019, 1, 22, 0, 0, 0);
	}
	
	private static class a_ extends JDialog{
	    private boolean a = false;
	    private b_ b = new b_(this);

	    public a_() throws HeadlessException {
	      this(null, "", true);
	    }

	    public a_(Frame paramFrame)throws HeadlessException {
	      this(paramFrame, "", true);
	    }

	    public a_(Frame paramFrame, String paramString) throws HeadlessException {
	      this(paramFrame, paramString, true);
	    }

	    public a_(Frame paramFrame, boolean paramBoolean)throws HeadlessException{
	      this(paramFrame, "", paramBoolean);
	    }

	    public a_(Frame paramFrame, String paramString, boolean paramBoolean){
	      //super(paramString, paramBoolean);
	      getRootPane().registerKeyboardAction(this.b, KeyStroke.getKeyStroke(27, 0), 1);
	    }

	    public final boolean getResult(){
	      return this.a;
	    }

	    public final void setResult(boolean paramBoolean){
	      this.a = paramBoolean;
	    }

	    public void display(boolean paramBoolean){
	      a(getRootPane());
	      pack();
	      setResizable(paramBoolean);
	      JideSwingUtilities.globalCenterWindow(this);
	      setVisible(true);
	    }

	    private void a(Component paramComponent){
	      if ((paramComponent instanceof JButton))
	        paramComponent.addFocusListener(new FocusAdapter(){
	          public void focusGained(FocusEvent paramAnonymousFocusEvent){
	            Lm.a_.this.getRootPane().setDefaultButton((JButton)paramAnonymousFocusEvent.getSource());
	          }
	        });
	      Component[] arrayOfComponent = null;
//	      if ((paramComponent instanceof JMenu))
//	        arrayOfComponent = ((JMenu)paramComponent).getMenuComponents();
//	      else if ((paramComponent instanceof Container))
//	        arrayOfComponent = ((Container)paramComponent).getComponents();
//	      if (arrayOfComponent != null)
//	        for (int i = 0; i < arrayOfComponent.length; i++)
//	          a(arrayOfComponent[i]);
	    }

	    public void display(){
	      display(false);
	    }

	    public AbstractAction getDefaultCancelAction(){
	      return this.b;
	    }

	    private class b_ extends AbstractAction {
	      private JDialog dialog;

	      protected b_(JDialog dialog){
	        super();
	        Object localObject;
	        //this.a = localObject;
	      }

	      public void actionPerformed(ActionEvent paramActionEvent){
	        Lm.a_.this.a = false;
	        this.dialog.setVisible(false);
	      }
	    }
	  }
	
	private static class b_ extends Lm.a_{
	    private String c;
	    private int d;
	    private String e;

		public b_(Frame paramFrame, String paramString1, String paramString2) throws HeadlessException{
	      this(paramFrame, paramString1, paramString2, -1, null);
	    }

	    public b_(Frame paramFrame, String paramString1, String paramString2, int paramInt) throws HeadlessException
	    {
	      this(paramFrame, paramString1, paramString2, paramInt, null);
	    }

	    public b_(Frame paramFrame, String paramString1, String paramString2, int paramInt, String paramString3) throws HeadlessException {
	      //super(paramString1, true);
	      this.c = paramString2;
	      this.d = paramInt;
	      this.e = paramString3;
	      a();
	    }

	    private void a(){
	      JPanel localJPanel1 = new JPanel(new BorderLayout(6, 6));
	      JButton localJButton = new JButton(getDefaultCancelAction());
	      getRootPane().setDefaultButton(localJButton);
	      if (this.e != null)
	        localJButton.setText(this.e);
	      localJPanel1.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
	      JLabel localJLabel1 = new JLabel(this.c);
	      JPanel localJPanel2 = new JPanel(new BorderLayout(12, 12));
	      JLabel localJLabel2;
	      switch (this.d){
	      case 2:
	        localJLabel2 = new JLabel(UIDefaultsLookup.getIcon("OptionPane.warningIcon"));
	        break;
	      case 0:
	        localJLabel2 = new JLabel(UIDefaultsLookup.getIcon("OptionPane.errorIcon"));
	        break;
	      case 1:
	        localJLabel2 = new JLabel(UIDefaultsLookup.getIcon("OptionPane.informationIcon"));
	        break;
	      case 3:
	        localJLabel2 = new JLabel(UIDefaultsLookup.getIcon("OptionPane.questionIcon"));
	        break;
	      default:
	        localJLabel2 = new JLabel(JideIconsFactory.getImageIcon("jide/jide_logo.png"));
	      }
	      localJPanel2.add(JideSwingUtilities.createTopPanel(localJLabel2), "Before");
	      localJPanel2.add(localJLabel1, "Center");
	      localJPanel1.add(localJPanel2, "Center");
	      localJPanel1.add(JideSwingUtilities.createCenterPanel(localJButton), "Last");
	      getContentPane().add(localJPanel1);
	    }
	  }
}
