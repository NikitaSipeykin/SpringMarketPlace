package com.app.bysell.services;

import com.app.bysell.models.Product;
import com.app.bysell.repositoryes.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public List<Product> getAllProducts(String title){
    if (title != null){
      return productRepository.findByTitle(title);
    }
    return productRepository.findAll();
  }

  public Product getProductById(Long id){
    return productRepository.findById(id).orElse(null);
  }

  public void saveProduct(Product product){
    log.info("Saving new {}", product);
    productRepository.save(product);
  }

  public void deleteProductById(Long id){
    productRepository.deleteById(id);
  }
}
