package de.htwg_konstanz.ebus.wholesaler.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ImportW3CDocuments {
	private final String CLASS_NAME = getClass().getName();
	private final Logger log = Logger.getLogger(CLASS_NAME);
	
	public org.w3c.dom.Document Fuc_ImportW3CDocuments(InputStream file){
		return createDocumentFromFile(file);
	}
	
	private org.w3c.dom.Document createDocumentFromFile(InputStream file) {
		log.entering(CLASS_NAME, "createDocumentFromFile");
		org.w3c.dom.Document document = null;
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(false);

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			document = db.parse(file);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.exiting(CLASS_NAME, "createDocumentFromFile");
		return document;
	}

}
