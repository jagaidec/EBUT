/* ProductListAction.java
***********************************************************************************
* 15.03.2007 ** tdi
* - created
*
***********************************************************************************
* Copyright 2007 HTWG Konstanz
* 
* Prof. Dr.-Ing. Juergen Waesch
* Dipl. -Inf. (FH) Thomas Dietrich
* Fakultaet Informatik - Department of Computer Science
* E-Business Technologien 
* 
* Hochschule Konstanz Technik, Wirtschaft und Gestaltung
* University of Applied Sciences
* Brauneggerstrasse 55
* D-78462 Konstanz
* 
* E-Mail: juergen.waesch(at)htwg-konstanz.de
************************************************************************************/
package de.htwg_konstanz.ebus.wholesaler.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOUserCustomer;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.CustomerBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.OrderBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.boa.UserBOA;
import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

/**
* The ProductListAction loads all available products from the database.<p>
* After loading, the action puts all products into an List-Object and makes them 
* available for the corresponding view (JSP-Page) via the HTTPSession.  
*
* @author tdi
*/
public class OrderListAction implements IAction
{
	public OrderListAction()
	{
		super();
	}

   /**
   * The execute method is automatically called by the dispatching sequence of the {@link ControllerServlet}. 
   * 
   * @param request the HttpServletRequest-Object provided by the servlet engine
   * @param response the HttpServletResponse-Object provided by the servlet engine
   * @param errorList a Stringlist for possible error messages occured in the corresponding action
   * @return the redirection URL
   */
	public String execute(HttpServletRequest request, HttpServletResponse response, ArrayList<String> errorList)
	{
		// get the login bean from the session
		LoginBean loginBean = (LoginBean)request.getSession(true).getAttribute(Constants. PARAM_LOGIN_BEAN);

		// ensure that the user is logged in
		if (loginBean != null && loginBean.isLoggedIn())
		{
			// ensure that the user is allowed to execute this action (authorization)
			// at this time the authorization is not fully implemented.
			// -> use the "Security.RESOURCE_ALL" constant which includes all resources.
			if (Security.getInstance().isUserAllowed(loginBean.getUser(), Security.RESOURCE_ALL, Security.ACTION_READ))
			{
				if(loginBean.getRole() == Constants.USER_CUSTOMER)
				{
					BOUserCustomer boUserCustomer = UserBOA.getInstance().findUserCustomerById(loginBean.getUser().getId()); 
					BOCustomer boCustomer = CustomerBOA.getInstance().findCustomerById(boUserCustomer.getUserCustomer().getCustomer().getCustomerid());
					
					// find all available products and put it to the session
					List<?> orderList = OrderBOA.getInstance().findAllCustomerOrders(boCustomer); 
					request.getSession(true).setAttribute(Constants.PARAM_ORDER_CUSTOMER_LIST, orderList);					

					// redirect to the product page
					return "orders.jsp";
				}
				else if(loginBean.getRole() == Constants.USER_INTERNAL)
				{
					// find all available products and put it to the session
					List<?> orderCustomerList = OrderBOA.getInstance().findAllCustomerOrders(); 
					request.getSession(true).setAttribute(Constants.PARAM_ORDER_CUSTOMER_LIST, orderCustomerList);					
				
					List<?> orderPurchaseList = OrderBOA.getInstance().findAllPurchaseOrders(); 
					request.getSession(true).setAttribute(Constants.PARAM_ORDER_PURCHASE_LIST, orderPurchaseList);					

					// redirect to the product page
					return "orders.jsp";
				}
				else
				{
					// authorization failed -> show error message
					errorList.add("User has to be customer or supplier!");
					
					// redirect to the welcome page
					return "welcome.jsp";
				}
					
			}
			else
			{
				// authorization failed -> show error message
				errorList.add("You are not allowed to perform this action!");
				
				// redirect to the welcome page
				return "welcome.jsp";
			}
		}
		else
			// redirect to the login page
			return "login.jsp";				
	}

   /**
   * Each action itself decides if it is responsible to process the corrensponding request or not.
   * This means that the {@link ControllerServlet} will ask each action by calling this method if it
   * is able to process the incoming action request, or not.
   * 
   * @param actionName the name of the incoming action which should be processed
   * @return true if the action is responsible, else false
   */
	public boolean accepts(String actionName)
	{
		return actionName.equalsIgnoreCase(Constants.ACTION_SHOW_ORDER_LIST);
	}
}
