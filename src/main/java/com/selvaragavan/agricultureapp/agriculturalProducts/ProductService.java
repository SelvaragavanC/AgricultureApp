package com.selvaragavan.agricultureapp.agriculturalProducts;


import com.selvaragavan.agricultureapp.address.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getProductsByName(String productName) {
        return productRepository.findAllByNameContaining(productName);
    }

    public List<Product> getAllProductsOfUser(int id) {
        return productRepository.findAllByUserId(id);
    }

    public String addProduct(Product product) {
        productRepository.save(product);
        return product.getName()+" added successfully";
    }

    public List<Product> getProductsByUserAddress(Address address) {
        return productRepository.findAllByUserAddress(address);
    }
}
