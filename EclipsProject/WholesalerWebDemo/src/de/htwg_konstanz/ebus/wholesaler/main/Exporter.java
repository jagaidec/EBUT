package de.htwg_konstanz.ebus.wholesaler.main;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;
import de.htwg_konstanz.ebus.wholesaler.demo.util.ExportFormat;

public class Exporter {

	private final ExportFormat format;
	private final Properties properties;
	private final ProductBOA productBOA = ProductBOA.getInstance();
	private final DocumentBuilderFactory documentFactory = DocumentBuilderFactory
			.newInstance();

	private final TransformerFactory transformerFactory = TransformerFactory
			.newInstance();
	private Transformer bmecat;
	private Transformer xhtml;
	private List<BOProduct> boProduct;

	public Exporter(String description, ExportFormat format) {
		this.format = format;
		properties = new Properties();

		if (!description.equalsIgnoreCase("") || !description.equals(null)) {
			boProduct = productBOA.findByCriteria(Constants.SEARCH_STRING, "%"
					+ description + "%");
		} else {
			boProduct = productBOA.findAll();
		}

		try {
			if (format.equals("bmecat")) {
				bmecat = transformerFactory.newTransformer();
			} else if (format.equals("xhtml")) {
				bmecat = transformerFactory.newTransformer(new Source(
						Constants.Path_BMECAT_PK));
				xhtml = transformerFactory.newTransformer(new StreamSource(
						Constants.Path_XHTML));
				xhtml.setOutputProperties(properties);
			} else {
				break;
			}

			bmecat.setOutputProperties(properties);
		} catch (TransformerConfigurationException exp) {
			exp.printStackTrace();
		}
	}

	public File export() {
		Document document = createBMECatDocument();
		File result = null;

		switch (format) {
		case bmecat:
			result = createBMECatFile(document);
			break;
		case xhtml:
			File produktCatalog = documentAsProductCatalog(document);
			result = produktCatalogHtml(documentFactory.newDocumentBuilder().parse(produktCatalog));
			break;
		default:
			break;
		}

		return result;

	}

	private Document createBMECatDocument() throws ParserConfigurationException {
		DocumentBuilder documentBuilder;
		Document document = null;
		
		documentBuilder = documentFactory.newDocumentBuilder();
		document = documentBuilder.newDocument();
		
		Element rootElement = document.createElement(Constants.ELEMENT_BMECAT);
		document.appendChild(rootElement);
		rootElement.setAttribute("version", "1.2");
		rootElement.setAttribute("xmlns:xsi",
				"http://www.w3.org/2001/XMLSchema-instance");
		
		rootElement.appendChild(createHeader(document));
		rootElement.appendChild(createBody(document));
		
		return document;		
		
	}
}
