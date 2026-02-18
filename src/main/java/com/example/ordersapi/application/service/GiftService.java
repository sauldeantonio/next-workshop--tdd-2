package com.example.ordersapi.application.service;

import com.example.ordersapi.application.port.inbound.GiftUseCase;
import com.example.ordersapi.domain.exception.GiftNotFoundException;
import com.example.ordersapi.domain.model.Gift;
import com.example.ordersapi.domain.repository.GiftRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService implements GiftUseCase {

    private final GiftRepositoryPort repository;

    public GiftService(GiftRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Gift> getAll() {
        return repository.findAll();
    }

    @Override
    public Gift create(Gift gift) {
        return repository.save(gift);
    }

    @Override
    public Gift getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new GiftNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Gift gift = repository.findById(id)
                .orElseThrow(() -> new GiftNotFoundException(id));
        repository.delete(gift);
    }
}
