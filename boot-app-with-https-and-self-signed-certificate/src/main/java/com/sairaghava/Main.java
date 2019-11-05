package com.sairaghava;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public ServletWebServerFactory servletContainer() {
    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
      protected void postProcessContext(Context context) {
        SecurityConstraint securityConstraint = new SecurityConstraint();
        securityConstraint.setUserConstraint("CONFIDENTIAL");

        SecurityCollection securityCollection = new SecurityCollection();
        securityCollection.addPattern("/*");

        securityConstraint.addCollection(securityCollection);
        context.addConstraint(securityConstraint);

      }
    };

    // Add http to http redirect
    tomcat.addAdditionalTomcatConnectors(httpsRedirector());
    return tomcat;
  }

  private Connector httpsRedirector() {
    Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
    connector.setScheme("http");
    connector.setPort(8080);
    connector.setSecure(false);
    connector.setRedirectPort(8443);
    return connector;
  }
}
