package com.sairaghava;

import org.springframework.stereotype.Component;

// @Primary
/*
 * Indicates that a bean should be given preference when multiple candidates are qualified to
 * autowire a single-valued dependency. If exactly one 'primary' bean exists among the candidates,
 * it will be the autowired value.
 */
@Component // This can also be used instead of @Service but @Service is narrow type of @Component
public class Windows implements Os {

  @Override
  public String getWelcomeMessage() {
    return "Welcome to Windows by Microsoft";
  }

}
