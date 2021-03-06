
package de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "updateCatalog", targetNamespace = "http://www.example.org/updateCatalog/", wsdlLocation = "http://localhost:8080/WholesalerWebDemo/wsdl/updateCatalog.wsdl")
public class UpdateCatalog_Service
    extends Service
{

    private final static URL UPDATECATALOG_WSDL_LOCATION;
    private final static WebServiceException UPDATECATALOG_EXCEPTION;
    private final static QName UPDATECATALOG_QNAME = new QName("http://www.example.org/updateCatalog/", "updateCatalog");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WholesalerWebDemo/wsdl/updateCatalog.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        UPDATECATALOG_WSDL_LOCATION = url;
        UPDATECATALOG_EXCEPTION = e;
    }

    public UpdateCatalog_Service() {
        super(__getWsdlLocation(), UPDATECATALOG_QNAME);
    }

    public UpdateCatalog_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), UPDATECATALOG_QNAME, features);
    }

    public UpdateCatalog_Service(URL wsdlLocation) {
        super(wsdlLocation, UPDATECATALOG_QNAME);
    }

    public UpdateCatalog_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, UPDATECATALOG_QNAME, features);
    }

    public UpdateCatalog_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UpdateCatalog_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UpdateCatalog
     */
    @WebEndpoint(name = "updateCatalogWebservice")
    public UpdateCatalog getUpdateCatalogWebservice() {
        return super.getPort(new QName("http://www.example.org/updateCatalog/", "updateCatalogWebservice"), UpdateCatalog.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UpdateCatalog
     */
    @WebEndpoint(name = "updateCatalogWebservice")
    public UpdateCatalog getUpdateCatalogWebservice(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.example.org/updateCatalog/", "updateCatalogWebservice"), UpdateCatalog.class, features);
    }

    private static URL __getWsdlLocation() {
        if (UPDATECATALOG_EXCEPTION!= null) {
            throw UPDATECATALOG_EXCEPTION;
        }
        return UPDATECATALOG_WSDL_LOCATION;
    }

}
