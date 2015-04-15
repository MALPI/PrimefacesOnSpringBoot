package de.coderebell.pfosb;

import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.jsf.el.SpringBeanFacesELResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.faces.webapp.FacesServlet;

/**
 * Main Class to run the App
 * Created by MALPI on 14.04.2015.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class PfosbStarter extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(PfosbStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(new Class[]{
                SpringApplication.class,  Initializer.class});
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean
                = new ServletRegistrationBean(servlet, "*.jsf");
        return servletRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(
                new ConfigureListener());
    }

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".xhtml");
        return resolver;
    }

    @Bean
    public SpringBeanFacesELResolver springBeanFacesELResolver(){
        return  new SpringBeanFacesELResolver();
    }
}
