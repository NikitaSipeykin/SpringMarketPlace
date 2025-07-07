package com.app.bysell.controllers;

import com.app.bysell.models.Product;
import com.app.bysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping("/")
  public String products(@RequestParam(name = "title", required = false) String title, Model model){
    model.addAttribute("products", productService.getAllProducts(title));
    return "products";
  }

  @GetMapping("/product/{id}")
  public String productInfo(@PathVariable Long id, Model model){
    model.addAttribute("product", productService.getProductById(id));
    return "product-info";
  }

  @PostMapping("/product/create")
  public String createProduct(@ModelAttribute Product product){
    productService.saveProduct(product);
    return "redirect:/";
  }

  @PostMapping("/product/delete/{id}")
  public String deleteProductById(@PathVariable Long id){
    productService.deleteProductById(id);
    return "redirect:/";
  }
}
