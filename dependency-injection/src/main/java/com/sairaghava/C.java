package com.sairaghava;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class C {

  int getRandomBelow10() {
    return ThreadLocalRandom.current().nextInt(10);
  }

}