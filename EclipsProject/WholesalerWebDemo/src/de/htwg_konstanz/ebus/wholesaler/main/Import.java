package de.htwg_konstanz.ebus.wholesaler.main;
	import java.io.File;
	import java.io.IOException;
	import java.io.InputStream;
	import java.math.BigDecimal;
	import java.util.HashSet;
	import java.util.List;
	import java.util.logging.ConsoleHandler;
	import java.util.logging.Handler;
	import java.util.logging.Logger;
	
	import javax.xml.XMLConstants;
	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.validation.Schema;
	import javax.xml.validation.SchemaFactory;
	import javax.xml.validation.Validator;
	
	import org.w3c.dom.NamedNodeMap;
	import org.w3c.dom.Node;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;
	
	import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCountry;
	import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
	import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOPurchasePrice;
	import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSalesPrice;
	import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
	import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CountryBOA;
	import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.PriceBOA;
	import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
	import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;


public class Import {
	private final String CLASS_NAME = getClass().getName();
	private final Logger log = Logger.getLogger(CLASS_NAME);
	private final Handler handler = new ConsoleHandler();
	
	public Import() {
		log.addHandler(handler);
	}
	
	public String uploadFile(InputStream file) throws ParserConfigurationException{
		String ret = "";
		org.w3c.dom.Document document = this.createDocument(file);
		
		
		
		return ret;
	}
	
	
	public org.w3c.dom.Document createDocument(InputStream file) throws ParserConfigurationException{
		org.w3c.dom.Document document = null;
		DocumentBuilder docBuild;
		DocumentBuilderFactory docBuildFac = DocumentBuilderFactory.newInstance();
		docBuildFac.setNamespaceAware(true);
		docBuildFac.setIgnoringElementContentWhitespace(true);
		docBuildFac.setValidating(true);
		
		docBuild=docBuildFac.newDocumentBuilder();
		try {
			document = docBuild.parse(file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return document;
	}
	
	public boolean validateDocument(org.w3c.dom.Document doc) throws SAXException{
		boolean ret = false;
		SchemaFactory schemaFac = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema bmeCatSchema = null;
		Validator valid = null;
		
		bmeCatSchema = schemaFac.newSchema(new File(""));
		
		return ret;
	}
	

}
