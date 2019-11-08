package com.sairaghava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  // @Qualifier("mac")
  // @Autowired // It is mandatory though we use @Qualifier
  private Os os; // This would result in error as it couldn't resolve the subtype
  // private Os mac; // This is autowiring by name
  // private Os windows; // This again autowiring by name


  /*-
  @Autowired // @Autowired(required=false) doesn't work for constructor injections, as all params are mandatory
  AppController(@Qualifier("mac") Os os) {
    this.os = os;
  }
  */


  @Autowired(required = false)
  /*
   * server starts but when accesing /message endpoint results in nullpointer exception required =
   * false meaning, if mac bean is available is injected otherwise null is passed
   */
  public void setOs(@Qualifier("mac") Os os) {
    this.os = os;
  }


  @GetMapping("/")
  public String defaultMapping() {
    return "Hello and welcome to some annotations demos";
  }

  @GetMapping("/message")
  public String getMessage() {
    return os.getWelcomeMessage();
  }

}
