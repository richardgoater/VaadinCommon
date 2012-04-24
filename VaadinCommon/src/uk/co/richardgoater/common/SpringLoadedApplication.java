package uk.co.richardgoater.common;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.WebApplicationContext;

public class SpringLoadedApplication extends Application {
	
	private static final long serialVersionUID = 7947600650336344230L;

	private ApplicationContext getSpringContext() {
		ServletContext servletContext = ((WebApplicationContext) this
				.getContext()).getHttpSession().getServletContext();
		return (ApplicationContext) WebApplicationContextUtils
			.getRequiredWebApplicationContext(servletContext);
	}
	
	private ApplicationContext context;	
	AppParams appParams;	
	String theme = null;
	
	@Override
	public void init() {
		context = getSpringContext();
		appParams = (AppParams) context.getBean("AppParams");
		setTheme(appParams.getTheme());		
	}
}
