package com.manikanta.microservices.project.OrderService.Service.Implementation;

import com.manikanta.microservices.project.OrderService.DTO.OrderDTO;
import com.manikanta.microservices.project.OrderService.Entity.Order;
import com.manikanta.microservices.project.OrderService.Repository.OrderRepository;
import com.manikanta.microservices.project.OrderService.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImplementation implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map((order -> mapToDTO(order)))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        return mapToDTO(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
        System.out.println("Order Deleted");
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
        System.out.println("Order Added");
    }

    public OrderDTO mapToDTO(Order order){
        return modelMapper.map(order,OrderDTO.class);
    }
}
