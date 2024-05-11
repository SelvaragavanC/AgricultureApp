package com.selvaragavan.agricultureapp.transportService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.selvaragavan.agricultureapp.address.Address;
import com.selvaragavan.agricultureapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonIgnoreProperties(value = {"password"})
    private User user;

    private String pricePerKM;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"id"})
    private Address[] addressesAvailable;

    private String phoneNumber;
}
