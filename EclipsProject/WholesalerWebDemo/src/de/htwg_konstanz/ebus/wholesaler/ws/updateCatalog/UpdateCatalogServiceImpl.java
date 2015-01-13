package de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.ProductBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.vo.Supplier;

import javax.jws.WebService;

@javax.jws.WebService(endpointInterface = "de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog.UpdateCatalog")
public class UpdateCatalogServiceImpl implements UpdateCatalog {
	private final ObjectFactory factory = new ObjectFactory();
	private final ProductBOA productBOA = ProductBOA.getInstance();

	@Override
	public UpdateResponseType updateCatalog(de.htwg_konstanz.ebus.wholesaler.ws.updateCatalog.UpdateRequestType requestPart)
			throws AuthentificationMessage {
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
				}
				
			}else{
				listOfUnavailableProducts.setSupplierProduct(productSupplier);
				
			}
		}
		return null;
	}
}
