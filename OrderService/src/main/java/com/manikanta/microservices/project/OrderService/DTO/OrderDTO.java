package com.manikanta.microservices.project.OrderService.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class OrderDTO {
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Order {

        private int orderID;
        private long userId;
        private String orderStatus;
    }
}
