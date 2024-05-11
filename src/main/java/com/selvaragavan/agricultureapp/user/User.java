package com.selvaragavan.agricultureapp.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.selvaragavan.agricultureapp.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String email;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties({"id"})
    private Address address;
}
