package com.fisher.config.basic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by fisbii on 16-12-1.
 */
public class CommonInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("contextConfigLocation","classpath:applicationContext.xml");
        servletContext.setInitParameter("webAppRootKey","springframework.root");
        servletContext.setInitParameter("log4jConfigLocation","classpath:log4j.properties");
        servletContext.setInitParameter("log4jRefreshInterval","3000");
        servletContext.addListener(Log4jConfigListener.class);
    }
}
