package de.coderebell.pfosb;

/**
 * Main Class to run the App
 * Created by MALPI on 14.04.2015.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class PfosbStarter {



        public static void main(String [] args){
            SpringApplication.run(FangbuchStarter.class, args);
        }

        @Override
        protected SpringApplicationBuilder configure(
                SpringApplicationBuilder application) {
            return application.sources(new Class[]{
                    FangbuchStarter.class, Initializer.class
            });
        }

        @Bean
        public ServletRegistrationBean servletRegistrationBean() {
            FacesServlet servlet = new FacesServlet();
            ServletRegistrationBean servletRegistrationBean
                    = new ServletRegistrationBean(servlet, "*.jsf");
            return servletRegistrationBean;
        }

    }

}
