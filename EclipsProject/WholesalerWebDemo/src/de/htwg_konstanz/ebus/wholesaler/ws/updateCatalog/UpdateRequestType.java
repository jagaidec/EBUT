
package de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für updateRequestType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="updateRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{http://www.example.org/updateCatalog/}authenticationType"/>
 *         &lt;element name="listOfProducts" type="{http://www.example.org/updateCatalog/}listOfProductsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateRequestType", propOrder = {
    "authentication",
    "listOfProducts"
})
public class UpdateRequestType {

    @XmlElement(required = true)
    protected AuthenticationType authentication;
    @XmlElement(required = true)
    protected ListOfProductsType listOfProducts;

    /**
     * Ruft den Wert der authentication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationType }
     *     
     */
    public AuthenticationType getAuthentication() {
        return authentication;
    }

    /**
     * Legt den Wert der authentication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationType }
     *     
     */
    public void setAuthentication(AuthenticationType value) {
        this.authentication = value;
    }

    /**
     * Ruft den Wert der listOfProducts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ListOfProductsType }
     *     
     */
    public ListOfProductsType getListOfProducts() {
        return listOfProducts;
    }

    /**
     * Legt den Wert der listOfProducts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfProductsType }
     *     
     */
    public void setListOfProducts(ListOfProductsType value) {
        this.listOfProducts = value;
    }

}
