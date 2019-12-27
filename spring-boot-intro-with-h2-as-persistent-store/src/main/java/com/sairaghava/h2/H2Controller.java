package com.sairaghava.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/h2/default/properties")
public class H2Controller {

  @Autowired
  Environment environment;

  @Autowired
  H2dbConfig h2dbConfig;

  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public H2dbConfig getH2Properties() {
    h2dbConfig.setConsoleContextPath(environment.getProperty("spring.h2.console.path"));
    h2dbConfig.setConsoleEnabled(Boolean.valueOf(environment.getProperty("spring.h2.console.enabled")));
    h2dbConfig.setDatabasePlatform(environment.getProperty("spring.jpa.database-platform"));
    h2dbConfig.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
    h2dbConfig.setHibernateDdlAuto(environment.getProperty("spring.jpa.hibernate.ddl-auto"));
    h2dbConfig.setInitializationMode(environment.getProperty("spring.datasource.initializtion-mode"));
    h2dbConfig.setDataSourceName(environment.getProperty("spring.datasource.name"));
    h2dbConfig.setDataSourceUrl(environment.getProperty("spring.datasource.url"));
    h2dbConfig.setUsername(environment.getProperty("spring.datasource.username"));
    h2dbConfig.setPassword(environment.getProperty("spring.datasource.password"));
    return h2dbConfig;
  }

}