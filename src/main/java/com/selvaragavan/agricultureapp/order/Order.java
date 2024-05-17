package com.selvaragavan.agricultureapp.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.selvaragavan.agricultureapp.agriculturalProducts.Product;
import com.selvaragavan.agricultureapp.transportService.TransportService;
import com.selvaragavan.agricultureapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"password"})
    private User user;

    @ManyToOne
    @JoinColumn
    private TransportService transportService;

    @ManyToOne
    @JoinColumn
    private Product product;

    private LocalDateTime deliveryTime;
}
