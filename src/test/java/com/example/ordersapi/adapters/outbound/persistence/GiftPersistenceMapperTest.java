package com.example.ordersapi.adapters.outbound.persistence;

import com.example.ordersapi.domain.model.Gift;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GiftPersistenceMapperTest {

    private final GiftPersistenceMapper mapper = new GiftPersistenceMapper();

    @Test
    void toEntity_should_map_domain_to_entity() {
        Gift domain = new Gift();
        domain.setId(1L);
        domain.setProduct("Book");
        domain.setQuantity(2);
        domain.setDescription("");

        GiftEntity entity = mapper.toEntity(domain);

        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getProduct()).isEqualTo("Book");
        assertThat(entity.getQuantity()).isEqualTo(2);
    }

    @Test
    void toDomain_should_map_entity_to_domain() {
        GiftEntity entity = new GiftEntity();
        entity.setId(1L);
        entity.setProduct("Pen");
        entity.setQuantity(5);

        Gift domain = mapper.toDomain(entity);

        assertThat(domain).isNotNull();
        assertThat(domain.getId()).isEqualTo(1L);
        assertThat(domain.getProduct()).isEqualTo("Pen");
        assertThat(domain.getQuantity()).isEqualTo(5);
    }

    @Test
    void toEntity_should_return_null_when_domain_is_null() {
        GiftEntity entity = mapper.toEntity(null);

        assertThat(entity).isNull();
    }

    @Test
    void toDomain_should_return_null_when_entity_is_null() {
        Gift domain = mapper.toDomain(null);

        assertThat(domain).isNull();
    }
}
