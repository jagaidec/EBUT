
package de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für updateResponseType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="updateResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updateDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="listOfUpdatedProducts" type="{http://www.example.org/updateCatalog/}listOfUpdatedProductsType"/>
 *         &lt;element name="listOfUnavaiableProducts" type="{http://www.example.org/updateCatalog/}listOfUnavailableProductsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateResponseType", propOrder = {
    "updateDate",
    "listOfUpdatedProducts",
    "listOfUnavaiableProducts"
})
public class UpdateResponseType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar updateDate;
    @XmlElement(required = true)
    protected ListOfUpdatedProductsType listOfUpdatedProducts;
    @XmlElement(required = true)
    protected ListOfUnavailableProductsType listOfUnavaiableProducts;

    /**
     * Ruft den Wert der updateDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateDate() {
        return updateDate;
    }

    /**
     * Legt den Wert der updateDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdateDate(XMLGregorianCalendar value) {
        this.updateDate = value;
    }

    /**
     * Ruft den Wert der listOfUpdatedProducts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ListOfUpdatedProductsType }
     *     
     */
    public ListOfUpdatedProductsType getListOfUpdatedProducts() {
        return listOfUpdatedProducts;
    }

    /**
     * Legt den Wert der listOfUpdatedProducts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfUpdatedProductsType }
     *     
     */
    public void setListOfUpdatedProducts(ListOfUpdatedProductsType value) {
        this.listOfUpdatedProducts = value;
    }

    /**
     * Ruft den Wert der listOfUnavaiableProducts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ListOfUnavailableProductsType }
     *     
     */
    public ListOfUnavailableProductsType getListOfUnavaiableProducts() {
        return listOfUnavaiableProducts;
    }

    /**
     * Legt den Wert der listOfUnavaiableProducts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfUnavailableProductsType }
     *     
     */
    public void setListOfUnavaiableProducts(ListOfUnavailableProductsType value) {
        this.listOfUnavaiableProducts = value;
    }

}
