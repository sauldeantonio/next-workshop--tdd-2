package com.example.ordersapi.application.service;

import com.example.ordersapi.domain.exception.OrderNotFoundException;
import com.example.ordersapi.domain.model.Order;
import com.example.ordersapi.domain.repository.OrderRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepositoryPort repository;

    public OrderService(OrderRepositoryPort repository) {
        this.repository = repository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public Order getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public void delete(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        repository.delete(order);
    }
}

