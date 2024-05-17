package com.selvaragavan.agricultureapp.transportService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.selvaragavan.agricultureapp.address.Address;
import com.selvaragavan.agricultureapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportService {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"password","address"})
    private User user;

    private String pricePerKM;

    @OneToMany
    @JoinColumn
    private List<Address> addressesAvailable;

    private String phoneNumber;
    private long capacity;
}

