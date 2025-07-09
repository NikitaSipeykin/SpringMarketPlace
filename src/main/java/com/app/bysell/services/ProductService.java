package com.app.bysell.services;

import com.app.bysell.models.Image;
import com.app.bysell.models.Product;
import com.app.bysell.models.User;
import com.app.bysell.repositoryes.ProductRepository;
import com.app.bysell.repositoryes.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final UserRepository userRepository;

  public List<Product> getAllProducts(String title){
    if (title != null){
      return productRepository.findByTitle(title);
    }
    return productRepository.findAll();
  }

  public Product getProductById(Long id){
    return productRepository.findById(id).orElse(null);
  }

  public void saveProduct(Principal principal, Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3)
      throws IOException {
    product.setUser(getUserByPrincipal(principal));
    Image image1, image2, image3;

    if (file1.getSize() != 0){
      image1 = toImageEntity(file1);
      image1.setPreviewImage(true);
      product.addImageToProduct(image1);
    }
    if (file2.getSize() != 0){
      image2 = toImageEntity(file2);
      product.addImageToProduct(image2);
    }
    if (file3.getSize() != 0){
      image3 = toImageEntity(file3);
      product.addImageToProduct(image3);
    }
    log.info("Saving new Product: Title {}; Author email {};", product.getTitle(), product.getUser().getEmail());
    Product productFromDb = productRepository.save(product);
    productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
    productRepository.save(product);
  }

  public User getUserByPrincipal(Principal principal) {
    if (principal == null){
      return new User();
    }
    return userRepository.findByEmail(principal.getName());
  }

  private Image toImageEntity(MultipartFile file) throws IOException {
    Image image = new Image();
    image.setName(file.getName());
    image.setOriginalFileName(file.getOriginalFilename());
    image.setContentType(file.getContentType());
    image.setSize(file.getSize());
    image.setBytes(file.getBytes());
    return image;
  }

  public void deleteProductById(Long id){
    productRepository.deleteById(id);
  }
}
