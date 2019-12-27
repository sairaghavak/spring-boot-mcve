package com.sairaghava.h2;

import org.springframework.stereotype.Component;

@Component
public class H2dbConfig {

  private String dataSourceName;
  private String dataSourceUrl;
  private String driverClassName;
  private String username;
  private String password;
  private String databasePlatform;
  private boolean isConsoleEnabled;
  private String consoleContextPath;
  private String hibernateDdlAuto;
  private String initializationMode; // Initializes DB, with DDL(schema.sql) and DML(data.sql) Scripts

  /**
   * @return the dataSourceName
   */
  public String getDataSourceName() {
    return dataSourceName;
  }

  /**
   * @param dataSourceName the dataSourceName to set
   */
  public void setDataSourceName(String dataSourceName) {
    this.dataSourceName = dataSourceName;
  }

  /**
   * @return the dataSourceUrl
   */
  public String getDataSourceUrl() {
    return dataSourceUrl;
  }

  /**
   * @param dataSourceUrl the dataSourceUrl to set
   */
  public void setDataSourceUrl(String dataSourceUrl) {
    this.dataSourceUrl = dataSourceUrl;
  }

  /**
   * @return the driverClassName
   */
  public String getDriverClassName() {
    return driverClassName;
  }

  /**
   * @param driverClassName the driverClassName to set
   */
  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the databasePlatform
   */
  public String getDatabasePlatform() {
    return databasePlatform;
  }

  /**
   * @param databasePlatform the databasePlatform to set
   */
  public void setDatabasePlatform(String databasePlatform) {
    this.databasePlatform = databasePlatform;
  }

  /**
   * @return the isConsoleEnabled
   */
  public boolean isConsoleEnabled() {
    return isConsoleEnabled;
  }

  /**
   * @param isConsoleEnabled the isConsoleEnabled to set
   */
  public void setConsoleEnabled(boolean isConsoleEnabled) {
    this.isConsoleEnabled = isConsoleEnabled;
  }

  /**
   * @return the consoleContextPath
   */
  public String getConsoleContextPath() {
    return consoleContextPath;
  }

  /**
   * @param consoleContextPath the consoleContextPath to set
   */
  public void setConsoleContextPath(String consoleContextPath) {
    this.consoleContextPath = consoleContextPath;
  }

  /**
   * @return the hibernateDdlAuto
   */
  public String getHibernateDdlAuto() {
    return hibernateDdlAuto;
  }

  /**
   * @param hibernateDdlAuto the hibernateDdlAuto to set
   */
  public void setHibernateDdlAuto(String hibernateDdlAuto) {
    this.hibernateDdlAuto = hibernateDdlAuto;
  }

  /**
   * @return the initializationMode
   */
  public String getInitializationMode() {
    return initializationMode;
  }

  /**
   * @param initializationMode the initializationMode to set
   */
  public void setInitializationMode(String initializationMode) {
    this.initializationMode = initializationMode;
  }

}