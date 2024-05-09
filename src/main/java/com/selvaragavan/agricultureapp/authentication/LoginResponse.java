package com.selvaragavan.agricultureapp.authentication;


import com.selvaragavan.agricultureapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private final String username;
}
