package com.selvaragavan.agricultureapp.transportService;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportServiceRepository extends JpaRepository<TransportService, Integer> {
}
