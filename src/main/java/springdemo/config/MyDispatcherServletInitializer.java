package springdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	/**
	 * No root config classes
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * This is where I find the configuration classes used
	 * in the app
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{DemoAppConfig.class};
	}

	/**
	 * Root path for the web app
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

}
