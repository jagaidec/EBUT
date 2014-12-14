package de.htwg_konstanz.ebus.wholesaler.demo.util;

public enum ExportFormat {
	
	bmecat, xhtml;
	
	public static ExportFormat getExportFormat(String value){
		return ExportFormat.valueOf(value.toLowerCase());
	}

}
