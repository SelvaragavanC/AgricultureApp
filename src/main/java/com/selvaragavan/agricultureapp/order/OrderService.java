package com.selvaragavan.agricultureapp.order;

import com.selvaragavan.agricultureapp.agriculturalProducts.Product;
import com.selvaragavan.agricultureapp.agriculturalProducts.ProductRepository;
import com.selvaragavan.agricultureapp.transportService.TransportService;
import com.selvaragavan.agricultureapp.transportService.TransportServiceRepository;
import com.selvaragavan.agricultureapp.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final TransportServiceRepository transportServiceRepository;

    public List<Order> getAllOrders(Integer id) {
        return orderRepository.findAllByUserId(id);
    }

    public OrderResponse addOrder(Order order) {
        Product product = productRepository.findById(order.getProduct().getId()).get();
        TransportService transportService = transportServiceRepository.findById(order.getTransportService().getId()).get();
        if(product.getQuantity()<order.getQuantity() || transportService.getCapacity()<order.getTransportService().getCapacity()){
            throw new InputMismatchException("We can not afford that much, Choose lesser quantity");
        }else{
            product.setQuantity(product.getQuantity()-order.getQuantity());
            productRepository.save(product);
            transportService.setCapacity(transportService.getCapacity()-order.getQuantity());
            transportServiceRepository.save(transportService);
        }
        orderRepository.save(order);
        return new OrderResponse("You're order will be received at "+order.getDeliveryTime());
    }
}
