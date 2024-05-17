package com.selvaragavan.agricultureapp.order;

import com.selvaragavan.agricultureapp.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders(Integer id) {
        return orderRepository.findAllByUserId(id);
    }

    public OrderResponse addOrder(Order order) {
        orderRepository.save(order);
        return new OrderResponse("You're order will be received at "+order.getDeliveryTime());
    }
}
