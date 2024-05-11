package com.selvaragavan.agricultureapp.agriculturalProducts;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.selvaragavan.agricultureapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Table(name = "products")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"password"})
    private User user;

    private String name;
    private String description;
    private int price;
    private int unit;
    private int quantity;
    private Date createdAt;
    private Date expiryDate;
}
