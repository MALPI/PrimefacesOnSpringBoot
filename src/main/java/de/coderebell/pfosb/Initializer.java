package de.coderebell.pfosb;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by MALPI on 15.04.2015.
 */
@Configuration
public class Initializer implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
    }
}
