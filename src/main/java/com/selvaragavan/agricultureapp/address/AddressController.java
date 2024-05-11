package com.selvaragavan.agricultureapp.address;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAll() {
        return new ResponseEntity<>(addressService.getAllAddress(), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/add")
    public ResponseEntity<Address> add(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatusCode.valueOf(200));
    }
}
