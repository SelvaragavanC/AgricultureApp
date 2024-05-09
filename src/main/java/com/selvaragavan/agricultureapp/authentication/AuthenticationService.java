package com.selvaragavan.agricultureapp.authentication;

import com.selvaragavan.agricultureapp.user.User;
import com.selvaragavan.agricultureapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    public ResponseEntity<RegisterResponse> registerService(RegisterRequest registerRequest){
        if(isAlreadyRegistered(registerRequest)){
            return new ResponseEntity<>(new RegisterResponse("You are already registered"), HttpStatusCode.valueOf(404));
        }
        User usr = User
                .builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .email(registerRequest.getEmail())
                .build();
        userRepository.save(usr);
        return new ResponseEntity<>(new RegisterResponse("You are registered Successfully"), HttpStatusCode.valueOf(200));
    }

    public boolean isAlreadyRegistered(RegisterRequest registerRequest){
        User user = userRepository.findByEmail(registerRequest.getEmail());
        return user != null;
    }

    public ResponseEntity<LoginResponse> loginService(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        return new ResponseEntity<>(new LoginResponse(user.getUsername()), HttpStatusCode.valueOf(200));
    }
}
