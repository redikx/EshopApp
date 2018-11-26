package org.redik.EshopApp.config;

import org.redik.EshopApp.config.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitilializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class[] {AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] {"/"};
    }
    
}
