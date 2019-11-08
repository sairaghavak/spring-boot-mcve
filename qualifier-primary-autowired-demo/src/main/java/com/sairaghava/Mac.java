package com.sairaghava;

import org.springframework.stereotype.Service;

@Service
public class Mac implements Os {

  @Override
  public String getWelcomeMessage() {
    return "Welcome to Mac OS";
  }

}
