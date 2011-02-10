package com.jidesoft.swing;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public interface LayoutPersistence {
	void setProfileKey(String paramString);

	short getVersion();

	void setVersion(short paramShort);

	void setUsePref(boolean paramBoolean);

	List<String> getAvailableLayouts();

	boolean isLayoutAvailable(String paramString);

	void removeLayout(String paramString);

	void loadLayoutData();

	void loadLayoutDataFrom(String paramString);

	boolean isLayoutDataVersionValid(String paramString);

	void loadLayoutDataFromFile(String paramString);

	boolean loadLayoutFrom(InputStream in);

	boolean isLoadDataSuccessful();

	void saveLayoutData();

	void saveLayoutDataAs(String paramString);

	void saveLayoutDataToFile(String paramString);

	void saveLayoutTo(OutputStream paramOutputStream) throws IOException;

	byte[] getLayoutRawData();

	void setLayoutRawData(byte[] paramArrayOfByte);

	String getLayoutDirectory();

	void setLayoutDirectory(String paramString);

	void resetToDefault();

	void setUseFrameState(boolean paramBoolean);

	void setUseFrameBounds(boolean paramBoolean);

	void beginLoadLayoutData();

	boolean isLast();

	void setLast(boolean paramBoolean);

	void loadInitialLayout(String paramString) throws ParserConfigurationException, SAXException, IOException;

	void loadInitialLayout(InputStream paramInputStream) throws ParserConfigurationException, SAXException, IOException;

	void loadInitialLayout(Document paramDocument);
}