package com.example.ordersapi.adapters.outbound.persistence;

import com.example.ordersapi.domain.model.Gift;
import org.springframework.stereotype.Component;

@Component
public class GiftPersistenceMapper {

    public GiftEntity toEntity(Gift domain) {
        if (domain == null) {
            return null;
        }

        GiftEntity entity = new GiftEntity();
        entity.setId(domain.getId());
        entity.setProduct(domain.getProduct());
        entity.setQuantity(domain.getQuantity());
        return entity;
    }

    public Gift toDomain(GiftEntity entity) {
        if (entity == null) {
            return null;
        }

        Gift domain = new Gift();
        domain.setId(entity.getId());
        domain.setProduct(entity.getProduct());
        domain.setQuantity(entity.getQuantity());
        return domain;
    }
}
