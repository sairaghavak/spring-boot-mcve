package com.sairaghava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  // Field Injection, not a good practice as defeats SRP priniciple
  @Autowired
  private A a;

  // Constructor Injection - For eager dependencies, prevents/detects circular
  // dependencies
  private final B b;

  // Setter Injection - Used when you have Lazy dependencies
  private C c;

  // @Autowired // Autowired here is optional
  SampleController(B b, D d) {
    this.b = b;
    System.out.println("D = " + d);
  }

  @GetMapping("/fieldInjection")
  String fieldInjectionDemo() {
    return a.getMessage();
  }

  @GetMapping("/constructorInjection")
  String constructorInjection() {
    return b.printMessage();
  }

  @GetMapping("/setterInjection")
  int setterInjection() {
    return c.getRandomBelow10();
  }

  @Autowired
  void setC(C c) {
    this.c = c;
  }

}