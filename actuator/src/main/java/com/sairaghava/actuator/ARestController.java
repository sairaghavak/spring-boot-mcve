package com.sairaghava.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ARestController {

  @GetMapping("/hello")
  public String sayHello() {
    return "Saying hello from the sample rest controller";
  }

}