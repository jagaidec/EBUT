package de.htwg_konstanz.ebus.wholesaler.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

public class UpdaterSelectSupplierAction implements IAction {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, ArrayList<String> errorList) {
		// TODO Auto-generated method stub
		return "updaterSelectSupplier.jsp";
	}

	@Override
	public boolean accepts(String actionName) {
		// TODO Auto-generated method stub
		return actionName.equalsIgnoreCase(Constants.ACTION_UpdaterSelectSupplier);
	}

}
