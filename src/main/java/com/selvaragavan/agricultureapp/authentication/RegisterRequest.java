package com.selvaragavan.agricultureapp.authentication;

import com.selvaragavan.agricultureapp.address.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private Address address;
}
