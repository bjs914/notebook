package com.tj.bjs.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends
	AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
				RootApplicationContextConfig.class };
	} 
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
	return new Class[] { WebApplicationContextConfig.class };
	}
	
	@Override
	protected String[] getServletMappings() {
	return new String[] { "/" };
	}
	
	@Override	//한글인코딩방법
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        
        return new Filter[] { characterEncodingFilter };
    }
}
