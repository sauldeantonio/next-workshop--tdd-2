package com.example.ordersapi.domain.repository;

import com.example.ordersapi.domain.model.Gift;

import java.util.List;
import java.util.Optional;

public interface GiftRepositoryPort {
    List<Gift> findAll();

    Optional<Gift> findById(Long id);

    Gift save(Gift gift);

    void delete(Gift gift);
}
