package com.lwl.greetingserverapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {
      @GetMapping("/greet")
      public String greetings(){
        return "Welcome to spring boot world!";
      }
}
