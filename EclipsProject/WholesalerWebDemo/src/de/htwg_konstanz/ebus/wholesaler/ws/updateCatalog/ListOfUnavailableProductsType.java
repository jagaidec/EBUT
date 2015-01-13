
package de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für listOfUnavailableProductsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="listOfUnavailableProductsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="supplierProduct" type="{http://www.example.org/updateCatalog/}supplierProductType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listOfUnavailableProductsType", propOrder = {
    "supplierProduct"
})
public class ListOfUnavailableProductsType {

    @XmlElement(required = true)
    protected SupplierProductType supplierProduct;

    /**
     * Ruft den Wert der supplierProduct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplierProductType }
     *     
     */
    public SupplierProductType getSupplierProduct() {
        return supplierProduct;
    }

    /**
     * Legt den Wert der supplierProduct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierProductType }
     *     
     */
    public void setSupplierProduct(SupplierProductType value) {
        this.supplierProduct = value;
    }

}
