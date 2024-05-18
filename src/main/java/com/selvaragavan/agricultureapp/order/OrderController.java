package com.selvaragavan.agricultureapp.order;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity<List<Order>> getOrders(@RequestParam("id") int id) {
        return  new ResponseEntity<>(orderService.getAllOrders(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/add")
    public ResponseEntity<OrderResponse> addOrder(@RequestBody Order order) {
        System.out.println(order);
        order.setDeliveryTime(LocalDateTime.now().plusHours(8));
        return new ResponseEntity<>(orderService.addOrder(order),HttpStatusCode.valueOf(200));
    }
}
