package com.app.bysell.services;

import com.app.bysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
  private List<Product> products = new ArrayList<>();

  public List<Product> getAllProducts(){
    return products;
  }

  public Product getProductById(Long id){
    for (Product product : products) {
      if (product.getId().equals(id)) return product;
    }
    return null;
  }

  public void saveProduct(Product product){
    products.add(product);
  }

  public void deleteProductById(Long id){
    products.removeIf(product -> product.getId().equals(id));
  }
}
