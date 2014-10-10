package org.tarena.dang.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class BaseAction implements SessionAware, ServletRequestAware,
		ServletResponseAware, ServletContextAware {
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public String toRealPath(String FilePath) {
		return application.getRealPath(FilePath);
	}
	public String execute() throws Exception{
		return "success";
	}

}
