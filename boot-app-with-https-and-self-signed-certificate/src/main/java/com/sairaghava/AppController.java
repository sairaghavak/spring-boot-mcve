package com.sairaghava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/")
  public String defaultMapping() {
    return "Hello & Welcome to Spring boot with https demo";
  }

}
