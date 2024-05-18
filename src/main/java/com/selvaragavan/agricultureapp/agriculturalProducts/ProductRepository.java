package com.selvaragavan.agricultureapp.agriculturalProducts;

import com.selvaragavan.agricultureapp.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByUserId(Integer user_id);
    public List<Product> findAllByNameContaining(String name);
    public List<Product> findAllByUserAddress(Address address);
}
