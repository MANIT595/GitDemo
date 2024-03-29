package com.manikanta.microservices.project.OrderService.Controller;

import com.manikanta.microservices.project.OrderService.DTO.OrderDTO;
import com.manikanta.microservices.project.OrderService.Entity.Order;
import com.manikanta.microservices.project.OrderService.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<OrderDTO> getProducts() {
        return orderService.getOrders();

    }

    @GetMapping("{order-id}")
    public OrderDTO getProductById(@PathVariable("order-id") Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/user/{user-id}")
    public List<OrderDTO> getOrdersByUserId( @PathVariable("user-id") String userId) {
        Long id = Long.parseLong(userId);
        return orderService.getOrderByUserId(id);
    }

    @DeleteMapping("{order-id}")
    public void deleteUserById(@PathVariable("order-id") Long id) {
        orderService.deleteOrder(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Order order){
        orderService.addOrder(order);
    }
}
