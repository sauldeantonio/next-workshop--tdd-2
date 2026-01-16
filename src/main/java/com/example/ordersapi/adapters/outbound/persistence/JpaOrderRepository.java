package com.example.ordersapi.adapters.outbound.persistence;

import com.example.ordersapi.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Order, Long> {
}
