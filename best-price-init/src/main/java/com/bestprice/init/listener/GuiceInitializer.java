package com.bestprice.init.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector();

    }
}
