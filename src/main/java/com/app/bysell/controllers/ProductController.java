package com.app.bysell.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

  @GetMapping("/")
  public String products(){
    return "products";
  }
}
