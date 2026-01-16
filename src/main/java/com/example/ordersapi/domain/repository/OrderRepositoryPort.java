package com.example.ordersapi.domain.repository;

import com.example.ordersapi.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryPort {
    List<Order> findAll();

    Optional<Order> findById(Long id);

    Order save(Order order);

    void delete(Order order);
}
