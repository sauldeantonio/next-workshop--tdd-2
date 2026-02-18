package com.example.ordersapi.adapters.outbound.persistence;

import com.example.ordersapi.domain.model.Gift;
import com.example.ordersapi.domain.repository.GiftRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GiftRepositoryAdapter implements GiftRepositoryPort {

    private final JpaGiftRepository jpaRepository;
    private final GiftPersistenceMapper mapper;

    public GiftRepositoryAdapter(JpaGiftRepository jpaRepository, GiftPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Gift> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Gift> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Gift save(Gift gift) {
        GiftEntity entity = mapper.toEntity(gift);
        GiftEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void delete(Gift gift) {
        GiftEntity entity = mapper.toEntity(gift);
        jpaRepository.delete(entity);
    }
}
