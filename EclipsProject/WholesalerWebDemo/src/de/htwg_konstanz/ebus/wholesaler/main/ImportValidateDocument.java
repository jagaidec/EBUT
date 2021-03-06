package de.htwg_konstanz.ebus.wholesaler.main;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import de.htwg_konstanz.ebus.wholesaler.exceptions.DocumentNotValidException;

public class ImportValidateDocument {

	private final String CLASS_NAME = getClass().getName();
	private final Logger log = Logger.getLogger(CLASS_NAME);
	
	public boolean Fuc_ImportValidateDocument(org.w3c.dom.Document document) throws DocumentNotValidException{
		return validateDoc(document);
	}
	
	
	private boolean validateDoc(org.w3c.dom.Document document)throws DocumentNotValidException {
		
		log.entering(CLASS_NAME, "validateDoc");
		boolean ret = false;
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema bmeCatSchema = null;
		Validator validator = null;

		try {
			
			bmeCatSchema = schemaFactory
					.newSchema(new File(
							"C:/bmecat_new_catalog_1_2_simple_without_NS.xsd"));
			validator = bmeCatSchema.newValidator();
		} catch (SAXException e) {
			log.warning("No Schema found!");
			e.printStackTrace();
		}

		try {
			validator.validate(new DOMSource(document));
			ret = true;
		} catch (NullPointerException e) {
			log.warning("Source is null!");
			throw new DocumentNotValidException("Source is null!");
		} catch (SAXException e) {
			log.warning("Document is not valid!");
			throw new DocumentNotValidException("Document is not valid!");
		} catch (IOException e) {
			log.warning("Document is not valid!");
			throw new DocumentNotValidException("Document is not valid!");
		}
		log.exiting(CLASS_NAME, "validateDoc");
		return ret;
	}


}
