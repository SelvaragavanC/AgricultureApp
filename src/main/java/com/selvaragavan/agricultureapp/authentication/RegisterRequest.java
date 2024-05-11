package com.selvaragavan.agricultureapp.authentication;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String address;
}
