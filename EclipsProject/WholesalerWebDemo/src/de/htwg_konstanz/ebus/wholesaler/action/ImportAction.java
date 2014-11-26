package de.htwg_konstanz.ebus.wholesaler.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;

public class ImportAction implements IAction {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, ArrayList<String> errorList) {
		
		LoginBean loginBean = (LoginBean) request.getSession(true).getAttribute(Constants.PARAM_LOGIN_BEAN);
		
		
		
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart==true){
			
		
		}
		return "importAction.jsp";
	}

	
	@Override
	public boolean accepts(String actionName) {
		return actionName.equalsIgnoreCase(Constants.IMPORT);
	}

}
