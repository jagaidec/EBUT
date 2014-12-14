package de.htwg_konstanz.ebus.wholesaler.action;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;
import de.htwg_konstanz.ebus.wholesaler.demo.util.ExportFormat;
import de.htwg_konstanz.ebus.wholesaler.main.Exporter;

public class ExportAction implements IAction {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, ArrayList<String> errorList) {
		String page = "export.jsp";
		LoginBean login = (LoginBean) request.getSession().getAttribute(
				Constants.PARAM_LOGIN_BEAN);
		if (login.isLoggedIn() && login != null) {
			String description = request.getParameter(Constants.SEARCH_STRING);
			ExportFormat exportFormat = ExportFormat.getExportFormat(request.getParameter(Constants.FILE_TYPE));
			
			Exporter exporter = new Exporter(description, exportFormat);
			File exportFile = exporter.export();
			
			request.getSession(true).setAttribute("exportfile", exportFile);
			
		} else {
			errorList.add("Please log in!");
			page = "login.jsp";
		}

		return page;
	}

	@Override
	public boolean accepts(String actionName) {
		return actionName.equalsIgnoreCase(Constants.EXPORT);
	}

}
