package com.jcodeshare.webtemplate.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.jcodeshare.webtemplate.config.SpringConfig;

public class ServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

}

// # Copyright by YP Leung, 2015 Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php 
