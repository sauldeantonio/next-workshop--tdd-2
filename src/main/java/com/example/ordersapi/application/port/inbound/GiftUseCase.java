package com.example.ordersapi.application.port.inbound;

import com.example.ordersapi.domain.model.Gift;

import java.util.List;

public interface GiftUseCase {

    List<Gift> getAll();

    Gift create(Gift gift);

    Gift getById(Long id);

    void delete(Long id);
}
