package com.selvaragavan.agricultureapp.transportService;


import com.selvaragavan.agricultureapp.address.Address;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/transportService")
public class TransportServiceController {

    public final TransportServiceService transportServiceService;

    @GetMapping("/get")
    public ResponseEntity<List<TransportService>> getTransportService(
            @RequestParam(value = "q",required = false) Integer id
    ){
        if(id == null){
            return new ResponseEntity<>(transportServiceService.getAllTransportServices(), HttpStatusCode.valueOf(200));
        }else{
            return new ResponseEntity<>(transportServiceService.getAllTransportServiceByAddressesAvailable(id),HttpStatusCode.valueOf(200));
        }

    }

    @PostMapping(value = "/add")
    public ResponseEntity<AddTransportResponse> addTransportService(
            @RequestBody TransportService transportService
    ){
        return new ResponseEntity<>(new AddTransportResponse(transportServiceService.addTransportService(transportService)),HttpStatusCode.valueOf(200));
    }
}
