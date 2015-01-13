
package de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Request_QNAME = new QName("http://www.example.org/updateCatalog/", "request");
    private final static QName _Authentification_QNAME = new QName("http://www.example.org/updateCatalog/", "authentification");
    private final static QName _Response_QNAME = new QName("http://www.example.org/updateCatalog/", "response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateRequestType }
     * 
     */
    public UpdateRequestType createUpdateRequestType() {
        return new UpdateRequestType();
    }

    /**
     * Create an instance of {@link UpdateResponseType }
     * 
     */
    public UpdateResponseType createUpdateResponseType() {
        return new UpdateResponseType();
    }

    /**
     * Create an instance of {@link SupplierProductType }
     * 
     */
    public SupplierProductType createSupplierProductType() {
        return new SupplierProductType();
    }

    /**
     * Create an instance of {@link ListOfUnavailableProductsType }
     * 
     */
    public ListOfUnavailableProductsType createListOfUnavailableProductsType() {
        return new ListOfUnavailableProductsType();
    }

    /**
     * Create an instance of {@link ListOfUpdatedProductsType }
     * 
     */
    public ListOfUpdatedProductsType createListOfUpdatedProductsType() {
        return new ListOfUpdatedProductsType();
    }

    /**
     * Create an instance of {@link PriceType }
     * 
     */
    public PriceType createPriceType() {
        return new PriceType();
    }

    /**
     * Create an instance of {@link AuthenticationType }
     * 
     */
    public AuthenticationType createAuthenticationType() {
        return new AuthenticationType();
    }

    /**
     * Create an instance of {@link ListOfProductsType }
     * 
     */
    public ListOfProductsType createListOfProductsType() {
        return new ListOfProductsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/updateCatalog/", name = "request")
    public JAXBElement<UpdateRequestType> createRequest(UpdateRequestType value) {
        return new JAXBElement<UpdateRequestType>(_Request_QNAME, UpdateRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/updateCatalog/", name = "authentification")
    public JAXBElement<String> createAuthentification(String value) {
        return new JAXBElement<String>(_Authentification_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/updateCatalog/", name = "response")
    public JAXBElement<UpdateResponseType> createResponse(UpdateResponseType value) {
        return new JAXBElement<UpdateResponseType>(_Response_QNAME, UpdateResponseType.class, null, value);
    }

}
