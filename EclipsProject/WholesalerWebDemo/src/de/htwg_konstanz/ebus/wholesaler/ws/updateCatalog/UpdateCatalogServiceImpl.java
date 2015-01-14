package de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog;

import java.util.logging.Logger;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier;

import javax.jws.WebService;

@javax.jws.WebService(endpointInterface = "de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog.UpdateCatalog")
public class UpdateCatalogServiceImpl implements UpdateCatalog {
	
	private final ObjectFactory factory = new ObjectFactory();
	private final ProductBOA productBOA = ProductBOA.getInstance();
	
	private final String CLASS_NAME = getClass().getName();
	private final Logger log = Logger.getLogger(CLASS_NAME);
	@Override
	public UpdateResponseType updateCatalog(de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog.UpdateRequestType requestPart)
			throws AuthentificationMessage {
		log.entering(CLASS_NAME, "updateCatalog");
		String retUpdate = "";
		String retNoUpdate = "";
		int changedProduct = 0;
		int sameProuct =0;
		UpdateResponseType response = factory.createUpdateResponseType();
		ListOfProductsType listProducts = requestPart.getListOfProducts();
		
		ListOfUnavailableProductsType listOfUnavailableProducts = factory.createListOfUnavailableProductsType();
		ListOfUpdatedProductsType listOfUpdatedProducts = factory.createListOfUpdatedProductsType();
		
		for(SupplierProductType productSupplier : listProducts.getSupplierProduct()){
			BOProduct product = productBOA.findByOrderNumberSupplier(productSupplier.getSupplierAID());
			if(product!=null){
				boolean hasLongDescriptionChanged = false;
				hasLongDescriptionChanged = productSupplier.getLongDescription().equals(product.getLongDescription());
				boolean hasShortDescriptionChanged = false;
				hasShortDescriptionChanged = productSupplier.getShortDescription().equals(product.getShortDescription());
				if((hasLongDescriptionChanged ||hasShortDescriptionChanged)){
					listOfUpdatedProducts.setChangedProducts(productSupplier);
				}else{
					//Beschreibung ist gleich
					retUpdate="LongDescription or ShortDescription not changed :" + changedProduct++;
				}
				
			}else{
				retNoUpdate="set supplier product to unvisible product: "+sameProuct++;
				listOfUnavailableProducts.setSupplierProduct(productSupplier);
				
			}
		}
		response.setListOfUnavaiableProducts(listOfUnavailableProducts);
		response.setListOfUpdatedProducts(listOfUpdatedProducts);
		log.warning(retUpdate+ " | " +retNoUpdate);
		
		log.exiting(CLASS_NAME, "importArticles");
		return null;
	}
}
