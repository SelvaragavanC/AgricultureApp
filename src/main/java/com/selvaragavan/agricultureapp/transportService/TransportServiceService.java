package com.selvaragavan.agricultureapp.transportService;


import com.selvaragavan.agricultureapp.address.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class TransportServiceService {
    private final TransportServiceRepository transportServiceRepository;

    public List<TransportService> getAllTransportServices() {
        return transportServiceRepository.findAll();
    }

    public List<TransportService> getAllTransportServiceByAddressesAvailable(Integer id){

        return transportServiceRepository.findAllByAddressesAvailable(id);
    }

    public String addTransportService(TransportService transportService){
        transportServiceRepository.save(transportService);
        return "TransportService added";
    }
}
