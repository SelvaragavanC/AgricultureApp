package com.selvaragavan.agricultureapp.agriculturalProducts;

import com.selvaragavan.agricultureapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findByName(String name);
    public List<Product> findAllByUserId(Integer user_id);
    public List<Product> findAllByNameContaining(String name);
    public List<Product> findAllByUserAddressContainingIgnoreCase(String address);
}
