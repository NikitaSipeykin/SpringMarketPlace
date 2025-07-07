package com.app.bysell.controllers;

import com.app.bysell.models.Product;
import com.app.bysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    Product product = productService.getProductById(id);
    model.addAttribute("product", product);
    model.addAttribute("images", product.getImages());
    return "product-info";
  }

  @PostMapping("/product/create")
  public String createProduct(@RequestParam("file1") MultipartFile file1,
                              @RequestParam("file2") MultipartFile file2,
                              @RequestParam("file3") MultipartFile file3, Product product) throws IOException {
    productService.saveProduct(product, file1, file2, file3);
    return "redirect:/";
  }

  @PostMapping("/product/delete/{id}")
  public String deleteProductById(@PathVariable Long id){
    productService.deleteProductById(id);
    return "redirect:/";
  }
}
