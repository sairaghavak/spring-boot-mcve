package com.sairaghava.commons;

import org.springframework.stereotype.Component;

@Component
public class Message {

  private String message;

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }


}
