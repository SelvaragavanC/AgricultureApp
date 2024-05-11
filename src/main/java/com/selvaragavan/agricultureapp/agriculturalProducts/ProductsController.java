package com.selvaragavan.agricultureapp.agriculturalProducts;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Product>> getProduct(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "address") String address) {
        if(address != null){
            return new ResponseEntity<>(productService.getProductsByUserAddress(address),HttpStatusCode.valueOf(200));
        }else if (name!=null){
            return new ResponseEntity<>(productService.getProductsByName(name), HttpStatusCode.valueOf(200));
        }else{
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatusCode.valueOf(200));
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<List<Product>> getAllProductsOfUser(@PathVariable(value = "id",required = true) int id){
        return new ResponseEntity<>(productService.getAllProductsOfUser(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(AddProductResponse.builder().message(productService.addProduct(product)).build(), HttpStatusCode.valueOf(200));
    }
}
