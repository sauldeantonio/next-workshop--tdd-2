package com.example.ordersapi.adapters.inbound.rest;

import com.example.ordersapi.adapters.inbound.rest.dto.GiftRequestDto;
import com.example.ordersapi.adapters.inbound.rest.dto.GiftResponseDto;
import com.example.ordersapi.domain.model.Gift;

public class GiftRestMapper {

    public Gift toDomain(GiftRequestDto dto) {
        Gift gift = new Gift();
        gift.setProduct(dto.getProduct());
        gift.setQuantity(dto.getQuantity());
        gift.setDescription(dto.getDescription());
        return gift;
    }

    public GiftResponseDto toResponse(Gift gift) {
        return new GiftResponseDto(
                gift.getId(),
                gift.getProduct(),
                gift.getQuantity(),
                gift.getDescription()
        );
    }
}
