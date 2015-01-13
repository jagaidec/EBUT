
package de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für listOfUpdatedProductsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="listOfUpdatedProductsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changedProducts" type="{http://www.example.org/updateCatalog/}supplierProductType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listOfUpdatedProductsType", propOrder = {
    "changedProducts"
})
public class ListOfUpdatedProductsType {

    @XmlElement(required = true)
    protected SupplierProductType changedProducts;

    /**
     * Ruft den Wert der changedProducts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupplierProductType }
     *     
     */
    public SupplierProductType getChangedProducts() {
        return changedProducts;
    }

    /**
     * Legt den Wert der changedProducts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierProductType }
     *     
     */
    public void setChangedProducts(SupplierProductType value) {
        this.changedProducts = value;
    }

}
