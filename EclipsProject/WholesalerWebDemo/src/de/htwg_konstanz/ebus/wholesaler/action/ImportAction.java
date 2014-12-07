package de.htwg_konstanz.ebus.wholesaler.action;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.*;

import de.htwg_konstanz.ebus.framework.wholesaler.api.security.Security;
import de.htwg_konstanz.ebus.wholesaler.demo.ControllerServlet;
import de.htwg_konstanz.ebus.wholesaler.demo.IAction;
import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;
import de.htwg_konstanz.ebus.wholesaler.demo.util.Constants;
import de.htwg_konstanz.ebus.wholesaler.main.Import;




public class ImportAction implements IAction {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, ArrayList<String> errorList) {
		
		LoginBean loginBean = (LoginBean) request.getSession(true).getAttribute(Constants.PARAM_LOGIN_BEAN);
		if (loginBean != null && loginBean.isLoggedIn()) {
			if(Security.getInstance().isUserAllowed(loginBean.getUser(), Security.RESOURCE_ALL, Security.ACTION_READ)){
				
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				ServletContext servletContext = request.getSession().getServletContext();
				File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(repository);
				
				
				
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				try {
					List<FileItem> items = upload.parseRequest(request);
					for(FileItem item : items){
						if(item.isFormField()==false){
							
							InputStream filecontent = item.getInputStream();
							
							try {
								errorList.add(new Import().uploadFile(filecontent));
								
								filecontent.close();
							} catch (ParserConfigurationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "importAction.jsp";
			}else{
				errorList.add("Your are not allowed to perform this action");
				// redirect to the welcome page
				return "welcome.jsp";
			}
		}
		
		// redirect to the login page
		return "login.jsp";
	}

	
	@Override
	public boolean accepts(String actionName) {
		return actionName.equalsIgnoreCase(Constants.IMPORT);
	}

}
