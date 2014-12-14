package de.htwg_konstanz.ebus.wholesaler.action;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants.ExportFormat;
import de.htwg_konstanz.ebus.wholesaler.main.ExportHandler;

public class ExportAction implements IAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ArrayList<String> errorList) {
		String nextPage = "export.jsp";

		// ----- Check if User is logged in correctly + check if user is allowed to use action ----- //
		
		//Gets the LoginBean from the Session
		LoginBean loginBean = (LoginBean) request.getSession().getAttribute(Constants.PARAM_LOGIN_BEAN);
		
		//Check if user is logged in correctly
		if (loginBean.isLoggedIn() && loginBean != null) {
			//Used for export with search Words
			String shortDescription = request.getParameter(Constants.PARAM_SEARCH_STRING);
			System.out.println(shortDescription + " ExportAction Zeile 30");
			//Get fileType
			ExportFormat fileType = Constants.ExportFormat.getExportFormat(request.getParameter(Constants.PARAM_FILE_TYPE));

			//Create ExportHandler and start Export
			ExportHandler exportHandler = new ExportHandler(shortDescription, fileType);
			File exportFile = exportHandler.export();

			request.getSession(true).setAttribute("exportfile", exportFile);
	
		} else {		
			//if user is not logged in correctly redirect to loginPage
			errorList.add("Please log in first!");
			nextPage = "login.jsp";
		}
		
		//if User is logged in correct he is allowed to export something
		return nextPage;
	}

	@Override
	public boolean accepts(String actionName) {
		return actionName.equalsIgnoreCase(Constants.ACTION_DOWNLOAD_CATALOG);
	}

}
