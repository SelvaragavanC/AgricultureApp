package com.selvaragavan.agricultureapp.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    public List<Order> findAllByUserId(Integer id);
}
