package de.htwg_konstanz.ebus.wholesaler.main;

import java.util.List;
import java.util.logging.Logger;

import org.w3c.dom.NodeList;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOSupplier;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.SupplierBOA;

public class ImportSupplier {

	private final String CLASS_NAME = getClass().getName();
	private final Logger log = Logger.getLogger(CLASS_NAME);
	
	
	public BOSupplier getSupplier(org.w3c.dom.Document document){
		return getSuppliers(document);
	}
	
	private BOSupplier getSuppliers(org.w3c.dom.Document document) {
		log.entering(CLASS_NAME, "getSupplier");

		NodeList suppliername = document.getElementsByTagName("SUPPLIER_NAME");
		String documentSupplierCompany = null;
		BOSupplier tempSupplier = null;

		if (suppliername.getLength() == 1) {
			documentSupplierCompany = suppliername.item(0).getTextContent();
		} else {
			log.warning("Unable to reach Supplier Company in Document!");
		}

		List<BOSupplier> suppliers = SupplierBOA.getInstance().findAll();
		for (BOSupplier boSupplier : suppliers) {
			if (documentSupplierCompany.equals(boSupplier.getCompanyname())) {
				tempSupplier = boSupplier;
			}
		}
		log.exiting(CLASS_NAME, "getSupplier");
		return tempSupplier;
	}

}
