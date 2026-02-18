package com.example.ordersapi.adapters.inbound.rest.dto;

public class GiftResponseDto {

    private final Long id;
    private final String product;
    private final int quantity;
    private String description;

    public GiftResponseDto(Long id, String product, int quantity, String description) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription(){return description;}
}
